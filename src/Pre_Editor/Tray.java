package Pre_Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author ZHW
 */
public class Tray {
    //Field
    private final Pre_Editor editor;




    //Constructor
    public Tray(Pre_Editor editor) {
        this.editor=editor;
        this.createTray();
    }

    //Method
    public void createTray() {

    	 editor.mainframe.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
             	Object[] options = new Object[]{"exit", "Minimizes", "cancel"};
             	editor.mainframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                 // 显示选项对话框, 返回选择的选项索引, 点击关闭按钮返回-1
                 int optionSelected = JOptionPane.showOptionDialog(
                         editor.mainframe,
                         "Do you Really want to exit?",
                         "Confirm Exit",
                         JOptionPane.YES_NO_CANCEL_OPTION,
                         JOptionPane.ERROR_MESSAGE,
                         null,
                         options,    // 如果传null, 则按钮为 optionType 类型所表示的按钮（也就是确认对话框）
                         options[0]
                 );

                 if (optionSelected >= 0) {
                     if(optionSelected==0)
                     {
                     	System.exit(0);
                     }
                     if(optionSelected==1)
                     {
                     	editor.mainframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                     }

                 }
                 
             }
             
         });
    	
    	

        if (SystemTray.isSupported()) {
            // Get the system tray of the current platform
            SystemTray tray = SystemTray.getSystemTray();

            // Load a picture to display the tray icon
            Image image = Toolkit.getDefaultToolkit().getImage("editor.png");

            // Create a pop-up menu when you click the icon
            PopupMenu popupMenu = new PopupMenu();

            MenuItem openItem = new MenuItem("open");
            MenuItem exitItem = new MenuItem("exit");

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Click to open the menu to display the window
                    if (!editor.mainframe.isShowing()) {
                        editor.mainframe.setVisible(true);
                    }
                }
            });

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Click Exit menu to exit the program
                    System.exit(0);
                }
            });

            popupMenu.add(openItem);
            popupMenu.add(exitItem);

            // Create a tray icon
            TrayIcon trayIcon = new TrayIcon(image, "others.Editor Master", popupMenu);

            // Tray icon adaptive size
            trayIcon.setImageAutoSize(true);


            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        editor.mainframe.setVisible(true);
                    }
                }
            });
            // Add tray icon to system tray
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The current system does not support system tray\r\n");
        }
        editor.mainframe.setVisible(true);
    }
}
