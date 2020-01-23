package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
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
		if (request.getParameter("name").isEmpty() || request.getParameter("password").isEmpty()) {
			out.print("<br><p style=\"color:red;\">" + " You need to type in a username and a password" + "</p><br><br>");
			request.getRequestDispatcher("index.jsp").include(request, response);
			
		}
		else {
			try {
				data dta = new data();
				dta.setName(request.getParameter("name"));
				dta.setPassword(request.getParameter("password"));
				if (dta.check()) {
					HttpSession session = request.getSession();
					session.setAttribute("username", dta.getName());
					for (String x : data.giveList()) {
						if (x.equals(session.getAttribute("username"))){
							session.setAttribute(session.getAttribute("username").toString(), data.giveList().indexOf(x));
							break;
						}
					}
					
					
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
					
				}
				else {
					out.print("<br><p style=\"color:red;\"> Incorrect username or password! </p><br><br>");
					request.getRequestDispatcher("index.jsp").include(request, response);
				}
				
			}
			catch (Exception e) {
				out.print("Error");
			}
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
