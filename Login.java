/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_zuxinrui;
import javax.swing.*;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

  
public class Login extends JFrame implements ActionListener {  
  
    JButton jb1,jb2,jb3=null;  
    JRadioButton jrb1,jrb2,jrb3=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;      
      
    JMenuBar jmb=null;    
    JMenu jm1=null; 
    JMenu jm2=null;
    JMenuItem jmi1,jmi2,jmi3=null;  
      
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Login  ms=new Login();  
          
                          
    }  
    public Login()  
    {  
        
        jb1=new JButton("登录");  
        jb2=new JButton("重置账户密码");  
        jb3=new JButton("退出");
        
        
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  
          
        jmb=new JMenuBar(); 
        jm1=new JMenu("系统选项");
        jm2=new JMenu("关于作者");
        jmi1=new JMenuItem("开始"); 
        jmi2=new JMenuItem("退出"); 
        jmi3=new JMenuItem("力学专业 祖新瑞 初学数据库JAVA请多指教～");
        jm1.add(jmi1);  
        jm1.add(jmi2);
        jm2.add(jmi3);
        jmb.add(jm1);
        jmb.add(jm2);
        jmi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        }
        
        );
          
          
        jrb1=new JRadioButton("教师",true);  
        jrb2=new JRadioButton("学生");
        jrb3=new JRadioButton("管理员");
        jrb1.setForeground(Color.WHITE);
        jrb2.setForeground(Color.WHITE);
        jrb3.setForeground(Color.WHITE);
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);
        bg.add(jrb3);
//      jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("用户名：");  
        jlb2=new JLabel("密    码：");  
        jlb3=new JLabel("权    限：");
        jlb1.setForeground(Color.WHITE);
        jlb2.setForeground(Color.WHITE);
        jlb3.setForeground(Color.WHITE);
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  

        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
        
        jp3.setBackground(Color.GRAY);
        jp2.setBackground(Color.GRAY);
        jp1.setBackground(Color.GRAY);
        jp4.setBackground(Color.GRAY);
        
        jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2);
        jp3.add(jrb3);
          
        jp4.add(jb1);  
        jp4.add(jb2);  
        jp4.add(jb3);  
          
        //加入JFrame中  
        this.setJMenuBar(jmb);  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
         
        this.setLayout(new GridLayout(4,1));        
        this.setTitle("学生成绩管理系统");          
        this.setSize(500,380);      
        this.setLocationRelativeTo(null);   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if(e.getActionCommand()=="退出")  
        {  
            System.exit(0);  
        }else if(e.getActionCommand()=="重置账户密码"){
            this.clear();
        }
        else if(e.getActionCommand()=="登录")  
        {  
            if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())  
            {  
               
                GetSQL.ConnectSQL();  
               
                if(jrb1.isSelected())  
                {  
                    GetSQL.querytea("教师",jtf.getText());  
               
                    if(GetSQL.pwd ==null)  
                    {  
                         this.clear();  
                    }else  
                    {  
                 
                        this.tealogin();  
                    }  
                }else if(jrb2.isSelected())
                {  
                    GetSQL.querystu("学生",jtf.getText());  
           
                    if(GetSQL.pwd ==null)  
                    {  
                         this.clear();  
                    }else  
                    {  
                        this.stulogin();  
                    }  
                     
                }else if(jrb3.isSelected())  
                {
                    if (jtf.getText().equals("admin")&&jpf.getText().equals("admin")) {
                    JOptionPane.showMessageDialog(null,"管理员登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
                    this.clear();  
             
                    dispose();  
               
                    admin2 adm = new admin2();
                    adm.setLocationRelativeTo(null);
                    adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    adm.setVisible(true);
                } else {
                        JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
                    }}
            }else if(jtf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"请输入用户名","提示消息",JOptionPane.WARNING_MESSAGE);  
                this.clear();  
            }else if(jpf.getText().isEmpty())     
            {  
                JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);  
                this.clear();  
            }  
        }else if(e.getActionCommand()=="重置")  
        {  
            this.clear();  
        }             
          
    }  
                  
       
    public  void clear()  
        {  
            jtf.setText("");  
            jpf.setText("");  
        }  
          
            public void stulogin()  
            {  
                if(GetSQL.pwd.equals(jpf.getText()))  
                {  
 
                    JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
                    this.clear();  
                  
                     dispose();  
                  
                     Stu_UI ui=new Stu_UI();  
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
                
                    this.clear();  
                }  
            }  
               
            public void tealogin()  
            {  
                if(GetSQL.pwd.equals(jpf.getText()))  
                {  
//                  System.out.println("登录成功");  
                     JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
                     this.clear();    
                     dispose();    
                    Teacher t=new Teacher();                                    
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);   
                    this.clear();  
                }  
            }  
          
}
