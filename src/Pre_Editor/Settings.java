package Pre_Editor;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Settings {
    //Fields
    public JDialog settingDialog;
    public JPanel settingPanel;
    public JTree tree;

    private final Pre_Editor editor;

    //Constructor
    public Settings(Pre_Editor editor) {
        this.editor = editor;


        settingDialog = new JDialog(editor.mainframe, "Settings", false);
//        settingDialog.setVisible(true);
        settingDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3;
        int height = (int) (screenSize.height / 1.5);
        settingDialog.setSize(width, height);
        settingDialog.setLocation((screenSize.width / 2) - (width / 2),
                (screenSize.height / 2) - (height / 2));

        settingPanel = new JPanel(new BorderLayout());
        settingDialog.add(settingPanel);

        settingDialog.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                settingDialog.dispose();
            }
        });

        createTree();

    }//End of Constructor

    private void createTree() {
        //创建根节点
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("others.Editor");

        //创建二级节点
        DefaultMutableTreeNode generalNode = new DefaultMutableTreeNode("General");

        //创建三级节点
        DefaultMutableTreeNode fontNode = new DefaultMutableTreeNode("Font");


        //将三级节点添加到二级节点
        generalNode.add(fontNode);


        //将二级节点添加到根节点
        rootNode.add(generalNode);


        tree = new JTree(rootNode);
        settingPanel.add(tree, BorderLayout.WEST);

        // 设置树显示根节点句柄
        tree.setShowsRootHandles(true);

        tree.setEditable(false);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                String action = e.getPath().toString();
                actionPerform(action);
            }
        });
    }//End of createTree

    private void actionPerform(String action) {
        if ("[others.Editor, General, Font]".equals(action)) {
            FontChooser fontChooser = new FontChooser(editor);
            settingPanel.add(fontChooser.parentPanel, BorderLayout.CENTER);
        }
    }

    public void setVisible() {
        settingDialog.setVisible(true);
    }

}//End of Class Settings
