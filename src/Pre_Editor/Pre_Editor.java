package Pre_Editor;


import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Pre_Editor {

    //Field
    public JFrame mainframe;
    public WritingArea writingArea;
    public EditorMenu editorMenu;
    public Tray tray;
    public Settings settings;
    Point pressedPoint;

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
        mainframe.setUndecorated(true);
        //Basic attribute of mainframe

        //Set size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainframe.setMinimumSize(new Dimension(screenSize.width / 4,
                screenSize.height / 4));
        mainframe.setSize(new Dimension(screenSize.width / 2,
                screenSize.height / 2));
        mainframe.addMouseMotionListener(new MouseMotionAdapter() {
            public void mousePressed(MouseEvent e) { //鼠标按下事件
                pressedPoint = e.getPoint(); //记录鼠标坐标
            }
            public void mouseMoved(MouseEvent e) {
                System.out.println("Hello1");
                if (e.getSource() == mainframe) {
                    System.out.println("Hello");
                    int WIDTH = mainframe.getWidth();
                    int HIGHT = mainframe.getHeight();

                    if (e.getX() <= 1) {//左边界
                        System.out.println("L\n");
                        mainframe.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                    } else if (e.getX() >= WIDTH - 1) {//右边界
                        System.out.println("R\n");
                        mainframe.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                    } else if (e.getY() <= 1) {//上边界
                        System.out.println("U\n");
                        mainframe.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                    } else if (e.getY() >= HIGHT - 1) {//下边界
                        System.out.println("D\n");
                        mainframe.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
                    }
                } else {
                    mainframe.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));//默认光标
                }
            }
        });
        mainframe.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
                Point point = e.getPoint();// 获取当前坐标
                Point locationPoint = mainframe.getLocation();// 获取窗体坐标
                int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
                int y = locationPoint.y + point.y - pressedPoint.y;
                mainframe.setLocation(x, y);// 改变窗体位置
            }
        });




        mainframe.setVisible(true);
        mainframe.setTitle("Editor");
        mainframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        //Set location
        mainframe.setLocation((screenSize.width / 4), (screenSize.height / 4));
    }//End of initializeMainframe

    public static void initializeUI() {
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


}
