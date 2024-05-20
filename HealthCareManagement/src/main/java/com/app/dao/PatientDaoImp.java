package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.app.utils.DBUtils.*;

import com.app.entities.Patient;


public class PatientDaoImp implements PatientDao {
	private Connection cn;
	PreparedStatement ps1;

	public PatientDaoImp() throws SQLException {
		cn = getConnection();
		ps1 = cn.prepareStatement("select * from patient where email=? and password=?;");
	}


	public Patient signUp(String email, String password) throws SQLException {
		ps1.setString(1, email);
		ps1.setString(2, password);
		try (ResultSet rs1 = ps1.executeQuery()) {
			if (rs1.next())
				return new Patient(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
		}
		return null;

	}
	
	public void cleanUp() throws SQLException
	{
		System.out.println("Inside Patient Cleanup");
		if(ps1!=null)
			ps1.close();
	}
}
