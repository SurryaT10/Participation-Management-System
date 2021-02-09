<%@page import="faculty.Faculty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SKCT</title>
</head>
	<body style="background-image:url('');font-family: 'Montserrat', sans-serif;background-color:whitesmoke;background-repeat:no-repeat;background-size=cover;background-attachment=fixed;height=100vh;width=100vh"> 
		<% 
		session = request.getSession();
		Faculty faculty = (Faculty)session.getAttribute("faculty");
		
		if (faculty == null)
			response.sendRedirect(request.getContextPath() + "/loginfaculty.html");
		%>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jiz<hr>
		<div class="divider">
		</div>o" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="#">SKCT</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" class="home" href="index.html">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="EditProfileFaculty.jsp">Edit Profile</a>
		      </li>
		      <li class="nav-item">
		          <a class="nav-link" href="GetCertificate.jsp">View Certificates</a>
		      </li>
		      <!--<li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Records
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="">Your Certificates</a>
		          <a class="dropdown-item" href="">Add New Certificates</a>
		          <!--<div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="#" onclick="suba()">More</a>
		        </div>t
		      </li>-->
		      <li  class="nav-item">
		      <a class="nav-link" href="notification_for_faculty.html">Send Notifications</a>
		      </li>
		    <li  class="nav-item">
		      <a class="nav-link" href="GetPerformance">Performance</a>
		      </li>
		      <li  class="nav-item">
		      <a class="nav-link" href="contact_faculty.html">Contact</a>
		      </li>
		      
		   
		    </ul>
		    <form action="index.jsp" class="form-inline my-2 my-lg-0">
		      <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log out</button>
		    </form>
		  </div>
		</nav>
		<div style="background-color:grey" class="p-3 mb-2 text-white" class="jumbotron">
		  <h1 class="blog-post-ti"><center><b>HOME</b></center></h1>
		</div>
		    </div>
		  </div>
		</div>
		</div>
		<div class="container">
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="https://www.wallpapertip.com/wmimgs/196-1962160_set-goals-that-scare-you-and-excite-you.jpg" class="d-block w-100" alt="not found">
		      <div class="container">
		     </div> 
		    </div>
		    <div class="carousel-item">
		      <img src="https://quotefancy.com/media/wallpaper/1600x900/124276-Bill-Gates-Quote-We-re-changing-the-world-with-technology.jpg" class="d-block w-100" alt="not found">
		    </div>
		    <div class="carousel-item">
		      <img src="https://storage.googleapis.com/production-ipage-v1-0-1/771/221771/7A8ur1Be/a3354fe33e3041019460eec20b146235" class="d-block w-100" alt="not found">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div></div><hr size=50>
		<div class="container text-black">
		<center><h3>ABOUT</H3><b></CENTER>
		<p><i>about the project and its uses</i></b></p></DIV><hr size=50>
		<p>The Participation Record Management System is a Web application that helps in managing the record of participation of students by the faculty members in an institution in online mode. This application acts in many certain ways like storing the certificates and data about the participation of a student in any event, sending notifications about the events and competitions to the students, and grading the performance of the students by the faculty.</p>
		<hr>
		<div class="divider">
		<footer class="container">
		<p style="font-color:grey"><b>by,SKCT BOOTCAMP Team No.2</p>
		</footer>
		</div>
		<script>
			function suba(){
			alert("Do you want to exit?");
			
			}
		</script>
</body>
</html>