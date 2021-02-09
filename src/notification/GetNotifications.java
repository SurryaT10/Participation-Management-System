package notification;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signup.Dbprocess;
import student.Student;

@WebServlet("/GetNotifications")
public class GetNotifications extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        if (student == null)
      	  response.sendRedirect(request.getContextPath() + "/loginstudent.html");
		
		int year = student.year;
        String dept = student.dept;
        String section = student.section;
        
		ArrayList<String> notifications = new Dbprocess().getNotifications(year, dept, section);
		
		session.setAttribute("notifications", notifications);
		
		response.sendRedirect(request.getContextPath() + "/ViewNotification");
	}
}
