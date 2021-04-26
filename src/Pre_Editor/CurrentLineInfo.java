package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

/**
 * @author ZHW
 */
public class CurrentLineInfo {
    private int caretPosition;
    private String lineText;
    private int row = 1;
    private int column = 0;
    private JTextArea currentTextArea;
    private int rowCount=0;
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
                
                	int start=currentTextArea.getLineStartOffset(getRow()-1);
                    int end=currentTextArea.getLineEndOffset(getRow()-1);
                    //打印偏移量
                    String str = currentTextArea.getText(start, end - start);
                    setCaretPosition(currentTextArea.getCaretPosition());
                   
                    setLineText(str);

                    //对所点击的JTextArea行的文本信息进行赋值

                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }//End of Constructor
    public String getSelectedLine(int line) {
    	line=line-1;
    	if(getRowCount()>=line)
    	{
 	
    	try {
        	int newstart=currentTextArea.getLineStartOffset(line);
            int newend=currentTextArea.getLineEndOffset(line);
            return currentTextArea.getText(newstart,newend-newstart);
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
    

}

