import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
public class OpenList extends JFrame{

    private Database databaseObj;
    private ArrayList <String> toDoList, inProgressList, doneList;
    private JButton pressExit;
    private JTable makeTable;

    public OpenList(){
        databaseObj = new Database();
        toDoList = new ArrayList<String>(5);
        inProgressList = new ArrayList<String>(5);
        doneList = new ArrayList<String>(5);
    }


    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }


    public boolean accessDatabase(String Username, String Password){
        return databaseObj.access(Username, Password);
    }

    private ExitButtonHandler ebHandler;

    public void makeGUI() {
        toDoList = databaseObj.getToDoList();
        inProgressList = databaseObj.getProgressList();
        doneList = databaseObj.getDoneList();
        String name = databaseObj.returnName();

        String [] toDoString = new String[5];
        String [] inProgressString = new String[5];
        String [] doneListString = new String[5];

        if(toDoList.size() != 0){
            for (int i = 0; i < toDoList.size(); i++) {
                toDoString[i] = toDoList.get(i);
            }
        }
        if(inProgressList.size() != 0) {
            for (int i = 0; i < inProgressList.size(); i++)
                inProgressString[i] = inProgressList.get(i);
        }

        if(doneList.size() != 0) {
                for (int i = 0; i < doneList.size(); i++) {
                    doneListString[i] = doneList.get(i);
                }
        }
        Vector<String> firstRow = new Vector<String>();
        Vector<String> secondRow = new Vector<String>();
        Vector<String> thirdRow = new Vector<String>();
        Vector<String> fourthRow = new Vector<String>();
        Vector<String> fifthRow = new Vector<String>();
        firstRow.addElement(toDoString[0]);
        firstRow.addElement(inProgressString[0]);
        firstRow.addElement(doneListString[0]);
        secondRow.addElement(toDoString[1]);
        secondRow.addElement(inProgressString[1]);
        secondRow.addElement(doneListString[1]);
        thirdRow.addElement(toDoString[2]);
        thirdRow.addElement(inProgressString[2]);
        thirdRow.addElement(doneListString[2]);
        fourthRow.addElement(toDoString[3]);
        fourthRow.addElement(inProgressString[3]);
        fourthRow.addElement(doneListString[3]);
        fifthRow.addElement(toDoString[4]);
        fifthRow.addElement(inProgressString[4]);
        fifthRow.addElement(doneListString[4]);
        Vector<Vector> addInto = new Vector<Vector>();
        addInto.addElement(firstRow);
        addInto.addElement(secondRow);
        addInto.addElement(thirdRow);
        addInto.addElement(fourthRow);
        addInto.addElement(fifthRow);
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("To do List");
        columnNames.addElement("In Progress List");
        columnNames.addElement("Done List");
        makeTable = new JTable(addInto, columnNames);

        pressExit = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        pressExit.addActionListener(ebHandler);

        setTitle(name);

        Container pane = getContentPane();          //sets up your grid

        pane.add(new JScrollPane(makeTable));

        setSize(500, 300);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);

    }
}
