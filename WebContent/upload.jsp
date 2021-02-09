<%@page import="db.DBConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/upload.css">
<title>SKCT</title>
</head>
<body>

	<div class="loginbox">
		<h2>Upload Certificate</h2>
		<form method="post" action="UploadCertificate" enctype="multipart/form-data">
			<input type="file" name="image" />
		    <p>Category : </p>
		    
		    <div class="box">
				<select name='name'>
				<%
					ResultSet rs;
					try {
							Connection con = DBConnection.getConnection();
							Statement st = con.createStatement();
							
							// get certificate categories
							rs = st.executeQuery("Select * from category");
							while(rs.next()) {
								String category = rs.getString(1);
								out.println("<option value='" + category + "'>" + category + "</option>");
							}
					} catch (Exception e) {
						System.out.println(e);
					}
				%>
			
				</select>
			</div>
		    
		    <input type="submit" value="upload">
		 </form>
	</div>
	
</body>
</html>