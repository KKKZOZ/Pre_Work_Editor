package Pre_Editor;


import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;

public class Pre_Editor {

    //Field
    public JFrame mainframe;
    public WritingArea writingArea;
    public EditorMenu editorMenu;
    public Tray tray;
    public Settings settings;
    //Main
    public static void main(String[] args) {

        initializeUI();
        new Pre_Editor();

    }

    //Constructor
    public Pre_Editor() {

        this.initializeMainframe();
        this.editorMenu = new EditorMenu(this);
        this.tray = new Tray(this);
        this.writingArea = new WritingArea(this);
        this.settings = new Settings(this);



    }//end of Constructor


    //Method
    public void initializeMainframe() {

        mainframe = new JFrame();
        //Basic attribute of mainframe

        mainframe.setVisible(true);
        mainframe.setTitle("Editor");
        mainframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        //Set size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainframe.setMinimumSize(new Dimension(screenSize.width / 4,
                screenSize.height / 4));
        mainframe.setSize(new Dimension(screenSize.width / 2,
                screenSize.height / 2));

        //Set location
        mainframe.setLocation((screenSize.width / 4), (screenSize.height / 4));
    }

    public static void initializeUI() {
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }



}
