package Pre_Editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * @author KKKZOZ
 */
public class WritingArea {

    //Field
    private Pre_Editor editor;
    public JSplitPane writingArea;
    public RSyntaxTextArea textArea;
    public RTextScrollPane textScrollPane;
    public Gutter gutter;
    public CurrentLineInfo currentLineInfo;
    private String fileDir;


    //Constructor
    public WritingArea(Pre_Editor editor) {
        this.editor = editor;
        this.writingArea = new JSplitPane();
//        this.textArea = new JTextArea();
        this.textArea = new RSyntaxTextArea();
        this.initializeTextArea();

        this.createWritingArea();
        currentLineInfo = new CurrentLineInfo(textArea);
        this.fileDir = "";
    }


    //Method


    public void initializeTextArea() {
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAnimateBracketMatching(true);
        textArea.setAntiAliasingEnabled(true);
        textArea.setAutoIndentEnabled(true);
        textArea.setFadeCurrentLineHighlight(true);
        textArea.setCloseCurlyBraces(true);
        textArea.setPopupMenu(null);
    }

    public void createWritingArea() {
        //Create objects

        textScrollPane = new RTextScrollPane(textArea, true);
        gutter = textScrollPane.getGutter();
        gutter.setBookmarkingEnabled(true);


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
