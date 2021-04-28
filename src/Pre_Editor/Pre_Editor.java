package Pre_Editor;


import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;

/**
 * @author KKKZOZ
 */
public class Pre_Editor {

    public JFrame mainframe;
    public EditorMenu editorMenu;
    public Tray tray;
    public Settings settings;
    public StatusBar statusBar;
    public Actions actions;
    public JPanel mainPanel;
    public Multi_use multiUse;
    public ActionExeManager actionExeManager;
    public WorkingManager workingManager;
    public SaveToLocal saveToLocal;

    /**The main method**/
    public static void main(String[] args) {
        initializeUI();
        new Pre_Editor();

    }


    /**Constructor**/
    public Pre_Editor() {
        this.mainPanel= new JPanel(new BorderLayout());
        this.initializeMainframe();
        this.workingManager = new WorkingManager(this);
        this.multiUse = new Multi_use(this);
        this.editorMenu = new EditorMenu(this);
        this.tray = new Tray(this);
        this.settings = new Settings(this);
        this.statusBar = new StatusBar(this);
        this.actions = new Actions(this);
        this.actionExeManager = new ActionExeManager(this);
        this.saveToLocal = new SaveToLocal(this);
    }//end of Constructor


    /**Initialize the mainframe**/
    public void initializeMainframe() {

        mainframe = new JFrame();


        //Set size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainframe.setMinimumSize(new Dimension(screenSize.width / 4,
                screenSize.height / 4));
        mainframe.setSize(new Dimension(screenSize.width / 2,
                screenSize.height / 2));


        mainframe.setVisible(true);
        mainframe.setTitle("Pre_Editor");
        mainframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        //Set location
        mainframe.setLocation((screenSize.width / 4), (screenSize.height / 4));
        mainframe.setContentPane(mainPanel);

    }//End of initializeMainframe

    public static void initializeUI() {
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


}
