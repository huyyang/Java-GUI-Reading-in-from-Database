import javax.swing.*;
import javax.xml.crypto.Data;
import javax.xml.soap.Name;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
public class SocialMedia extends JFrame{
    private String nameList [];
    private Database DatabaseObj;
    private int arraySize;
    private JButton NameB[];
    private JLabel NameArray[];

    public SocialMedia(){

        DatabaseObj = new Database();
        arraySize = DatabaseObj.returnNames().size();
        nameList = new String[arraySize];
        NameB = new JButton[arraySize];
        NameArray = new JLabel[arraySize];
    }

    private class CalculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {


        }
    }

    CalculateButtonHandler nameHandler[];

    public void createSocialMedia(){
        for (int i = 0; i < arraySize; i++) {
            if(DatabaseObj.returnNames().get(i) != " ")
                nameList[i] = DatabaseObj.returnNames().get(i);
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < arraySize; i++) {
            listModel.addElement(nameList[i]);
        }

        JList<String> listTable = new JList<>(listModel);
        /*
        JList listTable = new JList(listModel);
        listTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                JList listTable = (JList)evt.getSource();
                if(evt.getClickCount() == 2){
                    int index = listTable.locationToIndex(evt.getPoint());
                }
                else if(evt.getClickCount() == 3){
                    int index = listTable.locationToIndex(evt.getPoint());
                }

            }
        });
        */

        setTitle("List Smart");
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(new JScrollPane(listTable));

        setSize(200, 200);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
