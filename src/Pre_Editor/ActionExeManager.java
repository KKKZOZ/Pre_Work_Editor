package Pre_Editor;

import java.util.ArrayList;

/**
 * @author KKKZOZ
 */
public class ActionExeManager {

    public static final int NEW = 1;
    public static final int OPEN_FILE=2;
    public static final int SAVE_FILE=3;
    public static final int CREATE_LINE_BENEATH = 4;
    public static final int CREATE_LINE_ABOVE = 5;
    public static final int CALCULATE = 6;
    public static final int CMD = 7;
    public static final int QUICK_OPERATION = 8;
    public static final int MARKDOWN_PREVIEW = 9;
    public static final int SETTINGS = 10;
    public static final int ABOUT = 11;


    public static final int KEY_EVENT_P = 16;


    private Pre_Editor editor;
    private ActionExe actionExe1;
    private ActionExe actionExe2;
    private ActionExe actionExe3;
    private ActionExe actionExe4;
    private ArrayList<ActionExe> actionList;


    public ActionExeManager(Pre_Editor editor) {
        this.editor = editor;
        actionExe1 = new ActionExe(1, 1,editor);
        actionExe2 = new ActionExe(2, 2,editor);
        actionExe3 = new ActionExe(3, 3,editor);
        actionExe4 = new ActionExe(4, 4,editor);

        actionList = new ArrayList<ActionExe>();
        actionList.add(actionExe1);
        actionList.add(actionExe2);
        actionList.add(actionExe3);
        actionList.add(actionExe4);
    }

    public ActionExe getActionExe(int index) {
        for (ActionExe exe : actionList) {
            if (index == exe.getId()) {
                return exe;
            }
        }
        return null;
    }

    public void setFunction(int index, int function) {
        for (ActionExe exe : actionList) {
            if (index == exe.getId()) {
                exe.setNowPerform(function);
                return;
            }
        }
    }


    public class ActionExeDetail {
        private int actionNumber;

        public void exe(int actionNumber) {

        }
    }

}
