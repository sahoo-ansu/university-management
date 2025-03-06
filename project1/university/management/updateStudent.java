package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class updateStudent extends JFrame implements ActionListener {

    JTextField textAddress,textPhone,textEmail,textadhar,textCourse,textBranch;

    JLabel empText;


    JButton submit,cancel;
    Choice cEmpId;

    updateStudent(){

        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empID=new JLabel("select Roll No");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif",Font.PLAIN,20));
        add(empID);

        cEmpId=new Choice();
        cEmpId.setBounds(250,100,200,20);
        add(cEmpId);

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from student");
            while(rs.next()){
                cEmpId.add(rs.getString("roll_no"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }



        JLabel name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName=new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);


        JLabel fname=new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textFather=new JLabel();
        textFather.setBounds(600,150,150,30);
        add(textFather);


        JLabel EMPIDD=new JLabel("Roll No");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDD);

        empText=new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);


        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobdob=new JLabel();
        dobdob.setBounds(600,200,150,30);
        add(dobdob);

        JLabel address=new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress=new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);


        JLabel phone=new JLabel("Phone");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone=new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);


        JLabel email=new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail=new JTextField();
        textEmail.setBounds(200,300,150,30);
        add(textEmail);


        JLabel m10=new JLabel("Class X(%)");
        m10.setBounds(400,300,200,30);
        m10.setFont(new Font("serif",Font.BOLD,20));
        add(m10);

        JLabel textm10=new JLabel();
        textm10.setBounds(600,300,150,30);
        add(textm10);


        JLabel m12=new JLabel("Class XII(%)");
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        JLabel textm12=new JLabel();
        textm12.setBounds(200,350,150,30);
        add(textm12);


        JLabel adharno=new JLabel("Aadhar Number");
        adharno.setBounds(400,350,200,30);
        adharno.setFont(new Font("serif",Font.BOLD,20));
        add(adharno);

        textadhar=new JTextField();
        textadhar.setBounds(600,350,150,30);
        add(textadhar);


        JLabel qualification=new JLabel("Course");
        qualification.setBounds(50,400,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        textCourse=new JTextField();
        textCourse.setBounds(200,400,150,30);
        add(textCourse);


        JLabel dept=new JLabel("Branch");
        dept.setBounds(400,400,200,30);
        dept.setFont(new Font("serif",Font.BOLD,20));
        add(dept);

        textBranch=new JTextField();
        textBranch.setBounds(600,400,150,30);
        add(textBranch);

        try{
            conn c=new conn();
            String q="select * from student where roll_no='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.statement.executeQuery(q);
            while(rs.next()){
                textName.setText(rs.getString("name"));
                textFather.setText(rs.getString("fname"));
                dobdob.setText(rs.getString("dob"));
                textadhar.setText(rs.getString("aadhar"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));
                textm10.setText(rs.getString("class_x"));
                textm12.setText(rs.getString("class_xii"));
                textAddress.setText(rs.getString("address"));
                empText.setText(rs.getString("roll_no"));
                textCourse.setText(rs.getString("course"));
                textBranch.setText(rs.getString("branch"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    String q="select * from student where roll_no='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs=c.statement.executeQuery(q);
                    while(rs.next()) {
                        textName.setText(rs.getString("name"));
                        textFather.setText(rs.getString("fname"));
                        dobdob.setText(rs.getString("dob"));
                        textadhar.setText(rs.getString("aadhar"));
                        textPhone.setText(rs.getString("phone"));
                        textEmail.setText(rs.getString("email"));
                        textm10.setText(rs.getString("class_x"));
                        textm12.setText(rs.getString("class_xii"));
                        textAddress.setText(rs.getString("address"));
                        empText.setText(rs.getString("roll_no"));
                        textCourse.setText(rs.getString("course"));
                        textBranch.setText(rs.getString("branch"));
                    }
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });


        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);




        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String empid=empText.getText();
            String address=textAddress.getText();
            String email=textEmail.getText();
            String course=textCourse.getText();
            String branch=textBranch.getText();
            String phone=textPhone.getText();

            try{
                String q="update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where roll_no='"+empid+"'";
                conn c=new conn();
                if(c.statement.executeUpdate(q)>0){
                    JOptionPane.showMessageDialog(null,"Details Updated");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Details not Updated");
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateStudent();
    }
}
