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
    private final TextAction textAction;

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
    	
        if (action == ActionExeManager.NEW_TAB) {
            editor.workingManager.newTab("Untitled");
        }
        if (action == ActionExeManager.OPEN_FILE) {
            this.openFile();
        }
        if (action == ActionExeManager.SAVE_FILE) {
            this.saveFile();
        }
        if (action == ActionExeManager.CREATE_LINE_BENEATH) {
            editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().createNewLineBeneath();
        }
        if (action == ActionExeManager.CREATE_LINE_ABOVE) {
        	editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().createNewLineAbove();
        }
        if (action == ActionExeManager.CALCULATE) {
           
             new Calculate(editor);
        }
        if (action == ActionExeManager.CMD) {
//TODO
        	editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().deleteOffset(2);
        }
        if (action == ActionExeManager.QUICK_OPERATION) {
            new QuickOperation(editor);
        }
        if (action == ActionExeManager.MARKDOWN_PREVIEW) {
            new MarkdownPreview(editor);
        }
        if (action == ActionExeManager.SETTINGS) {
            new Settings(editor);
        }
        if (action == ActionExeManager.ABOUT) {
            //TODO
        	textAction.delete();
        }
      
        if (action == ActionExeManager.UP_CHANGE) {
            this.textAction.upchange();
        }
        if (action == ActionExeManager.DOWN_CHANGE) {
            this.textAction.downchange();
        }
        if (action == ActionExeManager.CLOSE_TAB) {
            editor.workingManager.closeSelectedTab(editor.workingManager.getSelectedIndex());
        }
        if (action == ActionExeManager.PAGE_UP_TAB) {
            if (editor.workingManager.getSelectedIndex() - 1 < 0) {
                editor.workingManager.setSelectedIndex(editor.workingManager.getTabCount()-1);
                return;
            }
            editor.workingManager.setSelectedIndex(editor.workingManager.getSelectedIndex()-1);
        }
        if (action == ActionExeManager.PAGE_DOWN_TAB) {
            if (editor.workingManager.getSelectedIndex() + 1 >= editor.workingManager.getTabCount()) {
                editor.workingManager.setSelectedIndex(0);
                return;
            }
            editor.workingManager.setSelectedIndex(editor.workingManager.getSelectedIndex()+1);
        }
        
        
        
    }
    public class TextAction {

    	private final CurrentLineInfo currentLineInfo;

		public TextAction(Pre_Editor editor) {
			currentLineInfo=editor.workingManager.getCurrentWritingArea().getCurrentLineInfo();
		}
    	
    	public  void delete() {
    		editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().delete();
        }
        public void upchange() {
        	if(currentLineInfo.getRow()==1) {
                return;
            }
        	int row=currentLineInfo.getRow();
        	String text1=currentLineInfo.getSelectedLine(row);
            String text2=currentLineInfo.getSelectedLine(row-1);
            currentLineInfo.setLineText(row, text2.replace("\n", ""));
            currentLineInfo.setLineText(row-1, text1.replace("\n", ""));
            currentLineInfo.reset();
             editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(currentLineInfo.tail[row-2]); 

        }
        public void downchange() {
          
            	if(currentLineInfo.getRow()==currentLineInfo.getRowCount()) {
                    return;
                }
                
                
              
            	int row=currentLineInfo.getRow();
                String text1=currentLineInfo.getLineText();//current           
                String text2=currentLineInfo.getSelectedLine(currentLineInfo.getRow()+1);
          
                System.out.println(text2.replace("\n", "")+text1.replace("\n", ""));
                if (row+1==currentLineInfo.getRowCount()) {
                	currentLineInfo.setLineText(row+1, text1.replace("\n", ""));
				}
                else {
                	currentLineInfo.setLineText(row+1, text1);
				}
                currentLineInfo.setLineText(row, text2.replace("\n", ""));

                currentLineInfo.reset();
                
                editor.workingManager.getCurrentWritingArea().textArea.setCaretPosition(currentLineInfo.tail[row]); 
        }
        

        

    }


}
