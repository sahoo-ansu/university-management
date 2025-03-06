package university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1540,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);


        JMenuBar mb=new JMenuBar();

        //new info

        JMenu newinfo=new JMenu("New information");
        newinfo.setForeground(Color.BLACK);
        mb.add(newinfo);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newinfo.add(facultyInfo);

        JMenuItem studentinfo=new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.white);
        studentinfo.addActionListener(this);
        newinfo.add(studentinfo);


        //details

        JMenu details=new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultydetails=new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails=new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);


        //leave

        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        //Leave details

        JMenu leavedetails=new JMenu("Leave Details");
        leavedetails.setForeground(Color.BLACK);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails=new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);


        //exam

        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);

        JMenuItem examinationdetails=new JMenuItem("Examination Result");
        examinationdetails.setBackground(Color.white);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);


        //update info

        JMenu updateinfo=new JMenu("Update Details");
        updateinfo.setForeground(Color.BLACK);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo=new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo=new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);


        //fee

        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform=new JMenuItem("Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);


        //utility


        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad=new JMenuItem("Note Pad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        //about

        JMenu about=new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About=new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);


        //exit

        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit=new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);



        setJMenuBar(mb);

        setSize(1540,850);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String sm=e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
        }
        else if (sm.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (sm.equals("Note Pad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new teacherDetails();
        } else if (sm.equals("View Student Details")) {
            new studentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new teacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new teacherLeaveDetaila();
        } else if (sm.equals("Student Leave Details")) {
            new studentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new updateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new updateStudent();
        } else if (sm.equals("Enter Marks")) {
            new enterMarks();
        } else if (sm.equals("Examination Result")) {
            new examinationDetails();
        } else if (sm.equals("Fee Structure")) {
            new feeStructure();
        } else if (sm.equals("Fee Form")) {
            new studentFeeForm();
        } else if (sm.equals("About")) {
            new about();
        }

    }

    public static void main(String[] args) {
        new main_class();
    }

}
