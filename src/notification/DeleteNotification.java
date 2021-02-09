package notification;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;

@WebServlet("/DeleteNotification")
public class DeleteNotification extends HttpServlet {
	Connection con;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		ArrayList<String> notifications = (ArrayList<String>)session.getAttribute("notifications");
		
		if (notifications == null)
			response.sendRedirect(request.getContextPath() + "/GetNotifications");

		int i=0;
		for (;i<notifications.size();i++) {
			String notif = notifications.get(i);
			
			if(notif.equals(message))
				break;
		}
		
		if (i<notifications.size())
			notifications.remove(i);
		
		session.setAttribute("notifications", notifications);
		response.sendRedirect(request.getContextPath() + "/ViewNotification");
	}

}
