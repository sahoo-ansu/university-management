package university.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teacherLeaveDetaila extends JFrame implements ActionListener {

    Choice choiceEmpid;
    JTable table;
    JButton search,cancel,print;

    teacherLeaveDetaila(){

        getContentPane().setBackground(new Color(250,172,206));

        JLabel heading=new JLabel("Search By Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpid=new Choice();
        choiceEmpid.setBounds(180,20,150,20);
        add(choiceEmpid);

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from teacher");
            while(rs.next()){
                choiceEmpid.add(rs.getString("empid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            e.printStackTrace();
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);


        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String q="select * from teacherleave where empid='"+choiceEmpid.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==print) {
            try{
                table.print();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new teacherLeaveDetaila();
    }
}
