package Pre_Editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class EditorMenu {


    //Field
    private Pre_Editor editor;
    private  MenuActionListener menuActionListener=new MenuActionListener();

    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = null;
    public JMenuItem menuItem = null;

    //Constructor
    public EditorMenu(Pre_Editor editor) {
        this.editor=editor;
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

        for (MenuDetail m : file) {
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




        //Menu fo Format
        menu = new JMenu("Format");
        menu.setMnemonic('m');
        ArrayList<MenuDetail> format=new ArrayList<MenuDetail>();
        format.add(new MenuDetail("Format", 'f', null, true));


        for (MenuDetail m : format) {
            menuItem = new JMenuItem(m.menuName, m.accelerator);
            menuItem.setAccelerator(m.keyStroke);
            menuItem.setActionCommand(m.menuName);
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
                //new calculate(editor);
            }
            if ("Open".equals(e.getActionCommand())) {
                System.out.println("Open");
            }
            if ("Save".equals(e.getActionCommand())) {
                System.out.println("Save");
            }
            if ("Quick Operation".equals(e.getActionCommand())) {
                System.out.println("Quick Operation");
                Quick_Operation quick_operation = new Quick_Operation(editor);

            }
            if ("Format".equals(e.getActionCommand())) {
                formatDialog();
            }

        }
    }//end of MenuActionListener

    private void formatDialog() {
        editor.settings.setVisible();
    }

}//End of Class EditorMenu
