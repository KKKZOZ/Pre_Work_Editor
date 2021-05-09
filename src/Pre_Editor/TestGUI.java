package Pre_Editor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Sat May 01 22:41:01 CST 2021
 */



/**
 * @author unknown
 */
public class TestGUI extends JFrame {
    private Pre_Editor editor;

    public TestGUI(Pre_Editor editor) {
        this.editor = editor;
        initComponents();
    }

    private void backgroundComboBoxItemStateChanged(ItemEvent e) {

        // TODO add your code here
    }

    private Color getSelectedColor(JComboBox comboBox,ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedColor = (String) comboBox.getSelectedItem();
            if ("Red".equals(selectedColor)) {
                return Color.RED;
            }
            if ("Orange".equals(selectedColor)) {
                return Color.ORANGE;
            }
            if ("Yellow".equals(selectedColor)) {
                return Color.YELLOW;
            }
            if ("Green".equals(selectedColor)) {
                return Color.GREEN;
            }
            if ("Cyan".equals(selectedColor)) {
                return Color.CYAN;
            }
            if ("Blue".equals(selectedColor)) {
                return Color.BLUE;
            }
            if ("Purple".equals(selectedColor)) {
                return new Color(128,0,128);
            }
            if ("Black".equals(selectedColor)) {
                return Color.BLACK;
            }
            if ("White".equals(selectedColor)) {
                return Color.WHITE;
            }
            if ("Gray".equals(selectedColor)) {
                return Color.GRAY;
            }
        }
        return null;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        mainPanel = new JPanel();
        layoutPanel = new JPanel();
        contentPanel = new JPanel();
        backgroundLabel = new JLabel();
        backgroundComboBox = new JComboBox<>();
        foregroundLabel = new JLabel();
        forgoundComboBox = new JComboBox<>();
        reservedWordLable = new JLabel();
        reservedWordComboBox = new JComboBox<>();
        operatorLabel = new JLabel();
        operatorComboBox = new JComboBox<>();
        dataTypeLabel = new JLabel();
        dataTypeComboBox = new JComboBox<>();
        numberLabel = new JLabel();
        numberComboBox = new JComboBox<>();
        commentLabel = new JLabel();
        commentComboBox = new JComboBox<>();
        label16 = new JLabel();
        comboBox16 = new JComboBox();
        label17 = new JLabel();
        comboBox17 = new JComboBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainPanel ========
        {
            mainPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
            mainPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,mainPanel. getBorder( )) ); mainPanel. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            mainPanel.setLayout(new BorderLayout());

            //======== layoutPanel ========
            {
                layoutPanel.setLayout(new BorderLayout());

                //======== contentPanel ========
                {
                    contentPanel.setLayout(new GridLayout(3, 6));

                    //---- backgroundLabel ----
                    backgroundLabel.setText(bundle.getString("backgroundLabel.text"));
                    contentPanel.add(backgroundLabel);

                    //---- backgroundComboBox ----
                    backgroundComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    backgroundComboBox.addItemListener(e -> backgroundComboBoxItemStateChanged(e));
                    contentPanel.add(backgroundComboBox);

                    //---- foregroundLabel ----
                    foregroundLabel.setText(bundle.getString("foregroundLabel.text"));
                    contentPanel.add(foregroundLabel);

                    //---- forgoundComboBox ----
                    forgoundComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(forgoundComboBox);

                    //---- reservedWordLable ----
                    reservedWordLable.setText(bundle.getString("reservedWordLable.text"));
                    contentPanel.add(reservedWordLable);

                    //---- reservedWordComboBox ----
                    reservedWordComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(reservedWordComboBox);

                    //---- operatorLabel ----
                    operatorLabel.setText(bundle.getString("operatorLabel.text"));
                    contentPanel.add(operatorLabel);

                    //---- operatorComboBox ----
                    operatorComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(operatorComboBox);

                    //---- dataTypeLabel ----
                    dataTypeLabel.setText(bundle.getString("dataTypeLabel.text"));
                    contentPanel.add(dataTypeLabel);

                    //---- dataTypeComboBox ----
                    dataTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(dataTypeComboBox);

                    //---- numberLabel ----
                    numberLabel.setText(bundle.getString("numberLabel.text"));
                    contentPanel.add(numberLabel);

                    //---- numberComboBox ----
                    numberComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(numberComboBox);

                    //---- commentLabel ----
                    commentLabel.setText(bundle.getString("commentLabel.text"));
                    contentPanel.add(commentLabel);

                    //---- commentComboBox ----
                    commentComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Cyan",
                        "Blue",
                        "Purple",
                        "Black",
                        "White",
                        "Gray"
                    }));
                    contentPanel.add(commentComboBox);

                    //---- label16 ----
                    label16.setText(bundle.getString("label16.text"));
                    contentPanel.add(label16);
                    contentPanel.add(comboBox16);

                    //---- label17 ----
                    label17.setText(bundle.getString("label17.text"));
                    contentPanel.add(label17);
                    contentPanel.add(comboBox17);
                }
                layoutPanel.add(contentPanel, BorderLayout.CENTER);
            }
            mainPanel.add(layoutPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text"));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("cancelButton.text"));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            mainPanel.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel mainPanel;
    private JPanel layoutPanel;
    private JPanel contentPanel;
    private JLabel backgroundLabel;
    private JComboBox<String> backgroundComboBox;
    private JLabel foregroundLabel;
    private JComboBox<String> forgoundComboBox;
    private JLabel reservedWordLable;
    private JComboBox<String> reservedWordComboBox;
    private JLabel operatorLabel;
    private JComboBox<String> operatorComboBox;
    private JLabel dataTypeLabel;
    private JComboBox<String> dataTypeComboBox;
    private JLabel numberLabel;
    private JComboBox<String> numberComboBox;
    private JLabel commentLabel;
    private JComboBox<String> commentComboBox;
    private JLabel label16;
    private JComboBox comboBox16;
    private JLabel label17;
    private JComboBox comboBox17;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
