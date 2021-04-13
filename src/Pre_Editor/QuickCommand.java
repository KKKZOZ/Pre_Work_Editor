package Pre_Editor;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static Pre_Editor.Actions.OPEN_FILE;
import static Pre_Editor.Actions.SAVE_FILE;

public class QuickCommand {
    //Field
    private CurrentLineInfo lineInfo;
    private Pre_Editor editor;
    private ArrayList<CommandDetail> commandList;

    //Constructor
    public QuickCommand(Pre_Editor editor) {
        this.editor = editor;
        this.lineInfo = editor.writingArea.currentLineInfo;
        commandList = new ArrayList<CommandDetail>();
        commandList.add(new CommandDetail("open", OPEN_FILE));
        commandList.add(new CommandDetail("save", SAVE_FILE));
        commandExecute();
    }


    //Method
    public void commandExecute() {
        StringTokenizer command = new StringTokenizer(lineInfo.getLineText(), " ");
        if (command.countTokens() != 2) {
            editor.statusBar.textField.setText("Invalid Command!");
            return;
        }
        String head,tail;
        Boolean isFound=false;
        head = command.nextToken();
        tail = command.nextToken();
        if (!"cmd".equals(head)) {
            editor.statusBar.textField.setText("Invalid Command!");
        }

        for (CommandDetail cmd : commandList) {
            if (tail.equals(cmd.getCommandName())) {
                editor.actions.actionPerforming(cmd.getCommandAction());
                isFound = true;
            }
        }
        if (isFound == false) {
            editor.statusBar.textField.setText("Invalid Command!");
        }
    }//End of commandExecute
}
