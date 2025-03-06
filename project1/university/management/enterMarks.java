package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class enterMarks extends JFrame implements ActionListener {

    Choice choiceRollno;
    JComboBox comboBox;
    JTextField sub1,sub2,sub3,sub4,sub5,mrk1,mrk2,mrk3,mrk4,mrk5;
    JButton submit,cancel;

    enterMarks(){

        getContentPane().setBackground(new Color(252,245,210));
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.png"));
        Image i2=i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(580,60,350,300);
        add(img);

        JLabel heading=new JLabel("Enter Marks Of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel rollNo=new JLabel("Select Roll No");
        rollNo.setBounds(50,70,150,20);
        //rollNo.setFont(new Font("Tahoma",Font.BOLD,20));
        add(rollNo);

        choiceRollno=new Choice();
        choiceRollno.setBounds(200,70,150,20);
        add(choiceRollno);

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from student");
            while(rs.next()){
                choiceRollno.add(rs.getString("roll_no"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        JLabel sem =new JLabel("Select Semester");
        sem.setBounds(50,110,150,20);
        //sem.setFont(new Font("Tahoma",Font.BOLD,20));
        add(sem);

        String semester[]={"1st sem","2nd sem","3rd sem","4th sem","5th sem","6th sem","7th sem","8th sem"};
        comboBox=new JComboBox(semester);
        comboBox.setBounds(200,110,150,20);
        comboBox.setBackground(Color.WHITE);
        add(comboBox);

        JLabel enterSub=new JLabel("Enter Subject");
        enterSub.setBounds(100,150,200,40);
        add(enterSub);

        JLabel enterMark=new JLabel("Enter Marks");
        enterMark.setBounds(320,150,200,40);
        add(enterMark);

        sub1=new JTextField();
        sub1.setBounds(50,200,200,20);
        add(sub1);

        sub2=new JTextField();
        sub2.setBounds(50,230,200,20);
        add(sub2);

        sub3=new JTextField();
        sub3.setBounds(50,260,200,20);
        add(sub3);

        sub4=new JTextField();
        sub4.setBounds(50,290,200,20);
        add(sub4);

        sub5=new JTextField();
        sub5.setBounds(50,320,200,20);
        add(sub5);


        mrk1=new JTextField();
        mrk1.setBounds(250,200,200,20);
        add(mrk1);

        mrk2=new JTextField();
        mrk2.setBounds(250,230,200,20);
        add(mrk2);

        mrk3=new JTextField();
        mrk3.setBounds(250,260,200,20);
        add(mrk3);

        mrk4=new JTextField();
        mrk4.setBounds(250,290,200,20);
        add(mrk4);

        mrk5=new JTextField();
        mrk5.setBounds(250,320,200,20);
        add(mrk5);

        submit=new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);





        setSize(1000,500);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                conn c=new conn();
                String q1="insert into subject values('"+choiceRollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String q2="insert into marks values('"+choiceRollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
                if(c.statement.executeUpdate(q1)>0 && c.statement.executeUpdate(q2)>0){
                    JOptionPane.showMessageDialog(null,"Marks inserted successfully");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Marks not inserted");
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new enterMarks();
    }
}
