package CityGuideClasses;
import java.awt.*;
import javax.swing.*;

public class SplashScreen {

    public static void main(String[] args) {
        SplashFrame sF = new SplashFrame();
        sF.setVisible(true);
        for (int i = 0; i < 600; i += 5) {
//            sF.setLocation(800 - (i * 3) / 4, 450 - (i + 5) / 2);
            sF.setLocationRelativeTo(null);
            sF.setSize(i + 300, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        sF.setVisible(true);
    }
}

class SplashFrame extends JFrame implements Runnable {

    Thread t1;
    Description d = new Description();
    SplashFrame() {
        
        JLabel l = new JLabel("City Guide", JLabel.CENTER);
        l.setBounds(0, 10, 900, 70);
        l.setFont(d.derivedFont("Cute Notes", 55));
        l.setForeground(new Color(102, 51, 153));
        add(l);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        JLabel l1 = new JLabel(i3);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(6000);   //sleep takes arguments in milliseconds.
            this.setVisible(false);  //hence for 7 sec pause we give 7000 as 1s = 1000ms.
            new Login().setVisible(true);
        } catch (Exception e) {
        }
    }
}
