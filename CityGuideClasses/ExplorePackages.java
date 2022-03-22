package CityGuideClasses;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExplorePackages extends JFrame implements ActionListener {
    ImageIcon i1,i2,i3,i4,i5,i6, backimg;
    JButton l1,l2,l3,l4,l5,l6, back;
    JLabel loc1,loc2,loc3,loc4,loc5,loc6;
    
    public ImageIcon setImage(String path, int i, int j){
        ImageIcon  menu1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image menu2 = menu1.getImage().getScaledInstance(i, j, Image.SCALE_DEFAULT);
        ImageIcon menu3 = new ImageIcon(menu2);
        return menu3;
    }
    String username;
    Description d = new Description();
    ExplorePackages(String uname){
        try{
        setTitle("City Guide | Explore Packages");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(730, 640);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);   
        setUndecorated(true);
        
        username=  uname;
        backimg = setImage("images/back.png", 48, 48);
        back = new JButton(backimg);
        back.setBounds(2, 2, 48, 48);
        back.setBackground(new Color(240, 248, 255));
        back.addActionListener(this);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        add(back);
        
        i1 = setImage("images/Goa/Goa.jpg", 200, 200);
        l1 = new JButton(i1);
        l1.setBounds(30, 50, 200, 200);
        l1.addActionListener(this);
        add(l1);
        loc1 = new JLabel("Goa", JLabel.CENTER);
        loc1.setBounds(30, 255, 200, 30);
        loc1.setForeground(new Color(255, 165, 0));
        loc1.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc1);
        
        i2 = setImage("images/Lonavala/Lonavala.jpg", 200, 200);
        l2 = new JButton(i2);
        l2.setBounds(260, 50, 200, 200);
        l2.addActionListener(this);
        add(l2);
        loc2 = new JLabel("Lonavala", JLabel.CENTER);
        loc2.setBounds(260, 255, 200, 30);
        loc2.setForeground(new Color(255, 165, 0));
        loc2.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc2);
        
        i3 = setImage("images/Manali/Manali.jpg", 200, 200);
        l3 = new JButton(i3);
        l3.setBounds(490, 50, 200, 200);
        l3.addActionListener(this);
        add(l3);
        loc3 = new JLabel("Manali", JLabel.CENTER);
        loc3.setBounds(490, 255, 200, 30);
        loc3.setForeground(new Color(255, 165, 0));
        loc3.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc3);
        
        i4 = setImage("images/Sri Nagar/Sri Nagar.jpg", 200, 200);
        l4 = new JButton(i4);
        l4.setBounds(30, 340, 200, 200);
        l4.addActionListener(this);
        add(l4);
        loc4 = new JLabel("Sri Nagar", JLabel.CENTER);
        loc4.setBounds(30, 545, 200, 30);
        loc4.setForeground(new Color(255, 165, 0));
        loc4.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc4);
        
        i5 = setImage("images/Udaipur/Udaipur.jpg", 200, 200);
        l5 = new JButton(i5);
        l5.setBounds(260, 340, 200, 200);
        l5.addActionListener(this);
        add(l5);
        loc5 = new JLabel("Udaipur", JLabel.CENTER);
        loc5.setBounds(260, 545, 200, 30);
        loc5.setForeground(new Color(255, 165, 0));
        loc5.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc5);
        
        i6 = setImage("images/Varanashi/Varanashi.jpg", 200, 200);
        l6 = new JButton(i6);
        l6.setBounds(490, 340, 200, 200);
        l6.addActionListener(this);
        add(l6);
        loc6 = new JLabel("Varanashi", JLabel.CENTER);
        loc6.setBounds(490, 545, 200, 30);
        loc6.setForeground(new Color(255, 165, 0));
        loc6.setFont(d.derivedFont("Cotton Butter", 25));
        add(loc6);
        }catch(Exception exp){JOptionPane.showMessageDialog(null, exp.toString());}

    }
    
    public static void main(String[] args){
        new ExplorePackages("mahendra").setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == l1){
            new DisplayPackages("Goa", 0, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == l2){
            new DisplayPackages("Lonavala", 3, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == l3){
            new DisplayPackages("Manali", 1, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == l4){
            new DisplayPackages("Sri Nagar", 2, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == l5){
            new DisplayPackages("Udaipur", 4, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == l6){
            new DisplayPackages("Varanashi", 5, username).setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == back){
            this.setVisible(false);
        }
    }
    
}
