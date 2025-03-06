package university.management;

import javax.swing.*;
import java.awt.*;

public class about extends JFrame {

    about(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/about.jpeg"));
        Image i2=i1.getImage().getScaledInstance(280,220,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(390,0,280,220);
        add(img);

        JLabel heading=new JLabel("<html>SOA<br>ITER</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("ANSUMAN");
        name.setBounds(60,260,550,40);
        name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(name);

        JLabel contact=new JLabel("ansuman@gmail.com");
        contact.setBounds(60,340,550,40);
        contact.setFont(new Font("Tahoma",Font.BOLD,30));
        add(contact);


      setSize(700,500);
      setLocation(400,150);
      setLayout(null);
      getContentPane().setBackground(new Color(254,254,255));
      setVisible(true);
    }

    public static void main(String[] args) {
        new about();
    }
}
