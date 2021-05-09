package Pre_Editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author KKKZOZ
 */
public class CustomizeManager {

    public static final Color DARK_GRAY_USED_GRAY = new Color(80, 80, 80);
    public static final Color DARK_GRAY_USED_BLUE = new Color(50, 50, 255);

    private Pre_Editor editor;
    private Color backgroundColor;
    private Color foregroundColor;
    private Color reservedWordColor;
    private Color operatorColor;
    private Color dataTypeColor;
    private Color numberColor;
    private Color commentColor;
    private Color lineHighlightColor;
    private Color selectionColor;

    public CustomizeManager(Pre_Editor editor) {
        this.editor = editor;
        setDefaultColor();
    }

    private void setDefaultColor() {
        backgroundColor = Color.DARK_GRAY;
        foregroundColor = Color.LIGHT_GRAY;
        reservedWordColor = Color.ORANGE;
        operatorColor = Color.LIGHT_GRAY;
        dataTypeColor = Color.ORANGE;
        numberColor = Color.YELLOW;
        commentColor = Color.GREEN;
        lineHighlightColor = DARK_GRAY_USED_GRAY;
        selectionColor = DARK_GRAY_USED_BLUE;
    }

    public void setCurrentTextArea(RSyntaxTextArea textArea) {
        setColor(textArea);
    }

    public void setPreviousTextArea() {
        ArrayList<WritingArea> list = editor.workingManager.getWritingAreaList();
        for (WritingArea writingArea : list) {
            setColor(writingArea.textArea);
        }
    }

    private void setColor(RSyntaxTextArea textArea) {
        textArea.setCurrentLineHighlightColor(lineHighlightColor);
        textArea.setSelectionColor(selectionColor);
        SyntaxScheme scheme = textArea.getSyntaxScheme();
        scheme.getStyle(Token.RESERVED_WORD).foreground = reservedWordColor;
        scheme.getStyle(Token.RESERVED_WORD_2).foreground = reservedWordColor;
        scheme.getStyle(Token.OPERATOR).foreground = operatorColor;
        scheme.getStyle(Token.DATA_TYPE).foreground = dataTypeColor;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
        //scheme.getStyle(Token.VARIABLE).foreground = Color.YELLOW;
        scheme.getStyle(Token.LITERAL_BOOLEAN).foreground = numberColor;
        scheme.getStyle(Token.LITERAL_NUMBER_FLOAT).foreground = numberColor;
        scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = numberColor;
        //scheme.getStyle(Token.)
        scheme.getStyle(Token.COMMENT_EOL).font = new Font("Georgia",
                Font.ITALIC, 12);
        scheme.getStyle(Token.COMMENT_MULTILINE).foreground = commentColor;
        scheme.getStyle(Token.COMMENT_MARKUP).foreground = commentColor;
    }

    //Getters and Setters

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Color getReservedWordColor() {
        return reservedWordColor;
    }

    public void setReservedWordColor(Color reservedWordColor) {
        this.reservedWordColor = reservedWordColor;
    }

    public Color getOperatorColor() {
        return operatorColor;
    }

    public void setOperatorColor(Color operatorColor) {
        this.operatorColor = operatorColor;
    }

    public Color getDataTypeColor() {
        return dataTypeColor;
    }

    public void setDataTypeColor(Color dataTypeColor) {
        this.dataTypeColor = dataTypeColor;
    }

    public Color getNumberColor() {
        return numberColor;
    }

    public void setNumberColor(Color numberColor) {
        this.numberColor = numberColor;
    }

    public Color getCommentColor() {
        return commentColor;
    }

    public void setCommentColor(Color commentColor) {
        this.commentColor = commentColor;
    }

    public Color getLineHighlightColor() {
        return lineHighlightColor;
    }

    public void setLineHighlightColor(Color lineHighlightColor) {
        this.lineHighlightColor = lineHighlightColor;
    }

    public Color getSelectionColor() {
        return selectionColor;
    }

    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
    }
}
