package upload;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import db.*;
import java.sql.*;
import student.Student;

@WebServlet("/UploadCertificate")
@MultipartConfig(maxFileSize = 16177216)

public class UploadCertificate extends HttpServlet {
	PrintWriter out;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		out = res.getWriter();
		Part part = req.getPart("image");
		
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		Student student = (Student)session.getAttribute("student");
		
		// if student not in session redirect to login page
		if (student == null)
			res.sendRedirect(req.getContextPath() + "/loginstudent.html");
		
		String reg_num = student.reg_num;
		
		int result = 0;
		
		res.setContentType("text/html");
		
		if (reg_num.equals("")) {
			out.println("<h2>Register number not available!</h2>");
			return;
		}
		
		if (name.equals("")) {
			out.println("<h2>Catogory name not available!</h2>");
			return;
		}
		
		// upload certificate details
		if (part != null) {
			try {
				
				Connection con = new db.DBConnection().getConnection();
				PreparedStatement ps = con.prepareStatement("insert into Certificate(name, reg_num, image) values(?, ?, ?)");
				InputStream is = part.getInputStream();
				ps.setString(1, name);
				ps.setString(2,reg_num);
				
				if (part.getSubmittedFileName().equals("")) {
					out.println("<div style='background-color:grey;color:white;padding:20px;'>");
						out.println("<h2>Image not available !</h2>");
					out.println("</div>");
					return;
				}
				
				ps.setBlob(3, is);
				result = ps.executeUpdate();
				
				out.println("<div style='background-color:grey;color:white;padding:20px;'>");
					out.println("<h2>Image has been uploaded !</h2>");
					out.println("<a href='GetMyCertificate.jsp'>view certificates</a>");
	        	out.println("</div>");
				
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCertificate.jsp");
//				dispatcher.forward(req, res);
				
			} catch (MySQLIntegrityConstraintViolationException e) {
				String err = e.toString();
				
				if (err.contains("reg_num")) {
					out.println("<div style='background-color:grey;color:white;padding:20px;'>");
						out.println("<h2>Register number not available !</h2>");
					out.println("</div>");
				}
				else if (err.contains("name")) {
					out.println("<div style='background-color:grey;color:white;padding:20px;'>");
						out.println("<h2>Catogory name not available !</h2>");
					out.println("</div>");
				}
			} catch (Exception e) {
				System.out.println(e);
				out.println("<div style='background-color:grey;color:white;padding:20px;'>");
					out.println("<h2>Image not uploaded !</h2>");
				out.println("</div>");
			}
		}
	}
}
