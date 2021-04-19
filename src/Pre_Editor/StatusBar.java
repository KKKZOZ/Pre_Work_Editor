package Pre_Editor;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class StatusBar {

    public JTextField textField;
    public JPanel bottomPanel;
    public String time;

    public StatusBar(Pre_Editor editor) {
        JTextArea textArea = editor.writingArea.textArea;
        TimeFrame timeFrame = new TimeFrame();
        BottomLabel label = new BottomLabel(editor, textArea);
        textField = new JTextField();
        textField.setEditable(false);
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(label.label, BorderLayout.WEST);
        bottomPanel.add(timeFrame.createFrame(editor, textArea), BorderLayout.EAST);
        bottomPanel.add(textField, BorderLayout.CENTER);
        editor.writingArea.writingArea.setBottomComponent(this.bottomPanel);
    }

    public void clear() {
        textField.setText("");
    }


    public class BottomLabel {
        //Field
        public int row;
        public JTextArea textArea;
        public JLabel label = new JLabel();

        //Method
        public BottomLabel(Pre_Editor editor, JTextArea textArea) {

            label.setText("column "
                    + editor.writingArea.getCurrentLineInfo().getColumn() + "      row "
                    + editor.writingArea.getCurrentLineInfo().getRow() + "     "
                    + textArea.getText().length() + " all    ");

            textArea.addCaretListener(new CaretListener() {

                @Override
                public void caretUpdate(CaretEvent e) {

                    new CurrentLineInfo(textArea);
                    label.setText("column "
                            + editor.writingArea.getCurrentLineInfo().getColumn() + "      row "
                            + editor.writingArea.getCurrentLineInfo().getRow() + "     "
                            + textArea.getText().length() + " all    ");
                }
            });

        }

    }

    //创建时间
    public class TimeFrame extends JFrame {
        private final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
        private final int ONE_SECOND = 1000;
        public String time;
        /*
         * Variables
         */
        private JLabel displayArea;

        public JLabel createFrame(Pre_Editor editor, JTextArea textArea) {

            displayArea = new JLabel();
            configTimeArea(editor);
            return displayArea;
        }

        /**
         * This method creates a timer task to update the time per second
         */
        private void configTimeArea(Pre_Editor editor) {
            Timer tmr = new Timer();
            tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);
        }

        /**
         * Timer task to update the time display area
         */
        protected class JLabelTimerTask extends TimerTask {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

            @Override
            public void run() {
                time = dateFormatter.format(Calendar.getInstance().getTime());

                displayArea.setText(time);
            }
        }

    }

}
