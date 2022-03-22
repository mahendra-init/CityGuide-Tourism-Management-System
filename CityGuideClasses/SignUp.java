package CityGuideClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.border.*;
public class SignUp extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    JComboBox c1;
    SignUp(){
        setTitle("City Guide | SignUp");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(600, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();  
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(195, 20, 200, 220);
        add(l1);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(60, 300, 480, 390);
        p1.setBorder(BorderFactory.createEmptyBorder());
        p1.setBackground(new Color(240, 248, 255));
        add(p1);
        
        JLabel l2 = new JLabel("Username");
        l2.setBounds(35, 10, 150, 20);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p1.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(210, 10, 250, 25);
        t1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        p1.add(t1);
        setVisible(true);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(35, 65, 150, 20);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p1.add(l3);
        
        t2 = new JTextField();
        t2.setBounds(210, 60, 250, 25);
        t2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        p1.add(t2);
        
        JLabel l4 = new JLabel("Password");
        l4.setBounds(35, 115, 150, 20);
        l4.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.add(l4);
        
        t3 = new JPasswordField();
        t3.setBounds(210, 110, 250, 25);
        t3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        p1.add(t3);

        JLabel l5 = new JLabel("Security Question");
        l5.setBounds(35, 165, 150, 25);
        l5.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.add(l5);
        
        c1 = new JComboBox( new String[] {"Primary school?", "Favourite teacher?", "Your lucky number?", "Favourite movie character?"});
        c1.setBounds(210, 160, 250, 25);
        p1.add(c1);
        
        JLabel l6 = new JLabel("Answer");
        l6.setBounds(35, 215, 150, 25);
        l6.setFont(new Font("Dialog", Font.PLAIN, 18));
        p1.add(l6);
        
        t4 = new JTextField();
        t4.setBounds(210, 220, 250, 25);
        t4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        p1.add(t4);
        
        b1 = new JButton("Back");
        b1.setBounds(90, 300, 100, 30);
        b1.setFont(new Font("Dialog", Font.BOLD, 16));
        b1.setBorder(BorderFactory.createBevelBorder(1));
        b1.setBackground(new Color(133, 193, 233));
        b1.addActionListener(this);
        b1.setFocusable(false);
        p1.add(b1);
        
        b2 = new JButton("Create");
        b2.setBounds(250, 300, 100, 30);
        b2.setFont(new Font("Dialog", Font.BOLD, 16));
        b2.setBorder(new LineBorder(new Color(133, 193, 233)));
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
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String answer = t4.getText();
            String security = (String)c1.getSelectedItem();
            String q = "select *from accounts where username = '" + username + "'";
            try{
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Username already exists try another one!");
                }else{
                    String query = "insert into accounts values('" +username +"', '"+name +"', '"+password+"', '"+security+"', '"+answer+"')";
            String sql = "insert into accountInfo values('" + username + "', '" + name + "', '" + 
                        "" + "', '"+ "" + "', '" +
                        "" + "', '" + ""+ "', '" + ""+ "', '" 
                        + ""+ "', '" + ""+ "', '" + "" + "')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                this.setVisible(false);
                new Login().setVisible(true);
                }
            }catch(Exception ex){}
        }
    }
    public static void main(String[] args){
        new SignUp().setVisible(true);
    }
}
