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
    private String savings;

    public SaveToLocal(Pre_Editor editor) {
        this.editor = editor;
        this.actionExeManager = editor.actionExeManager;
        this.fileDir = "config.txt";
        this.savings = "";
        this.stringBuilder = new StringBuilder();
    }

    public void saveSettings() {
        saveColors();
        saveToFile();
    }

    private void saveColors() {
        String savginsColors = "";
        savginsColors += editor.customizeManager.getForegroundColor() + "\n";
        savginsColors += editor.customizeManager.getBackgroundColor() + "\n";
        savginsColors += editor.customizeManager.getCommentColor() + "\n";
        savginsColors += editor.customizeManager.getNumberColor() + "\n";
        savginsColors += editor.customizeManager.getDataTypeColor() + "\n";
        savginsColors += editor.customizeManager.getOperatorColor();
        savings += savginsColors;
    }

    public void saveToFile() {

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileDir, false));
            bufferedWriter.write(savings);
            bufferedWriter.close();
            //System.out.println(savings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
