package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.deo.connet;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	
		PrintWriter ps=response.getWriter();
		Connection conn=connet.suceess();
		try {
			
			PreparedStatement ps1=conn.prepareStatement("select * from student");
			ps.write("<html><head><style>html,\r\n"
					+ "body {\r\n"
					+ "  height: 100%;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "body {\r\n"
					+ "  margin: 0;\r\n"
					+ "  background: linear-gradient(45deg, #49a09d, #5f2c82);\r\n"
					+ "  font-family: sans-serif;\r\n"
					+ "  font-weight: 100;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".container {\r\n"
					+ "  position: absolute;\r\n"
					+ "  top: 50%;\r\n"
					+ "  left: 50%;\r\n"
					+ "  transform: translate(-50%, -50%);\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "table {\r\n"
					+ "  width: 800px;\r\n"
					+ "  border-collapse: collapse;\r\n"
					+ "  overflow: hidden;\r\n"
					+ "  box-shadow: 0 0 20px rgba(0,0,0,0.1);\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "th,\r\n"
					+ "td {\r\n"
					+ "  padding: 15px;\r\n"
					+ "  background-color: rgba(255,255,255,0.2);\r\n"
					+ "  color: #fff;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "th {\r\n"
					+ "  text-align: left;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "thead {\r\n"
					+ "  th {\r\n"
					+ "    background-color: #55608f;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "tbody {\r\n"
					+ "  tr {\r\n"
					+ "    &:hover {\r\n"
					+ "      background-color: rgba(255,255,255,0.3);\r\n"
					+ "    }\r\n"
					+ "  }\r\n"
					+ "  td {\r\n"
					+ "    position: relative;\r\n"
					+ "    &:hover {\r\n"
					+ "      &:before {\r\n"
					+ "        content: \"\";\r\n"
					+ "        position: absolute;\r\n"
					+ "        left: 0;\r\n"
					+ "        right: 0;\r\n"
					+ "        top: -9999px;\r\n"
					+ "        bottom: -9999px;\r\n"
					+ "        background-color: rgba(255,255,255,0.2);\r\n"
					+ "        z-index: -1;\r\n"
					+ "      }\r\n"
					+ "    }\r\n"
					+ "  }\r\n"
					+ "}</style></head><body><div class=\"container\">\r\n"
					+ "  <table>\r\n"
					+ "    <thead>\r\n"
					+ "      <tr>\r\n"
					+ "        <th>Id</th>\r\n"
					+ "        <th>Name</th>\r\n"
					+ "        <th>Email_Id</th>\r\n"
					+ "        <th>Password</th>\r\n"
				+ "      </tr>\r\n"
					+ "    </thead>\r\n"
					+ "    <tbody></body></html>");

			ResultSet rs=ps1.executeQuery();
			
			while(rs.next())
			{
				ps.write("<html><body>    <tr>\r\n"
						+ "        <td>"+rs.getInt(1)+"</td>\r\n"
						+ "        <td>"+rs.getString(2)+"</td>\r\n"
						+ "        <td>"+rs.getString(3)+"</td>\r\n"
						+ "        <td>"+rs.getString(4)+"</td>\r\n"
						+ "      </tr><body></html>");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
