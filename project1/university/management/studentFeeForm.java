package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentFeeForm extends JFrame implements ActionListener {

    Choice crollNo;
    JComboBox deptbox,courseBox,semBox;
    JLabel totalAmount;
    JButton pay,update,back;

    studentFeeForm(){

        getContentPane().setBackground(new Color(155,224,225));

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpeg"));
        Image i2=i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(400,35,450,320);
        add(img);

        JLabel roolno=new JLabel("Select Roll No");
        roolno.setBounds(40,60,150,20);
        roolno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(roolno);


        crollNo=new Choice();
        crollNo.setBounds(200,60,150,20);
        add(crollNo);

        try {
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from student");
            while(rs.next()){
                crollNo.add(rs.getString("roll_no"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(40,100,150,20);
        add(name);

        JLabel textName=new JLabel();
        textName.setBounds(200,100,150,20);
        add(textName);


        JLabel fname=new JLabel("Father Name");
        fname.setBounds(40,140,150,20);
        add(fname);

        JLabel textfName=new JLabel();
        textfName.setBounds(200,140,150,20);
        add(textfName);

        try{
            conn c=new conn();
            String q="select * from student where roll_no='"+crollNo.getSelectedItem()+"'";
            ResultSet rs=c.statement.executeQuery(q);
            while(rs.next()){
                textName.setText(rs.getString("name"));
                textfName.setText(rs.getString("fname"));
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }

        crollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    String q="select * from student where roll_no='"+crollNo.getSelectedItem()+"'";
                    ResultSet rs=c.statement.executeQuery(q);
                    while(rs.next()){
                        textName.setText(rs.getString("name"));
                        textfName.setText(rs.getString("fname"));
                    }
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });

        JLabel qualification=new JLabel("Course");
        qualification.setBounds(40,180,150,20);
//        qualification.setFont(new Font("Tahoma",Font.BOLD,16));
        add(qualification);

        String course[]={"BTech","BBA","BCA","BSC","MBA","MSC","MCA","MCom","MA","BA"};
        courseBox=new JComboBox(course);
        courseBox.setBounds(200,180,150,20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);


        JLabel dept=new JLabel("Branch");
        dept.setBounds(40,220,150,20);
//        dept.setFont(new Font("serif",Font.BOLD,16));
        add(dept);

        String department[]={"Computer Science","Electronics","Civil","Mechanical","IT"};
        deptbox=new JComboBox(department);
        deptbox.setBounds(200,220,150,20);
        deptbox.setBackground(Color.WHITE);
        add(deptbox);


        JLabel textSem=new JLabel("Semester");
        textSem.setBounds(40,260,150,20);
        add(textSem);

        String sem[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        semBox=new JComboBox(sem);
        semBox.setBounds(200,260,150,20);
        add(semBox);

        JLabel total=new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        add(total);

        totalAmount=new JLabel();
        totalAmount.setBounds(200,300,150,20);
        add(totalAmount);

        update=new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        pay=new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back=new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);





        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
            String course=(String) courseBox.getSelectedItem();
            String sem=(String) semBox.getSelectedItem();

            try{
                conn c=new conn();
                ResultSet rs=c.statement.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next()){
                    totalAmount.setText(rs.getString(sem));

                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==pay) {
            String rollno=crollNo.getSelectedItem();
            String course=(String) courseBox.getSelectedItem();
            String sem=(String) semBox.getSelectedItem();
            String branch=(String) deptbox.getSelectedItem();
            String total=totalAmount.getText();

            try{
                conn c=new conn();
                String q="insert into feecollege values('"+rollno+"','"+course+"','"+branch+"','"+sem+"','"+total+"')";
                if(c.statement.executeUpdate(q)>0){
                    JOptionPane.showMessageDialog(null,"fee submitted successfully");
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"fee not submitted");
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentFeeForm();
    }
}
