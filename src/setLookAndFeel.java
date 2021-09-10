import javax.swing.*;
import javax.swing.UIManager. *;
public class setLookAndFeel {
    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("blad");
        }
    }
}