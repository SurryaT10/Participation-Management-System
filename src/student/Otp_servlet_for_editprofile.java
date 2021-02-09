package student;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.SendMail;
import notification.Otp;

@WebServlet("/Otp_servlet_for_editprofile")
public class Otp_servlet_for_editprofile extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String session_email = "";
        try{
        	HttpSession s=request.getSession();
        	Student student = (Student)s.getAttribute("student");
        	session_email = student.email;
        }
        catch(Exception e)
        {
        	System.out.println("session error"+e);
        }
        String username=request.getParameter("user_name");
        String registernum =request.getParameter("regno");
        String year =request.getParameter("year");
        String dept =request.getParameter("dept");
        String section =request.getParameter("section");
        String batchnum = request.getParameter("batch");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("re_password");
        
        if (!password.equals(confirm_password)) {
        	out.println("<div style='background-color:grey;color:white;padding:20px;'>");
        	out.println("<h2>Passwords do not match ! </h2>");
        	out.println("</div>");
        	
        	return;
        }
        
        Otp o = new Otp();
        String otp = o.otp;
        
        Thread t = new Thread(new SendMail(session_email, "Your otp is : " + otp));
        t.start();
        
        
        HttpSession s = request.getSession();
        Student student = new Student(registernum, username, Integer.parseInt(year), dept, section, Integer.parseInt(batchnum), session_email, password);
        
        s.setAttribute("student", student);
        s.setAttribute("otp", otp);
        
        response.sendRedirect("otp_for_editprofile.html"); 
	}

}
