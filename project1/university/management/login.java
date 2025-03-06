package university.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class login extends JFrame implements ActionListener{

    JTextField textFieldName;
    JPasswordField passwordField;
    JButton Login;
    JButton Back;

    login(){

        JLabel labelname=new JLabel("Username");
        labelname.setBounds(40,50,100,20);
        labelname.setForeground(Color.WHITE);
        add(labelname);

        textFieldName=new JTextField();
        textFieldName.setBounds(150,50,150,20);
        add(textFieldName);

        JLabel labelpass=new JLabel("Password");
        labelpass.setBounds(40, 100, 100, 20);
        labelpass.setForeground(Color.WHITE);
        add(labelpass);

        passwordField=new JPasswordField();
        passwordField.setBounds(150, 100, 150, 20);
        add(passwordField);

        Login=new JButton("Login");
        Login.setBounds(40,170,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        Back=new JButton("Back");
        Back.setBounds(180,170,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2=i1.getImage().getScaledInstance(220, 180, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,20,220,180);
        add(img);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i22=i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel Img=new JLabel(i33);
        Img.setBounds(0,0,600,300);
        add(Img);

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Login){
            String username=textFieldName.getText();
            String password=passwordField.getText();
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                conn c=new conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            //setVisible(false);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
