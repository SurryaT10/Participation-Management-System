<%@page import="signup.Dbprocess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DBConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/performance.css">
<title>Performance</title>
</head>
<body>
	<%! Connection con; %>
	
	<table border="1" width="70%">
		<tr>
			<th>reg num</th>
			<th>name</th>
			<th>dept</th>
			<th>year</th>
			<th>section</th>
	
	<%
	    con = DBConnection.getConnection();
		session = request.getSession();
		ResultSet student = (ResultSet)session.getAttribute("student_set");
		
		ArrayList<String> courses = new Dbprocess().getCourses();
		
		for (int i=0;i<courses.size();i++)
			out.println("<th>" + courses.get(i) + "</th>");
		
		out.println("<th>Grade</th></tr>");
		
		PreparedStatement ps;

		while(student.next()) {
			int total_certificates = 0;
			ArrayList<Integer> certificates = new ArrayList<Integer>();
			for (int i=0;i<courses.size();i++) {
					int count = 0;
					ps = con.prepareStatement("select * from certificate where reg_num=? and name=?");
					ps.setString(1, student.getString("reg_num"));
					ps.setString(2, courses.get(i));
					
					ResultSet rs1 = ps.executeQuery();
					
					while (rs1.next()) {
						count++;
					}
					certificates.add(count);
					total_certificates += count;
			}
			
			float grade = new Dbprocess().getGrade(total_certificates);
			
			out.println("<tr>");
			out.println("<td>" + student.getString("reg_num") + "</td>");
			out.println("<td>" + student.getString("name") + "</td>");
			out.println("<td>" + student.getString("dept") + "</td>");
			out.println("<td>" + student.getString("year") + "</td>");
			out.println("<td>" + student.getString("section") + "</td>");
			
			for (int i=0;i<certificates.size();i++)
				out.println("<td>" + certificates.get(i) + "</td>");
			
			out.println("<td>" + grade + "</td>");
			out.println("</tr>");
		}
	%>
	</table>
	<nav>
          <form id="login-content" action='GetPerformance' method='get'>
          	<h2>Select category</h2>
            <fieldset id="inputs">
			<div class="box">
				<label>Department</label>
				<select name='dept'>
					<option value="CSE">CSE</option>
					<option value="CIVIL">CIVIL</option>
					<option value="ECE">ECE</option>
					<option value="EEE">EEE</option>
					<option value="ICE">ICE</option>
					<option value="IT">IT</option>
					<option value="MECH">MECH</option>
				</select>
				<label>Year</label>
				<select name='year'>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
				<label>Section</label>
				<select name='section'>
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
			</div>
			<input type='submit' value='view' />
            </fieldset>
          </form>
	  </nav>
</body>
</html>