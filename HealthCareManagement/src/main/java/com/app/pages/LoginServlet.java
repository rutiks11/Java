package com.app.pages;

import static com.app.utils.DBUtils.closeconnection;
import static com.app.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppointmentImpl;
import com.app.dao.PatientDaoImp;
import com.app.entities.Patient;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDaoImp patientDao;
	private AppointmentImpl appointmentDao;

	public LoginServlet() {
		System.out.println("Inside Login def Constructor");
		// Servlet is requesting to WC for getServletConfig
		// For passing params to the DB Connection
		// getServletConfig() -- return the servletConfig Object;
		System.out.println("Config " + getServletConfig());
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// get servlet Config object for this servlet
		ServletConfig config = getServletConfig();
		try {
			openConnection(config.getInitParameter("db_url"), config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			patientDao = new PatientDaoImp();
			appointmentDao =  new AppointmentImpl();
		} catch (Exception e) {
			throw new ServletException("Error in " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			patientDao.cleanUp();
			appointmentDao.cleanUp();
			closeconnection();
		} catch (SQLException e) {
			System.out.println("Error in Destroy" + getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setting the Content Type
		response.setContentType("text/html");
		
		//Getting PrintWriter From the wc
		try(PrintWriter pw=response.getWriter())
		{
			String email= request.getParameter("em");
			String Pass =  request.getParameter("pass");
			
			Patient patient = patientDao.signUp(email, Pass);
			
			if(patient == null)
			{
				pw.print("<h1>Invalid Login, Please <a href='login.html'>Retry</a></h1>");
			}
			else
			{	
				// Login Successfull then we are maintainin the state of the Patiet 
				
				// Login Servlet is requesting a session to maintain state of the user
				HttpSession session = request.getSession();
				// Checking the Session is new or already existing
				System.out.println("Checking session is already created or it is new "+ session.isNew());
				// Get Session ID from session
				System.out.println("Session ID" + session.getId());
				// Adding patient under session scope
				session.setAttribute("patient", patient);
				// Adding the daos under the session scope
				// Store the state of the Patient under the session scope 
				session.setAttribute("patient_dao",patientDao);
				// Storing the state of Appointment Dao under the session scope 
				session.setAttribute("appointment_dao",appointmentDao);
				
				pw.print("<h2>Hello "+ patient.getName() +"</h2>");
				pw.print("<h3><a href='upcomingappointment'>View Upcoming Appointment</h3>");
				pw.print("<h3><a href='Registration.html'>Book Appoinment</h3>");
				
			}
		}
		catch (Exception e) {
			throw new ServletException("Error in service "+ getClass(),e);
		}
	}

}
