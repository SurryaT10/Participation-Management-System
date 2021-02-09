<%-- 
    Document   : Chart
    Created on : 6 Feb, 2021, 9:02:07 AM
    Author     : NIRMALA.B
--%>

<%@page import="signup.Dbprocess"%>
<%@page import="db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
String dataPoints = null;
 
try{
	Connection con = DBConnection.getConnection();
	session = request.getSession();
	ResultSet student = (ResultSet)session.getAttribute("student_set");
	
	Statement statement = con.createStatement();
	String xVal;
    int yVal;
	
    ArrayList<String> courses = new Dbprocess().getCourses();
    
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
		
		xVal = student.getString("reg_num");
		float grade = new Dbprocess().getGrade(total_certificates);
		yVal = (int)grade;
		
		map = new HashMap<Object,Object>(); map.put("label",xVal);map.put("y",yVal);
        list.add(map);
		dataPoints = gsonObj.toJson(list);
		
	}
	con.close();
}
catch(Exception e){
	//out.println("<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
	out.println("Exception-----"+e);
        dataPoints = null;
}
%>
 


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/performance.css">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
        //animationEnabled: true,
	title: {
		text:"Students Performance"
	},
	subtitles: [{
		text: "Grades"
	}],
        //axisX{
        //    interval:5
        //}
	axisY: {
		title: "Percentage",
                includeZero: true
	},
	data: [{
		type: "bar",
		indexLabel: "{y}",
		indexLabelFontColor: "#444",
		indexLabelPlacement: "inside",
                yValueFormatString: "#,##0\"%\"",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 730px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

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