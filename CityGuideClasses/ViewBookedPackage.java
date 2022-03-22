package CityGuideClasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewBookedPackage extends JFrame implements ActionListener {

    ConDB c = new ConDB();
    Description d = new Description();

    JButton back;
    String loc, cn, eid, tper, ta, pay_stat;

    ViewBookedPackage(String uname) {
        try {
            String sql = "select *from bookingInfo where username = '" + uname + "'";
            ResultSet rs = c.s.executeQuery(sql);
            while (rs.next()) {
                loc = rs.getString("packName");
                cn = rs.getString("phoneNo");
                eid = rs.getString("emailId");
                tper = rs.getString("totPer");
                ta = rs.getString("totAmount");
                pay_stat = rs.getString("payment_status");
            }
        } catch (Exception ex) {
        }
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
        ImageIcon backimg = new ImageIcon(i2);
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

        JLabel l = new JLabel("7 Days & 6 Nights holiday tour", JLabel.CENTER);
        l.setBounds(0, 20, 630, 75);
        l.setFont(d.derivedFont("Cotton Butter", 55));
        l.setForeground(new Color(102, 51, 153));
        p1.add(l);

        JLabel un = new JLabel("Username:");
        un.setBounds(80, 190, 150, 20);
        un.setFont(d.derivedFont("Roboto-Bold", 20));
        add(un);
        JLabel un1 = new JLabel(uname);
        un1.setBounds(260, 190, 150, 20);
        un1.setFont(d.derivedFont("Roboto-Medium", 18));
        add(un1);

        JLabel pn = new JLabel("Package Name:");
        pn.setBounds(80, 240, 150, 20);
        pn.setFont(d.derivedFont("Roboto-Bold", 20));
        add(pn);

        JLabel tp = new JLabel("Total Person:");
        tp.setBounds(80, 290, 150, 20);
        tp.setFont(d.derivedFont("Roboto-Bold", 20));
        add(tp);

        JLabel tamount = new JLabel("Total Amount:");
        tamount.setBounds(80, 340, 150, 20);
        tamount.setFont(d.derivedFont("Roboto-Bold", 20));
        add(tamount);

        JLabel phoneNo = new JLabel("Contact No:");
        phoneNo.setBounds(80, 390, 150, 20);
        phoneNo.setFont(d.derivedFont("Roboto-Bold", 20));
        add(phoneNo);

        JLabel emailId = new JLabel("Email Id:");
        emailId.setBounds(80, 440, 150, 20);
        emailId.setFont(d.derivedFont("Roboto-Bold", 20));
        add(emailId);
        
        JLabel payment = new JLabel("Payment Status:");
        payment.setBounds(80, 490, 150, 20);
        payment.setFont(d.derivedFont("Roboto-Bold", 20));
        add(payment);

        if (loc == null && cn == null && eid == null && tper == null && ta == null) {
            JLabel msg = new JLabel("You haven't booked any package yet.", JLabel.CENTER);
            msg.setBounds(0, 570, 630, 30);
            msg.setFont(d.derivedFont("Roboto-Medium", 25));
            msg.setForeground(Color.red);
            add(msg);
        } else {
            JLabel pn1 = new JLabel(loc);
            pn1.setBounds(260, 240, 150, 20);
            pn1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(pn1);
            JLabel tp1 = new JLabel(tper);
            tp1.setBounds(260, 290, 150, 20);
            tp1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(tp1);

            JLabel tamount1 = new JLabel("Rs. " + ta + " /-");
            tamount1.setBounds(260, 340, 150, 20);
            tamount1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(tamount1);

            JLabel phoneNo1 = new JLabel(cn);
            phoneNo1.setBounds(260, 390, 150, 20);
            phoneNo1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(phoneNo1);

            JLabel emailId1 = new JLabel(eid);
            emailId1.setBounds(260, 440, 250, 20);
            emailId1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(emailId1);
            
            JLabel payment1 = new JLabel();
            payment1.setBounds(260, 490, 250, 20);
            payment1.setFont(d.derivedFont("Roboto-Medium", 18));
            add(payment1);
            
            if(pay_stat == null){
                payment1.setText("Will update soon.");
                payment1.setForeground(Color.red);
            }else{
                payment1.setText(pay_stat);
            }
        }
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("images/travel1.jpg"));
        Image I2 = I1.getImage().getScaledInstance(630, 570, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(I2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 130, 630, 570);
        add(l1);

    }

    public static void main(String[] args) {
        new ViewBookedPackage("mahendra").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
        }
    }
}
