package upload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Base64;

import db.*;

@WebServlet("/ViewCertificate")
public class ViewCertificate extends HttpServlet {
	PrintWriter out;
	Connection con;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		out = res.getWriter();
		res.setContentType("text/html");
		
		
		// view certificate form
		ResultSet rs;
		try {
			con = new db.DBConnection().getConnection();
			Statement st = con.createStatement();
			
			// get all certificate categories
			rs = st.executeQuery("Select * from category");
			
			out.println("<form action='GetCertificate' method='get'>");
			out.println("<select name='category'>");
			while(rs.next()) {
				String category = rs.getString(1);
				out.println("<option value='" + category + "'>" + category + "</option>");
			}
			out.println("</select>");
			out.println("<input type='submit' value='view' />");
			out.println("</form>");
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// get certificates from session
		HttpSession session = req.getSession();
		int image_count = 0;
		if (session.getAttribute("image_count") != null)
			image_count = (int)session.getAttribute("image_count");
		
		for (int i=0;i<image_count;i++) {
			String image_64 = (String)session.getAttribute("image64_"+i);
			out.println("<img class='certificate-img' src='data:image/jpg;base64,"+image_64+ "' width='300px' height='300px' />");
		}
		
	}
}
