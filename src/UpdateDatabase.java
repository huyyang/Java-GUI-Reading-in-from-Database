import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UpdateDatabase extends JFrame {

    private JButton toDoButton, inProgressButton, doneButton, moreToDoButton, exitButton;
    private JTextField enterToDo, enterInProgress, enterDone, enterMoreToDo;
    private String username, password;
    private Database databaseObj;

    public UpdateDatabase(){
        databaseObj = new Database();
    }

    private class CalculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){     //function that performs action
            databaseObj.access(username, password);
            String addToDo = enterToDo.getText();
            if(databaseObj.addToDo(addToDo) == 1){
                AccessDenied obj = new AccessDenied();
                obj.printUpdate();
                databaseObj.update(username,password);
                dispose();
            }
            else{
                AccessDenied obj = new AccessDenied();
                obj.printFalse();
                dispose();
            }

        }
    }
    private class CalculateButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e){     //function that performs action
            databaseObj.access(username, password);
            String addInProgress = enterInProgress.getText();
            AccessDenied obj = new AccessDenied();
            if(databaseObj.addInProgress(addInProgress)==1){
                obj.printUpdate();
                databaseObj.update(username,password);
                dispose();
            }
            else{
                obj.printFalse();
                dispose();
            }

        }
    }
    private class CalculateButtonHandler3 implements ActionListener {
        public void actionPerformed(ActionEvent e){     //function that performs action
            databaseObj.access(username, password);
            String deleteDone = enterDone.getText();
            AccessDenied obj = new AccessDenied();

            if(databaseObj.addToDone(deleteDone)==1){
                obj.printUpdate();
                databaseObj.update(username,password);
                dispose();
            }
            else{
                obj.printFalse();
                dispose();
            }

        }
    }
    private class CalculateButtonHandler4 implements ActionListener {
        public void actionPerformed(ActionEvent e){     //function that performs action
            databaseObj.access(username, password);
            String addToDoMore = enterMoreToDo.getText();
            AccessDenied obj = new AccessDenied();

            if(databaseObj.addMoreToDo(addToDoMore)==1){
                obj.printUpdate();
                databaseObj.update(username,password);
                dispose();
            }
            else{
                obj.printFalse();
                dispose();
            }

        }
    }
    private class CalculateButtonHandler5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }

    CalculateButtonHandler presstodo;
    CalculateButtonHandler2 pressinprogress;
    CalculateButtonHandler3 pressdone;
    CalculateButtonHandler4 pressMoreToDo;
    CalculateButtonHandler5 pressExit;
    public void makeGUI(String user, String pass){
        this.username = user;
        this.password = pass;

        moreToDoButton = new JButton("Add In To-Do List");
        pressMoreToDo = new CalculateButtonHandler4();
        moreToDoButton.addActionListener(pressMoreToDo);

        toDoButton = new JButton("Add from To-Do to In-Progress");
        presstodo = new CalculateButtonHandler();
        toDoButton.addActionListener(presstodo);

        inProgressButton = new JButton("Add from In-Progress to Done");
        pressinprogress = new CalculateButtonHandler2();
        inProgressButton.addActionListener(pressinprogress);

        doneButton = new JButton("Delete from Done");
        pressdone = new CalculateButtonHandler3();
        doneButton.addActionListener(pressdone);

        exitButton = new JButton("Exit");
        pressExit = new CalculateButtonHandler5();
        exitButton.addActionListener(pressExit);

        enterToDo = new JTextField(10);
        enterInProgress = new JTextField(10);
        enterDone = new JTextField(10);
        enterMoreToDo = new JTextField(10);

        setTitle("New User");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,5));

        pane.add(enterMoreToDo);
        pane.add(moreToDoButton);

        pane.add(enterToDo);
        pane.add(toDoButton);

        pane.add(enterInProgress);
        pane.add(inProgressButton);

        pane.add(enterDone);
        pane.add(doneButton);

        pane.add(exitButton);

        setSize(800, 500);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);

    }
}
