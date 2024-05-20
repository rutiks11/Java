package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppointmentDao;
import com.app.entities.Patient;

/**
 * Servlet implementation class CancelAppointmentServlet
 */
@WebServlet("/cancelappointment")
public class CancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			if (request.getParameter("no") == null)
				System.out.println("Parameter null");
			int num = Integer.parseInt(request.getParameter("no"));
			HttpSession hs = request.getSession();
			AppointmentDao adao = (AppointmentDao) hs.getAttribute("appointment_dao");
			if (adao == null)
				System.out.println("Error in aptdao in " + getClass());
			Patient patient = (Patient) hs.getAttribute("patient");
			if (patient == null)
				System.out.println("Error in aptdao in " + getClass());

			if (adao.cancelAppointment(num, patient.getPid()))
				pw.print("<h3>Appointment Cancelled!!!!!</h3>");
			else
				pw.print("<h3>Enter Correct Appointment Number!!!!!</h3>");

			pw.print(
					"<form action='logout' method='post'><table ><tr><td><input type='submit' value='logout'></td></tr><table></form>");

		} catch (Exception e) {
			throw new ServletException("Error in " + getClass(), e);
		}
	}

}
