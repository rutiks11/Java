package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppointmentDao;
import com.app.entities.Patient;

/**
 * Servlet implementation class BookAppointmentServlet
 */
@WebServlet("/bookappointment")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		try (PrintWriter pw = resp.getWriter()) {
			int did = Integer.parseInt(req.getParameter("doctor"));
			LocalDate date = LocalDate.parse(req.getParameter("dt"));
			LocalTime time = LocalTime.parse(req.getParameter("time"));
			String timeslot = req.getParameter("timeslot");

			HttpSession session = req.getSession();
			AppointmentDao adao = (AppointmentDao) session.getAttribute("appointment_dao");
			if (adao == null)
				System.out.println("NULL");
			Patient patient = (Patient) session.getAttribute("patient");
			if (patient == null)
				System.out.println("patient null");
			System.out.println(date + " " + time + " " + timeslot + " " + did + " " + patient.getPid());
			boolean ret = adao.bookAppointment(date, time, timeslot, did, patient.getPid());

			RequestDispatcher rs = req.getRequestDispatcher("upcomingappointment");

			if (ret)
				rs.forward(req, resp);
			else
				pw.print("<h3>Slot is Already Booked,  Please Try Again<h3>");
		} catch (Exception e) {
			throw new ServletException("Error in service " + getClass(), e);
		}
	}

}
