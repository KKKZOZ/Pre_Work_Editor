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


    //Constructor
    public Actions(Pre_Editor editor) {
        this.editor = editor;

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
                editor.writingArea.textArea.setText(fileContent.toString());
                editor.writingArea.setFileDir(file.getPath());
                reader.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(editor.mainframe, "Error opening file!");

            }
        }
    }//End of openFile

    public void saveFile() {
        String filePath = editor.writingArea.getFileDir();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
            bufferedWriter.write(editor.writingArea.textArea.getText());
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


    public void createNewLineAbove() {
        //add one line above the current line
        StringBuilder sb = new StringBuilder(editor.writingArea.textArea.getText());
        int a=editor.writingArea.getCurrentLineInfo().getCaretPosition()-
                editor.writingArea.getCurrentLineInfo().getColumn();//Expected caretlocation
        sb.insert(a, "\n");
        editor.writingArea.textArea.setText(sb.toString());
        editor.writingArea.textArea.setCaretPosition(a);
    }

    public void createNewLineBeneath() {
        //add one line beneath the current line.
        StringBuilder sb = new StringBuilder(editor.writingArea.textArea.getText());
        int a=editor.writingArea.getCurrentLineInfo().getCaretPosition()
                +editor.writingArea.getCurrentLineInfo().getLineText().length()
                -editor.writingArea.getCurrentLineInfo().getColumn();//Expected caretlocation
        boolean judge=editor.writingArea.getCurrentLineInfo().getRow()==editor.writingArea.getCurrentLineInfo().getRowCount();
        sb.insert(a, "\n");
        editor.writingArea.textArea.setText(sb.toString());
        if (!judge) {

            editor.writingArea.textArea.setCaretPosition(a);
        }
        else {
            editor.writingArea.textArea.append("");
            editor.writingArea.textArea.setCaretPosition(a+1);
        }
    }
    public void delete() {
        int start=editor.writingArea.getCurrentLineInfo().getCaretPosition()-
                editor.writingArea.getCurrentLineInfo().getColumn();
        int end=editor.writingArea.getCurrentLineInfo().getCaretPosition()+editor.writingArea.getCurrentLineInfo().getLineText().length()
                -editor.writingArea.getCurrentLineInfo().getColumn();
        String text=editor.writingArea.textArea.getText();
        System.out.println("st  "+start+"en  "+end+"length    "+editor.writingArea.textArea.getText().length());
        int row=editor.writingArea.getCurrentLineInfo().getRow();
        String firsttext=text.substring(0, start);
        String lasttext=text.substring(end, text.length());
        if(editor.writingArea.getCurrentLineInfo().getRow()!=editor.writingArea.getCurrentLineInfo().getRowCount())


            editor.writingArea.textArea.setText(firsttext+lasttext);
        else {
            String newString=firsttext+lasttext;
            editor.writingArea.textArea.setText(newString.substring(0, newString.length()-1));
        }
        if(row!=1)
            editor.writingArea.textArea.setCaretPosition(start-1);
        else {
            editor.writingArea.textArea.setCaretPosition(0);
        }
    }
    public void upchange() {
        try {
            int start=editor.writingArea.getCurrentLineInfo().getCaretPosition()-
                    editor.writingArea.getCurrentLineInfo().getColumn();
            int end=editor.writingArea.getCurrentLineInfo().getCaretPosition()+editor.writingArea.getCurrentLineInfo().getLineText().length()
                    -editor.writingArea.getCurrentLineInfo().getColumn();
            String oringinString=editor.writingArea.textArea.getText();
            boolean islast=editor.writingArea.getCurrentLineInfo().getRow()==editor.writingArea.getCurrentLineInfo().getRowCount();
            int upline =start- editor.writingArea.getCurrentLineInfo().getSelectedLine(editor.writingArea.getCurrentLineInfo().getRow()-1).length();
            String text1=editor.writingArea.getCurrentLineInfo().getLineText();
            String text2=editor.writingArea.getCurrentLineInfo().getSelectedLine(editor.writingArea.getCurrentLineInfo().getRow()-1);
            String first= oringinString.substring(0, upline);
            String last=oringinString.substring(end, oringinString.length());
            if(!islast) {
                editor.writingArea.textArea.setText(first+text1+text2+last);
                editor.writingArea.textArea.setCaretPosition(upline+text1.length()-1);
            }
            else {
                text2=text2.substring(0, text2.length()-1);
                editor.writingArea.textArea.setText(first+text1+"\n"+text2);
                editor.writingArea.textArea.setCaretPosition(upline+text1.length());
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void downchange() {
        try {
            int start=editor.writingArea.getCurrentLineInfo().getCaretPosition()-
                    editor.writingArea.getCurrentLineInfo().getColumn();
            int end=editor.writingArea.getCurrentLineInfo().getCaretPosition()+editor.writingArea.getCurrentLineInfo().getLineText().length()
                    -editor.writingArea.getCurrentLineInfo().getColumn();
            String oringinString=editor.writingArea.textArea.getText();
            boolean islast2=editor.writingArea.getCurrentLineInfo().getRow()==editor.writingArea.getCurrentLineInfo().getRowCount()-1;
            int downline =end+ editor.writingArea.getCurrentLineInfo().getSelectedLine(editor.writingArea.getCurrentLineInfo().getRow()+1).length();
            String text1=editor.writingArea.getCurrentLineInfo().getLineText();
            String text2=editor.writingArea.getCurrentLineInfo().getSelectedLine(editor.writingArea.getCurrentLineInfo().getRow()+1);
            String first= oringinString.substring(0, start);
            String last=oringinString.substring(downline, oringinString.length());
            if (!islast2) {
                editor.writingArea.textArea.setText(first+text2+text1+last);
                editor.writingArea.textArea.setCaretPosition(downline-1);
            }
            else {
                text1.substring(0, text1.length()-18);

                editor.writingArea.textArea.setText(first+text2+"\n"+text1);
                editor.writingArea.textArea.setCaretPosition(downline);
            }

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


    public void actionPerforming(int action) {
        if (action == ActionExeManager.NEW) {
            this.openFile();
        }
        if (action == ActionExeManager.OPEN_FILE) {
            this.openFile();
        }
        if (action == ActionExeManager.SAVE_FILE) {
            this.saveFile();
        }
    }


}
