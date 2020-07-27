package com.wylegly.clinic.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = "root_cms";
		String pwd = "root_cms";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/clinic?serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to db: " + jdbcUrl + "\n");
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, pwd);
			
			out.println("\nSuccess");
			con.close();
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
		
		
	}

}
