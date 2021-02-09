package notification;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;
import signup.Dbprocess;
import student.Student;

/**
 * Servlet implementation class ViewNotification
 */
@WebServlet("/ViewNotification")
public class ViewNotification extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {

      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      try{
          HttpSession session = request.getSession();
          ArrayList<String> notifications = (ArrayList<String>)session.getAttribute("notifications");
          
          out.println("<table cellspacing='0' width='100%' border='4'>");
          out.println("<tr  bgcolor='grey'>");
          out.println("<th>Notifcations</th>");
          out.println("<th>Delete</th>");
          out.println("</tr>");
          
          for (int i=0;i<notifications.size();i++){
        	String deleteBtn = "<a href='DeleteNotification?message=" + notifications.get(i) + "'>delete</a>";
        	  
            out.println("<tr>");
            out.println("<td align='center'>"+notifications.get(i)+"</td>");
            out.println("<td>" + deleteBtn + "</td>");
            out.println("</tr>");
          }
          out.println("</table>");
          
          out.println("<a href='HomeStudent.jsp'>Back</a>");
       }
       catch(Exception ex)
       {
          out.println("  "+ex);
       }
    }
}
