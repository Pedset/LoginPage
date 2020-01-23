package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createAcc
 */
@WebServlet("/createAcc")
public class createAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			if (request.getParameter("newName").isEmpty() || request.getParameter("newPassword1").isEmpty()) {
				out.print("<br><p style=\"color:red;\">You need to type in a username or a password</p><br><br>");
				request.getRequestDispatcher("createAcc.jsp").include(request, response);
			}
			else {
			if (data.giveList().isEmpty()) {
				if (request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))) {
					setAcc(request, response);
					out.print("<br><p style=\"color:green;\">Account created successfully</p><br><br>");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
				else {
					out.print("<br><p style=\"color:red;\">Passwords do not match, try again.</p><br><br>");
					request.getRequestDispatcher("createAcc.jsp").include(request, response);
				}
			}
			else {
				int key = 0;
				for (String x : data.giveList()) {
					if(x.equals(request.getParameter("newName"))) {
						out.print("<br><p style=\"color:red;\">"
								+ "Username already exists</p><br><br>");
						request.getRequestDispatcher("createAcc.jsp").include(request, response);
						key = 1;
						break;
					}
					}
				if (key==0) {
					if (request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))) {
						setAcc(request, response);
						out.print("<br><p style=\"color:green;\">Account created successfully</p><br><br>");
						request.getRequestDispatcher("index.jsp").include(request, response);
					}
					else {
						out.print("<p style=\"color:green;\">Passwords do not match, try again.</p><br><br>");
						request.getRequestDispatcher("createAcc.jsp").include(request, response);
					}
				}
				
			}}
			
		}
		catch (Exception e) {
			out.print("Error");
		}
		
		
	}
	
	protected void setAcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		data.accCreate(request.getParameter("newName"), request.getParameter("newPassword1"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
