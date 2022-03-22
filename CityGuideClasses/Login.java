package CityGuideClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;
    
    Login(){
        setTitle("City Guide | Login");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(600, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(185, 30, 200, 200);
        add(l1);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(160, 280, 300, 300);
        p1.setBorder(BorderFactory.createEmptyBorder());
//        p1.setBackground(Color.WHITE);
        p1.setBackground(new Color(240, 248, 255));
        add(p1);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(30, 10, 150, 25);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p1.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(30, 40, 200, 25);
        t1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        t1.addActionListener(this);
        p1.add(t1);
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(30, 70, 150, 25);
        l3.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.add(l3);
        
        t2 = new JPasswordField();
        t2.setBounds(30, 100, 200, 25);
        t2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        t2.addActionListener(this);
        p1.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(30, 140, 90, 25);
        b1.setBackground(new Color(133, 193, 233));
        b1.addActionListener(this);
        b1.setFocusable(false);
        p1.add(b1);
        
        b2 = new JButton("SingUp");
        b2.setBounds(140, 140, 90, 25);
        b2.setBorder(new LineBorder(new Color(133, 193, 233)));
        b2.setBackground(Color.WHITE);
        b2.setFocusable(false);
        b2.setForeground(new Color(102, 51, 153));
        b2.addActionListener(this);
        p1.add(b2);
        
        b3 = new JButton("Forgot Password?");
        b3.setBounds(60, 180, 120, 25);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setBackground(new Color(240, 248, 255));
        b3.setFocusable(false);
        b3.setForeground(Color.RED);
        b3.addActionListener(this);
        p1.add(b3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        ConDB c = new ConDB();
        if(ae.getSource() == b1){
            try{
                String username = t1.getText().trim();
                String password = t2.getText();
                String sql = "select *from accounts where username = '" + username +"' AND password = '" + password +"'";
                ResultSet rs = c.s.executeQuery(sql);
                if(rs.next()){
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                 }
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new SignUp().setVisible(true);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}