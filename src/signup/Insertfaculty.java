/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

/**
 *
 * @author NIRMALA.B
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import faculty.Faculty;
import student.Student;

@WebServlet("/Insertfaculty")
public class Insertfaculty extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String regnum=request.getParameter("reg_num");
      String name=request.getParameter("name");
      String year=request.getParameter("year_of_join");
      String dept=request.getParameter("dept").toLowerCase();
      String in_year=request.getParameter("in_year");
      String in_section=request.getParameter("in_section").toLowerCase();
      String batch=request.getParameter("batch_num");
      String email=request.getParameter("email");
      String password=request.getParameter("password");
      
      Validation validation = new Validation();
      if (!validation.isEmailValid(email)) {
    	  out.println("<div style='background-color:grey;color:white;padding:20px;'>");
			out.println("<h2>Email id is not valid !</h2>");
		  out.println("</div>");
		  
		  return;
      }
      
      if (!validation.isPassValid(password)) {
    	  out.println("<div style='background-color:grey;color:white;padding:20px;'>");
			out.println("<h2>Password is not valid !</h2>");
		  out.println("</div>");
		  
		  return;
      }
      
      // store student in session
      Faculty faculty = new Faculty(regnum, name, Integer.parseInt(year), dept, Integer.parseInt(in_year), in_section, Integer.parseInt(batch), email, password);
      HttpSession session = request.getSession();
      session.setAttribute("faculty", faculty);
      
      Dbprocess ob=new Dbprocess();
      String result=ob.insertvaluesfaculty(regnum,name,year,dept,in_year,in_section,batch,email,password);
      
      if (result.equals("success"))
    	  response.sendRedirect(request.getContextPath() + "/HomeFaculty.jsp");
      
      out.println("<h1>"+result+"</h1>");
      out.println("<a href=''>Back</a>");
    }
}
