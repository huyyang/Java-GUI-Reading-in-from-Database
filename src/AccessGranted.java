import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccessGranted extends JFrame{
    private JLabel printL, information;
    private JButton pressGo, pressExit, pressRefresh, pressUpdate;
    private String username, password;

    private class CalculateButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //create the openlist class that will open up when this
            //button is clicked
            OpenList OpenListobj = new OpenList();
            OpenListobj.accessDatabase(username, password);
            OpenListobj.makeGUI();
        }
    }

    private class CalculateButtonHandler2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            OpenList OpenListobj = new OpenList();
            OpenListobj.accessDatabase(username, password);
            OpenListobj.makeGUI();
        }
    }

    private class CalculateButtonHandler3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            UpdateDatabase UDobj = new UpdateDatabase();
            //UDobj.accessDatabase(username, password);
            UDobj.makeGUI(username, password);

        }
    }
    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }


    private CalculateButtonHandler press1;
    private ExitButtonHandler press2;
    private CalculateButtonHandler2 press3;
    private CalculateButtonHandler3 press4;

    public void makeGUI(String Username, String Password){
        this.username = Username;
        this.password = Password;

        pressGo = new JButton("OPEN TABLE");
        press1 = new CalculateButtonHandler();
        pressGo.addActionListener(press1);
        pressExit = new JButton("EXIT");
        press2 = new ExitButtonHandler();
        pressExit.addActionListener(press2);
        pressRefresh = new JButton("REFRESH");
        press3 = new CalculateButtonHandler2();
        pressRefresh.addActionListener(press3);
        pressUpdate = new JButton("UPDATE TABLE");
        press4 = new CalculateButtonHandler3();
        pressUpdate.addActionListener(press4);

        //information = new JLabel("Open Table/Refresh + Update Table", SwingConstants.HORIZONTAL);
        printL = new JLabel("Access Granted", SwingConstants.HORIZONTAL);
        setTitle("Access Granted");
        Container makeGrid = getContentPane();
        makeGrid.setLayout(new GridLayout(4,4));
        //makeGrid.add(printL);
        makeGrid.add(pressGo);
        makeGrid.add(pressExit);
        makeGrid.add(pressRefresh);
        makeGrid.add(pressUpdate);
        //makeGrid.add(information);
        setSize(500,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
