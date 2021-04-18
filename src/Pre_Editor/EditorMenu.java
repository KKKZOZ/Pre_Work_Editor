package Pre_Editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class EditorMenu {


    //Field
    private Pre_Editor editor;
    private MenuActionListener menuActionListener = new MenuActionListener();

    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = null;
    public JMenuItem menuItem = null;

    //Constructor
    public EditorMenu(Pre_Editor editor) {
        this.editor = editor;
        this.createMenuBar();
    }


    //Method
    public void createMenuBar() {
        //create the elements of menubar


        //Menu of File
        menu = new JMenu("File");
        menu.setMnemonic('F');

        ArrayList<MenuDetail> file = new ArrayList<MenuDetail>();

        file.add(new MenuDetail("New", 'n',
                KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK), false));
        file.add(new MenuDetail("Open", 'o',
                KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK), false));
        file.add(new MenuDetail("Save", 's',
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK), false));
        file.add(new MenuDetail("Quick Operation", 'q',
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK), false));
        creatMenuItem(file);



        menu = new JMenu("Tools");
        menu.setMnemonic('T');
        ArrayList<MenuDetail> tools = new ArrayList<MenuDetail>();
        tools.add(new MenuDetail("Calculate", 'c', null, false));
        tools.add(new MenuDetail("Cmd", 'd',
                KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK), false));
        creatMenuItem(tools);



        //Menu fo Settings
        menu = new JMenu("Settings");
        menu.setMnemonic('s');
        ArrayList<MenuDetail> settings = new ArrayList<MenuDetail>();
        settings.add(new MenuDetail("Settings", 's', null, true));
        creatMenuItem(settings);

    }//End of createMenuBar

    private void creatMenuItem(ArrayList<MenuDetail> item) {
        for (MenuDetail m : item) {
            menuItem = new JMenuItem(m.menuName, m.accelerator);
            menuItem.setAccelerator(m.keyStroke);
            menuItem.setActionCommand(m.menuName);
            // 绑定菜单项的动作命令名称，如果所有菜单项使用同一个监听器
            // 可以在监听器回调时过命令名称区别是哪个菜单项触发的动作
            menuItem.addActionListener(menuActionListener);
            menu.add(menuItem);
            if (m.separatorBelow) {
                menu.addSeparator();
            }
        }
        menuBar.add(menu);
        editor.mainframe.setJMenuBar(menuBar);
        editor.mainframe.setVisible(true);
    }

    class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("New".equals(e.getActionCommand())) {
                System.out.println("New");
//                new QuickCommand(editor);

            }
            if ("Open".equals(e.getActionCommand())) {
                System.out.println("Open");
                editor.actions.openFile();
            }
            if ("Save".equals(e.getActionCommand())) {
                System.out.println("Save");
                editor.actions.saveFile();
            }
            if ("Quick Operation".equals(e.getActionCommand())) {
                System.out.println("Quick Operation");
                QuickOperation quick_operation = new QuickOperation(editor);

            }
            if ("Settings".equals(e.getActionCommand())) {
                editor.settings.setVisible();
            }
            if ("Calculate".equals(e.getActionCommand())) {

                new Calculate(editor);
            }
            if ("Cmd".equals(e.getActionCommand())) {
                try {
                    Process proc = Runtime.getRuntime().exec("cmd");
                    OutputStream out = proc.getOutputStream();
                    InputStream stdout = proc.getInputStream();
                    InputStream stderr = proc.getErrorStream();
                    int len = 0 ;
                    byte[] bys = new byte[1024];
                    while ((len = stdout.read(bys)) != -1) {
                        System.out.println(new String(bys,0,len));
                    }

                    try {
                        out.write("ls\n".getBytes());
                        out.flush();
                    } catch (Exception es) {
                        es.printStackTrace();
                    }
                    int len1 = 0 ;
                    byte[] bys1 = new byte[1024];
                    while ((len1 = stdout.read(bys1)) != -1) {
                        System.out.println(new String(bys1,0,len1));
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }

        }//End of actionPerformed
    }//End of MenuActionListener


}//End of Class EditorMenu
