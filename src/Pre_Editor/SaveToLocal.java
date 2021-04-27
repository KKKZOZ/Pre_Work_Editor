package Pre_Editor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author KKKZOZ
 */
public class SaveToLocal {

    private Pre_Editor editor;
    private ActionExeManager actionExeManager;
    private String fileDir;
    private StringBuilder stringBuilder;

    public SaveToLocal(Pre_Editor editor) {
        this.editor = editor;
        this.actionExeManager = editor.actionExeManager;
        this.fileDir = "";
        this.stringBuilder = new StringBuilder();
    }

    public void saveSettings() {

    }

    public void saveToFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileDir, false));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
