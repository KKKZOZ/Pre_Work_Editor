package Pre_Editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

/**
 * @author KKKZOZ
 */
public class WritingArea {

    public JPanel writingArea;
    public RSyntaxTextArea textArea;
    public Gutter gutter;
    //Field
    private final Pre_Editor editor;
    private RTextScrollPane textScrollPane;
    private final CurrentLineInfo currentLineInfo;
    private String fileDir;


    //Constructor
    public WritingArea(Pre_Editor editor) {
        this.editor = editor;
        this.writingArea = new JPanel(new BorderLayout());
//      this.textArea = new JTextArea();
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
        textArea.setBracketMatchingEnabled(true);
        textArea.setCurrentLineHighlightColor(new Color(80, 80, 80));
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setSelectionColor(new Color(50, 50, 255));
        changeStyle();

    }

    private void changeStyle() {

        SyntaxScheme scheme = textArea.getSyntaxScheme();

        scheme.getStyle(Token.RESERVED_WORD).foreground = Color.ORANGE;
        scheme.getStyle(Token.RESERVED_WORD_2).foreground = Color.ORANGE;
        scheme.getStyle(Token.OPERATOR).foreground = Color.lightGray;
        scheme.getStyle(Token.DATA_TYPE).foreground = Color.ORANGE;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
        scheme.getStyle(Token.VARIABLE).foreground = Color.YELLOW;
        scheme.getStyle(Token.LITERAL_BOOLEAN).foreground = Color.YELLOW;
        scheme.getStyle(Token.LITERAL_NUMBER_FLOAT).foreground = Color.YELLOW;
        scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = Color.YELLOW;
        //scheme.getStyle(Token.)
        scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",
                Font.ITALIC, 12);
        scheme.getStyle(Token.COMMENT_MULTILINE).foreground = Color.GREEN;
        scheme.getStyle(Token.COMMENT_MARKUP).foreground = Color.GREEN;
    }

    public void createWritingArea() {
        //Create objects

        textScrollPane = new RTextScrollPane(textArea, true);
        gutter = textScrollPane.getGutter();
        gutter.setBookmarkingEnabled(true);


        //scrollPane.setViewportView(label);

        //Set the attribute of splitPane
        writingArea.add(textScrollPane, BorderLayout.CENTER);
//        writingArea.setTopComponent(textScrollPane);
//
//        writingArea.setOrientation(JSplitPane.VERTICAL_SPLIT);
//        writingArea.setContinuousLayout(true);
//        writingArea.setOneTouchExpandable(false);
//        writingArea.setDividerSize(5);
        //writingArea.setDividerLocation(0.98);


//        writingArea.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                writingArea.setDividerLocation(0.98);
//            }
//        });


//        editor.mainframe.setContentPane(writingArea);
        editor.mainPanel.add(writingArea, BorderLayout.CENTER);
        editor.mainframe.setVisible(true);


        new CurrentLineInfo(textArea);
//        writingArea.setDividerLocation(0.02);
    }//End of createWritingArea

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public RSyntaxTextArea getTextArea() {
        return textArea;
    }

    public RTextScrollPane getTextScrollPane() {
        return textScrollPane;
    }

    public CurrentLineInfo getCurrentLineInfo() {
        return currentLineInfo;
    }
}
