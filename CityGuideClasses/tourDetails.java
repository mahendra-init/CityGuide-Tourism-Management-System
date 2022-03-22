package CityGuideClasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tourDetails extends JFrame implements ActionListener {

    JButton back, bp;
    ImageIcon backimg;
    Description d = new Description();
    JTextArea t1,t2,t3;
    String loc, username;
    tourDetails(String l0, String uname) {
        loc = l0;
        username = uname;
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(630, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        backimg = new ImageIcon(i2);
        back = new JButton(backimg);
        back.setBounds(2, 2, 48, 48);
        back.setBackground(new Color(255, 165, 0));
        back.addActionListener(this);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        add(back);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 165, 0));
        p1.setBounds(0, 0, 630, 130);
        add(p1);

        JLabel l = new JLabel("7 Days & 6 Nights " + loc + " Tour", JLabel.CENTER);
        l.setBounds(0, 5, 630, 55);
        l.setFont(d.derivedFont("Cotton Butter", 50));
        l.setForeground(new Color(102, 51, 153));
        p1.add(l);

        JLabel l2 = new JLabel("Best Price @ 10,999/- per person", JLabel.CENTER);
        l2.setBounds(0, 65, 630, 40);
        l2.setFont(d.derivedFont("Roboto-Medium", 22));
        l2.setForeground(Color.white);
        p1.add(l2);

        String costInclude = "-> Accommodation on twin Sharing Basis.\n"
                + "-> Meal Plan (Please refer Cost sheet)\n"
                + "-> Exclusive Non a/c vehicle for transfers & sightseeing.\n"
                + "-> All permit fees & hotel taxes (as per itinerary).\n"
                + "-> Rates are valid for INDIAN NATIONALS only.";
        String costExclude = "-> Air Fare / Train fare.\n"
                + "-> Personal expenses such as laundry, telephone calls, tips & gratuity, etc. \n"
                + "-> Additional sightseeing or extra usage of vehicle.\n"
                + "-> Service Tax 3.09 %\n"
                + "-> Travel Insurance.\n"
                + "-> Anything which is not include in the inclusion.";

        String cp = "-> Minimum Cancellation is Rs. 1000 per Head.\n"
                + "-> 25% Between 30-20 Days Before Tour Departure and after that 50%.\n"
                + "-> 100% on the Same Day & No show.\n"
                + "-> Cancellation charges as % of Total Tour Cost.";
        
        JLabel cI = new JLabel("Cost Includes:");
        cI.setBounds(20, 140, 150, 30);
        cI.setForeground(new Color(255, 165, 0));
        cI.setFont(d.derivedFont("ShadowsIntoLight-Regular", 25));
        add(cI);
        
        t1 = new JTextArea(costInclude);
        t1.setEditable(false);
        t1.setFont(d.derivedFont("Grunge", 18));
        t1.setBounds(10, 175, 600, 125);
        t1.setBackground(new Color(240, 248, 255));
        add(t1);
        
        JLabel cE = new JLabel("Cost Excludes:");
        cE.setBounds(20, 300, 150, 30);
        cE.setForeground(new Color(255, 165, 0));
        cE.setFont(d.derivedFont("ShadowsIntoLight-Regular", 25));
        add(cE);
        
        t2 = new JTextArea(costExclude);
        t2.setEditable(false);
        t2.setFont(d.derivedFont("Grunge", 18));
        t2.setBounds(10, 335, 600, 135);
        t2.setBackground(new Color(240, 248, 255));
        add(t2);
        
        JLabel c = new JLabel("Cancellation Policy:");
        c.setBounds(20, 475, 250, 30);
        c.setForeground(new Color(255, 165, 0));
        c.setFont(d.derivedFont("ShadowsIntoLight-Regular", 25));
        add(c);
        
        t3 = new JTextArea(cp);
        t3.setEditable(false);
        t3.setFont(d.derivedFont("Grunge", 18));
        t3.setBounds(10, 510, 600, 120);
        t3.setBackground(new Color(240, 248, 255));
        add(t3);
        
        bp = new JButton("Book Now");
        bp.setBounds(255, 630, 100, 40);
        bp.addActionListener(this);
        bp.setBackground(new Color(102, 51, 153));
        bp.setFont(d.derivedFont("Grunge", 22));
        bp.setForeground(new Color(255, 165, 0));
        bp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        bp.setFocusable(false);
        add(bp);
    }

    public static void main(String[] args) {
        new tourDetails("Udaipur", "").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new ExplorePackages(username).setVisible(true);
        }else if(e.getSource() == bp){
                new BookPackage(loc, username).setVisible(true);
                this.setVisible(false);
        }
    }
}
