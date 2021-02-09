<%@page import="java.util.ArrayList, db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*, student.Student"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="./css/view_certificate.css">
</head>
<body>
	
	<%! Connection con;
	%>
	
	<%
		session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		if (student == null) {
			response.sendRedirect(request.getContextPath() + "/loginstudent.html");
			return;
		}
	%>
	
	 <nav>
          <form id="login-content" action='GetMyCertificate.jsp' method='get'>
          	<h3 style="color: black;">Select category</h3>
            <fieldset id="inputs">
              <%
				response.setContentType("text/html");
				
				session = request.getSession();
				
				// view certificate form
				ResultSet rs;
				try {
					con = DBConnection.getConnection();
					Statement st = con.createStatement();
					
					// get certificate categories
					rs = st.executeQuery("Select * from category");
			%>
			
			<div class="box">
				<select name='category'>
					<option value="All">All</option>
			
				<%
					while(rs.next()) {
						String category = rs.getString(1);
						out.println("<option value='" + category + "'>" + category + "</option>");
					}
				%>
			
				</select>
			</div>
			<input type='submit' value='view' />
            </fieldset>
          </form>
	  </nav>
		
	<%
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// get certificates from session
		int image_count = 0;
		if (session.getAttribute("image_count") != null)
			image_count = (int)session.getAttribute("image_count");
		ArrayList<String> images = (ArrayList<String>)session.getAttribute("images");
	%>
		
		<div class="slide-container">
    <%
		for (int i=0;i<image_count;i++) {
			String image_64 = images.get(i);
	%>
			
			<%
				out.println("<div class='slide fade'>");
				out.println("<img class='certificate-img' src='data:image/jpg;base64,"+image_64+ "' alt='' />");
				out.println("</div>");
		}
	%>

      <%
      		if (image_count > 0) {
      			out.println("<a href='#' class='prev' title='Previous'>&#10094</a>");
      	     	out.println("<a href='#' class='next' title='Next'>&#10095</a>");
      		} else {
      			out.println("<h2>No certificates available</h2>");
      		}
      %>
    </div>
    <div class="dots-container">
      <% for (int i=0;i<image_count;i++) { %>
      		<span class="dot"></span>
      <% } %>
    </div>
    <a class="back" href="HomeStudent.jsp">Back</a>
	<script src="./js/view_certificate.js"></script>
</body>
</html>