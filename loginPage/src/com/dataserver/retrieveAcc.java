package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class retrieveAcc
 */
@WebServlet("/retrieveAcc")
public class retrieveAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public retrieveAcc() {
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
			
			if (data.giveList().isEmpty()) {
				out.print("<br><p style=\"color:red;\">There are no accounts saved! <br>");
				request.getRequestDispatcher("forgotPass.jsp").include(request, response);
			}
			else {
				int key = 0;
				for (String x : data.giveList()) {
					if (x.equals(request.getParameter("getUserName"))) {
						key= 1;
						out.print("<p>" + "username: " + x + "</p><br>");
						ArrayList<String> pwList = data.givePw();
						out.print("<p>" + "password: " + pwList.get(data.giveList().indexOf(x)) + "</p><br>");
						out.print("<form action=\"index.jsp\" method=\"post\">\r\n" +  
								"<input type=\"submit\" value=\"Back\"></form>");
					}
					
				}
				if (key == 0 ) {
					out.print("<br><p style=\"color:red;\">There is no account by that username</p> <br>");
					request.getRequestDispatcher("forgotPass.jsp").include(request, response);
				}
			}
		}
		catch (Exception e) {
			out.print("Error");
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
