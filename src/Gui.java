
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends Main
{
    static JFrame frame;



    public static void main(String[] args)
    {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                displayJFrame();
            }
        });
    }

    static void displayJFrame()
    {
        Main mainInstance = new Main();
        frame = new JFrame("Database Application");

        // create our jbutton
        JButton showDialogButton = new JButton("Run Query");

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                System.out.println("-------Clear line-------");
                mainInstance.findBoB();

            }
        });

        // put the button on the frame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(showDialogButton);

        // set up the jframe, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}