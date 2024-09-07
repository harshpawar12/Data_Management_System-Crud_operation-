package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.student;
import com.project.deo.InsertQuery;

/**
 * Servlet implementation class fetchServlet
 */
@WebServlet("/fetchServlet")
public class fetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter ps=response.getWriter();
		
		String s=request.getParameter("name");
		List<student>al=InsertQuery.isfetch(s);
		//System.out.println(al);

		
		
		
		ps.write("<html><body background-color='Yellow'>");
		ps.write("<style>");
		ps.write("table { width: 100%; border-collapse: collapse; margin: 25px 0; font-size: 18px; text-align: left; }");
		ps.write("th, td { padding: 12px; border-bottom: 2px solid #dddddd; }");
		ps.write("th { background-color: #f2f2f2; color: black; }");
		ps.write("tr:hover { background-color: #f5f5f5; }");
		ps.write("</style>");
		ps.write("<h2>Showing the Serch Data</h2>");
		ps.write("<table border='4'>");
		ps.write("<tr>");
		ps.write("<th>ID</th>");
		ps.write("<th>Name</th>");
		ps.write("<th>Email</th>");
		ps.write("<th>Password</th>");
		
		ps.write("</tr>");
		
		for(student e:al)
		{
			ps.write("<tr>");

			ps.write("<td>"+e.getId()+"</td>");
			ps.write("<td>"+e.getName()+"</td>");
			ps.write("<td>"+e.getEmail()+"</td>");
			ps.write("<td>"+e.getPassword()+"</td>");
			ps.write("</tr>");

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
