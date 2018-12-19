
package com.dmitriy;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dmitriy
 */

class startThread extends Thread {
	public void run() {
		System.out.println("1 test is good");
	}
}

class startRunnable implements Runnable {
	public void run() {
		System.out.println("2 test is good");
	}
}

public class allServlet extends HttpServlet {

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

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet addServlet</title>");
			out.println(
					"<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>");
			out.println("<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>");
			out.println("<link href='./css/app.css' rel='stylesheet'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
			out.println("<script src='./js/app.js'></script>");

			out.println(
					"<div class='container mt-5'>" + "<div class='mb-4'>" + "<a href='./' >Return to the home page</a>"
							+ "</div>" + "<div class='row'>" + "<div class='col-sm-12'>");

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Notes.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();

			try {

				session.beginTransaction();

				List<Notes> users = session.createQuery("from users").getResultList();

				for (Notes temp : users) {
					out.println("<div class='card p-3'>" + "<div class='row'>"
							+ "<div class='col-sm-2 text-uppercase'>Username:</div>" + "<div class='col-sm-10'>"
							+ temp.username + "</div>" + "</div>" + "<div class='row'>"
							+ "<div class='col-sm-2 text-uppercase'>Note:</div>" + "<div class='col-sm-10'>" + temp.note
							+ "</div>" + "</div>" + "<div class='row'>"
							+ "<div class='col-sm-2 text-uppercase'>First Name:</div>" + "<div class='col-sm-10'>"
							+ temp.firstName + "</div>" + "</div>" + "<div class='row'>"
							+ "<div class='col-sm-2 text-uppercase'>Last NAme:</div>" + "<div class='col-sm-10'>"
							+ temp.lastName + "</div>" + "</div>" + "<div class='row'>"
							+ "<div class='col-sm-2 text-uppercase'>Actions:</div>" + "<div class='col-sm-10'>"
							+ "<span><i class='material-icons text-warning editIcon' title='update'>edit</i></span>"
							+ "<a class='deleteIcon' href='delServlet?del1=" + temp.userId
							+ "'><i class='material-icons text-danger' title='delete'>delete</i></a>" + "</div>"
							+ "</div>" + "<div class='pt-4 displayNone'>" + "<form action='edServlet'>"
							+ "<input type='hidden' name='num0' value='" + temp.userId + "'>"
							+ "<div class='form-group'>" + "<input class='form-control' type='text' name='num1' value='"
							+ temp.username + "' required>" + "</div>" + "<div class='form-group'>"
							+ "<input class='form-control' type='text' name='num2' value='" + temp.note + "' required>"
							+ "</div>" + "<div class='form-group'>"
							+ "<input class='form-control' type='text' name='num3' value='" + temp.firstName
							+ "' required>" + "</div>" + "<div class='form-group'>"
							+ "<input class='form-control' type='text' name='num4' value='" + temp.lastName
							+ "' required>" + "</div>"
							+ "<button class='btn btn-dark float-right'><b>UPDATE NOTE</b></button>" + "</form>"
							+ "</div></div>");

				}

			} finally {
				session.close();
				factory.close();
			}

			out.println("</div>" + "</div>" + "</div>");

			startThread first1 = new startThread();
			first1.start();

			Thread second2 = new Thread(new startRunnable());
			second2.start();

			try {
				Thread.sleep(1000);

				try {
					JSONParser parser = new JSONParser();
					URL appJson = new URL("http://digitalbrightsun.com/cit360/app.json");
					URLConnection yc = appJson.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

					String jsonString = in.readLine();

					JSONObject appJSON = (JSONObject) parser.parse(jsonString);

					System.out.println(appJSON.get("app"));
					System.out.println(appJSON.get("class"));

					out.println("<div class='color-white text-center'><p>" + appJSON.get("app") + " App powered by "
							+ appJSON.get("first_name") + " " + appJSON.get("last_name") + "<br>" + appJSON.get("class")
							+ " (" + appJSON.get("semester") + ")</p></div>");

					in.close();
				} catch (FileNotFoundException | ParseException e) {
					System.out.println(e);
				}

				System.out.println("3 test is good");
			} catch (InterruptedException e) {
				System.out.println("Exception works " + e);
			}

			ExecutorService exe = Executors.newSingleThreadExecutor();
			exe.submit(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("4 test is good" + threadName);
			});

			try {
				System.out.println("step 5 - try to shutdown exe");
				exe.shutdown();
				exe.awaitTermination(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				System.err.println("Can't shutdown");
			} finally {
				if (!exe.isTerminated()) {
					System.err.println("Try again");
				}
				exe.shutdownNow();
				System.out.println("6 test is good");
			}

			out.println("</body>");
			out.println("</html>");
		}

	}

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
	}

	public String authorInfo(String first_name, String last_name) {
		return "Dmitriy Sinitsyn";
	}

}
