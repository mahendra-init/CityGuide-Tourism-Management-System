package CityGuideClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField t1, t2;
    JComboBox c1;
    ForgotPassword(){
        setTitle("City Guide | ForgotPassword");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(500, 600);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/fg.png"));
        Image i2 = i1.getImage().getScaledInstance(278, 242, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(110, 30, 278, 242);
        add(l1);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 300, 440, 300);
        p1.setBorder(BorderFactory.createEmptyBorder());
        p1.setBackground(new Color(240, 248, 255));
        add(p1);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(5, 30, 150, 20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        p1.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(180, 30, 250, 25);
        t1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        t1.addActionListener(this);
        p1.add(t1);
        setVisible(true);
        
        JLabel l3 = new JLabel("Security Question");
        l3.setBounds(5, 70, 150, 25);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        p1.add(l3);
        
        c1 = new JComboBox( new String[] {"Primary school?", "Favourite teacher?", "Your lucky number?", "Favourite movie character?"});
        c1.setBounds(180, 70, 250, 25);
        p1.add(c1);
        
        JLabel l4 = new JLabel("Answer");
        l4.setBounds(5, 110, 150, 25);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        p1.add(l4);
        
        t2 = new JTextField();
        t2.setBounds(180, 110, 250, 25);
        t2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        p1.add(t2);
        
        b1 = new JButton("Back");
        b1.setBounds(90, 180, 100, 30);
        b1.setFont(new Font("Dialog", Font.PLAIN, 16));
        b1.setBorder(BorderFactory.createBevelBorder(2));
        b1.setBackground(new Color(133, 193, 233));
        b1.addActionListener(this);
        b1.setFocusable(false);
        p1.add(b1);
        
        b2 = new JButton("Retrieve");
        b2.setBounds(250, 180, 100, 30);
        b2.setFont(new Font("Dialog", Font.BOLD, 16));
        b1.setBorder(BorderFactory.createBevelBorder(2));
        b2.setBackground(Color.WHITE);
        b2.setFocusable(false);
        b2.setForeground(new Color(133, 193, 233));
        b2.addActionListener(this);
        p1.add(b2);
    }
    public void actionPerformed(ActionEvent ae){
        ConDB c = new ConDB();
        if(ae.getSource() == b1){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource() == b2){
            try{
                String sql = "select *from accounts where username = '" +t1.getText() +"' AND security = '"+ (String)c1.getSelectedItem()+"' AND answer = '" + t2.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Password: " + rs.getString("password"));
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials !!");
                 }
            }catch(Exception e){}
        }
    }
    public static void main(String[] args){
        new ForgotPassword().setVisible(true);
    }
}
