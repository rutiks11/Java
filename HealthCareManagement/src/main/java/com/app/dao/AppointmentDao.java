package com.app.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.entities.Appointment;

public interface AppointmentDao {
	public List<Appointment> viewUpcomingAppointment(int id) throws SQLException;
	public String bookAppointment(int aid, LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid) throws SQLException;
}
