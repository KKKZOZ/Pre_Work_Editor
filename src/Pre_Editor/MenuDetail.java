package Pre_Editor;

import javax.swing.*;

public class MenuDetail {
    //Field
    public String menuName;
    public String actionLabel;
    public char accelerator;
    public KeyStroke keyStroke;
    public boolean separatorBelow;

    //Constructor
    public MenuDetail(String name, char accelerator, KeyStroke keyStroke,
                      boolean sepBelow) {
        this.menuName=name;
        this.actionLabel=name;
        this.accelerator=accelerator;
        this.keyStroke=keyStroke;
        this.separatorBelow =sepBelow;
    }
}
