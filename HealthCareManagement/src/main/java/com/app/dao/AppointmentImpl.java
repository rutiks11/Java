package com.app.dao;

import static com.app.utils.DBUtils.getConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Appointment;

public class AppointmentImpl implements AppointmentDao {
	private Connection cn;
	private PreparedStatement ps1, ps2, ps3, ps4;

	public AppointmentImpl() throws SQLException {
		System.out.println("Inside appoint const");
		cn = getConnection();
		if (cn == null)
			System.out.println("Conection null in AppintImpl");
		ps1 = cn.prepareStatement("select * from appointment where pid=?");
		ps2 = cn.prepareStatement("insert into Appointment values(DEFAULT,?,?,?,?,?)");
		ps3 = cn.prepareStatement("select * from Appointment");
		ps4 = cn.prepareStatement("delete from Appointment where aid=? and pid=?");
		System.out.println("Appointment Dao Created");
		System.out.println("below appoint const");
	}

	@Override
	public List<Appointment> viewUpcomingAppointment(int id) throws SQLException {
		// Setting IN param
		ps1.setInt(1, id);
		// Creating the list
		List<Appointment> list = new ArrayList<>();
		System.out.println("In viewappoint");
		// Catch the result in Resultset
		try (ResultSet rs1 = ps1.executeQuery()) {
			while (rs1.next()) {
				System.out.println("Inside while");
				// aid |AppointmentDate | AppointmentTime | TimeSlot | did | pid
				list.add(new Appointment(rs1.getInt(1), rs1.getDate(2).toLocalDate(), rs1.getTime(3).toLocalTime(),
						rs1.getString(4), rs1.getInt(5), rs1.getInt(6)));
			}
		}
		return list;
	}

	public boolean cancelAppointment(int id, int pid) throws SQLException {
		ps4.setInt(1, id);
		ps4.setInt(2, pid);

		int i = ps4.executeUpdate();
		if (i == 1)
			return true;
		else
			return false;

	}

	public boolean bookAppointment(LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid)
			throws SQLException {

		try (ResultSet rs1 = ps3.executeQuery()) {
			List<Appointment> list = new ArrayList<Appointment>();

			if (rs1 == null)
				System.out.println("Result set is Empty " + getClass());

			ps2.setDate(1, java.sql.Date.valueOf(appointmentdate));
			ps2.setTime(2, Time.valueOf(slottime));
			ps2.setString(3, timeSlot);
			ps2.setInt(4, did);
			ps2.setInt(5, pid);

			if (1 == ps2.executeUpdate())
				return true;

			return false;
			// validateInputs(aid, appointmentdate, slottime, timeSlot, did, pid, list);
			// Executing the Update
		}

	}

	public void cleanUp() throws SQLException {
		System.out.println("Inside CleanUp");
		if (ps1 != null)
			ps1.close();
		if (ps2 != null)
			ps2.close();
		if (ps3 != null)
			ps3.close();
		if (ps4 != null)
			ps4.close();

	}
}
