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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter ps=response.getWriter();
		int a=Integer.parseInt(request.getParameter("id1"));
		String name=request.getParameter("name");
		
		
		student s=new student();
		s.setId(a);
		s.setName(name);
		int del=InsertQuery.isdelete(s);
		if(del!=0)
		{
			ps.write("<html><body><script>alert('Data updated Succesfully...!!');window.location.replace('HomePage.html');</script></body></html>");
		}
		else
		{
			ps.write("<html><body><script>alert('Data not updated Succesfully...!!');window.location.replace('HomePage.html');</script></body></html>");
		}
		
	}

}
