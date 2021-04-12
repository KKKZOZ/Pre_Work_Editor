import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * 取消窗口边框
 *
 */
public class NoneFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    Point pressedPoint;

    public NoneFrame() {
        this.getContentPane().setBackground(new Color(195, 184, 162)); // 设置窗体背景颜色
        this.setUndecorated(true);// 取消窗体修饰效果
        this.getContentPane().setLayout(null);// 窗体使用绝对布局
        this.setLocationRelativeTo(null);// 窗体居中
        this.setAlwaysOnTop(true); //窗体最顶层显示

        JLabel l1 = new JLabel(); // 使用便签存放logo
        ImageIcon icon = new ImageIcon("Image/03.jpg");
        l1.setIcon(icon);
        l1.setBounds(25, 27, 122, 122);
        this.getContentPane().add(l1);// 加载进窗体

        JTextArea t = new JTextArea();
        t.setOpaque(false);// 设置文本背景为透明
        t.setEditable(true);//移除焦点
        t.setText("Eduardo：\n" + "我要飞得更高\n" + "周一至周日：09:00-22:00");
        t.setBounds(180, 28, 187, 154);
        this.getContentPane().add(t);

        JButton b = new JButton("关闭");
        b.addActionListener(new ActionListener() {// 设置按钮关闭动作事件处理
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        b.setBounds(230, 165, 90, 30);
        this.getContentPane().add(b);
        /**
         * 窗体鼠标移动事件
         */
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { //鼠标按下事件
                pressedPoint = e.getPoint(); //记录鼠标坐标
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
                Point point = e.getPoint();// 获取当前坐标
                Point locationPoint = getLocation();// 获取窗体坐标
                int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
                int y = locationPoint.y + point.y - pressedPoint.y;
                setLocation(x, y);// 改变窗体位置
            }
        });

        this.setTitle("");
        this.setBounds(100, 100, 354, 206);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new NoneFrame();
    }
}
