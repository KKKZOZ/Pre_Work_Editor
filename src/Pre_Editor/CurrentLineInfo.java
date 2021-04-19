package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

/**
 * @author ZHW
 */
public class CurrentLineInfo {
    private int caretPosition;
    private String lineText;
    private int row = 1;
    private int column = 0;


    //Constructor
    public CurrentLineInfo(JTextArea textArea) {

        textArea.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {

                JTextArea dArea = (JTextArea) e.getSource();

                int row1 = 1;
                int column1 = 1;

                try {
                    //获取行数与列数
                    int carePos = dArea.getCaretPosition();
                    row1 = dArea.getLineOfOffset(carePos);
                    column1 = carePos - dArea.getLineStartOffset(row1);
                    row1 += 1;
                    row = row1;

                    column = column1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


                try {
                    //获取本行文字
                    int height = 0;
                    Rectangle rec = dArea.modelToView(dArea.getCaretPosition());
                    height = rec.y / rec.height + 1;
                    //height为当前鼠标所点击的行数（第几行）
                    int start = dArea.getLineStartOffset(height - 1);
                    //确定给定行起始处的偏移量。
                    int end = dArea.getLineEndOffset(height - 1);

                    //打印偏移量
                    String str = dArea.getText(start, end - start);
                    setCaretPosition(dArea.getCaretPosition());


                    setLineText(str);

                    //对所点击的JTextArea行的文本信息进行赋值

                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }//End of Constructor


    //Method
    //Getters and Setters

    public int getCaretPosition() {
        return caretPosition;
    }

    public void setCaretPosition(int caretPosition) {
        this.caretPosition = caretPosition;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

