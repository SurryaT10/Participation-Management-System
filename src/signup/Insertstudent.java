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

import student.Student;
@WebServlet("/Insertstudent")
public class Insertstudent extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String regnum=request.getParameter("reg_num");
      String name=request.getParameter("name");
      String year=request.getParameter("year");
      String dept=request.getParameter("dept").toLowerCase();
      String section=request.getParameter("section").toLowerCase();
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
      Student st = new Student(regnum, name, Integer.parseInt(year), dept, section, Integer.parseInt(batch), email, password);
      HttpSession session = request.getSession();
      session.setAttribute("student", st);
      
      Dbprocess ob=new Dbprocess();
      String result=ob.insertvaluesstudent(regnum,name,year,dept,section,batch,email,password);
      
      if (result.equals("success"))
    	  response.sendRedirect(request.getContextPath() + "/HomeStudent.jsp");
      
      out.println("<h1>"+result+"</h1>");
      out.println("<a href=''>Back</a>");
      out.close();
    }
}
