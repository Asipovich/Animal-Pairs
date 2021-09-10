import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultMessage extends JFrame{
    private JButton okButton;
    private JPanel Cong;
    private JLabel Result;

    public ResultMessage(int rec) {
        super("Congratulation!");
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimemsion.width / 2 - 350 / 2,
                dimemsion.height / 2 -230 / 2, 350, 230);
        setVisible(false);

        add(Cong);
        Result.setText("Your result: "+rec + " sec");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
