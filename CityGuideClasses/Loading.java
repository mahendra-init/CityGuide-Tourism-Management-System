package CityGuideClasses;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar p = new JProgressBar();
    Thread t;
    String un;
    Description d = new Description();
    public void run(){
        try{
            for(int i = 0;i<101;i++){
                int m = p.getMaximum();
                int n = p.getValue();
                if(n<m){
                    p.setValue(p.getValue() + 1);
                }else{
                    i = 101;
                    setVisible(false);
                    new DashBoard(un).setVisible(true);
                }
                 Thread.sleep(50);
            }
        }catch(Exception e){}
        }
    Loading(String username){
        un = username;
        t = new Thread(this);
        setUndecorated(true);
        setSize(450, 250);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();  
        setIconImage(icon);
        
        JLabel l1 = new JLabel("City Guide", JLabel.CENTER);
        l1.setBounds(0, 10, 450, 70);
        l1.setFont(d.derivedFont("FROZBITE", 55));
        l1.setForeground(new Color(102, 51, 153));
        add(l1);
        
        p.setBounds(70, 100, 300, 20);
        p.setStringPainted(true);
        add(p);
        
        JLabel l2 = new JLabel("Please wait...");
        l2.setBounds(290, 120, 100, 20);
        l2.setFont(new Font("Raleway", Font.PLAIN, 12));
        l2.setForeground(Color.RED);
        add(l2);
        
        JLabel l3 = new JLabel("Welcome " + username +"..");
        l3.setBounds(10, 200, 200, 30);
        l3.setFont(d.derivedFont("ShadowsIntoLight-Regular", 20));
        l3.setForeground(Color.RED);
        add(l3);
        
        t.start();
    }
    public static void main(String[] args){
        new Loading("mahendra").setVisible(true);
    }
}
