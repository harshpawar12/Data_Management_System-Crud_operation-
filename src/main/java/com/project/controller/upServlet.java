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
 * Servlet implementation class upServlet
 */
@WebServlet("/upServlet")
public class upServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter ps=response.getWriter();
		int s=Integer.parseInt(request.getParameter("id"));
		student ob=InsertQuery.up(s);
		
			ps.write("<h1>data updation</h1>");
		ps.write("<form action='editServlet' method=post>");
		ps.write("<input type='hidden' name=id value="+ob.getId()+"><br><br>");
		ps.write("Name:<input type='text' name=name value="+ob.getName()+"><br><br>");
		ps.write("E_mail:<input type='email' name=email value="+ob.getEmail()+"><br><br>");
		ps.write("Pass:<input type='text' name=password value="+ob.getPassword()+"><br><br>");
		ps.write("<button type='submit'>update</button>");

		
		ps.write("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
