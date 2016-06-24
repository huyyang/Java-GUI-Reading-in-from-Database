import javafx.scene.control.PasswordField;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login extends JFrame{
    private Database DatabaseObj;
    private JLabel usernameLabel, passwordLabel, nameLabel, passwordLabel2;
    private JPasswordField passwordJF, passwordJF2;
    private JTextField usernameJF, nameJF;
    private JButton enter, exit;
    private ArrayList <String> toDoList;
    private JTextField [] toDo;
    private JLabel [] displayToDo;

    public Login(){
        DatabaseObj = new Database();
        toDoList = new ArrayList<String> (5);
        toDo = new JTextField[5];
        displayToDo = new JLabel[5];
    }

    private class CalculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){     //function that performs action
            String enterUser, enterPass, enterPass2, enterName;
            String [] enterToDo = new String[5];
            enterUser = usernameJF.getText();
            enterPass = passwordJF.getText();
            enterPass2 = passwordJF2.getText();
            if(enterPass.compareTo(enterPass2) != 0){
                AccessDenied obj = new AccessDenied();
                obj.invalidPassword();
                dispose();
            }
            enterName = nameJF.getText();

            for (int i = 0; i < 5; i++) {
                if(!toDo[i].getText().isEmpty())
                    toDoList.add(toDo[i].getText());
            }
            int to_do_int = toDoList.size();
            int index = 1;
            if(to_do_int != 5) {
                index = to_do_int;
                while (index != 5) {
                    toDoList.add(" ");
                    ++index;
                }
            }
            if(DatabaseObj.addAcccount(enterUser, enterPass, enterName, toDoList)==1){
                AccessDenied obj = new AccessDenied();
                obj.notTHeSamePasswordOrUsername();
            }
            else{
                AccessDenied obj = new AccessDenied();
                obj.samePasswordOrUsername();
            }
            dispose();
        }
    }

    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){     //function that performs action
            dispose();                             //exits program
        }
    }
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;

    public void makeGUI(){
        usernameLabel = new JLabel("username: ", SwingConstants.HORIZONTAL);  //creates your label
        passwordLabel = new JLabel("Password: ", SwingConstants.HORIZONTAL);  //creates your label
        passwordLabel2 = new JLabel("Confirm your password: ", SwingConstants.HORIZONTAL);
        nameLabel = new JLabel("Name: ", SwingConstants.HORIZONTAL);
        passwordJF = new JPasswordField(5);        //creates your textfield
        passwordJF2 = new JPasswordField(5);
        usernameJF = new JTextField(5);        //creates your textfield
        nameJF = new JTextField(5);

        for (int i = 0; i < 5; i++) {
            displayToDo[i] = new JLabel("Enter in to do #" + i + ": ", SwingConstants.HORIZONTAL);
            toDo[i] = new JTextField(10);
        }

        enter = new JButton ("Enter");
        cbHandler = new CalculateButtonHandler();
        enter.addActionListener(cbHandler);
        exit = new JButton ("Exit");
        ebHandler = new ExitButtonHandler();
        exit.addActionListener(ebHandler);

        setTitle("New User");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 5));

        pane.add(usernameLabel);
        pane.add(usernameJF);
        pane.add(passwordLabel);
        pane.add(passwordJF);
        pane.add(passwordLabel2);
        pane.add(passwordJF2);
        pane.add(nameLabel);
        pane.add(nameJF);
        for (int i = 0; i < 5; i++) {
            pane.add(displayToDo[i]);
            pane.add(toDo[i]);
        }

        pane.add(enter);
        pane.add(exit);

        setSize(800, 500);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
