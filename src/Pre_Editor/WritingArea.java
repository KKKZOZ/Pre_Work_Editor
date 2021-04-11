package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Utilities;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WritingArea {

    //Field
    private Pre_Editor editor;
    public JSplitPane writingArea;
    public JTextArea textArea;


    //Constructor
    public WritingArea(Pre_Editor editor) {
        this.editor = editor;
        this.writingArea = new JSplitPane();
        this.textArea = new JTextArea();
        this.createWritingArea();
    }


    //Method


    public void createWritingArea() {
        //Create objects

        JScrollPane textScrollPane = new JScrollPane();

        textScrollPane.setViewportView(textArea);


        JLabel label = new JLabel();
        textArea.addCaretListener(new CaretListener() {

            public void caretUpdate(CaretEvent e) {

                JTextArea dArea = (JTextArea) e.getSource();

                int row = 1;
                int column = 1;


                try {
                    int caretPos = dArea.getCaretPosition();
                    row = (caretPos == 0) ? 1 : 0;
                    for (int offset = caretPos; offset > 0; ) {
                        offset = Utilities.getRowStart(textArea, offset) - 1;
                        row++;
                    }


                    int offset = Utilities.getRowStart(textArea, caretPos);
                    column = caretPos - offset + 1;


                    //System.out.println(caretPos);


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                label.setText("column " + column + "      row " + row + "     " + textArea.getText().length() + " all    ");
            }
        });
        //scrollPane.setViewportView(label);

        //Set the attribute of splitPane
        writingArea.setTopComponent(textScrollPane);
        writingArea.setBottomComponent(label);
        writingArea.setOrientation(JSplitPane.VERTICAL_SPLIT);
        writingArea.setContinuousLayout(true);
        writingArea.setOneTouchExpandable(false);
        writingArea.setDividerSize(5);


        writingArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                writingArea.setDividerLocation(0.98);
            }
        });


        editor.mainframe.setContentPane(writingArea);
        editor.mainframe.setVisible(true);


        new getLineText(textArea);
    }
}
