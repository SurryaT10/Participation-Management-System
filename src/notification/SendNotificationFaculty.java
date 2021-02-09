/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

/**
 *
 * @author NIRMALA.B
 */
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signup.Dbprocess;
@WebServlet("/SendNotificationFaculty")
public class SendNotificationFaculty extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String year=request.getParameter("year");
        String dept=request.getParameter("dept");
        String section=request.getParameter("section");
        String message=request.getParameter("message");
        Dbprocess ob=new Dbprocess();
        String result=ob.sendmessage(year,dept,section,message);
        out.println("<div style='background-color:grey;color:white;padding:20px;'>");
        out.println("<h1>"+result+"</h1>");
    	out.println("</div>");
        out.println("<a href='HomeFaculty.jsp'>Back</a>");
        out.close();
    }
}
