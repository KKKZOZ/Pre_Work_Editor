package Pre_Editor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author KKKZOZ
 */
public class GetFromLocal {

    private final Pre_Editor editor;
    private final String fileDir;

    public GetFromLocal(Pre_Editor editor) {
        this.editor = editor;
        this.fileDir = "config.txt";
    }

    public void getSettings() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileDir));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
