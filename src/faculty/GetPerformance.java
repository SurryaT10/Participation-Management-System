package faculty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;
import signup.Dbprocess;

import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class GetPerformance
 */
@WebServlet("/GetPerformance")
public class GetPerformance extends HttpServlet {
	Connection con;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept = request.getParameter("dept");
		String year = request.getParameter("year");
		String section = request.getParameter("section");
		
		try {
			con = DBConnection.getConnection();
			Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from student where dept=? and year=? and section=?");
			
			ResultSet student = null;
			if (dept == null || year == null || section == null)
				student = st.executeQuery("select * from student");
			else {
				ps.setString(1, dept);
				ps.setInt(2, Integer.parseInt(year));
				ps.setString(3, section);
				
				student = ps.executeQuery();
			}
			
			// store performance in session
			HttpSession session = request.getSession();
			session.setAttribute("student_set", student);
			
			response.sendRedirect(request.getContextPath()+"/Chart.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect(request.getContextPath()+"/HomeFaculty.jsp");
		}
	}

}
