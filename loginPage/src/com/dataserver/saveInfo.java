package com.dataserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class saveInfo
 */
@WebServlet("/saveInfo")
public class saveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")==null || session.getAttribute("username").toString().equals("")) {
			response.sendRedirect("index.jsp");
			
		}
		else {
		try {
		for (String x : data.giveList()) {
			if (x.equals(session.getAttribute("username"))){
				data.saveText(request.getParameter("txt"), data.giveList().indexOf(x));
				session.setAttribute(session.getAttribute("username").toString(), data.giveList().indexOf(x));
				out.print("<br><p style=\"color:green;\">Text saved successfully</p><br><br>");
				
				break;
			}
		}
		request.getRequestDispatcher("welcome.jsp").include(request, response);
		
	}
	
	catch (Exception e) {
		out.print("Error 2");
	}}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
