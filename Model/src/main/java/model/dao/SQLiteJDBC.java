package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBC {
	private static final String DATABASE_PATH = "pyjchat.db";

	private static SQLiteJDBC instance = null;

	private Connection connection = null;

	private SQLiteJDBC() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_PATH);
			this.connection.setAutoCommit(false);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Opened database successfully");
	}

	public static SQLiteJDBC getInstance() {
		return (instance == null) ? instance = new SQLiteJDBC() : instance;
	}
}
