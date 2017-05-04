/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_zuxinrui;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
 
public class GetSQL  
{  
    static String userword;  
    static String pwd;  
      
    static String english;  
    static String num;  
    static String name;  
    static String chinese;  
    static String zhengzhi;  
    static String math;  
      
    static String age;  
    static String salary;  
    static String sex;  
    static String zhicheng;  
    static String teanum;  
    static String teaname;  
  
    static Connection ct = null;  
    static PreparedStatement ps = null;  
    static ResultSet rs = null;
    static Statement sm = null;
    public static void ConnectSQL() { 
      
        try {  
            Class.forName("com.mysql.jdbc.Driver"); 
            System.out.println("driver success!");
            String conurl = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String userpassword = "95521521ABab";
            ct = DriverManager.getConnection(conurl, username, userpassword);
            System.out.println("Connection success!");
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            System.out.println("driver failure!");
        } catch (SQLException e) {
            System.out.println("connection failure!");
        }
        
    }  
    
    public static void querystu(String a,String b) {  
        
        try {  
            ps = ct.prepareStatement("select * from info where un=? ");              
            ps.setString(1, b);   
            rs = ps.executeQuery();
            System.out.println(b);
            if(rs.next()){
                System.out.println("resultset success!");
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("数据库匹配成功！祖新瑞很强！");  
                System.out.println(userword+"\t"+pwd+"\t");  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);  
            } 
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(ct!=null);{
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
    public static void querytea(String a,String b) {  
       
        try {  
            ps = ct.prepareStatement("select * from info_tea where un=? ");  
            ps.setString(1, b);   
            rs = ps.executeQuery();
            System.out.println(b);
            if(rs.next()){
                System.out.println("resultset success!");
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("数据库匹配成功！祖新瑞很强！");  
                System.out.println(userword+"\t"+pwd+"\t");  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);  
            } 
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(ct!=null);{
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
   
    public static void getdatastu(String s) {  
        try {  
            ps = ct.prepareStatement("select * from info  where sn=? ");  
            ps.setString(1, s);  
            rs = ps.executeQuery();  
            if(rs.next())     
            {  
                num = rs.getString(4);  
                name = rs.getString(5);  
                math = rs.getString(6);  
                chinese = rs.getString(7);  
                english = rs.getString(8);  
                zhengzhi = rs.getString(9);  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "沒有此学生，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);  
            }  
      
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
    public static void getdatatea(String s) {  
        try {  
            ps = ct.prepareStatement("select * from info_tea  where tn=? ");  
            ps.setString(1, s);  
            rs = ps.executeQuery();  
            if(rs.next())     
            {  
                teanum = rs.getString(4);  
                teaname = rs.getString(5);  
                sex = rs.getString(6);  
                salary = rs.getString(7);  
                zhicheng = rs.getString(8);  
                age = rs.getString(9);  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "沒有此教师，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);  
            }  
      
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
     
    public static void deldatastu(String s) {
        try {
            ps = ct.prepareStatement("delete from info  where sn=? ");
            ps.setString(1, s);
            ps.executeUpdate();
            
            
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    }
    
    public static void insdatastu(String a,String b,String c,String d,String e,String f,String g,String h) {
        try {
            ps = ct.prepareStatement("insert into info  values('学生',?,?,?,?,?,?,?,?)");
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);ps.setString(4, d);
            ps.setString(5, e);
            ps.setString(6, f);
            ps.setString(7, g);
            ps.setString(8, h);
            ps.executeUpdate();
            System.out.println("h的值为");
            System.out.println(h);
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    }
    
    public static void deldatatea(String s){
        try {
            ps = ct.prepareStatement("delete from info_tea  where tn=? ");
            ps.setString(1, s);
            ps.executeUpdate();
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    
    }
    
    public static void insdatatea(String a,String b,String c,String d,String e,String f,String g,String h) {
        try {
            ps = ct.prepareStatement("insert into info_tea  values('教师',?,?,?,?,?,?,?,?)");
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);ps.setString(4, d);
            ps.setString(5, e);
            ps.setString(6, f);
            ps.setString(7, g);
            ps.setString(8, h);
            ps.executeUpdate();
            System.out.println("h的值为");
            System.out.println(h);
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    }
    
    public static void updatastu(String a,String b,String c) {
        try {
            ps = ct.prepareStatement("update info set ?=? where sn=? ");
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            System.out.println("c的值为");
            System.out.println(c);
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    }
    
    public static void updatatea(String a,String b,String c) {
        try {
            ps = ct.prepareStatement("update info_tea set ?=? where sn=? ");
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            System.out.println("c的值为");
            System.out.println(c);
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }
    }

    
}
