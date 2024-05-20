package com.app.dao;

import java.sql.SQLException;

import com.app.entities.Patient;

public interface PatientDao {
	public Patient signUp(String email,String password)throws SQLException;
}
