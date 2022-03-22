package CityGuideClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener, Runnable{
    JButton menu,about,vpd,upd,da,vp,vbp;
    JLabel[] label = new JLabel[5];
    String[] text = new String[]{"\"Oh the places you’ll go\"",
        "\"The life you have led doesn’t need to be the only life you have\"",
        "\"The most beautiful thing in the world is, of course, the world itself\"",
        "\"There's a sunrise and a sunset every single day, and they're absolutely free. Don't miss so many of them\"",
        "\"Traveling – it leaves you speechless, then turns you into a storyteller\""};
    JLabel caption;
    JPanel p1;
    int i=1;
    Thread t;
    String uname;
    Description d = new Description();
    DashBoard(String username){
        uname = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("City Guide");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/icon.png"));
        Image icon = i.getImage();
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(255, 165, 0));
        p.setBounds(0, 0, 1600, 40);
        add(p);
        
        p1 = new JPanel();
        p1.setLayout (null);
        p1.setBackground(new Color(240, 248, 255));
        p1.setForeground(new Color(102, 51, 153));
        p1.setBounds(0, 40, 200, 600);
        add(p1);
        p1.setVisible(false);
        
        
        ImageIcon[] imgicon = new ImageIcon[5];
        ImageIcon[] ic1 = new ImageIcon[5];
        Image[] im = new Image[5];
        caption = new JLabel(text[0], JLabel.CENTER);
        caption.setBounds(0, 670, 1600, 50);
        caption.setForeground(new Color(0, 0, 0));
        caption.setFont(d.derivedFont("ShadowsIntoLight-Regular", 45));
        add(caption);
        for(int j = 0; j<5; j++){
            imgicon[j] = new ImageIcon(ClassLoader.getSystemResource("images/dashboard"+(j+1)+".jpg"));
            im[j] = imgicon[j].getImage().getScaledInstance(1200, 560, Image.SCALE_DEFAULT);
            ic1[j] = new ImageIcon(im[j]);
            label[j] = new JLabel(ic1[j]);
            label[j].setBounds(200, 90, 1200, 560);
            label[j].setBorder(BorderFactory.createRaisedSoftBevelBorder());
            add(label[j]);
        }
        
        JLabel dashboard = new JLabel("DashBoard");
        dashboard.setFont(d.derivedFont("Cotton Butter", 30));
        dashboard.setBounds(45, 5, 150, 30);
        dashboard.setForeground(new Color(102, 51, 153));
        p.add(dashboard);
        
        JLabel un = new JLabel();
        un.setText(uname);
        un.setBounds(1430, 5, 120, 30);
        un.setFont(d.derivedFont("Roboto-Light", 25));
        un.setForeground(new Color(0, 0, 0));
        p.add(un);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/user.png"));
        Image i5 = i4.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(1555, 5, 32, 32);
        l2.setBackground(new Color(133, 193, 233));
        p.add(l2);
        
        ImageIcon  menu1 = new ImageIcon(ClassLoader.getSystemResource("images/menu.png"));
        Image menu2 = menu1.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
        ImageIcon menu3 = new ImageIcon(menu2);
        
        menu =  new JButton(menu3);
        menu.setBounds(0, 0, 40, 40);
        menu.setBackground(new Color(255, 165, 0));
        menu.addActionListener(this);
        menu.setBorder(BorderFactory.createEmptyBorder());
        menu.setFocusable(false);
        p.add(menu);
        
        upd = new JButton("Update Personal Details");
        upd.setBackground(new Color(240, 248, 255));
        upd.addActionListener(this);
        upd.setBounds(0, 0, 200, 40);
        upd.setFocusable(false);
        p1.add(upd);
        
        vpd = new JButton("View Personal Details");
        vpd.setBackground(new Color(240, 248, 255));
        vpd.addActionListener(this);
        vpd.setBounds(0,40, 200, 40);
        vpd.setFocusable(false);
        p1.add(vpd);
        
        
        vp = new JButton("Explore Packages");
        vp.setBackground(new Color(240, 248, 255));
        vp.addActionListener(this);
        vp.setBounds(0, 80, 200, 40);
        vp.setFocusable(false);
        p1.add(vp);
        
        vbp = new JButton("View Booked Packages");
        vbp.setBackground(new Color(240, 248, 255));
        vbp.addActionListener(this);
        vbp.setBounds(0, 120, 200, 40);
        vbp.setFocusable(false);
        p1.add(vbp);
    
        da = new JButton("Delete Account");
        da.setBackground(new Color(240, 248, 255));
        da.addActionListener(this);
        da.setFocusable(false);
        da.setBounds(0, 160, 200, 40);
        p1.add(da);
        
        about = new JButton("About");
        about.setBackground(new Color(240, 248, 255));
        about.addActionListener(this);
        about.setFocusable(false);
        about.setBounds(0, 200, 200, 40);
        p1.add(about);
        
        t = new Thread(this);
        t.start();
    }
    public static void main(String[] args){
        new DashBoard("mahendra").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == menu){
           if(i%2 == 1){
                   p1.setVisible(true);
                   i=2;
           }else{
               p1.setVisible(false);
                   i=1;
           }
       }else if(e.getSource() == upd){
           new UpdatePD(uname).setVisible(true);
           p1.setVisible(false);
           i=1;
       }else if(e.getSource() == vpd){
           new ViewPD(uname).setVisible(true);
           p1.setVisible(false);
           i=1;
       }else if(e.getSource() == vp){
           new ExplorePackages(uname).setVisible(true);
           p1.setVisible(false);
       }else if(e.getSource() == vbp){
           new ViewBookedPackage(uname).setVisible(true);
           p1.setVisible(false);
           i=1;
       }else if(e.getSource() == da){
           new DeleteAccount(uname).setVisible(true);
           p1.setVisible(false);
           i=1;
       }else if(e.getSource() == about){
           new About().setVisible(true);
           p1.setVisible(false);
           i=1;
       }
    }

    @Override
    public void run() {
        try{
            while(true){
                for(int j = 0; j<5; j++){
                this.label[j].setVisible(true);
                caption.setText(text[j]);
                this.add(caption);
                Thread.sleep(5000);
                this.label[j].setVisible(false);
            }
        }
        }catch(Exception e){}
    }
}