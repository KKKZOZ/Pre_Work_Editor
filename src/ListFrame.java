import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.WindowConstants;

public class ListFrame extends javax.swing.JFrame {
private JList jList1;
private JButton jButton1;
    private JButton jButton2;
    private JList jList2;
    private DefaultListModel listModel1;
    private DefaultListModel listModel2;
    private JButton jButton4;
    private JButton jButton3;

    {
        //Set Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
      * Auto-generated main method to display this JFrame
      */
            public static void main(String[] args) {
        ListFrame inst = new ListFrame();
        inst.setVisible(true);
    }

    public ListFrame() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            {
                listModel1 = new DefaultListModel();
                listModel1.addElement("item 1");
                listModel1.addElement("item 2");
                listModel1.addElement("item 3");
                listModel1.addElement("item 4");
                listModel1.addElement("item 5");
                listModel1.addElement("item 6");
                jList1 = new JList(listModel1);
                getContentPane().add(jList1);
                jList1.setBounds(42, 28, 119, 203);
            }
            {
                listModel2 = new DefaultListModel();
                jList2 = new JList(listModel2);
                getContentPane().add(jList2);
                jList2.setBounds(238, 28, 119, 196);
            }
            {
                jButton1 = new JButton();
                getContentPane().add(jButton1);
                jButton1.setText(">");
                jButton1.setBounds(168, 84, 63, 28);
                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
            }
            {
                jButton2 = new JButton();
                getContentPane().add(jButton2);
                jButton2.setText("<");
                jButton2.setBounds(168, 133, 63, 28);
                jButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton2ActionPerformed(evt);
                    }
                });
            }
            {
                jButton3 = new JButton();
                getContentPane().add(jButton3);
                jButton3.setText("添加");
                jButton3.setBounds(168, 35, 63, 28);
                jButton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton3ActionPerformed(evt);
                    }
                });
            }
            {
                jButton4 = new JButton();
                getContentPane().add(jButton4);
                jButton4.setText("删除");
                jButton4.setBounds(168, 189, 63, 28);
                jButton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jButton4ActionPerformed(evt);
                    }
                });
            }
            pack();
            setSize(400, 300);
            setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** jList1移动到jList2*/
            private void jButton1ActionPerformed(ActionEvent evt) {
        if(jList1.getSelectedIndex()!=-1){
            listModel2.addElement(jList1.getSelectedValue());
            int i=jList1.getSelectedIndex();
            listModel1.remove(i);   
            jList1.setSelectedIndex(i>0? i-1:0);
            jList2.setSelectedIndex(listModel2.size()-1);
        }
    }
    /** jList2移动到jList1*/
            private void jButton2ActionPerformed(ActionEvent evt) {
        if(jList2.getSelectedIndex()!=-1){
            listModel1.addElement(jList2.getSelectedValue());
            int i=jList2.getSelectedIndex();
            listModel2.remove(i);
            jList2.setSelectedIndex(i>0? i-1:0);
        }
    }
    /** jList1增加项*/
            private void jButton3ActionPerformed(ActionEvent evt) {
        listModel1.addElement("new item");
    }
    /** jList1删除项*/
            private void jButton4ActionPerformed(ActionEvent evt) {
        if(jList1.getSelectedIndex()!=-1){
            listModel1.remove(jList1.getSelectedIndex());   
        }

    }

}