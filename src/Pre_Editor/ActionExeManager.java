package Pre_Editor;

import java.util.ArrayList;

/**
 * @author KKKZOZ
 */
public class ActionExeManager {

    public static final int NEW = 1;
    public static final int OPEN_FILE = 2;
    public static final int SAVE_FILE = 3;
    public static final int CREATE_LINE_BENEATH = 4;
    public static final int CREATE_LINE_ABOVE = 5;
    public static final int CALCULATE = 6;
    public static final int CMD = 7;
    public static final int QUICK_OPERATION = 8;
    public static final int MARKDOWN_PREVIEW = 9;
    public static final int SETTINGS = 10;
    public static final int ABOUT = 11;
    public static final int UPCHANGE = 12;
    public static final int DOWNCHANGE = 13;


    public static final int KEY_EVENT_P = 16;//1
    public static final int KEY_EVENT_O = 15;//2
    public static final int KEY_EVENT_S = 19;//3
    public static final int KEY_EVENT_Q = 17;//4
    public static final int KEY_EVENT_W = 23;//5
    public static final int KEY_EVENT_E = 5;//6
    public static final int KEY_EVENT_R = 18;//7
    public static final int KEY_EVENT_T = 20;//8
    public static final int KEY_EVENT_U = 21;//9
    public static final int KEY_EVENT_I = 9;//10
    public static final int KEY_EVENT_L = 12;//11
    public static final int KEY_EVENT_K = 11;//12
    public static final int KEY_EVENT_J = 10;//13
    public static final int KEY_EVENT_H = 8;//14

    private Pre_Editor editor;
    private ActionExe actionExe1;
    private ActionExe actionExe2;
    private ActionExe actionExe3;
    private ActionExe actionExe4;
    private ActionExe actionExe5;
    private ActionExe actionExe6;
    private ActionExe actionExe7;
    private ActionExe actionExe8;
    private ActionExe actionExe9;
    private ActionExe actionExe10;
    private ActionExe actionExe11;
    private ActionExe actionExe12;
    private ActionExe actionExe13;
    private ActionExe actionExe14;
    private ArrayList<ActionExe> actionList;


    public ActionExeManager(Pre_Editor editor) {
        this.editor = editor;
        actionExe1 = new ActionExe(1, 1, editor);
        actionExe2 = new ActionExe(2, 2, editor);
        actionExe3 = new ActionExe(3, 3, editor);
        actionExe4 = new ActionExe(4, 4, editor);
        actionExe5 = new ActionExe(5, 5, editor);
        actionExe6 = new ActionExe(6, 6, editor);
        actionExe7 = new ActionExe(7, 7, editor);
        actionExe8 = new ActionExe(8, 8, editor);
        actionExe9 = new ActionExe(9, 9, editor);
        actionExe10 = new ActionExe(10, 10, editor);
        actionExe11 = new ActionExe(11, 11, editor);
        actionExe12 = new ActionExe(12, 12, editor);
        actionExe13 = new ActionExe(13, 13, editor);
        actionExe14 = new ActionExe(14, 14, editor);

        actionList = new ArrayList<ActionExe>();
        actionList.add(actionExe1);
        actionList.add(actionExe2);
        actionList.add(actionExe3);
        actionList.add(actionExe4);
        actionList.add(actionExe5);
        actionList.add(actionExe6);
        actionList.add(actionExe7);
        actionList.add(actionExe8);
        actionList.add(actionExe9);
        actionList.add(actionExe10);
        actionList.add(actionExe11);
        actionList.add(actionExe12);
        actionList.add(actionExe13);
        actionList.add(actionExe14);
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
