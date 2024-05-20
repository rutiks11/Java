package com.app.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	// aid | AppointmentDate | AppointmentTime | TimeSlot | did | pid

	private int aid;
	private LocalDate appointmentdate;
	private LocalTime slottime;
	private String TimeSlot;
	private int did;
	private int pid;

	public Appointment(int aid, LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid) {
		super();
		this.aid = aid;
		this.appointmentdate = appointmentdate;
		this.slottime = slottime;
		TimeSlot = timeSlot;
		this.did = did;
		this.pid = pid;
	}

	public Appointment(LocalDate appointmentdate, LocalTime slottime, String timeSlot, int did, int pid) {
		this.appointmentdate = appointmentdate;
		this.slottime = slottime;
		TimeSlot = timeSlot;
		this.did = did;
		this.pid = pid;
	}

	public int getAid() {
		return aid;
	}

	public LocalDate getAppointmentdate() {
		return appointmentdate;
	}

	public LocalTime getSlottime() {
		return slottime;
	}

	public String getTimeSlot() {
		return TimeSlot;
	}

	public int getDid() {
		return did;
	}

	public int getPid() {
		return pid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setAppointmentdate(LocalDate appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public void setSlottime(LocalTime slottime) {
		this.slottime = slottime;
	}

	public void setTimeSlot(String timeSlot) {
		TimeSlot = timeSlot;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", appointmentdate=" + appointmentdate + ", slottime=" + slottime
				+ ", TimeSlot=" + TimeSlot + ", did=" + did + ", pid=" + pid + "]";
	}

}
