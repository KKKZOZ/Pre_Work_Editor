package Pre_Editor;

import javax.swing.*;

/**
 * @author KKKZOZ
 */
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
        this.menuName = name;
        this.actionLabel = name;
        this.accelerator = accelerator;
        this.keyStroke = keyStroke;
        this.separatorBelow = sepBelow;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public char getAccelerator() {
        return accelerator;
    }

    public void setAccelerator(char accelerator) {
        this.accelerator = accelerator;
    }

    public KeyStroke getKeyStroke() {
        return keyStroke;
    }

    public void setKeyStroke(KeyStroke keyStroke) {
        this.keyStroke = keyStroke;
    }

    public boolean isSeparatorBelow() {
        return separatorBelow;
    }

    public void setSeparatorBelow(boolean separatorBelow) {
        this.separatorBelow = separatorBelow;
    }
}
