package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class getLineText {
    public static int caretposition;
    public static String linetext;

    public getLineText(JTextArea textArea) {


        textArea.addCaretListener(new CaretListener() {


            public void caretUpdate(CaretEvent e) {

                JTextArea dArea = (JTextArea) e.getSource();

                try {
                    int height = 0;
                    Rectangle rec = dArea.modelToView(dArea.getCaretPosition());
                    height = rec.y / rec.height + 1;
                    //height为当前鼠标所点击的行数（第几行）
                    int start = dArea.getLineStartOffset(height - 1);
                    //确定给定行起始处的偏移量。
                    int end = dArea.getLineEndOffset(height - 1);

                    //打印偏移量
                    String str = dArea.getText(start, end - start);
                    caretposition = dArea.getCaretPosition();
                    linetext = str;


                    //对所点击的JTxtarea行的文本信息进行赋值

                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }


}

