import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel Hello;
    private JButton continueButton;
    private JTextField UserName;
    private JPanel Picture;
    private Choice choice;

    private JLabel labe;
    public MainFrame() {
        super("Animal Pairs");//ustawia nazwe okna aplikacji
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimemsion.width/2-650/2,
                dimemsion.height/2-650/2,650,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Hello.setVisible(true);
        Picture.setVisible(true);
        labe= new JLabel(new ImageIcon("img/Start1.png"));
        Picture.add(labe) ;
        add(Hello);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = UserName.getText();
                int record = 60;
                choice = new Choice(name, record);
                choice.setVisible(true);
                setVisible(false);
            }
        });

    }


}
