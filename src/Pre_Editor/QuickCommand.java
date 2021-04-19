package Pre_Editor;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static Pre_Editor.Actions.OPEN_FILE;
import static Pre_Editor.Actions.SAVE_FILE;

/**
 * @author KKKZOZ
 */
public class QuickCommand {
    //Field
    private final CurrentLineInfo lineInfo;
    private final Pre_Editor editor;
    private final ArrayList<CommandDetail> commandList;
    private final static String CMD = "cmd";
    private final static int WORDS_COUNT=2;

    //Constructor
    public QuickCommand(Pre_Editor editor) {
        this.editor = editor;
        this.lineInfo = editor.writingArea.getCurrentLineInfo();
        commandList = new ArrayList<>();
        commandList.add(new CommandDetail("open", OPEN_FILE));
        commandList.add(new CommandDetail("save", SAVE_FILE));
        commandExecute();
    }


    //Method
    public void commandExecute() {
        StringTokenizer command = new StringTokenizer(lineInfo.getLineText(), " ");
        if (command.countTokens() != WORDS_COUNT) {
            editor.statusBar.textField.setText("Invalid Command!");
            return;
        }
        String head, tail;
        boolean isFound = false;
        head = command.nextToken();
        tail = command.nextToken();
        if (!CMD.equals(head)) {
            editor.statusBar.textField.setText("Invalid Command!");
        }

        for (CommandDetail cmd : commandList) {
            if (tail.equals(cmd.getCommandName())) {
                editor.actions.actionPerforming(cmd.getCommandAction());
                isFound = true;
                editor.statusBar.clear();
            }
        }
        if (!isFound) {
            editor.statusBar.textField.setText("Invalid Command!");
        }
    }//End of commandExecute
}
