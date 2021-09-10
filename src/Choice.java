import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Choice extends JFrame {

    public JPanel Choice;
    private JButton StartButton;
    private JLabel HelloUser;
    private MainFrame mainframe;
    private JPanel Ava0;private JLabel Pic0;
    private JPanel Ava1;private JLabel Pic1;
    private JPanel Ava2;private JLabel Pic2;
    private JPanel Ava3;private JLabel Pic3;
    private JPanel Ava4;private JLabel Pic4;
    private JPanel Ava5;private JLabel Pic5;
    private JPanel Ava6;private JLabel Pic6;
    private JPanel Ava7;private JLabel Pic7;
    private JPanel Ava8;private JLabel Pic8;
    private JPanel Ava9;private JLabel Pic9;
    private JPanel Ava10;private JLabel Pic10;
    private JPanel Ava11;private JLabel Pic11;
    private JPanel Ava12;private JLabel Pic12;
    private JPanel Ava13;private JLabel Pic13;
    private JPanel Ava14;private JLabel Pic14;
    private JPanel Ava15;private JLabel Pic15;
    private JButton backButton;
    private JLabel countOfChoise;
    private Request request;

    public Choice(String name,int record) {
        super("Animal Pairs");
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimemsion.width/2-650/2,
                dimemsion.height/2-650/2,650,650);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Choice.setVisible(true);
        add(Choice);
        HelloUser.setText("Hello "+ name);
        countOfChoise.setText("0/8");
        int[] value = {0};
        JLabel Pic[] = {Pic0,Pic1,Pic2,Pic3,Pic4,Pic5,Pic6,Pic7,Pic8,Pic9,Pic10,Pic11,Pic12,Pic13,Pic14,Pic15};
        JPanel Ava[] = {Ava0,Ava1,Ava2,Ava3,Ava4,Ava5,Ava6,Ava7,Ava8,Ava9,Ava10,Ava11,Ava12,Ava13,Ava14,Ava15};
        for(int i =0;i<=15;i++){
            int j = i+1;
            Pic[i] = new JLabel(new ImageIcon("img/"+j+".png"));
            Ava[i].add(Pic[i]);
            int finalI = i;
            Pic[finalI].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(flags[finalI] == 0&&value[0]<8) {
                        flags[finalI] = 1;
                        Pic[finalI].setIcon(new ImageIcon("img/"+j+"_1.png"));
                        value[0]++;
                        countOfChoise.setText(value[0]+"/8");
                    }
                    else if(flags[finalI]== 1) {
                        flags[finalI] = 0;
                        Pic[finalI].setIcon(new ImageIcon("img/"+j+".png"));
                        value[0]--;
                        countOfChoise.setText(value[0]+"/8");
                    }
                }
            });
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainframe= new MainFrame();
                mainframe.setVisible(true);
            }
        });
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(value[0]==8){
                    setVisible(false);
                    request = new Request(name,getIconsPosition(), record);
                    request.setVisible(true);
                }
            }
        });
    }
    int []flags = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int []choised = {0,0,0,0,0,0,0,0};
    int [] getIconsPosition(){
        int k=0;
        for(int i=0;i<16;i++)
            if(flags[i]==1){
                choised[k] =i;
                k++;}
        return choised;
    }
}
