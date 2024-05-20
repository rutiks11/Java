package com.app.dao;

import static com.app.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Doctor;
import com.app.entities.Speciality;
import com.mysql.cj.protocol.Resultset;

public class DoctorDaoImpl implements DoctorDao {

	// Creating the PreparedStatement Reference
	private PreparedStatement ps1;
	// Creating the Connection Reference to get Connection
	private Connection cn;

	public DoctorDaoImpl() throws SQLException {
		// Getting connection from DButils getConnection static method
		cn = getConnection();

		// a new default PreparedStatement object containing thepre-compiled SQL
		// statement
		// cn.preparedStatement Returns default preparedStatement object of precompiled
		// SQL statement
		ps1 = cn.prepareStatement("select * from Doctor");
	}

	@Override
	public List<Doctor> getallDoctorDetails() throws SQLException {
		// Creating the list to store the all Doctor list
		List<Doctor> list = new ArrayList<Doctor>();

		// Try with Resources
		try (ResultSet rs = ps1.executeQuery()) {
			while (rs.next())
				list.add(new Doctor(rs.getInt(1), rs.getString(2), Speciality.valueOf(rs.getString(3))));
		}
		return list;
	}

	public void cleanUp() throws SQLException {
		System.out.println("Inside Doctor's Clean Up");
		if (ps1 != null) {
			ps1.close();
		}
	}

}
