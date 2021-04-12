package Pre_Editor;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

public class getLineText {
	 public static int caretposition;
		public static String linetext;
		public static int row=0,column=0;
    public getLineText(JTextArea textArea) {

    
    	 textArea.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {

                 JTextArea dArea = (JTextArea) e.getSource();
                 
                 int row1 = 1;
                 int column1 = 1;

                 try {
                	 //获取行数与列数
                     int caretpos = dArea.getCaretPosition();
                     row1 = dArea.getLineOfOffset(caretpos);
                     column1 = caretpos - dArea.getLineStartOffset(row1);
                     row1 += 1;
                     row=row1;
                     column=column1;
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 
                 
                 try {
                	 //获取本行文字
                     int height =0;
                     Rectangle rec = dArea.modelToView(dArea.getCaretPosition());
                     height=rec.y / rec.height + 1;
                     	//height为当前鼠标所点击的行数（第几行）
                     int start=dArea.getLineStartOffset(height-1);
                     //确定给定行起始处的偏移量。
                     int end = dArea.getLineEndOffset(height-1);
          
                     //打印偏移量
                     String str = dArea.getText(start, end-start); 
                     caretposition=dArea.getCaretPosition();
                     linetext=str;
                   
                   
                     //对所点击的JTxtarea行的文本信息进行赋值

                               } catch (BadLocationException e1) {
                                e1.printStackTrace();
                               }

             }
         });
    }
    
    
 
               
               
 
	
}

