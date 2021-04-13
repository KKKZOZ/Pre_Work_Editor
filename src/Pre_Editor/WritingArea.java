package Pre_Editor;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WritingArea {

    //Field
    private Pre_Editor editor;
    public JSplitPane writingArea;
    public JTextArea textArea;
    public CurrentLineInfo currentLineInfo;
    private String fileDir;


    //Constructor
    public WritingArea(Pre_Editor editor) {
        this.editor = editor;
        this.writingArea = new JSplitPane();
        this.textArea = new JTextArea();
        this.createWritingArea();
        currentLineInfo=new CurrentLineInfo(textArea);
        this.fileDir = "";
    }


    //Method
   

    public void createWritingArea() {
        //Create objects

        JScrollPane textScrollPane = new JScrollPane();

        textScrollPane.setViewportView(textArea);



        //scrollPane.setViewportView(label);

        //Set the attribute of splitPane
        writingArea.setTopComponent(textScrollPane);

        writingArea.setOrientation(JSplitPane.VERTICAL_SPLIT);
        writingArea.setContinuousLayout(true);
        writingArea.setOneTouchExpandable(false);
        writingArea.setDividerSize(5);


        writingArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                writingArea.setDividerLocation(0.98);
            }
        });


        editor.mainframe.setContentPane(writingArea);
        editor.mainframe.setVisible(true);


        new CurrentLineInfo(textArea);
    }//End of createWritingArea

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
