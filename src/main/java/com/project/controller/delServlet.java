package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.deo.InsertQuery;

/**
 * Servlet implementation class delServlet
 */
@WebServlet("/delServlet")
public class delServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter ps=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int status=InsertQuery.del(id);
		
		if(status!=0)
		{
			ps.print("<h1><script>alert('data deleted succesfully...');</script></h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ShowServlet");
			rd.include(request, response);
		}
		else
		{
			ps.print("<h1><script>alert('data deleted not succesfully...');</script></h1>");
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
