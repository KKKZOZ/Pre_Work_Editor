package Pre_Editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class EditorMenu {


    //Field
    private final Pre_Editor editor;
    private final MenuActionListener menuActionListener = new MenuActionListener();
    public JMenuBar menuBar = new JMenuBar();
    public JMenu menu = null;
    public JMenuItem menuItem = null;
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
        file.add(new MenuDetail("Close", 'c', true));
        file.add(new MenuDetail("Open", 'o', false));
        file.add(new MenuDetail("Save", 's', false));
        file.add(new MenuDetail("Quick Operation", 'q', false));
        creatMenuItem(file);


        menu = new JMenu("Tools");
        menu.setMnemonic('T');
        ArrayList<MenuDetail> tools = new ArrayList<MenuDetail>();
        tools.add(new MenuDetail("Calculate", 'c', false));
        tools.add(new MenuDetail("Cmd", 'd', false));
        tools.add(new MenuDetail("Markdown Preview", 'M', true));
        tools.add(new MenuDetail("Compile", 'o', false));
        tools.add(new MenuDetail("Run", 'r', false));
        creatMenuItem(tools);

        menu = new JMenu("Run");
        menu.setMnemonic('R');
        ArrayList<MenuDetail> runs = new ArrayList<MenuDetail>();
        runs.add(new MenuDetail("Compile", 'C', false));
        runs.add(new MenuDetail("Run", 'R', false));
        runs.add(new MenuDetail("Compile && Run", '&', false));
        creatMenuItem(runs);

        //Menu fo Settings
        menu = new JMenu("Settings");
        menu.setMnemonic('s');
        ArrayList<MenuDetail> settings = new ArrayList<MenuDetail>();
        settings.add(new MenuDetail("Settings", 's', true));
        creatMenuItem(settings);

        menu = new JMenu("Help");
        menu.setMnemonic('H');
        ArrayList<MenuDetail> helps = new ArrayList<MenuDetail>();
        helps.add(new MenuDetail("ShortcutReference", 'S', false));
        creatMenuItem(helps);


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
                editor.workingManager.newTextTab("Untitled");
//                new QuickCommand(editor);
            }
            if ("Close".equals(e.getActionCommand())) {
                editor.workingManager.closeSelectedTab(editor.workingManager.getSelectedIndex());
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
                if (!editor.workingManager.getCurrentWritingArea().isMarkdownIsOpen()) {
                    markdownPreview = new MarkdownPreview(editor);
                    editor.workingManager.getCurrentWritingArea().setMarkdownIsOpen(true);
                    return;
                }
                //TODO 可能会出现关闭失败的情况
                if (editor.workingManager.getCurrentWritingArea().isMarkdownIsOpen()) {
                    editor.workingManager.getCurrentWritingArea().writingArea.remove(markdownPreview.markdownPane);
                    editor.workingManager.getCurrentWritingArea().setMarkdownIsOpen(false);
                    return;
                }

            }
            if ("Compile".equals(e.getActionCommand())) {
                editor.actions.compile();
            }
            if ("Run".equals(e.getActionCommand())) {
                editor.actions.run();
            }
            if ("Compile && Run".equals(e.getActionCommand())) {
                editor.actions.compileAndRun();
            }
            if ("ShortcutReference".equals(e.getActionCommand())) {
                editor.actions.showShortcutReference();
            }

        }//End of actionPerformed


    }//End of MenuActionListener


}//End of Class EditorMenu
