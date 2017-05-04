/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_zuxinrui;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class Teacher extends JFrame implements ActionListener {  
  

    JLabel jl2,jl,jl3,jl4 = null;  
    JTextField jtf,jtf2 = null;  
    JButton jb,jb2,jb3 = null;  
    JPanel jp1, jp2,jp3,jp4,jp5,jp6,jp7 = null;  
  
    DefaultTableModel model,model2 = null;  
    JTable table,table2 = null;  
    JScrollPane jsp,jsp2 = null;  
    
    public static void main(String[] args) {  
       Teacher6 t = new Teacher6();    
       }  
  

    public Teacher() {  
    
        jl = new JLabel("请输入学号：");  
        jl2=new JLabel("请输入教工号：");    
          
        jl3=new JLabel("学生信息表：");  
        jl4=new JLabel("教师信息表：");  
          
        jtf = new JTextField(10);  
        jtf2 = new JTextField(10);  
        jb = new JButton("查询1");  
        jb2 = new JButton("查询2");
        jb3 = new JButton("返回登录界面");
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                Login ms=new Login();
            }
        });
       
        jb.addActionListener(this);  
        jb2.addActionListener(this);  
    
        String[] colnames = { "姓名", "学号", "数学", "语文", "英语", "政治" };  
        model = new DefaultTableModel(colnames, 3);  
        table = new JTable(model);  
        jsp = new JScrollPane(table);  
   
        String[] col = { "姓名", "教工号", "性别", "工资", "职称", "年龄" };  
        model2 = new DefaultTableModel(col, 3);  
        table2 = new JTable(model2);  
        jsp2 = new JScrollPane(table2);  
          
  
        jp1 = new JPanel();  
        jp2 = new JPanel();  
        jp3 = new JPanel();  
        jp4 = new JPanel();  
        jp5 = new JPanel();  
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp5.setLayout(new BorderLayout());  
        jp6.setLayout(new BorderLayout());  
  
        jp1.add(jl);  
        jp1.add(jtf);  
        jp1.add(jb);  
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT));  
        jp1.setPreferredSize(new Dimension(20,20));  
          
        jp3.add(jl2);  
        jp3.add(jtf2);  
        jp3.add(jb2);  
        jp3.setLayout(new FlowLayout(FlowLayout.LEFT));  
  
        jp2.add(jsp);  
        jp4.add(jsp2);  
          
        jp5.add(jl3,BorderLayout.SOUTH);  
        jp6.add(jl4,BorderLayout.SOUTH);
        
        jp7.add(jb3);
  
        this.add(jp1);  
        this.add(jp5);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp6);  
        this.add(jp4);
        this.add(jp7);
          
        this.setLayout(new GridLayout(7, 1));  
        this.setTitle("学生成绩管理系统—教师");  
        this.setSize(500, 500);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
        this.setResizable(false);  
          
  
    }  
  
     
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("查询1")  &&!jtf.getText().isEmpty()) {                         
   
            GetSQL.ConnectSQL();  
            GetSQL.getdatastu(jtf.getText());  
            jtf.setText("");  
            System.out.println(GetSQL.english);  
            System.out.println(GetSQL.chinese);  
  
            table.setValueAt(GetSQL.name, 0, 0);  
            table.setValueAt(GetSQL.num, 0, 1);  
            table.setValueAt(GetSQL.math, 0, 2);  
            table.setValueAt(GetSQL.chinese, 0, 3);  
            table.setValueAt(GetSQL.english, 0, 4);  
            table.setValueAt(GetSQL.zhengzhi, 0, 5);                  
                  
        }else if (e.getActionCommand().equals("查询2")  &&!jtf2.getText().isEmpty())  
        {  
         
            GetSQL.ConnectSQL();  
            GetSQL.getdatatea(jtf2.getText());  
            jtf2.setText("");  
  
                        
            table2.setValueAt(GetSQL.teaname, 0, 0);  
            table2.setValueAt(GetSQL.teanum, 0, 1);  
            table2.setValueAt(GetSQL.sex, 0, 2);  
            table2.setValueAt(GetSQL.salary, 0, 3);  
            table2.setValueAt(GetSQL.zhicheng, 0, 4);  
            table2.setValueAt(GetSQL.age, 0, 5);  
        }else  
        {  
            JOptionPane.showMessageDialog(null , "请输入要查询的编号","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
  
    }  
}
