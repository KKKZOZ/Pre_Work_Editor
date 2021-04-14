package Pre_Editor;

/**
 * @author KKKZOZ
 */
public class CommandDetail {
    //Field
    private String commandName;
    private int commandAction;

    //Constructor
    public CommandDetail(String name, int action) {
        this.commandName = name;
        this.commandAction = action;
    }

    //Method

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public int getCommandAction() {
        return commandAction;
    }

    public void setCommandAction(int commandAction) {
        this.commandAction = commandAction;
    }
}
