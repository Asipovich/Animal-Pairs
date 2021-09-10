import javax.swing.*;
import java.io.IOException;

public class Main{
    private static setLookAndFeel set= new setLookAndFeel();
    public static void main(String[] args) throws IOException {
        set.setLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame mainFrame = new MainFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}