package CityGuideClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewPD extends JFrame implements ActionListener{
    JButton back;
    ViewPD(String usern){
        String uname = usern;
        setTitle("City Guide | View Personal Details");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(600, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);   
//        setUndecorated(true);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/profileimg.png"));
        Image i3 = i2.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel proImg = new JLabel(i4);
        proImg.setBounds(240, 25, 94, 94);
        proImg.setBorder(BorderFactory.createEmptyBorder());
        add(proImg);
        
        JLabel username = new JLabel("Username");
        username.setBounds(65, 170, 150, 20);
        username.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(username);
        
        JLabel un = new JLabel(uname);
        un.setBounds(250, 170, 230, 22);
        un.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(un);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(65, 210, 150, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);
        
        JLabel n = new JLabel();
        n.setBounds(250, 210, 230, 22);
        n.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(n);
        
        JLabel id = new JLabel("ID");
        id.setBounds(65, 250, 150, 20);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(id);
        
        JLabel chooseId = new JLabel();
        chooseId.setBounds(250, 250, 230, 22);
        chooseId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(chooseId);
        
        JLabel idValue = new JLabel();
        idValue.setBounds(65, 290, 150, 20);
        idValue.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(idValue);
        
        JLabel idv = new JLabel();
        idv.setBounds(250, 290, 230, 22);
        idv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(idv);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(65, 330, 150, 20);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(gender);
        
        JLabel chooseGender = new JLabel();
        chooseGender.setBounds(250, 330, 230, 22);
        chooseGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(chooseGender);
              
        JLabel country = new JLabel("Country");
        country.setBounds(65, 370, 150, 20);
        country.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(country);
        
        
        JLabel c = new JLabel();
        c.setBounds(250, 370, 230, 22);
        c.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(c);
        
        JLabel address = new JLabel("Address");
        address.setBounds(65, 410, 150, 20);
        address.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(address);
        
        JLabel a = new JLabel();
        a.setBounds(250, 410, 230, 22);
        a.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(a);
        
        JLabel phoneNo = new JLabel("Contact No.");
        phoneNo.setBounds(65, 450, 150, 20);
        phoneNo.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(phoneNo);
        
        JLabel p = new JLabel();
        p.setBounds(250, 450, 230, 22);
        p.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(p);
        
        JLabel email = new JLabel("Email Id");
        email.setBounds(65, 490, 150, 20);
        email.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(email);
        
        JLabel em = new JLabel();
        em.setBounds(250, 490, 230, 22);
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
//                proImg.setIcon(ResizeImg(rs.getString("imgPath")));
            }
        }catch(Exception excp){excp.printStackTrace();}
        
        
        back = new JButton("Back");
        back.setBounds(240, 560, 100, 35);
        back.setFont(new Font("Dialog", Font.BOLD, 18));
        back.setBorder(BorderFactory.createBevelBorder(1));
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);
        
    }
    
    public static void main(String[] args){
        new ViewPD("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
