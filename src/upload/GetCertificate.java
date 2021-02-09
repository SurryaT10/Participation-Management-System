package upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetCertificate
 */
@WebServlet("/GetCertificate")
public class GetCertificate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out;
		try {
			
			String category = req.getParameter("category");
			out = res.getWriter();
			
			// get all certificate categories
			Connection con = new db.DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement("select * from certificate where name=?");
			ps.setString(1, category);
			
			ResultSet rs = ps.executeQuery();
			int id=0;
			HttpSession session = req.getSession();
			
			// convert image to base64 and store in session
			while(rs.next()) {
				Blob blob = rs.getBlob("image");
				
				byte byteArray[] = blob.getBytes(1, (int)blob.length());
				String base64Image = Base64.getEncoder().encodeToString(byteArray);
				
//				out.println("<a href='http://localhost:8080/participation_record/upload.html'>back</a>");
				session.setAttribute("image64_"+id, base64Image);
				id++;
			}
			session.setAttribute("image_count", id);
			res.sendRedirect(req.getContextPath() + "/ViewCertificate");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
