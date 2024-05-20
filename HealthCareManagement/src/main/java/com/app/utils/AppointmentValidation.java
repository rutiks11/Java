package com.app.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.entities.Appointment;

public class AppointmentValidation {
	public static Appointment validateInputs(int aid, LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid,List<Appointment> list)
	{
		validatedateandtime(appointmentdate,slottime,timeSlot);
		
		
		return null;
	}
	
	public static void validatedateandtime(LocalDate appointmentdate, LocalTime slottime, String timeSlot)
	{
	
	}
	
}
