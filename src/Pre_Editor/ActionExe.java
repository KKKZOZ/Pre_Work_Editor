package Pre_Editor;

public class ActionExe {

    private final Pre_Editor editor;
    private final int id;
    private int nowPerform;

    public ActionExe(int id, int nowPerform, Pre_Editor editor) {
        this.editor = editor;
        this.id = id;
        this.nowPerform = nowPerform;
    }

    public void exe() {
        editor.actions.actionPerforming(nowPerform);
    }


    public int getId() {
        return id;
    }

    public int getNowPerform() {
        return nowPerform;
    }

    public void setNowPerform(int nowPerform) {
        this.nowPerform = nowPerform;
    }
}
