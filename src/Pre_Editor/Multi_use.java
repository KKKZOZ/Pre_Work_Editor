package Pre_Editor;

import javax.swing.*;
import java.awt.*;

public class Multi_use {
    private Pre_Editor editor;
    public JPanel southPanel;
    public JTabbedPane multiPane;


    public Multi_use(Pre_Editor editor) {
        this.editor = editor;
        southPanel=new JPanel(new BorderLayout());
        editor.mainPanel.add(southPanel, BorderLayout.SOUTH);
        multiPane = new JTabbedPane();

        //Temporary
        JTextArea temp = new JTextArea("Test");
        temp.setRows(8);
        multiPane.addTab("Test", temp);
        southPanel.add(multiPane,BorderLayout.CENTER);
    }
}
