package Pre_Editor;

import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.spell.SpellingParser;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * @author KKKZOZ
 */
public class WritingArea {

    //Field
    private final Pre_Editor editor;
    private final CurrentLineInfo currentLineInfo;
    public JPanel writingArea;
    public RSyntaxTextArea textArea;
    public Gutter gutter;
    private RTextScrollPane textScrollPane;
    private String fileDir;
    private String fileName;
    private boolean markdownOpen = false;
    private boolean compileCheck = false;


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
        this.fileName = "";
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
//        textArea.setCurrentLineHighlightColor(new Color(80, 80, 80));
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.LIGHT_GRAY);
//        textArea.setSelectionColor(new Color(50, 50, 255));
        addKeyShortCut();
//        changeStyle();
        extendTextArea();
    }

    private void addKeyShortCut() {
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
//                System.out.println((int)keyChar);
//                if (Character.isLetter(keyChar) && Character.isLowerCase(keyChar)) {
//                    System.out.println("???");
//                    keyChar = Character.toUpperCase(keyChar);
//                }

//                System.out.println((int)keyChar);
                int keyCode = e.getKeyCode();
//                System.out.println((int)keyChar);


                //When Ctrl + N is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_N && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(1).exe();
                }

                //When Ctrl + O is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_O && e.isControlDown()) {


                    editor.actionExeManager.getActionExe(2).exe();
                }

                //When Ctrl + S is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_S && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(3).exe();
                }

                //When Ctrl + Q is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_Q && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(4).exe();
                }

                //When Ctrl + W is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_W && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(5).exe();
                }

                //When Ctrl + E is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_E && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(6).exe();
                }

                //When Ctrl + R is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_R && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(7).exe();
                }

                //When Ctrl + T is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_T && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(8).exe();
                }

                //When Ctrl + U is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_U && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(9).exe();
                }

                //When Ctrl + I is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_I && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(10).exe();
                }

                //When Ctrl + L is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_L && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(11).exe();
                }

                //When Ctrl + K is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_K && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(12).exe();
                }

                //When Ctrl + J is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_J && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(13).exe();
                }

                //When Ctrl + H is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_H && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(14).exe();
                }

                //When Ctrl + Shift + Left is pressed
                if (keyCode == ActionExeManager.KEY_EVENT_LEFT && e.isControlDown() && e.isShiftDown()) {

                    editor.actionExeManager.getActionExe(15).exe();
                }

                //When Ctrl + Shift + Right is pressed
                if (keyCode == ActionExeManager.KEY_EVENT_RIGHT && e.isControlDown() && e.isShiftDown()) {

                    editor.actionExeManager.getActionExe(16).exe();
                }

                //When Ctrl + P is pressed
                if (keyChar == ActionExeManager.KEY_EVENT_P && e.isControlDown()) {

                    editor.actionExeManager.getActionExe(17).exe();

                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

                char keyChar = e.getKeyChar();
                if (keyChar == ActionExeManager.KEY_EVENT_OPEN_BRACKET) {
                    editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().insertAtCaretPosition(")");
                    editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().setCaretOffSet(-1);
                }

                if (keyChar == ActionExeManager.KEY_EVENT_OPEN_PARENTHESIS) {
                    editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().insertAtCaretPosition("]");
                    editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().setCaretOffSet(-1);
                }

            }
        });
    }

    private void extendTextArea() {
        LanguageSupportFactory.get().register(textArea);
        File zip = new File("english_dic.zip");
        boolean usEnglish = true; // "false" will use British English
        SpellingParser parser = null;
        try {
            parser = SpellingParser.createEnglishSpellingParser(zip, usEnglish);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.addParser(parser);


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
//        editor.mainPanel.add(writingArea, BorderLayout.CENTER);
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

    public boolean isMarkdownIsOpen() {
        return markdownOpen;
    }

    public void setMarkdownIsOpen(boolean isMarkdownOpen) {
        this.markdownOpen = isMarkdownOpen;
    }

    public boolean isCompileCheck() {
        return compileCheck;
    }

    public void setCompileCheck(boolean compileCheck) {
        this.compileCheck = compileCheck;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
