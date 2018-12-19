
package com.dmitriy;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author dmitriy
 */
public class addServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet addServlet</title>");
			out.println(
					"<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>");
			out.println("<link href='./css/app.css' rel='stylesheet'>");
			out.println("</head>");
			out.println("<body>");

			String username1 = request.getParameter("num1");
			String password1 = request.getParameter("num2");
			String firstname1 = request.getParameter("num3");
			String lastname1 = request.getParameter("num4");

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Notes.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();

			try {

				Notes user = new Notes(username1, password1, firstname1, lastname1);

				session.beginTransaction();

				session.save(user);
				user = session.get(Notes.class, 0);

				session.flush();

				session.getTransaction().commit();
				System.out.println("Row added!");

				System.out.println(user);

			} finally {

				session.close();
				factory.close();
			}
			out.println("<div class='container mt-5'>" + "<div class='mb-4'>"
					+ "<a class='' href='./' >Return to the home page</a>"
					+ "<a class='float-right' href='allServlet' >Return to all notes</a>" + "</div>"
					+ "<div class='row'>" + "<div class='col-sm-12'>" + "<div class='card-body p-3'>"
					+ "<h1 class='text-center text-uppercase text-success success'>success!<br><br>New note was added </h1>"
					+ "</div>" + "</div>" + "</div>" + "</div>");

			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
