import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
public class Information extends JFrame {
    private JLabel info;

    public void makeGUI(){
        info = new JLabel("Here is the information you need to know: " + '\n' +
                "You have a To-Do list, an In-Progress list, and a done list" +
                "When you are", SwingConstants.HORIZONTAL);

        setTitle("Information");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,5));

        pane.add(info);

        setSize(800, 500);                          //sets the size of GUI (WIDTH*Height)
        setVisible(true);
    }
}
