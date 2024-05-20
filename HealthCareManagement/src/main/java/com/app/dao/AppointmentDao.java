package com.app.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.entities.Appointment;

public interface AppointmentDao {
	public List<Appointment> viewUpcomingAppointment(int id) throws SQLException;

	public boolean bookAppointment(LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid)
			throws SQLException;

	public boolean cancelAppointment(int id, int pid) throws SQLException;
}
