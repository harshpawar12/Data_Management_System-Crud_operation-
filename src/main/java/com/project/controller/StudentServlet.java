package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.student;
import com.project.deo.InsertQuery;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter ps=response.getWriter();
		int a=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(password);
		
		student s=new student();
		s.setId(a);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		int check=InsertQuery.isquery(s);
		
		if(check!=0)
		{
			ps.write("<html><body><script>alert('Data inserted Succesfully...!!');window.location.replace('HomePage.html');</script></body></html>");
		}
		else
		{
			ps.write("<html><body><script>alert('Data not inserted Succesfully...!!');window.location.replace('HomePage.html');</script></body></html>");
		}
		
				
		
		
		
		
	}
	
}
