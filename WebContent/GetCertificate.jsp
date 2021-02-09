<%@page import="db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.*, java.sql.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		try {
			session = request.getSession();
			session.setAttribute("images", null);
			
			// get certificate categories
			Connection con = DBConnection.getConnection();
			PreparedStatement ps;
			
			String category = request.getParameter("category");
			if (category == null || category.equals("All")) {
				ps = con.prepareStatement("select * from certificate");
			} else {
				ps = con.prepareStatement("select * from certificate where name=?");
				ps.setString(1, category);
			}
			
			ResultSet rs = ps.executeQuery();
			int count=0;	// image count
			session = request.getSession();
			
			// convert image to base64 and store in session
			ArrayList<String> images = new ArrayList<String>();
			ArrayList<String> students = new ArrayList<String>();
			while(rs.next()) {
				Blob blob = rs.getBlob("image");
				
				byte byteArray[] = blob.getBytes(1, (int)blob.length());
				String base64Image = Base64.getEncoder().encodeToString(byteArray);
				
	//			out.println("<a href='http://localhost:8080/participation_record/upload.html'>back</a>");
				students.add(rs.getString("reg_num"));
				images.add(base64Image);
				count++;
			}
			
			session.setAttribute("students", students);
			session.setAttribute("images", images);
			session.setAttribute("image_count", count);
			response.sendRedirect(request.getContextPath() + "/ViewCertificate.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	
	%>
</body>
</html>