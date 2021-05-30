package Pre_Editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author KKKZOZ
 */
public class Copyright {

    private static Copyright copyright;
    private static Pre_Editor editor;
    private JDialog copyrightDialog;
    private JPanel copyrightPanel;
    private RTextScrollPane scrollPane;
    private RSyntaxTextArea textArea;

    private Copyright() {
        copyrightDialog = new JDialog(editor.mainframe, "Copyright", false);
        copyrightPanel = new JPanel(new BorderLayout());
        textArea = new RSyntaxTextArea();
        scrollPane = new RTextScrollPane(textArea);
        copyrightPanel.add(textArea, BorderLayout.CENTER);
        copyrightDialog.add(copyrightPanel);

        copyrightDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3;
        int height = (int) (screenSize.height / 1.5);
        copyrightDialog.setSize(width, height);
        copyrightDialog.setLocation((screenSize.width / 2) - (width / 2),
                (screenSize.height / 2) - (height / 2));

        copyrightDialog.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                copyrightDialog.dispose();
            }
        });
        initialize();

        copyrightDialog.setVisible(true);
    }

    public static Copyright getInstance() {
        if (copyright == null) {
            copyright = new Copyright();
        }
        copyright.copyrightDialog.setVisible(true);
        return copyright;
    }

    public static void setEditor(Pre_Editor editor) {
        Copyright.editor = editor;
    }

    private void initialize() {
        String content = "This is a simple copyright!";
        textArea.setText(content);
        textArea.setEditable(false);
    }
}
