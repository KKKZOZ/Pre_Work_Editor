package Pre_Editor;

public class ActionExe {

    private final Pre_Editor editor;
    private final int id;
    private int function;

    public ActionExe(int id, int function, Pre_Editor editor) {
        this.editor = editor;
        this.id = id;
        this.function = function;
    }

    public void exe() {
        editor.actions.actionPerforming(function);
    }


    public int getId() {
        return id;
    }

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }
}
