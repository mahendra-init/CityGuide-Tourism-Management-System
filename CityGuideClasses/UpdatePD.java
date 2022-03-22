package CityGuideClasses;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;

public class UpdatePD extends JFrame implements ActionListener{
    JLabel proImg, username, name, id, idValue, country, address, phoneNo, email, gender;
    JTextField un,n,idv,c,a,p,em;
    JButton change, back, save;
    JComboBox chooseId, chooseGender;
    String uname, path;
    ConDB c1 = new ConDB();
    UpdatePD(String usern){
        uname = usern;
        setTitle("City Guide | Update Personal Details");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(600, 700);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);    
//        setUndecorated(true);
        
        change = new JButton("Browse image..");
        change.setBounds(240, 115, 200, 20);
        change.setBackground(new Color(240, 248, 255));
        change.setFont(new Font("Raleway", Font.PLAIN, 12));
        change.setForeground(Color.red);
        change.setBorder(BorderFactory.createEmptyBorder());
        change.setFocusable(false);
        change.addActionListener(this);
        add(change);
        
        username = new JLabel("Username");
        username.setBounds(55, 170, 150, 20);
        username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(username);
        
        un = new JTextField(uname);
        un.setBounds(230, 170, 230, 22);
        un.setEditable(false);
        un.setBackground(Color.WHITE);
        un.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(un);
        
        
        name = new JLabel("Name");
        name.setBounds(55, 210, 150, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        n = new JTextField();
        n.setBounds(230, 210, 230, 22);
        n.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        n.setBackground(Color.WHITE);
        add(n);
        
        id = new JLabel("ID");
        id.setBounds(55, 250, 150, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(id);
        
        chooseId = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving License"});
        chooseId.setBounds(230, 250, 230, 22);
        chooseId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chooseId.addActionListener(this);
        add(chooseId);
        
        idValue = new JLabel("Passport No.");
        idValue.setBounds(55, 290, 150, 20);
        idValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(idValue);
        
        idv = new JTextField();
        idv.setBounds(230, 290, 230, 22);
        idv.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(idv);
        
        gender = new JLabel("Gender");
        gender.setBounds(55, 330, 150, 20);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender);
        
        chooseGender = new JComboBox(new String[]{"Male", "Female", "Others"});
        chooseGender.setBounds(230, 330, 230, 22);
        chooseGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(chooseGender);
              
        country = new JLabel("Country");
        country.setBounds(55, 370, 150, 20);
        country.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(country);
        
        
        c = new JTextField();
        c.setBounds(230, 370, 230, 22);
        c.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(c);
        
        address = new JLabel("Address");
        address.setBounds(55, 410, 150, 20);
        address.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(address);
        
        a = new JTextField();
        a.setBounds(230, 410, 230, 22);
        a.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(a);
        
        phoneNo = new JLabel("Contact No.");
        phoneNo.setBounds(55, 450, 150, 20);
        phoneNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(phoneNo);
        
        p = new JTextField();
        p.setBounds(230, 450, 230, 22);
        p.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(p);
        
        email = new JLabel("Email Id");
        email.setBounds(55, 490, 150, 20);
        email.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(email);
        
        em = new JTextField();
        em.setBounds(230, 490, 230, 22);
        em.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        add(em);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/profileimg.png"));
        Image i3 = i2.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        proImg = new JLabel(i4);
        proImg.setBounds(240, 20, 94, 94);
        proImg.setBorder(BorderFactory.createEmptyBorder());
        add(proImg);
        
        try{
            String query = "select *from accountInfo where username = '" + uname +"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()){
                n.setText(rs.getString("name"));
                chooseId.setSelectedItem(rs.getString("id"));
                idv.setText(rs.getString("idVal"));
                chooseGender.setSelectedItem(rs.getString("id"));
                c.setText(rs.getString("country"));
                a.setText(rs.getString("address"));
                p.setText(rs.getString("phone"));
                em.setText(rs.getString("email"));
//                proImg.setIcon(ResizeImg(rs.getString("imgPath")));
            }
        }catch(Exception excp){excp.printStackTrace();}
           
        back = new JButton("Back");
        back.setBounds(170, 560, 80, 35);
        back.setFont(new Font("Dialog", Font.BOLD, 18));
        back.setBorder(BorderFactory.createBevelBorder(1));
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);
        
        save = new JButton("Save");
        save.setBounds(330, 560, 80, 35);
        save.setFont(new Font("Dialog", Font.BOLD, 18));
        save.setBorder(BorderFactory.createBevelBorder(1));
        save.setBackground(Color.WHITE);
        save.setFocusable(false);
        save.setForeground(new Color(133, 193, 233));
        save.addActionListener(this);
        add(save);
    }
    public ImageIcon ResizeImg (String ImagePath){
        ImageIcon myImg = new ImageIcon(ImagePath);
        Image img = myImg.getImage().getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
    public static void main(String[] args){
        new UpdatePD("").setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == change ){
            try{
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png","jpeg","gif");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    path = selectedFile.getAbsolutePath();
                    proImg.setIcon(ResizeImg(path));
                }
            }catch(Exception ex){ex.printStackTrace();}
        }else if(e.getSource() == chooseId){
            idValue.setText((String)chooseId.getSelectedItem()+ " No.");
        }else if(e.getSource() == back){
            this.setVisible(false);
        }else if(e.getSource() == save){
            try{
                String sql = "update accountInfo set id = '" + 
                        (String)chooseId.getSelectedItem() + "', idVal = '"+ idv.getText() + "', gender = '" +
                        (String)chooseGender.getSelectedItem()  + "', country = '" + c.getText() + "', address = '" + a.getText() + "', phone = '" 
                        + p.getText() + "', email = '" + em.getText() + "', imgPath = '" + path + "' where username = '"+ uname +"'";              
                c1.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Details updated successfully.");
                this.setVisible(false);
            }catch(Exception exc){exc.printStackTrace();}
        }
    }
}
