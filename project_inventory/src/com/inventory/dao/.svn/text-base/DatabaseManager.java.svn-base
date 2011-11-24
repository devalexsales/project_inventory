package com.inventory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static final DatabaseManager db = new DatabaseManager();
	private Connection connection;
	public static final String DB_CONN = "jdbc:hsqldb:hsql://localhost/";
	public static final String USERNAME = "SA";
	public static final String PASSWORD = "";

	private DatabaseManager() {
		try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			this.connection = DriverManager.getConnection(DB_CONN, USERNAME,
					PASSWORD);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseManager getInstance() {
		return DatabaseManager.db;
	}

	public Connection getConnection() {
		return connection;
	}

}
