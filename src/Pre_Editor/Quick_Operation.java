package Pre_Editor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Quick_Operation {


    //Field
    private Pre_Editor editor;

    public JDesktopPane desktopPane;
    public JInternalFrame internalFrame;

    //Constructor
    public Quick_Operation(Pre_Editor editor) {
        this.editor=editor;
        this.createPopBar(editor.mainframe);
    }



    //Method
    public  void createPopBar(JFrame mainframe) {
        //Initialize
        desktopPane = new JDesktopPane();
        internalFrame = createInternalFrame(mainframe);
        desktopPane.add(internalFrame);
        mainframe.setContentPane(desktopPane);
        mainframe.setVisible(true);

        try {
            internalFrame.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    public  JInternalFrame createInternalFrame(JFrame mainframe) {
        System.out.println("!!!");
        //Create an internalFrame
        JInternalFrame internalFrame = new JInternalFrame(
                "Quick Operation",
                true,
                true,
                true
        );

        //Set attributes
        internalFrame.setSize(200, 200);
        internalFrame.setLocation(50, 50);

        internalFrame.addVetoableChangeListener(new VetoableChangeListener() {

            public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
                JInternalFrame frame = (JInternalFrame) e.getSource();
                String name = e.getPropertyName();
                Object value = e.getNewValue();
                if (name.equals("closed") && value.equals(Boolean.TRUE))// 窗口被关闭
                {
                    System.out.println("窗口被关闭");
                    mainframe.setContentPane(editor.writingArea.writingArea);
                }
            }
        });


        //Create inner components
        JPanel panel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        final JList[] cmdList = new JList[1];

        DefaultListModel defaultList = new DefaultListModel();
        DefaultListModel cmdContent = new DefaultListModel();
        defaultList.addElement("new");
        defaultList.addElement("open");
        defaultList.addElement("save");


        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cmdContent.removeAllElements();
                String cmdInput = textField.getText();
                //System.out.println(cmdInput);

                if ("new".contains(cmdInput)) {
                    cmdContent.addElement("new");
                    System.out.println("contains new");
                }
                if ("open".contains(cmdInput)) {
                    cmdContent.addElement("open");
                    System.out.println("contains open");
                }
                if ("save".contains(cmdInput)) {
                    cmdContent.addElement("save");
                    System.out.println("contains save");
                }
                cmdContent.addElement("exit");

                cmdList[0] = new JList(cmdContent);

                panel.add(cmdList[0], BorderLayout.CENTER);

                cmdList[0].addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        System.out.println("Changed");
                        int[] indices = cmdList[0].getSelectedIndices();
                        //TODO 不是每次都能正确启动
                        ListModel<String> listModel = cmdList[0].getModel();
                        boolean adjust = e.getValueIsAdjusting();
                        if (adjust) {
                            for (int index : indices) {
                                System.out.println(listModel.getElementAt(index).toString());
                                String cmdName = listModel.getElementAt(index).toString();
                                if ("new".equals(cmdName)) {
                                    System.out.println("new is finally selected");
                                }
                                if ("open".equals(cmdName)) {
                                    System.out.println("Open is finally selected");
                                }
                                if ("save".equals(cmdName)) {
                                    System.out.println("save is finally selected");
                                }
                            }
                        }


                    }
                });


            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        internalFrame.setContentPane(panel);
        internalFrame.setVisible(true);

        return internalFrame;


    }
}
