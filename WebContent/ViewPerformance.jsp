<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="signup.Dbprocess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DBConnection"%>
<%@page import="student.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Performance</title>
<link rel="stylesheet" href="./css/view_performance.css">
<style>
	p.a { 
	    word-spacing: 300px;
	 }
	p.b{
	    word-spacing:420px;
	}
</style>
</head>
<body style="background-color:mediumaquamarine">
	<%! Connection con; %>
	<% 
		con = DBConnection.getConnection();
		session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Nptel");
		courses.add("Coursera");
		courses.add("Udemy");
		courses.add("Sports");
		courses.add("Others");
		
		PreparedStatement ps;
		ArrayList<Integer> certificates = new ArrayList<Integer>();
		
		
		int total_certificates = 0;
		for (int i=0;i<courses.size();i++) {
			int count = 0;
			ps = con.prepareStatement("select * from certificate where reg_num=? and name=?");
			ps.setString(1, student.reg_num);
			ps.setString(2, courses.get(i));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				count++;
			}
			certificates.add(count);
			total_certificates += count;
		}
		
		float grade = new Dbprocess().getGrade(total_certificates);
		
	%>

    <center>
        <% out.println("<p style='font-family:courier;font-size:300%;color:black' class='a'>" + courses.get(0).toUpperCase() + " " + courses.get(1).toUpperCase() + " " + courses.get(2).toUpperCase() + "</h2>"); %>
        <% out.println("<p style='font-family:verdana;font-size:650%;color: slateblue' class='b'>" + certificates.get(0) + " " + certificates.get(1) + " " + certificates.get(2) + "</h1>"); %>
        <br>
        <br>
        <% out.println("<p style='font-family:courier;font-size:300%;color:black' class='a'>" + courses.get(3).toUpperCase() + " " + courses.get(4).toUpperCase() + "</h2>"); %>
        <% out.println("<p style='font-family:verdana;font-size:650%;color: slateblue' class='b'>" + certificates.get(3) + " " + certificates.get(4) + "</h1>"); %>
        <br>
        <br>
        <% out.println("<p style='font-family:courier;font-size:300%;color:black' class='a'>" + "Grade" + "</h2>"); %>
        <% out.println("<p style='font-family:verdana;font-size:650%;color: slateblue' class='b'>" + grade + "%" + "</h1>"); %>	
		
    </center>
    
</body>
</html>