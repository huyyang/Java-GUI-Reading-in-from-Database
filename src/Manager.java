import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Manager extends JFrame {

        private Database DatabaseObj;
        private JLabel passwordLabel, usernameLabel;
        private JPasswordField passwordTF;
        private JTextField usernameTF;
        private JButton calculateB, exitB;

    public Manager(){
        DatabaseObj = new Database();
    }

    private class CalculateButtonHandler implements ActionListener {
            public void actionPerformed(ActionEvent e){

                String UserName, PassWord;
                UserName = usernameTF.getText();
                PassWord = passwordTF.getText();
                if(DatabaseObj.access(UserName, PassWord)){

                    AccessGranted AG = new AccessGranted();
                    AG.makeGUI(UserName, PassWord);
                    dispose();
                }
                else{
                    AccessDenied AD = new AccessDenied();
                    AD.makeGUI();
                }

            }
        }

        private class ExitButtonHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        }

        private CalculateButtonHandler cbHandler;
        private ExitButtonHandler ebHandler;


        public void makeGUI(){
            usernameLabel = new JLabel("Enter your username: ", SwingConstants.RIGHT);
            passwordLabel = new JLabel("Enter your password: ", SwingConstants.RIGHT);

            passwordTF = new JPasswordField(10);        //creates your textfield
            usernameTF = new JTextField(10);        //creates your textfield

            calculateB = new JButton("ENTER");          //creates your button "Enter"
            cbHandler = new CalculateButtonHandler();
            calculateB.addActionListener(cbHandler);
            exitB = new JButton("EXIT");                //creates your button "exit"
            ebHandler = new ExitButtonHandler();
            exitB.addActionListener(ebHandler);

            setTitle("Huy's Task Management!");                     //Creates your title
            Container pane = getContentPane();          //sets up your grid
            pane.setLayout(new GridLayout(4,2));        //creates your grid

            pane.add(usernameLabel);
            pane.add(usernameTF);
            pane.add(passwordLabel);
            pane.add(passwordTF);
            pane.add(calculateB);
            pane.add(exitB);

            setSize(500, 500);                          //sets the size of GUI (WIDTH*Height)
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

}

