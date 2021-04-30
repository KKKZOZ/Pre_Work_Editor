package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * @author ZHW
 */
public class CurrentLineInfo {
    int tail[];
    int head[];
    private int caretPosition;
    private String lineText;
    private int row = 1;
    private int column = 0;
    private JTextArea currentTextArea;
    private int rowCount = 0;

    //Constructor
    public CurrentLineInfo(JTextArea textArea) {


        textArea.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {

                currentTextArea = (JTextArea) e.getSource();
                setRowCount(currentTextArea.getLineCount());
                int row1 = 1;
                int column1 = 1;

                try {
                    //获取行数与列数
                    int carePos = currentTextArea.getCaretPosition();
                    row1 = currentTextArea.getLineOfOffset(carePos);
                    column1 = carePos - currentTextArea.getLineStartOffset(row1);
                    row1 += 1;
                    row = row1;

                    column = column1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


                try {

                    int start = currentTextArea.getLineStartOffset(getRow() - 1);
                    int end = currentTextArea.getLineEndOffset(getRow() - 1);
                    //打印偏移量
                    String str = currentTextArea.getText(start, end - start);
                    setCaretPosition(currentTextArea.getCaretPosition());

                    setLineText(str);

                    //对所点击的JTextArea行的文本信息进行赋值

                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }


                if (currentTextArea != null) {
                    doclistener();
                }


            }
        });


    }//End of Constructor

    public void insertAtCaretPosition(String text) {
        int pos = getCaretPosition();
        currentTextArea.insert(text, pos);

    }

    public void setCaretOffSet(int offSet) {
        if (getCaretPosition() + offSet >= 0 && getCaretPosition() + offSet <= currentTextArea.getText().length()) {
            currentTextArea.setCaretPosition(getCaretPosition() + offSet);
        }
    }

    public boolean isInBracket() {
        return true;
    }


    public void doclistener() {

        currentTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            //set the array head and  tail
            public void insertUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reset();
            }
        });


    }

    public void setLineText(int lineNumber, String text) {

        int start = head[lineNumber - 1];
        int end = tail[lineNumber - 1];
        if (lineNumber != getRowCount()) {
            currentTextArea.replaceRange(text, start, end);
        } else {
            currentTextArea.replaceRange(text, start - 1, end);
        }

    }

    public void appendLineText(int lineNumber, String text) {
        int start = tail[lineNumber - 1];
        currentTextArea.insert(text, start);
    }

    public void moveToLineHead() {
        currentTextArea.setCaretPosition(getCaretPosition() - getColumn());
    }

    public void moveToLineTail() {
        currentTextArea.setCaretPosition(getCaretPosition() + getLineText().length() - getColumn());
    }

    public void deleteOffset(int offset) {
        //光标向前向后删除（前正后负）
        if (getCaretPosition() - offset < 0 || getCaretPosition() - offset > currentTextArea.getText().length()) {
            return;
        }

        if (offset <= 0) {
            currentTextArea.replaceRange("", getCaretPosition(), getCaretPosition() - offset);
        } else {
            currentTextArea.replaceRange("", getCaretPosition() - offset, getCaretPosition());
        }

    }


    public String getSelectedLine(int line) {
        line = line - 1;
        if (getRowCount() >= line) {

            try {
                int newstart = currentTextArea.getLineStartOffset(line);
                int newend = currentTextArea.getLineEndOffset(line);
                return currentTextArea.getText(newstart, newend - newstart);


            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        throw new RuntimeException("Out of Range");
    }

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

    public int getRowCount() {
        return rowCount;
    }

    private void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int[] getTail() {
        return tail;
    }

    public void setTail(int[] tail) {
        this.tail = tail;
    }

    public int[] getHead() {
        return head;
    }

    public void setHead(int[] head) {
        this.head = head;
    }

    public void delete() {
        int start = head[getRow() - 1];
        int end = tail[getRow() - 1];
        if (getRow() + 1 == getRowCount()) {
            if (getRow() == 1) {
                currentTextArea.replaceRange("", 0, end + 1);
            } else {
                currentTextArea.replaceRange("", start, end + 1);
            }
        } else {
            if (getRow() != getRowCount()) {
                currentTextArea.replaceRange("", start - 1, end);
            } else if (getRow() == 1) {
                currentTextArea.replaceRange("", 0, end);
            } else {
                currentTextArea.replaceRange("", start - 2, end);
            }

        }
        reset();
    }

    public void reset() {
        int oringin[] = new int[getRowCount()];
        int head[] = new int[getRowCount()];

        for (int i = 0; i < oringin.length; i++) {
            try {

                if (i + 1 != getRowCount()) {
                    oringin[i] = currentTextArea.getLineEndOffset(i) - 1;
                    head[i] = oringin[i] - getSelectedLine(i + 1).length() + 1;
                } else {
                    oringin[i] = currentTextArea.getLineEndOffset(i);
                    head[i] = oringin[i] - getSelectedLine(i + 1).length() + 1;
                }
            } catch (BadLocationException e1) {


            }
        }
        setTail(oringin);
        setHead(head);
    }

    public void createNewLineAbove() {
        //add one line above the current line
        if (getRow() == 1) {
            return;
        }
        currentTextArea.insert("\n", head[getRow() - 1]);

    }

    public void createNewLineBeneath() {
        //add one line beneath the current line.
        if (getRow() == getRowCount()) {
            return;
        }
        currentTextArea.insert("\n", tail[getRow() - 1]);
    }


}

