package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfileStudent")
public class UpdateProfileStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String input_otp = request.getParameter("otp");
        String otp = "";
        
        try{
        	HttpSession s=request.getSession();
        	Student student = (Student)s.getAttribute("student");
        	otp = (String)s.getAttribute("otp");
        	
        	if(otp.equals(input_otp)){
            	String sql = " UPDATE student SET name = ?, reg_num = ?, year = ?, dept = ?, section = ?, batch = ?, password = ? WHERE email = ? ";
            	Connection con = DBConnection.getConnection();
            	PreparedStatement ps=con.prepareStatement(sql);
            	ps.setString(1, student.name);
                ps.setString(2, student.reg_num);
                ps.setInt(3, student.year);
                ps.setString(4, student.dept);
                ps.setString(5, student.section);
                ps.setInt(6, student.batch);
                ps.setString(7, student.password);
                ps.setString(8, student.email);
                
                ps.executeUpdate();
                
                response.sendRedirect(request.getContextPath() + "/HomeStudent.jsp");
        }
        else{
        	out.println("OTP incorrect");
        }
        	
        }
        catch(Exception e)
        {
        	System.out.println("session error"+e);
        }
        
        
	}
}
