package CityGuideClasses;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
     Description d = new Description();
     JButton back;
    About(){
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(600, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);   
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        ImageIcon backimg = new ImageIcon(i2);
        back = new JButton(backimg);
        back.setBounds(2, 2, 48, 48);
        back.setBackground(new Color(240, 248, 255));
        back.addActionListener(this);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        add(back);
        
        JLabel l = new JLabel("CITY GUIDE", JLabel.CENTER);
        l.setBounds(0, 30, 600, 50);
        l.setFont(d.derivedFont("Grunge", 45));
        l.setForeground(Color.red);
        add(l);
        
        String s = "                                   About Project          \n  "
                + "\nThe objective of the Travel and Tourism Management System "
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                ;
        TextArea t = new TextArea(s, 15, 50, Scrollbar.VERTICAL);
        t.setBounds(50, 150, 500, 540);
        t.setEditable(false);
        t.setBackground(new Color(240, 248, 255));
        t.setFont(d.derivedFont("Roboto-Thin", 18));
        add(t);
    }
    
    
    public static void main(String[] args){
        new About().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    
}
