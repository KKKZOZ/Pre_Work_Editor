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


    public void actionPerforming(int action) {
        if (action == OPEN_FILE) {
            this.openFile();
        }
        if (action == SAVE_FILE) {
            this.saveFile();
        }
    }


}
