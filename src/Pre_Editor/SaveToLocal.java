package Pre_Editor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author KKKZOZ
 */
public class SaveToLocal {

    private final Pre_Editor editor;
    private final ActionExeManager actionExeManager;
    private final String fileDir;
    private final StringBuilder stringBuilder;

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
