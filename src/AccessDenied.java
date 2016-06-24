import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class AccessDenied extends JFrame{

    private JLabel printL;
    private JButton exitB;

    private class ExitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
    private ExitButtonHandler exitButton;
    public void notTHeSamePasswordOrUsername(){
        printL = new JLabel("An account has been made!", SwingConstants.HORIZONTAL);
        exitB = new JButton("EXIT SCREEN");
        exitButton = new ExitButtonHandler();
        exitB.addActionListener(exitButton);
        setTitle("Invalid Password");
        Container makeGrid = getContentPane();
        makeGrid.setLayout((new GridLayout(4,4)));
        makeGrid.add(printL);
        makeGrid.add(exitB);
        setSize(500,300);
        setVisible(true);
    }
    public void samePasswordOrUsername(){
        printL = new JLabel("Username/password already taken", SwingConstants.HORIZONTAL);
        exitB = new JButton("EXIT SCREEN");
        exitButton = new ExitButtonHandler();
        exitB.addActionListener(exitButton);
        setTitle("Invalid Password");
        Container makeGrid = getContentPane();
        makeGrid.setLayout((new GridLayout(4,4)));
        makeGrid.add(printL);
        makeGrid.add(exitB);
        setSize(500,300);
        setVisible(true);
    }
    public void invalidPassword(){
        printL = new JLabel("Passwords do not match. Try again.", SwingConstants.HORIZONTAL);
        exitB = new JButton("EXIT SCREEN");
        exitButton = new ExitButtonHandler();
        exitB.addActionListener(exitButton);
        setTitle("Invalid Password");
        Container makeGrid = getContentPane();
        makeGrid.setLayout((new GridLayout(4,4)));
        makeGrid.add(printL);
        makeGrid.add(exitB);
        setSize(500,300);
        setVisible(true);
    }
    public void printUpdate(){

        printL = new JLabel("You have updated your list! Refresh table", SwingConstants.HORIZONTAL);
        exitB = new JButton("EXIT SCREEN");
        exitButton = new ExitButtonHandler();
        exitB.addActionListener(exitButton);
        setTitle("Updated");
        Container makeGrid = getContentPane();
        makeGrid.setLayout(new GridLayout(4,4));
        makeGrid.add(printL);
        makeGrid.add(exitB);
        setSize(500, 300);
        setVisible(true);
    }
    public void printFalse(){
        printL = new JLabel("The list is too full!", SwingConstants.HORIZONTAL);
        setTitle("Too full");
        exitB = new JButton("EXIT SCREEN");
        exitButton = new ExitButtonHandler();
        exitB.addActionListener(exitButton);
        Container makeGrid = getContentPane();
        makeGrid.setLayout(new GridLayout(4,4));
        makeGrid.add(printL);
        makeGrid.add(exitB);
        setSize(300, 300);
        setVisible(true);
    }
    public void makeGUI(){
        printL = new JLabel("Access Denied, you can try again later", SwingConstants.HORIZONTAL);
        setTitle("Access Denied");
        Container makeGrid = getContentPane();
        makeGrid.setLayout(new GridLayout(4,4));
        makeGrid.add(printL);
        setSize(300,300);
        setVisible(true);
    }
}
