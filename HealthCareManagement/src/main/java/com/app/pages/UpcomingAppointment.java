package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AppointmentImpl;
import com.app.dao.PatientDaoImp;
import com.app.entities.Appointment;
import com.app.entities.Patient;

/**
 * Servlet implementation class UpcomingAppointment
 */
@WebServlet("/upcomingappointment")
public class UpcomingAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: set content type in the responce header
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			// Getting the session from the WC (request parameter)
			// Returning the existing session
			HttpSession hs = request.getSession();
			System.out.println("Check for session is new"+hs.isNew());
			// Checking the 
			System.out.println("Session ID"+ hs.getId());
			
			AppointmentImpl adao= (AppointmentImpl)hs.getAttribute("appointment_dao");
			if(adao == null)
				System.out.println("NULL adao");
			PatientDaoImp pdao = (PatientDaoImp)hs.getAttribute("patient_dao");
			Patient patient1 = (Patient)hs.getAttribute("patient");
			int id =patient1.getPid();
			pw.print("<h1>Hii " + patient1.getName() +", Yours Upcoming Appointments</h1>");
			List<Appointment> list = adao.viewUpcomingAppointment(id);
			
			pw.print("<table ><tr style='border:2px; solid'><th>Id</th><th>PID</th><th>Email</th><th>Password</th></tr></table>");
			
			for(Appointment a:list)
			{
				pw.print("<h1><table style='border: 2px solid black;'>\r\n"
						+ "    <tr>\r\n"
						+ "        <td>"+ a.getAid() +"</td>\r\n"
						+ "        <td> "+ a.getAppointmentdate() +"</td>\r\n"
						+ "        <td> "+ a.getSlottime() +"</td>\r\n"
						+ "        <td>" + a.getTimeSlot() +"</td>\r\n"
						+ "       <td>" + a.getDid() +"</td>\r\n"
						+ "       <td>" + a.getPid() +"</td>\r\n"
						+ "    </tr>\r\n"
						+ "</table></h1>");
			}
			
			pw.print("<form action='logout' method='post'><table ><tr><td><input type='submit' value='logout'></td></tr><table></form>");
		}
		catch (Exception e) {
			throw new ServletException("Error in "+getClass(),e);
		}
	}

}
