import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class Request extends JFrame {

    private JPanel Record;
    private JButton RestartButton;
    private JLabel Result;
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
    private JLabel TimeLabel;
    private Choice choice;
    private ResultMessage resultmessage;
    Timer mainTimer;
    Timer helpTimer;
    int gameTime = 66;
    int TimeOfShowing = 2;
    int lastrec = 60;
    public Request(String name,int[] iconsPosition,int lrec)  {
        super("Animal Pairs");
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimemsion.width / 2 - 650 / 2,
                dimemsion.height / 2 - 650 / 2, 650, 650);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Record.setVisible(true);
        add(Record);
        int[] ActOpenNR = {0};
        int [] valueOfCards = {17,18};
        int [] position = {17};
        int[] countOfOpenedCard = {0};
        int [] isBlock = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] ableToPlay ={1};
        int [] Cards = new int[16];
        for (int i=0;i<=7;i++){
            Cards[i] = iconsPosition[i]+1;
            Cards[i+8] = iconsPosition[i]+1;
        }
        JLabel Pic[] = {Pic0,Pic1,Pic2,Pic3,Pic4,Pic5,Pic6,Pic7,Pic8,Pic9,Pic10,Pic11,Pic12,Pic13,Pic14,Pic15};
        JPanel Ava[] = {Ava0,Ava1,Ava2,Ava3,Ava4,Ava5,Ava6,Ava7,Ava8,Ava9,Ava10,Ava11,Ava12,Ava13,Ava14,Ava15};
        randomize(Cards,15);
        for(int i =0;i<=15;i++) {
            Pic[i] =new JLabel(new ImageIcon("img/"+Cards[i]+".png"));
            Ava[i].add(Pic[i]);
            int finalI = i;

            Pic[finalI].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (ableToPlay[0] == 0 && ActOpenNR[0] != 2 && position[0] != finalI+1 && isBlock[finalI] == 0) {
                        if (ActOpenNR[0] == 0) {
                            ActOpenNR[0] = 1;
                            valueOfCards[0] = Cards[finalI];
                            position[0] = finalI+1;
                            Pic[finalI].setIcon(new ImageIcon("img/" + Cards[finalI] + ".png"));
                        } else if (ActOpenNR[0] == 1) {
                            ActOpenNR[0] = 2;
                            valueOfCards[1] = Cards[finalI];
                            Pic[finalI].setIcon(new ImageIcon("img/" + Cards[finalI] + ".png"));
                            if (valueOfCards[0] != valueOfCards[1]) {
                                TimeOfShowing = 2;
                                helpTimer = new Timer(500, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        TimeOfShowing--;
                                        if(TimeOfShowing >0) ableToPlay[0]=1;
                                        if (TimeOfShowing == 0) {
                                            for(int i =0;i<=15;i++) {
                                                if (isBlock[i] == 1) Pic[i].setIcon(new ImageIcon("img/" + Cards[i] + ".png"));
                                                else Pic[i].setIcon(new ImageIcon("img/17.png"));
                                            }
                                            position[0] = 17;
                                            ableToPlay[0]=0;
                                            helpTimer.stop();
                                        }
                                    }
                                });
                                helpTimer.setInitialDelay(0);
                                helpTimer.start();
                            } else {
                                countOfOpenedCard[0] = countOfOpenedCard[0] + 2;
                                isBlock[finalI] = 1;
                                isBlock[position[0] - 1] = 1;
                                position[0] = 17;
                            }
                            valueOfCards[0] = 17;
                            valueOfCards[1] = 18;
                            ActOpenNR[0] = 0;
                        }
                    }
                }
            });
        }

        lastrec = lrec;
        if(lrec==60)
            Result.setText("Record: - sec");
        else Result.setText("Record: " + lastrec + " sec");

        mainTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameTime--;
                if(countOfOpenedCard[0]==16) {
                    mainTimer.stop();
                    int rec = 60 - gameTime;
                    if(rec<lastrec) {
                        lastrec = rec;
                        Result.setText("Record: " + rec + " sec");
                        resultmessage = new ResultMessage(rec);
                        resultmessage.setVisible(true);
                    }
                }
                else if (gameTime < 10) {
                    TimeLabel.setText("00:0" + Integer.toString(gameTime));
                    TimeLabel.setForeground(new Color(255, 69, 69));
                }
                else if (gameTime <60&& gameTime >=10) {
                    TimeLabel.setText("00:" + Integer.toString(gameTime));
                }
                else if (gameTime == 60) {
                    TimeLabel.setForeground(new Color(0, 0, 0));
                    TimeLabel.setText("01:00");
                }
                else if (gameTime >= 65) {
                    TimeLabel.setForeground(new Color(255, 69, 69));
                    TimeLabel.setText("3");
                }
                else if (gameTime == 64) {
                    TimeLabel.setForeground(new Color(255, 69, 69));
                    TimeLabel.setText("2");
                }
                else if (gameTime == 63) {
                    TimeLabel.setForeground(new Color(255, 190, 0));
                    TimeLabel.setText("1");
                }
                else if (gameTime ==62) {
                    TimeLabel.setForeground(new Color(40, 186, 72));
                    TimeLabel.setText("START");
                }
                else if(gameTime == 61) {
                    for(int i =0;i<=15;i++) {
                        Pic[i].setIcon(new ImageIcon("img/17.png"));
                    }
                    ableToPlay[0]=0;
                    TimeLabel.setForeground(new Color(40, 186, 72));
                    TimeLabel.setText("START");
                }
                else if (gameTime == 0) {
                    mainTimer.stop();
                    TimeLabel.setText("Koniec czasu! 00:00");
                    ableToPlay[0]=1;

                }

            }
        });
        mainTimer.setInitialDelay(0);
        mainTimer.start();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = new Choice(name,lastrec);
                choice.setVisible(true);
                setVisible(false);
            }
        });

        RestartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameTime = 66;
                ableToPlay[0]=1;
                mainTimer.start();
                valueOfCards[0] = 17;
                valueOfCards[1] = 18;
                ActOpenNR[0] = 0;
                position[0]=17;
                countOfOpenedCard[0]=0;
                for(int i=0;i<=15;i++){
                    isBlock[i]= 0;}
                randomize(Cards,16);
                for(int i =0;i<=15;i++) {
                    Pic[i].setIcon(new ImageIcon("img/" + Cards[i] + ".png"));

                }
            }
        });

    }
    static void randomize(int arr[],int n)
    {
        Random r = new Random();
        for (int i = n-1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}