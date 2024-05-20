package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	/*
	 * Creating the Connection with the mysql server Method is public static because
	 * we are accessing from servlet. Accepting three parameters - URL of the
	 * connection , name and Password of the database Getting the connection and
	 * assigning to the local variable
	 */

	public static void openConnection(String DB_URL, String USER_NAME, String PASSWORD) throws SQLException {
		cn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	}

	// Seperation of the creating the instance and returning the creation
	// Returning the connection to caller
	public static Connection getConnection() throws SQLException {
		return cn;
	}

	// Clean method to clean up the resourses
	public static void closeconnection() throws SQLException {
		// Check connection is not null
		if (cn != null) {
			cn.close();
			System.out.println("Connection Closed");
		}
	}
}
