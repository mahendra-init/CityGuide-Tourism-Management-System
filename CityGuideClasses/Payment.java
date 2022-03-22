package CityGuideClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Payment extends JFrame implements ActionListener {

    String username, ta;
    JButton back, ok;
    JRadioButton r1, r2, r3;
    ImageIcon I1, I2, I3;
    Description d = new Description();
    ConDB c = new ConDB();

    Payment(String username, String ta) {
        this.username = username;
        this.ta = ta;
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(500, 600);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setUndecorated(true);

        JLabel l = new JLabel("Payment", JLabel.CENTER);
        l.setBounds(0, 20, 500, 50);
        l.setFont(d.derivedFont("Grunge", 45));
        l.setForeground(new Color(0, 0, 0));
        add(l);

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

        JLabel l1 = new JLabel("Username:           " + this.username);
        l1.setBounds(15, 100, 500, 30);
        l1.setFont(d.derivedFont("Roboto-Bold", 16));
        l1.setForeground(new Color(0, 0, 0));
        add(l1);

        JLabel l2 = new JLabel("Total Amount:");
        l2.setBounds(15, 130, 150, 30);
        l2.setFont(d.derivedFont("Roboto-Bold", 16));
        l2.setForeground(new Color(0, 0, 0));
        add(l2);

        JLabel l3 = new JLabel("Rs. " + this.ta);
        l3.setBounds(140, 130, 200, 30);
        l3.setFont(d.derivedFont("Roboto-Bold", 16));
        l3.setForeground(Color.red);
        add(l3);

        JLabel l4 = new JLabel("Acceptable Payment Method :");
        l4.setBounds(10, 190, 480, 40);
        l4.setFont(d.derivedFont("Cotton Butter", 30));
        l4.setForeground(new Color(102, 51, 153));
        add(l4);

        I1 = new ImageIcon(ClassLoader.getSystemResource("images/upi.png"));
        I2 = new ImageIcon(ClassLoader.getSystemResource("images/netBank.png"));
        I3 = new ImageIcon(ClassLoader.getSystemResource("images/gpay.png"));

        r1 = new JRadioButton("UPI Id");
        r1.setBounds(20, 240, 200, 20);
        r1.setFont(d.derivedFont("Roboto-Bold", 16));
        r1.setBackground(new Color(240, 248, 255));
        r1.addActionListener(this);
        r1.setBorder(BorderFactory.createEmptyBorder());
        add(r1);

        r2 = new JRadioButton("Net Banking");
        r2.setBounds(20, 270, 200, 20);
        r2.addActionListener(this);
        r2.setFont(d.derivedFont("Roboto-Bold", 16));
        r2.setBackground(new Color(240, 248, 255));
        r2.setBorder(BorderFactory.createEmptyBorder());
        add(r2);

        r3 = new JRadioButton("Google Pay / PhonePe");
        r3.setBounds(20, 300, 300, 20);
        r3.addActionListener(this);
        r3.setFont(d.derivedFont("Roboto-Bold", 16));
        r3.setBackground(new Color(240, 248, 255));
        r3.setBorder(BorderFactory.createEmptyBorder());
        add(r3);

        JLabel l5 = new JLabel("Note:");
        l5.setBounds(10, 350, 500, 40);
        l5.setFont(d.derivedFont("Grunge", 30));
        l5.setForeground(Color.red);
        add(l5);

        String n = "\"Your payment will be checked manually as if it\n"
                + "is recieved properly or not. Once payment is recieved,\n"
                + "then confirmation mail of your booking will be\n"
                + "send to you. As the whole process is manual, \n"
                + "it will take 2-3 working days.\"";

        JTextArea note = new JTextArea(n);
        note.setEditable(false);
        note.setFont(new Font("Raleway", Font.ITALIC, 18));
        note.setBounds(25, 394, 470, 120);
        note.setBackground(new Color(240, 248, 255));
        add(note);

        ok = new JButton("OK");
        ok.setBounds(185, 540, 70, 38);
        ok.setBackground(new Color(102, 51, 153));
        ok.setFont(d.derivedFont("Grunge", 22));
        ok.setForeground(new Color(255, 165, 0));
        ok.addActionListener(this);
        ok.setBorder(BorderFactory.createEmptyBorder());
        ok.setFocusable(false);
        add(ok);
    }

    public static void main(String[] args) {
        String s = "20999";
        new Payment("mahendra", s).setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            
        } else if (r1.isSelected()) {
            r2.setSelected(false);
            r3.setSelected(false);
            JOptionPane.showMessageDialog(null, "Pay to : 8225340@ybl", "UPI Id", JOptionPane.PLAIN_MESSAGE, I1);
        } else if (r2.isSelected()) {
            r1.setSelected(false);
            r3.setSelected(false);
            JOptionPane.showMessageDialog(null, "Pay to: \nAccount No:  5022122544544354\nIFSC Code: UBIN02145", "Net Banking", JOptionPane.PLAIN_MESSAGE, I2);
        } else if (r3.isSelected()) {
            r2.setSelected(false);
            r1.setSelected(false);
            JOptionPane.showMessageDialog(null, "Pay to: 8225340533", "GPay / PhonePe", JOptionPane.PLAIN_MESSAGE, I3);
        } else if (e.getSource() == ok) {
            this.setVisible(false);
        }
    }
}
