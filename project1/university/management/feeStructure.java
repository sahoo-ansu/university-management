package university.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class feeStructure extends JFrame implements ActionListener {

    feeStructure(){

        getContentPane().setBackground(Color.WHITE);
        JLabel heading =new JLabel("Fee Structure");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JTable table=new JTable();

        try{
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane js=new JScrollPane(table);
        js.setBounds(0,60,1000,700);
        add(js);

        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new feeStructure();
    }
}
