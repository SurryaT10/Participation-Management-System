/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author NIRMALA.B
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import faculty.Faculty;
import signup.Dbprocess;

@WebServlet("/Loginvalidationfaculty")
public class Loginvalidationfaculty extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email=request.getParameter("email");
        String password=request.getParameter("password");

        Dbprocess ob=new Dbprocess();

        Faculty faculty=ob.loginvalidationfaculty(email, password);
        
        // store faculty in session
        HttpSession session = request.getSession();
        if (faculty != null) {
        	session.setAttribute("faculty", faculty);
        	response.sendRedirect(request.getContextPath() + "/HomeFaculty.jsp");
        } 
        else {
        	out.println("<div style='background-color:grey;color:white;padding:20px;'>");
        	out.println("<h2>Sorry - Login failed!</h2>");
        	out.println("</div>");
        	return;
        }
    }
}
