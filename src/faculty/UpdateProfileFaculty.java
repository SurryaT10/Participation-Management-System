package faculty;

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
 * Servlet implementation class UpdateProfileFaculty
 */
@WebServlet("/UpdateProfileFaculty")
public class UpdateProfileFaculty extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String input_otp = request.getParameter("otp");
        String otp = "";
        
        try{
        	HttpSession s=request.getSession();
        	Faculty faculty = (Faculty)s.getAttribute("faculty");
        	otp = (String)s.getAttribute("otp");
        	
        	if(otp.equals(input_otp)){
            	String sql = " UPDATE faculty SET name = ?, reg_num = ?, year_of_join = ?, dept = ?, incharge_year = ?, incharge_section = ?, batch_num = ?, password = ? WHERE email = ? ";
            	Connection con = DBConnection.getConnection();
            	PreparedStatement ps=con.prepareStatement(sql);
            	ps.setString(1, faculty.name);
                ps.setString(2, faculty.reg_num);
                ps.setInt(3, faculty.year);
                ps.setString(4, faculty.dept);
                ps.setInt(5, faculty.in_year);
                ps.setString(6, faculty.in_section);
                ps.setInt(7, faculty.batch);
                ps.setString(8, faculty.password);
                ps.setString(9, faculty.email);
                
                ps.executeUpdate();
                
                response.sendRedirect(request.getContextPath() + "/HomeFaculty.jsp");
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
