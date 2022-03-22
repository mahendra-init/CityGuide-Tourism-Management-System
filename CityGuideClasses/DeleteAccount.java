package CityGuideClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class DeleteAccount extends JFrame implements ActionListener{
    JButton back, delete;
    String uname;
    Description d = new Description();
    DeleteAccount(String usern){
        uname = usern;
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
        
        ImageIcon I2 = new ImageIcon(ClassLoader.getSystemResource("images/delete.png"));
        Image I3 = I2.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(I3);
        JLabel proImg = new JLabel(i4);
        proImg.setBounds(240, 25, 94, 94);
        proImg.setBorder(BorderFactory.createEmptyBorder());
        add(proImg);
        
        JLabel l = new JLabel("Delete Account", JLabel.CENTER);
        l.setBounds(0, 120, 600, 40);
        l.setFont(d.derivedFont("Grunge", 35));
        l.setForeground(Color.red);
        add(l);
        
        JLabel username = new JLabel("Username");
        username.setBounds(65, 190, 150, 20);
        username.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(username);
        
        JLabel un = new JLabel(uname);
        un.setBounds(250, 190, 230, 22);
        un.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(un);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(65, 230, 150, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);
        
        JLabel n = new JLabel();
        n.setBounds(250, 230, 230, 22);
        n.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(n);
        
        JLabel id = new JLabel("ID");
        id.setBounds(65, 270, 150, 20);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(id);
        
        JLabel chooseId = new JLabel();
        chooseId.setBounds(250, 270, 230, 22);
        chooseId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(chooseId);
        
        JLabel idValue = new JLabel();
        idValue.setBounds(65, 310, 150, 20);
        idValue.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(idValue);
        
        JLabel idv = new JLabel();
        idv.setBounds(250, 310, 230, 22);
        idv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(idv);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(65, 350, 150, 20);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(gender);
        
        JLabel chooseGender = new JLabel();
        chooseGender.setBounds(250, 350, 230, 22);
        chooseGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(chooseGender);
              
        JLabel country = new JLabel("Country");
        country.setBounds(65, 390, 150, 20);
        country.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(country);
        
        
        JLabel c = new JLabel();
        c.setBounds(250, 390, 230, 22);
        c.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(c);
        
        JLabel address = new JLabel("Address");
        address.setBounds(65, 430, 150, 20);
        address.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(address);
        
        JLabel a = new JLabel();
        a.setBounds(250, 430, 230, 22);
        a.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(a);
        
        JLabel phoneNo = new JLabel("Contact No.");
        phoneNo.setBounds(65, 470, 150, 20);
        phoneNo.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(phoneNo);
        
        JLabel p = new JLabel();
        p.setBounds(250, 470, 230, 22);
        p.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(p);
        
        JLabel email = new JLabel("Email Id");
        email.setBounds(65, 510, 150, 20);
        email.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(email);
        
        JLabel em = new JLabel();
        em.setBounds(250, 510, 230, 22);
        em.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(em);
        
        ConDB c1 = new ConDB();
        try{
            String query = "select *from accountInfo where username = '" + uname +"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()){
                n.setText(rs.getString("name"));
                chooseId.setText(rs.getString("id"));
                idValue.setText(rs.getString("id") +" No.");
                idv.setText(rs.getString("idVal"));
                chooseGender.setText(rs.getString("gender"));
                c.setText(rs.getString("country"));
                a.setText(rs.getString("address"));
                p.setText(rs.getString("phone"));
                em.setText(rs.getString("email"));
            }
        }catch(Exception excp){excp.printStackTrace();}
        
        
        delete = new JButton("Delete");
        delete.setBounds(240, 580, 100, 35);
        delete.setFont(new Font("Dialog", Font.BOLD, 18));
        delete.setBorder(BorderFactory.createBevelBorder(1));
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        delete.setFocusable(false);
        add(delete);
        
    }
    
    public static void main(String[] args){
        new DeleteAccount("mahendra").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.setVisible(false);
        }else if(e.getSource() == delete){
            ConDB c  = new ConDB();
            try{
            c.s.executeUpdate("delete from accounts where username = '" + uname + "'");
            c.s.executeUpdate("delete from accountInfo where username = '" + uname + "'");
            c.s.executeUpdate("delete from bookingInfo where username = '" + uname + "'");
            c.s.executeUpdate("delete from customerInfo where bookedById = '" + uname + "'");
            
            JOptionPane.showMessageDialog(null, "Account deleted succesfully");
            System.exit(0);
            }catch(Exception exp){exp.printStackTrace();}
        }
    }
}
