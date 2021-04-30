package Pre_Editor;

import com.petebevin.markdown.MarkdownProcessor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

/**
 * @author KKKZOZ
 */
public class MarkdownPreview {
    //Field
    public JPanel markdownPane;
    private final Pre_Editor editor;
    private final JTextPane htmlPane;
    private final HTMLEditorKit kit;
    private final MarkdownProcessor processor;


    public MarkdownPreview(Pre_Editor editor) {
        this.editor = editor;
        this.markdownPane = new JPanel();
        this.htmlPane = new JTextPane();
        htmlPane.setPreferredSize(new Dimension(300,500));
        this.processor = new MarkdownProcessor();
        this.kit = new HTMLEditorKit();
        this.htmlPane.setEditorKit(kit);
        this.htmlPane.setContentType("text/html");
        this.htmlPane.setEditable(false);

        markdownPane.add(htmlPane);
        editor.workingManager.getCurrentWritingArea().textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String markdown = editor.workingManager.getCurrentWritingArea().textArea.getText();
                setContent(processor.markdown(markdown));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String markdown = editor.workingManager.getCurrentWritingArea().textArea.getText();
                setContent(processor.markdown(markdown));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String markdown = editor.workingManager.getCurrentWritingArea().textArea.getText();
                setContent(processor.markdown(markdown));
            }
        });
        editor.workingManager.getCurrentWritingArea().writingArea.add(markdownPane, BorderLayout.EAST);
    }


    public void setContent(String markdown) {
        htmlPane.setText(markdown);
    }

}
