<%@page import="faculty.Faculty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./css/edit_profile_faculty.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		session = request.getSession();
		Faculty faculty = (Faculty)session.getAttribute("faculty");
		
		if (faculty == null) {
			response.sendRedirect(request.getContextPath() + "/loginfaculty.html");
			return;
		}
	%>

    <div class="contanier">
        <div class="Edit_profile">
            <h1>Update Profile</h1>
        </div>

            <form id="form" action="Otp_servlet_for_editprofile_faculty">
                <div class="wrapper">
                    <div class="form_comp">
                        <label for="user_name">User Name</label>
                        <% out.println("<input type='text' value='" + faculty.name + "' placeholder='Username' name='user_name' id='username'>"); %>
                        <div class="first_row_icon">
                            <i class="fa fa-check-square"aria-hidden="true" ></i>
                            <i class="fa fa-window-close" aria-hidden="true"></i>
                        </div>
                        
                        <small id="error">error message</small>
                    </div>
    
                    <div class="form_comp">
                        <label for="regno">Register Number</label>
                        <% out.println("<input type='text' value='" + faculty.reg_num + "' placeholder='Register Number' name='regno' id='regnum'>"); %>
                        <div class="first_row_icon">
                            <i class="fa fa-check-square"aria-hidden="true" ></i>
                            <i class="fa fa-window-close" aria-hidden="true"></i>
                        </div>
                        <small>Error Message</small>
                    </div>
                </div>
                
                <div class="wrapper">
                    <div class="form_comp">
                        <label for="year_of_join">Year of Join</label>
                        <select name="year_of_join">
                        	<% 
                        		if (faculty.year == 2008)
                        			out.println("<option value='2008' selected=true>2008</option>");
                        		else
                        			out.println("<option value='2008'>2008</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2009)
                        			out.println("<option value='2009' selected=true>2009</option>");
                        		else
                        			out.println("<option value='2009'>2009</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2010)
                        			out.println("<option value='2010' selected=true>2010</option>");
                        		else
                        			out.println("<option value='2010'>2010</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2011)
                        			out.println("<option value='2011' selected=true>2011</option>");
                        		else
                        			out.println("<option value='2011'>2011</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2012)
                        			out.println("<option value='2012' selected=true>2012</option>");
                        		else
                        			out.println("<option value='2012'>2012</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2013)
                        			out.println("<option value='2013' selected=true>2013</option>");
                        		else
                        			out.println("<option value='2013'>2013</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2014)
                        			out.println("<option value='2014' selected=true>2014</option>");
                        		else
                        			out.println("<option value='2014'>2014</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2015)
                        			out.println("<option value='2015' selected=true>2015</option>");
                        		else
                        			out.println("<option value='2015'>2015</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2016)
                        			out.println("<option value='2016' selected=true>2016</option>");
                        		else
                        			out.println("<option value='2016'>2016</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2017)
                        			out.println("<option value='2017' selected=true>2017</option>");
                        		else
                        			out.println("<option value='2017'>2017</option>");
                        	%>
                        
                        	<% 
                        		if (faculty.year == 2018)
                        			out.println("<option value='2018' selected=true>2018</option>");
                        		else
                        			out.println("<option value='2018'>2018</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2019)
                        			out.println("<option value='2019' selected=true>2019</option>");
                        		else
                        			out.println("<option value='2019'>2019</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2020)
                        			out.println("<option value='2020' selected=true>2020</option>");
                        		else
                        			out.println("<option value='2020'>2020</option>");
                        	%>
                        	<% 
                        		if (faculty.year == 2021)
                        			out.println("<option value='2021' selected=true>2021</option>");
                        		else
                        			out.println("<option value='2021'>2021</option>");
                        	%>
                        </select>
                        <div class="second_row_icon">
                            <i class="fa fa-check-square"aria-hidden="true" ></i>
                            <i class="fa fa-window-close" aria-hidden="true"></i>
                        </div>
                        <br>
                    <small>Error Message</small>
                    </div>
                    
                    <div class="form_comp">
                        <label for="batch">Batch</label>
                        <select name="batch" id="batch">
                        	<% 
                        		if (faculty.batch == 2018)
                        			out.println("<option value='2018' selected=true>2018</option>");
                        		else
                        			out.println("<option value='2018'>2018</option>");
                        	%>
                        	<% 
                        		if (faculty.batch == 2019)
                        			out.println("<option value='2019' selected=true>2019</option>");
                        		else
                        			out.println("<option value='2019'>2019</option>");
                        	%>
                        	<% 
                        		if (faculty.batch == 2020)
                        			out.println("<option value='2020' selected=true>2020</option>");
                        		else
                        			out.println("<option value='2020'>2020</option>");
                        	%>
                        	<% 
                        		if (faculty.batch == 2021)
                        			out.println("<option value='2021' selected=true>2021</option>");
                        		else
                        			out.println("<option value='2021'>2021</option>");
                        	%>

                        </select>
                        <i class="fa fa-check-square"aria-hidden="true"></i>
                        <i class="fa fa-window-close" aria-hidden="true"></i>
                        <br>
                        <small>Error Message</small>
                    </div>
                </div>
                
                <div class="wrapper">
                    <div class="form_comp">
                        <label for="dept" >Department</label>
                        <select name="dept" id="dept">
                            <% 
                        		if (faculty.dept.equals("cse"))
                        			out.println("<option value='cse' selected=true>CSE</option>");
                        		else
                        			out.println("<option value='cse'>CSE</option>");
                        	%>
                        	<% 
                        		if (faculty.dept.equals("mech"))
                        			out.println("<option value='mech' selected=true>MECH</option>");
                        		else
                        			out.println("<option value='mech'>MECH</option>");
                        	%>
                        	<% 
                        		if (faculty.dept.equals("it"))
                        			out.println("<option value='it' selected=true>IT</option>");
                        		else
                        			out.println("<option value='it'>IT</option>");
                        	%>
                        	<% 
                        		if (faculty.dept.equals("ece"))
                        			out.println("<option value='ece' selected=true>ECE</option>");
                        		else
                        			out.println("<option value='ece'>ECE</option>");
                        	%>
                        	<% 
                        		if (faculty.dept.equals("eee"))
                        			out.println("<option value='eee' selected=true>EEE</option>");
                        		else
                        			out.println("<option value='eee'>EEE</option>");
                        	%>
                        	<% 
                        		if (faculty.dept.equals("civil"))
                        			out.println("<option value='civil' selected=true>CIVIL</option>");
                        		else
                        			out.println("<option value='civil'>CIVIL</option>");
                        	%>
                        </select>
                        <i class="fa fa-check-square"aria-hidden="true"></i>
                        <i class="fa fa-window-close" aria-hidden="true"></i>
                        <br>
                        <small>Error Message</small>
                    </div>
                    
    
                    <div class="form_comp">
                        <label for="section">Section</label>
                        <select name="section" id="section">
                            <% 
                        		if (faculty.in_section.equals("a"))
                        			out.println("<option value='a' selected=true>A</option>");
                        		else
                        			out.println("<option value='a'>A</option>");
                        	%>
                        	<% 
                        		if (faculty.in_section.equals("b"))
                        			out.println("<option value='b' selected=true>B</option>");
                        		else
                        			out.println("<option value='b'>B</option>");
                        	%>
                        	<% 
                        		if (faculty.in_section.equals("c"))
                        			out.println("<option value='c' selected=true>C</option>");
                        		else
                        			out.println("<option value='c'>C</option>");
                        	%>
                        </select>
                        <i class="fa fa-check-square"aria-hidden="true"></i>
                        <i class="fa fa-window-close" aria-hidden="true"></i>
                        <br>
                        <small>Error Message</small>
                    </div>
                </div>
                
                <div class="wrapper">
                	<div class="form_comp">
                        <label for="year">Year</label>
                        <select name="year" id="year">
                            <%
                        		if (faculty.in_year == 1)
                        			out.println("<option value='1' selected=true>I Year</option>");
                        		else
                        			out.println("<option value='1'>I Year</option>");
                        	%>
                            <%
                        		if (faculty.in_year == 2)
                        			out.println("<option value='2' selected=true>II Year</option>");
                        		else
                        			out.println("<option value='2'>II Year</option>");
                        	%>
                            <%
                        		if (faculty.in_year == 3)
                        			out.println("<option value='3' selected=true>III Year</option>");
                        		else
                        			out.println("<option value='3'>III Year</option>");
                        	%>
                            <%
                        		if (faculty.in_year == 4)
                        			out.println("<option value='4' selected=true>IV Year</option>");
                        		else
                        			out.println("<option value='4'>IV Year</option>");
                        	%>
                        </select>
                        <div class="second_row_icon">
                            <i class="fa fa-check-square"aria-hidden="true" ></i>
                            <i class="fa fa-window-close" aria-hidden="true"></i>
                        </div>
                        <br>
                    <small>Error Message</small>
                    </div>
                    
                    <div>
                    </div>
                </div>

                <div class="wrapper">
                    <div class="form_comp">
                        <label for="password">Password</label>
                        <input type="password" placeholder="Password" name="password" id="password" required>
                        <i class="fa fa-check-square"aria-hidden="true"></i>
                        <i class="fa fa-window-close" aria-hidden="true"></i>
                        <small>Error Message</small>
                    </div>
    
                    <div  class="form_comp">
                        <label for="re_password">Retype Password</label>
                        <input type="password" placeholder="Retype Password" name="re_password" id="re_password" required>
                        <i class="fa fa-check-square"aria-hidden="true"></i>
                        <i class="fa fa-window-close" aria-hidden="true"></i>
                        <small>Error Message</small>    
                    </div>
                </div>

                <div class="dbu">
                    <input class="button" type="submit" value="Update">
                </div>
                
                
            </form>
    </div>
    <script src="./js/js_for_editprofile.js"></script>
</body>
</html>