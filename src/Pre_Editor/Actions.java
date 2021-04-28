package Pre_Editor;

import javax.swing.*;
import java.io.*;

/**
 * @author KKKZOZ
 */
public class Actions {
    public static final int OPEN_FILE = 0;
    public static final int SAVE_FILE = 1;
    //Field
    private final Pre_Editor editor;
    private TextAction textAction;

    //Constructor
    public Actions(Pre_Editor editor) {
        this.editor = editor;
        this.textAction=new TextAction(editor);
    }//End of Constructor

    //Method
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(editor.mainframe);
        if (status == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder fileContent = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    fileContent.append((char) c);
                }
                editor.workingManager.getCurrentWritingArea().textArea.setText(fileContent.toString());
                editor.workingManager.getCurrentWritingArea().setFileDir(file.getPath());
                reader.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(editor.mainframe, "Error opening file!");

            }
        }
    }//End of openFile

    public void saveFile() {
        String filePath = editor.workingManager.getCurrentWritingArea().getFileDir();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
            bufferedWriter.write(editor.workingManager.getCurrentWritingArea().textArea.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(editor.mainframe, "Failed to save file");

        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }//End of saveFile


    
    

    public void actionPerforming(int action) {
    	
        if (action == ActionExeManager.NEW) {
            editor.workingManager.newTab("Untitled");
        }
        if (action == ActionExeManager.OPEN_FILE) {
            this.openFile();
        }
        if (action == ActionExeManager.SAVE_FILE) {
            this.saveFile();
        }
        if (action == ActionExeManager.CREATE_LINE_BENEATH) {
            this.textAction.createNewLineBeneath();
        }
        if (action == ActionExeManager.CREATE_LINE_ABOVE) {
            this.textAction.createNewLineAbove();
        }
        if (action == ActionExeManager.CALCULATE) {
           
             Calculate cal=new Calculate(editor);
        }
        if (action == ActionExeManager.CMD) {

        	
        }
        if (action == ActionExeManager.QUICK_OPERATION) {
            //TODO
        }
        if (action == ActionExeManager.MARKDOWN_PREVIEW) {
            //TODO
        }
        if (action == ActionExeManager.SETTINGS) {
            //TODO
        }
        if (action == ActionExeManager.ABOUT) {
            //TODO
        }
      
        if (action == ActionExeManager.UPCHANGE) {
            this.textAction.upchange();
        }
        if (action == ActionExeManager.DOWNCHANGE) {
            this.textAction.downchange();
        }
        
    }
    public class TextAction {

    	private CurrentLineInfo currentLineInfo;

		public TextAction(Pre_Editor editor) {
			currentLineInfo=editor.workingManager.getCurrentWritingArea().getCurrentLineInfo();
		}
    	
    	public void delete() {
            int start=currentLineInfo.getCaretPosition()-
                    currentLineInfo.getColumn();
            int end=currentLineInfo.getCaretPosition()+currentLineInfo.getLineText().length()
                    -currentLineInfo.getColumn();
            String text=editor.workingManager.getCurrentWritingArea().textArea.getText();
            int row=currentLineInfo.getRow();
            String firsttext=text.substring(0, start);
            String lasttext=text.substring(end, text.length());
            if(currentLineInfo.getRow()!=currentLineInfo.getRowCount()) {
                editor.workingManager.getCurrentWritingArea().textArea.setText(firsttext+lasttext);
            } else {
                String newString=firsttext+lasttext;
                editor.workingManager.getCurrentWritingArea().textArea.setText(newString.substring(0, newString.length()-1));
            }
            if(row!=1) {
                editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(start-1);
            } else {
                editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(0);
            }
        }
        public void upchange() {
            try {
            	if(currentLineInfo.getRow()==1) {
                    return;
                }
                int start=currentLineInfo.getCaretPosition()-
                        currentLineInfo.getColumn();
                int end=currentLineInfo.getCaretPosition()+currentLineInfo.getLineText().length()
                        -currentLineInfo.getColumn();
                String oringinString=editor.workingManager.getCurrentWritingArea().textArea.getText();
                boolean islast=currentLineInfo.getRow()==currentLineInfo.getRowCount();
                int upline =start- currentLineInfo.getSelectedLine(currentLineInfo.getRow()-1).length();
                String text1=currentLineInfo.getLineText();
                String text2=currentLineInfo.getSelectedLine(currentLineInfo.getRow()-1);
                String first= oringinString.substring(0, upline);
                String last=oringinString.substring(end, oringinString.length());
                if(!islast) {
                    editor.workingManager.getCurrentWritingArea().textArea.setText(first+text1+text2+last);
                    editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(upline+text1.length()-1);
                }
                else {
                    text2=text2.substring(0, text2.length()-1);
                    editor.workingManager.getCurrentWritingArea().textArea.setText(first+text1+"\n"+text2);
                    editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(upline+text1.length());
                }
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        public void downchange() {
            try {
            	if(currentLineInfo.getRow()==currentLineInfo.getRowCount()) {
                    return;
                }
                int start=currentLineInfo.getCaretPosition()-
                        currentLineInfo.getColumn();
                int end=currentLineInfo.getCaretPosition()+currentLineInfo.getLineText().length()
                        -currentLineInfo.getColumn();
                String oringinString=editor.workingManager.getCurrentWritingArea().textArea.getText();
                boolean islast2=currentLineInfo.getRow()==currentLineInfo.getRowCount()-1;
                int downline =end+ currentLineInfo.getSelectedLine(currentLineInfo.getRow()+1).length();
                String text1=currentLineInfo.getLineText();//current           
                String text2=currentLineInfo.getSelectedLine(currentLineInfo.getRow()+1);
                //downline
                String first= oringinString.substring(0, start);
               
                if (!islast2) {
                String last=oringinString.substring(downline, oringinString.length()-1);
                    editor.workingManager.getCurrentWritingArea().textArea.setText(first+text2+text1+"\n"+last);
                    editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(downline-1);
                }
                else {
                    text1.substring(0, text1.length()-1);
                	System.out.println(first+text2+text1);
                    editor.workingManager.getCurrentWritingArea().textArea.setText(first+text2+"\n"+text1);
                    editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(downline);
               }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        public void createNewLineAbove() {
            //add one line above the current line
            StringBuilder sb = new StringBuilder(editor.workingManager.getCurrentWritingArea().textArea.getText());
            int a=currentLineInfo.getCaretPosition()-
                    currentLineInfo.getColumn();//Expected caretlocation
            sb.insert(a, "\n");
            editor.workingManager.getCurrentWritingArea().textArea.setText(sb.toString());
            editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(a);
        }

        public void createNewLineBeneath() {
            //add one line beneath the current line.
            StringBuilder sb = new StringBuilder(editor.workingManager.getCurrentWritingArea().textArea.getText());
            int a=currentLineInfo.getCaretPosition()
                    +currentLineInfo.getLineText().length()
                    -currentLineInfo.getColumn();//Expected caretlocation
            boolean judge=currentLineInfo.getRow()==currentLineInfo.getRowCount();
            sb.insert(a, "\n");
            editor.workingManager.getCurrentWritingArea().textArea.setText(sb.toString());
            if (!judge) {

                editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(a);
            }
            else {
                editor.workingManager.getCurrentWritingArea().textArea.append("");
                editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(a+1);
            }
        }

    }


}
