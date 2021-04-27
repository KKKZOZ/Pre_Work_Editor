package Pre_Editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class EditorMenu {


    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = null;
    public JMenuItem menuItem = null;
    //Field
    private Pre_Editor editor;
    private MenuActionListener menuActionListener = new MenuActionListener();
    private boolean markdownIsOpen = false;
    private MarkdownPreview markdownPreview;

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

        file.add(new MenuDetail("New", 'n', false));
        file.add(new MenuDetail("Open", 'o', false));
        file.add(new MenuDetail("Save", 's', false));
        file.add(new MenuDetail("Quick Operation", 'q', false));
        creatMenuItem(file);


        menu = new JMenu("Tools");
        menu.setMnemonic('T');
        ArrayList<MenuDetail> tools = new ArrayList<MenuDetail>();
        tools.add(new MenuDetail("Calculate", 'c',false));
        tools.add(new MenuDetail("Cmd", 'd', false));
        tools.add(new MenuDetail("Markdown Preview", 'M',false));
        creatMenuItem(tools);


        //Menu fo Settings
        menu = new JMenu("Settings");
        menu.setMnemonic('s');
        ArrayList<MenuDetail> settings = new ArrayList<MenuDetail>();
        settings.add(new MenuDetail("Settings", 's',true));
        creatMenuItem(settings);

    }//End of createMenuBar

    private void creatMenuItem(ArrayList<MenuDetail> item) {
        for (MenuDetail m : item) {
            menuItem = new JMenuItem(m.menuName, m.accelerator);
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
                new QuickCommand(editor);
            }
            if ("Markdown Preview".equals(e.getActionCommand())) {
                if (!markdownIsOpen) {
                    markdownPreview = new MarkdownPreview(editor);
                    markdownIsOpen = true;
                    return;
                }
                if (markdownIsOpen) {
                    editor.writingArea.writingArea.remove(markdownPreview.markdownPane);
                    markdownIsOpen = false;
                    return;
                }

            }

        }//End of actionPerformed


    }//End of MenuActionListener


}//End of Class EditorMenu
