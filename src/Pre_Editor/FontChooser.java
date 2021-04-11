package Pre_Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontChooser {
    //Field
    private JCheckBox bold;
    private JCheckBox italic;
    public JPanel parentPanel;
    private JPanel defaultPane;

    private JTextArea textArea;
    private JPanel contentPanel = new JPanel(new BorderLayout());
    private Font font;
    private Pre_Editor editor;


    //Initialize two lists
    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getAvailableFontFamilyNames();
    String[] fontSizes = {"9", "10", "11", "12", "14", "16", "18", "20", "22",
            "24", "28", "36", "48", "72"};
    JList fontList = new JList(fonts);
    JList sizeList = new JList(fontSizes);

    //Constructor
    public FontChooser(Pre_Editor editor) {
        this.editor = editor;
        this.textArea = editor.writingArea.textArea;
        //获得当前字体情况
        font = this.textArea.getFont();

        parentPanel = new JPanel(new BorderLayout());
        createFontList();
        createButtons();

    }//end of Constructor

    private void createFontList() {


        //The parent panel of leftPanel and SizePanel

        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel sizePanel = new JPanel(new BorderLayout());

        leftPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(), "Font"));
        sizePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Size"));

        JScrollPane fontPane = new JScrollPane(fontList);
        JScrollPane sizePane = new JScrollPane(sizeList);

        fontPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        leftPanel.add(fontPane);

        sizePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sizePanel.add(sizePane);

        JPanel attributes = new JPanel(new GridLayout(1, 2));
        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");

        attributes.add(bold);
        attributes.add(italic);
        attributes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Attributes"));

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(sizePanel, BorderLayout.CENTER);
        rightPanel.add(attributes, BorderLayout.SOUTH);

        contentPanel.add(leftPanel, BorderLayout.CENTER);
        contentPanel.add(rightPanel, BorderLayout.EAST);


        //选中当前字体
        final String fontName = font.getName();
        ListModel fontModel = fontList.getModel();
        fontList.clearSelection();

        for (int i = 0; i < fontModel.getSize(); i++) {
            if (fontName.equals(fontModel.getElementAt(i))) {
                fontList.setSelectedIndex(i);
                break;
            }
        }

        //选中当前大小
        final String fontSize = String.valueOf(font.getSize());
        ListModel sizeModel = sizeList.getModel();
        sizeList.clearSelection();

        for (int i = 0; i < sizeModel.getSize(); i++) {
            if (fontSize.equals(sizeModel.getElementAt(i))) {
                sizeList.setSelectedIndex(i);
                break;
            }
        }


        if (font.isBold()) {
            bold.setSelected(true);
        }
        if (font.isItalic()) {
            italic.setSelected(true);
        }

        parentPanel.add(contentPanel, BorderLayout.CENTER);

    }//end of createFontList


    public void createButtons() {

        JPanel positionPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        //Add ActionListener
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(getSelectedFont());
                //TODO TextArea.lineNumberBar.setFont(textArea.getFont());
                editor.settings.settingDialog.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editor.settings.settingDialog.dispose();
            }
        });


        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        positionPanel.add(buttonPanel, BorderLayout.EAST);
        parentPanel.add(positionPanel, BorderLayout.SOUTH);

    }//End of createButtons

    private Font getSelectedFont() {

        String fontName = (String) fontList.getSelectedValue();

        //确定字体风格
        int style = Font.PLAIN;
        if (bold.isSelected() && italic.isSelected()) {
            style = Font.BOLD | Font.ITALIC;
        }
        if (bold.isSelected()) {
            style = Font.BOLD;
        }
        if (italic.isSelected()) {
            style = Font.ITALIC;
        }

        //确定字体大小
        int size;
        String sizeSelected = (String) sizeList.getSelectedValue();
        if (sizeSelected != null) {
            size = Integer.parseInt(sizeSelected);
        } else {
            size = 12;
        }

        Font font = new Font(fontName, style, size);

        return font;


    }//End of getSelectedFont

}//End of Class FontChooser
