import javax.swing.*;

public class new2 {
    JFrame mainframe = new JFrame();
    JTextArea textArea;

    public new2() {
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.pack();

        CustomizeStyledDocument doc = new CustomizeStyledDocument(-1);
        textArea = new JTextArea(doc);
        mainframe.add(textArea);
    }

    public static void main(String[] args) {
        new new2();
    }

}
