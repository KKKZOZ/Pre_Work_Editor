package Pre_Editor;

/**
 * @author KKKZOZ
 */
public class MenuDetail {
    //Field
    public String menuName;
    public String actionLabel;
    public char accelerator;
    public boolean separatorBelow;

    //Constructor
    public MenuDetail(String name, char accelerator,
                      boolean sepBelow) {
        this.menuName = name;
        this.actionLabel = name;
        this.accelerator = accelerator;
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

    public boolean isSeparatorBelow() {
        return separatorBelow;
    }

    public void setSeparatorBelow(boolean separatorBelow) {
        this.separatorBelow = separatorBelow;
    }
}
