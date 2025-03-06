package university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teacherLeave extends JFrame implements ActionListener {

    Choice choicerollNo,choTime;
    JDateChooser selDate;
    JButton submit,cancel;

    teacherLeave(){

        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading=new JLabel("Apply Leave(Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tohama",Font.BOLD,20));
        add(heading);

        JLabel rollNo=new JLabel("Search By Employee ID");
        rollNo.setBounds(60,100,200,20);
        rollNo.setFont(new Font("Tohama",Font.PLAIN,18));
        add(rollNo);

        choicerollNo=new Choice();
        choicerollNo.setBounds(60,130,200,20);
        add(choicerollNo);

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from teacher");
            while(rs.next()){
                choicerollNo.add(rs.getString("empid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbldt=new JLabel("Date");
        lbldt.setBounds(60,180,200,20);
        lbldt.setFont(new Font("Tohama",Font.PLAIN,18));
        add(lbldt);

        selDate=new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        JLabel time=new JLabel("Time");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tohama",Font.PLAIN,18));
        add(time);

        choTime=new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("Half Day");
        choTime.add("Full Day");
        add(choTime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(250,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String rollno=choicerollNo.getSelectedItem();
            String date=((JTextField)selDate.getDateEditor().getUiComponent()).getText();
            String time=choTime.getSelectedItem();
            String q="insert into teacherleave values('"+rollno+"','"+date+"','"+time+"')";

            try{
                conn c=new conn();
                if(c.statement.executeUpdate(q)>0){
                    JOptionPane.showMessageDialog(null,"Leave Confirmed");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Leave Not Confirm");
                }

            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new teacherLeave();
    }
}
