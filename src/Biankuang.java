import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Biankuang {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setBounds(400, 300, 200, 200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.red));
        frame1.add(panel);
        frame1.setVisible(true);
        JFrame frame2 = new JFrame() {
            public void paint(Graphics g) {
                super.paint(g);
                Rectangle rect = this.getBounds();
                int width = (int) rect.getWidth() - 1;
                int height = (int) rect.getHeight() - 1;
                g.setColor(Color.red);
                g.drawRect(0, 0, width, height);
            }
        };
        frame2.setBounds(650, 300, 200, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setUndecorated(true);
        frame2.setVisible(true);
    }
}