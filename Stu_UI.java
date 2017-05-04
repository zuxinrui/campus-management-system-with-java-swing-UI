/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_zuxinrui;  
import java.awt.*;  
import java.awt.event.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
  
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
  
public class Stu_UI extends JFrame implements ActionListener  
{  
  
        JButton jb1,jb2,jb3=null;  
        JPanel jp1,jp2,jp3=null;  
        JLabel jlb1,jlb2,jlb3,jlb4=null;  
          
//      public static void main(String[] args) {  
//          // TODO Auto-generated method stub  
//          Stu_UI6  ui=new Stu_UI6();  
//      }
        public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Stu_UI  ui=new Stu_UI();  
          
                          
        }

        public  Stu_UI()    
        {  
           
            jb1=new JButton("课程管理");  
            jb2=new JButton("成绩查询");
            jb3=new JButton("返回登录界面");
            jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                Login ms=new Login();
            }
        });
              
            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();  
              
            jlb1=new JLabel("姓名");  
            jlb2=new JLabel("学号");  
            jlb3=new JLabel("最新公告：");  
            jlb4=new JLabel("我校举行110周年校庆的通知");  
              
            jp1.add(jlb1);  
            jp1.add(jlb2);
            jp1.add(jb3);
              
            jp2.add(jb1);  
            jp2.add(jlb3);  
              
            jp3.add(jb2);  
            jp3.add(jlb4);  
              
              
            this.add(jp1);  
            this.add(jp2);  
            this.add(jp3);  
              
            this.setLayout(new GridLayout(3,3,50,50));  
            this.setTitle("学生成绩管理系统");  
            this.setSize(400,300);  
            this.setLocationRelativeTo(null);       
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setVisible(true);  
  
}  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            // TODO Auto-generated method stub  
              
              
        }  
}  
