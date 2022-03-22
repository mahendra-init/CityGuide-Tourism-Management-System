package CityGuideClasses;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class DisplayPackages extends JFrame implements ActionListener{
    JLabel img;
    JTextArea desc;
    int c, c1;
    Description d = new Description();
    JButton back,backward,forward, bp;
    ImageIcon backimg, backwardimg, forwardimg, mainimg; 
    String l, username;
    DisplayPackages(String loc, int p, String uname){
        c=1; 
        c1=p*8;
        l = loc;
        username = uname;
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setSize(730, 640);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);  
        setUndecorated(true);
                
        mainimg = setImage("images/" + l +"/" + c + ".jpg", 500, 400);
        img = new JLabel(mainimg);
        img.setBounds(105, 30, 500, 400);
        img.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, null, Color.lightGray));
        add(img);
        
        desc = new JTextArea(d.loc[c1]);
        desc.setEditable(false);
        desc.setFont(new Font("Raleway", Font.ITALIC, 16));
        desc.setBounds(50, 445, 680, 120);
        desc.setBackground(new Color(240, 248, 255));
        add(desc);
        
        backimg = setImage("images/back.png", 48, 48);
        back = new JButton(backimg);
        back.setBounds(2, 2, 48, 48);
        back.setBackground(new Color(240, 248, 255));
        back.addActionListener(this);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        add(back);
        
        backwardimg = setImage("images/backward.png", 48, 48);
        backward = new JButton(backwardimg);
        backward.setBounds(5, 280, 48, 48);
        backward.setBackground(new Color(240, 248, 255));
        backward.addActionListener(this);
        backward.setBorder(BorderFactory.createEmptyBorder());
        backward.setFocusable(false);
        add(backward);
        
        forwardimg = setImage("images/forward.png", 48, 48);
        forward = new JButton(forwardimg);
        forward.setBounds(665, 280, 48, 48);
        forward.addActionListener(this);
        forward.setBackground(new Color(240, 248, 255));
        forward.setBorder(BorderFactory.createEmptyBorder());
        forward.setFocusable(false);
        add(forward);
                
        bp = new JButton("Check Deatils");
        bp.setBounds(305, 580, 140, 40);
        bp.addActionListener(this);
        bp.setBackground(new Color(102, 51, 153));
        bp.setFont(d.derivedFont("Grunge", 22));
        bp.setForeground(new Color(255, 165, 0));
        bp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        bp.setFocusable(false);
        add(bp);
        

    }

    public static void main(String[] args){
        new DisplayPackages("Varanashi", 5, "").setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.setVisible(false);
            new ExplorePackages(username).setVisible(true);
        }
        else if(e.getSource() == backward && c>1){
            c-=1;
            c1-=1;
            img.setVisible(false);
            desc.setVisible(false);
            mainimg = setImage("images/" + l +"/" + c + ".jpg", 500, 400);
            img = new JLabel(mainimg);
            img.setBounds(105, 30, 500, 400);
            img.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, null, Color.lightGray));
            add(img);
            
            desc = new JTextArea(d.loc[c1]);
            desc.setEditable(false);
            desc.setFont(new Font("Raleway", Font.ITALIC, 16));
            desc.setBounds(50, 445, 680, 120);
            desc.setBackground(new Color(240, 248, 255));
            add(desc);
        }
        else if(e.getSource() == forward && c<8){
            c+=1;
            c1+=1;
            img.setVisible(false);
            desc.setVisible(false);
            mainimg = setImage("images/" + l +"/" + c + ".jpg", 500, 400);
            img = new JLabel(mainimg);
            img.setBounds(105, 30, 500, 400);
            img.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, null, Color.lightGray));
            add(img);
            
            desc = new JTextArea(d.loc[c1]);
            desc.setEditable(false);
            desc.setFont(new Font("Raleway", Font.ITALIC, 16));
            desc.setBounds(50, 445, 680, 120);
            desc.setBackground(new Color(240, 248, 255));
            add(desc);
        }else if(e.getSource() == bp){
            new tourDetails(l, username).setVisible(true);
            this.setVisible(false);
        }
    }
     public ImageIcon setImage(String path, int i, int j){
        ImageIcon  menu1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image menu2 = menu1.getImage().getScaledInstance(i, j, Image.SCALE_DEFAULT);
        ImageIcon menu3 = new ImageIcon(menu2);
        return menu3;
    }
    
}
