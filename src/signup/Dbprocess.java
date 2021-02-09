/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import db.DBConnection;
import faculty.Faculty;
import mail.SendMail;
import student.Student;

/**
 *
 * @author NIRMALA.B
 */
public class Dbprocess {
	private Connection con;
    public Student loginvalidationstudent(String email,String password){

        Student st = null;
        try{

                con=DBConnection.getConnection();
                String query="select * from student where email=? and password=?";

                PreparedStatement pstmt=con.prepareStatement(query);

                pstmt.setString(1,email);
                pstmt.setString(2,password);

                ResultSet rs=pstmt.executeQuery();

                // get student (to store in session)
                if(rs.next()){
                	String regnum = rs.getString("reg_num");
    				String name = rs.getString("name");
    				int year = rs.getInt("year");
    				String dept = rs.getString("dept");
    				String section = rs.getString("section");
    				int batch = rs.getInt("batch");
    				
    				st = new Student(regnum, name, year, dept, section, batch, email, password);
                }

                con.close();

                return st;
        }
        catch(Exception ex){
        	System.out.println(ex);
            return  st;
        }
    }
    public Faculty loginvalidationfaculty(String email,String password){
    	Faculty faculty = null;
        try{

                con = DBConnection.getConnection();
                String query="select * from faculty where email=? and password=?";

                PreparedStatement pstmt=con.prepareStatement(query);

                pstmt.setString(1,email);
                pstmt.setString(2,password);

                ResultSet rs=pstmt.executeQuery();
                
                // get faculty (to store in session)
                if(rs.next()){
                	String regnum = rs.getString("reg_num");
    				String name = rs.getString("name");
    				int year = rs.getInt("year_of_join");
    				String dept = rs.getString("dept");
    				int in_year = rs.getInt("incharge_year");
    				String in_section = rs.getString("incharge_section");
    				int batch = rs.getInt("batch_num");
    				
    				faculty = new Faculty(regnum, name, year, dept, in_year, in_section, batch, email, password);
                }
                con.close();

                return faculty;
        }
        catch(Exception ex){
        	System.out.println(ex);
             return  faculty;
        }
    }
    public String insertvaluesstudent(String regnum,String name,String year,String dept,String section,String batch,String email,String password){

        try{

                con=DBConnection.getConnection();
                String query="insert into student values(?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(query);

                pstmt.setString(1,regnum);
                pstmt.setString(2,name);
                pstmt.setInt(3,Integer.parseInt(year));
                pstmt.setString(4,dept);
                pstmt.setString(5,section);
                pstmt.setInt(6,Integer.parseInt(batch));
                pstmt.setString(7,email);
                pstmt.setString(8,password);

                pstmt.executeUpdate();
                con.setAutoCommit(true);
                con.close();
                return "success";
        }
        catch(Exception ex){
             return  "Exception------------------------>  "+ex;
        }

    }
    public String insertvaluesfaculty(String regnum,String name,String year,String dept,String in_year,String in_section,String batch,String email,String password){

        try{

                Connection con=DBConnection.getConnection();
                String query="insert into faculty values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(query);

                pstmt.setString(1,regnum);
                pstmt.setString(2,name);
                pstmt.setInt(3,Integer.parseInt(year));
                pstmt.setString(4,dept);
                pstmt.setInt(5,Integer.parseInt(in_year));
                pstmt.setString(6,in_section);
                pstmt.setInt(7,Integer.parseInt(batch));
                pstmt.setString(8,email);
                pstmt.setString(9,password);

                pstmt.executeUpdate();
                con.setAutoCommit(true);
                con.close();
                return "success";
        }
        catch(Exception ex){
             return  "Exception------------------------>  "+ex;
        }
    }
    
    public String sendmessage(String year,String dept,String section,String message){
        try{
            Connection con=DBConnection.getConnection();
            String query="insert into notification values(?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setInt(2,Integer.parseInt(year));
            pstmt.setString(3,dept.toLowerCase());
            pstmt.setString(4,section.toLowerCase());
            pstmt.setString(5,message);
            
            String query1="select email from student where year=? AND dept=? AND section=?";
            PreparedStatement pstmt1=con.prepareStatement(query1);
            pstmt1.setInt(1,Integer.parseInt(year));
            pstmt1.setString(2, dept);
            pstmt1.setString(3,section);
            ResultSet rs=pstmt1.executeQuery();
            
            Thread t = new Thread(new SendMail(rs, message));
            t.start();
//            mail.JavaMail j=new mail.JavaMail();
//            while(rs.next()){
//                String mail=rs.getString(1);
//                if(mail!=null)
//                {
//                  j.accept(mail,message);
//                }
//            }
            
            
            pstmt.executeUpdate();
            con.setAutoCommit(true);
            return "Message Sent!";
        }
        catch(Exception ex){
            return "Exception------------------------>"+ex;
        }
    }
    
    public ArrayList<String> getCourses() {
    	ArrayList<String> courses = new ArrayList<String>();
    	
    	try {
    		Connection con = DBConnection.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("select * from category");
    		
    		while(rs.next())
    			courses.add(rs.getString("name"));
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	return courses;
    }
    
    public float getGrade(int certificates_count) {
    	float total_certificates = 8;
    	
    	return (certificates_count/total_certificates)*100;
    }
    
    public ArrayList<String> getNotifications(int year, String dept, String section) {
    	ArrayList<String> notifications = new ArrayList<String>();
    	try {
    		Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select message from notification where year=? AND dept=? AND section=?");
            pst.setInt(1,year);
            pst.setString(2, dept);
            pst.setString(3,section);
            ResultSet rst=pst.executeQuery();
            
            while(rst.next())
            	notifications.add(rst.getString(1));
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	return notifications;
    }
}
