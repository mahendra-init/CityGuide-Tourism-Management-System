package CityGuideClasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BookPackage extends JFrame implements ActionListener {

    String loc, Username;
    ConDB c = new ConDB();
    JLabel username, ta;
    JTextField un, sp, rate, tp, cn, eId;
    JButton bp, cancel, addpd;
    int tpcount, cost;
    JComboBox Id, gender;
    JTextField n, idVal;
    Description d = new Description();

    BookPackage(String location, String uname) {
        loc = location;
        Username = uname;
        cost = 10999;
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setUndecorated(true);

        JLabel l = new JLabel("Book Package", JLabel.CENTER);
        l.setBounds(0, 20, 800, 50);
        l.setFont(d.derivedFont("Grunge", 45));
        l.setForeground(new Color(0, 0, 0));
        add(l);

        username = new JLabel("Username");
        username.setBounds(20, 120, 130, 20);
        username.setFont(new Font("Dialog", Font.BOLD, 16));
        add(username);

        un = new JTextField(Username);
        un.setBounds(180, 120, 200, 22);
        un.setEditable(false);
        un.setBackground(new Color(240, 248, 255));
        un.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(un);

        JLabel selPac = new JLabel("Selected Package");
        selPac.setBounds(20, 170, 150, 20);
        selPac.setFont(new Font("Dialog", Font.BOLD, 16));
        add(selPac);

        sp = new JTextField(loc);
        sp.setBounds(180, 170, 200, 22);
        sp.setEditable(false);
        sp.setBackground(new Color(240, 248, 255));
        sp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(sp);

        JLabel rpp = new JLabel("Rate pp");
        rpp.setBounds(20, 220, 150, 20);
        rpp.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rpp);

        rate = new JTextField("10999");
        rate.setBounds(180, 220, 200, 22);
        rate.setEditable(false);
        rate.setBackground(new Color(240, 248, 255));
        rate.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(rate);

        JLabel totperson = new JLabel("Total person");
        totperson.setBounds(20, 270, 150, 20);
        totperson.setFont(new Font("Dialog", Font.BOLD, 16));
        add(totperson);

        tp = new JTextField("1");
        tp.setBounds(180, 270, 200, 22);
        tp.setBackground(new Color(240, 248, 255));
        tp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(tp);
        tpcount = Integer.parseInt(tp.getText());
        tp.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cost = 10999;
                tpcount = Integer.parseInt(tp.getText());
                cost *= tpcount;
                ta.setText("Rs." + cost);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (tp.getText().isEmpty()) {
                    ta.setText("Rs. 0");
                } else {
                    cost = 10999;
                    tpcount = Integer.parseInt(tp.getText());
                    cost *= tpcount;
                    ta.setText("Rs." + cost);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cost = 10999;
                tpcount = Integer.parseInt(tp.getText());
                cost *= tpcount;
                ta.setText("Rs." + cost);
            }
        });

        addpd = new JButton("Add all persons details....");
        addpd.setBounds(180, 295, 200, 25);
        addpd.setBorder(BorderFactory.createEmptyBorder());
        addpd.setBackground(new Color(240, 248, 255));
        addpd.setFocusable(false);
        addpd.setForeground(Color.RED);
        addpd.addActionListener(this);
        add(addpd);

        JLabel pn = new JLabel("Contact No.");
        pn.setBounds(20, 345, 150, 20);
        pn.setFont(new Font("Dialog", Font.BOLD, 16));
        add(pn);

        cn = new JTextField();
        cn.setBounds(180, 345, 200, 22);
        cn.setBackground(new Color(240, 248, 255));
        cn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(cn);

        JLabel email = new JLabel("Email Id");
        email.setBounds(20, 395, 150, 20);
        email.setFont(new Font("Dialog", Font.BOLD, 16));
        add(email);

        eId = new JTextField();
        eId.setBounds(180, 395, 200, 22);
        eId.setBackground(new Color(240, 248, 255));
        eId.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(eId);

        JLabel tamount = new JLabel("Total Amount");
        tamount.setBounds(20, 445, 150, 20);
        tamount.setFont(new Font("Dialog", Font.BOLD, 16));
        add(tamount);

        ta = new JLabel();
        ta.setText("Rs." + cost);
        ta.setBounds(180, 445, 200, 22);
        ta.setForeground(Color.black);
        ta.setFont(d.derivedFont("Roboto-Bold", 20));
        ta.setBorder(BorderFactory.createEmptyBorder());
        add(ta);

        cancel = new JButton("Cancel");
        cancel.setBounds(285, 500, 100, 40);
        cancel.addActionListener(this);
        cancel.setBackground(new Color(240, 248, 255));
        cancel.setFont(d.derivedFont("Grunge", 18));
        cancel.setForeground(Color.red);
        cancel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        cancel.setFocusable(false);
        add(cancel);

        bp = new JButton("Confirm");
        bp.setBounds(425, 500, 100, 40);
        bp.addActionListener(this);
        bp.setBackground(new Color(240, 248, 255));
        bp.setFont(d.derivedFont("Grunge", 18));
        bp.setForeground(new Color(102, 51, 153));
        bp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        bp.setFocusable(false);
        add(bp);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/travel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 800, 600);
        add(l1);

    }

    public static void main(String[] args) {
        new BookPackage("Udaipur", "mahendra").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancel) {
            int input = JOptionPane.showOptionDialog(null, "Are you sure want to cancel ?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (input == JOptionPane.OK_OPTION) {
                try {
                    String sql = " delete from customerInfo where bookedById = '" + Username + "'";
                    c.s.executeUpdate(sql);
                } catch (Exception ex) {
                }
                this.setVisible(false);
                new tourDetails(loc, Username).setVisible(true);
            }
        } else if (e.getSource() == bp) {
            if (cn.getText().isEmpty() || eId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fields cannot be left empty!!");
            } else {
                try {
                    String sql = "insert into bookingInfo values('" + Username + "', '" + loc + "', '" + tpcount + "', '" + cost + "', '" + cn.getText() + "', '" + eId.getText() + "', " + null + ")";
                    c.s.executeUpdate(sql);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                this.setVisible(false);
                new Payment(Username, ta.getText()).setVisible(true);
            }
        } else if (e.getSource() == addpd) {
            for (int j = 0; j < tpcount; j++) {
                n = new JTextField();
                Id = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving License"});
                idVal = new JTextField();
                gender = new JComboBox(new String[]{"Male", "Female", "Others"});
                Object[] msg = {
                    "Name", n,
                    "Id", Id,
                    "ID No", idVal,
                    "Gender", gender
                };
                int option = JOptionPane.showConfirmDialog(null, msg, "Add Details of Person " + (j + 1), JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String value1 = n.getText().trim();
                    String value2 = (String) Id.getSelectedItem();
                    String value3 = idVal.getText().trim();
                    String value4 = (String) gender.getSelectedItem();
                    if (value1.isEmpty() || value3.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fields cannot be left empty!!");
                        j--;
                    } else {
                        try {
                            String query = "insert into customerInfo values('" + value1 + "', '" + value2 + "', '" + value3 + "', '" + value4 + "', '" + loc + "', '" + Username + "')";
                            c.s.executeUpdate(query);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
