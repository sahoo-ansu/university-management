package university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName,textFather,textAddress,textPhone,textEmail,textm10,textm12,textadhar;

    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox,deptbox;

    JButton submit,cancel;

    Random ran=new Random();
    long f4=Math.abs((ran.nextLong()%9000L)+1000L);


    AddFaculty(){




        getContentPane().setBackground(new Color(166,164,252));

        JLabel heading=new JLabel("New teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);



        JLabel name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName=new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);


        JLabel fname=new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textFather=new JTextField();
        textFather.setBounds(600,150,150,30);
        add(textFather);


        JLabel empID=new JLabel("Employee ID");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        empText=new JLabel(""+f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);


        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob=new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);


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

        textm10=new JTextField();
        textm10.setBounds(600,300,150,30);
        add(textm10);


        JLabel m12=new JLabel("Class XII(%)");
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        textm12=new JTextField();
        textm12.setBounds(200,350,150,30);
        add(textm12);


        JLabel adharno=new JLabel("Aadhar Number");
        adharno.setBounds(400,350,200,30);
        adharno.setFont(new Font("serif",Font.BOLD,20));
        add(adharno);

        textadhar=new JTextField();
        textadhar.setBounds(600,350,150,30);
        add(textadhar);


        JLabel qualification=new JLabel("Qualification");
        qualification.setBounds(50,400,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String course[]={"B.Tech","BBA","BCA","BSC","MBA","MSC","MCA","MCom","MA","BA"};
        courseBox=new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);


        JLabel dept=new JLabel("Department");
        dept.setBounds(400,400,200,30);
        dept.setFont(new Font("serif",Font.BOLD,20));
        add(dept);

        String department[]={"Computer Science","Electronics","Civil","Mechanical","IT"};
        deptbox=new JComboBox(department);
        deptbox.setBounds(600,400,150,30);
        deptbox.setBackground(Color.WHITE);
        add(deptbox);


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
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String name=textName.getText();
            String fname=textFather.getText();
            String empid=empText.getText();
            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address=textAddress.getText();
            String phone=textPhone.getText();
            String email=textEmail.getText();
            String x=textm10.getText();
            String xii=textm12.getText();
            String aadhar=textadhar.getText();
            String course=(String) courseBox.getSelectedItem();
            String dept=(String) deptbox.getSelectedItem();
            try{
                String q="insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+dept+"')";
                conn c=new conn();
                if(c.statement.executeUpdate(q)>0) {
                    JOptionPane.showMessageDialog(null, "Details inserted");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Details insertion Failed");
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddFaculty();
    }
}
