import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Choice extends JFrame{

    private JButton loginB, newAccountB, exitB, infoB, socialMediaB;

    private class CalculateButtonHandler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Manager ManagerObj = new Manager();
            ManagerObj.makeGUI();
            //dispose();
        }
    }

    private class CalculateButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Login LoginObj = new Login();
            LoginObj.makeGUI();
        }
    }

    private class CalculateButtonHandler3 implements ActionListener {
        public void actionPerformed(ActionEvent e){

            System.exit(0);
        }
    }

    private class CalculateButtonHandler4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Information infoObj = new Information();
            infoObj.makeGUI();
        }
    }

    private class CalculateButtonHandler5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SocialMedia SMobject = new SocialMedia();
            SMobject.createSocialMedia();
        }
    }

    private CalculateButtonHandler1 loginHandler;
    private CalculateButtonHandler2 newAccountHandler;
    private CalculateButtonHandler3 exitHandler;
    private CalculateButtonHandler4 infoHandler;
    private CalculateButtonHandler5 socialMediaHandler;

    public void makeGUI(){
        loginB = new JButton("Login");
        loginHandler = new CalculateButtonHandler1();
        loginB.addActionListener(loginHandler);

        newAccountB = new JButton("New Account");
        newAccountHandler = new CalculateButtonHandler2();
        newAccountB.addActionListener(newAccountHandler);

        exitB = new JButton("Exit");
        exitHandler = new CalculateButtonHandler3();
        exitB.addActionListener(exitHandler);

        infoB = new JButton("Information");
        infoHandler = new CalculateButtonHandler4();
        infoB.addActionListener(infoHandler);

        socialMediaB = new JButton("Social Media");
        socialMediaHandler = new CalculateButtonHandler5();
        socialMediaB.addActionListener(socialMediaHandler);

        setTitle("Huy's Task Management Project!");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,5));

        pane.add(loginB);
        pane.add(newAccountB);
        pane.add(infoB);
        pane.add(exitB);
        pane.add(socialMediaB);

        setSize(800, 500);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
