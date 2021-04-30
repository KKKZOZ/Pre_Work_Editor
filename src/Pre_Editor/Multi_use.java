package Pre_Editor;

import javax.swing.*;
import java.awt.*;

public class Multi_use {
    private final Pre_Editor editor;
    public JPanel southPanel;
    public JTabbedPane multiPane;
    public Terminal terminal;


    public Multi_use(Pre_Editor editor) {
        this.editor = editor;
        southPanel=new JPanel(new BorderLayout());
        editor.mainPanel.add(southPanel, BorderLayout.SOUTH);
        multiPane = new JTabbedPane();

        try {
            terminal = new Terminal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        terminal.getTextArea().setRows(10);
        multiPane.addTab("Test", terminal.getMainPanel());
        southPanel.add(multiPane,BorderLayout.CENTER);
    }
}
