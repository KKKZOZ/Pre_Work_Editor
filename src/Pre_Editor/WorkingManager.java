package Pre_Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author KKKZOZ
 */
public class WorkingManager {

    private final Pre_Editor editor;
    private final JTabbedPane workingTabbedPane;
    private final ArrayList<WritingArea> writingAreaList;
    private int tabCount;


    public WorkingManager(Pre_Editor editor) {
        this.editor = editor;
        this.workingTabbedPane = new JTabbedPane();
        this.writingAreaList = new ArrayList<WritingArea>();
        editor.mainPanel.add(workingTabbedPane, BorderLayout.CENTER);
        newTextTab("Untitled");
        this.workingTabbedPane.setSelectedIndex(0);
        this.tabCount = workingTabbedPane.getTabCount();
    }

    public void newTextTab(String title) {
        WritingArea temp = new WritingArea(editor);
        editor.customizeManager.setCurrentTextArea(temp.getTextArea());
        writingAreaList.add(temp);
        workingTabbedPane.addTab(title, temp.writingArea);
        tabCount = workingTabbedPane.getTabCount();
        JPanel titlePane = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(title);
        titlePane.add(titleLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton();

        titlePane.add(closeButton, BorderLayout.EAST);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSelectedTab(getSelectedIndex());
            }
        });
        workingTabbedPane.setTabComponentAt(tabCount - 1, titlePane);
    }

    public void closeSelectedTab(int index) {
        workingTabbedPane.remove(index);
        writingAreaList.remove(index);
    }

    public int getSelectedIndex() {
        return workingTabbedPane.getSelectedIndex();
    }

    public void setSelectedIndex(int index) {
        workingTabbedPane.setSelectedIndex(index);
    }

    public int getTabCount() {
        return tabCount;
    }

    public WritingArea getCurrentWritingArea() {
        int index = workingTabbedPane.getSelectedIndex();
        return writingAreaList.get(index);
    }

    public void setCurrentTabTitle(String title) {
        this.workingTabbedPane.setTitleAt(workingTabbedPane.getSelectedIndex(), title);
    }

    public ArrayList<WritingArea> getWritingAreaList() {
        return writingAreaList;
    }
}
