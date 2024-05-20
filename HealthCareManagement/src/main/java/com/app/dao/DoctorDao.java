package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Doctor;

public interface DoctorDao {
	public List<Doctor> getallDoctorDetails() throws SQLException;
	public void cleanUp() throws SQLException;
}
