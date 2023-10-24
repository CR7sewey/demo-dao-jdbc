package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection(){
		if (conn == null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl"); // vai buscar url do props
			conn = DriverManager.getConnection(url,props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		
		}
	}
	
	public static void closeConnection() {
		if (conn != null) { //conection instanciada
			try {
			conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) { //conection instanciada
			try {
			st.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) { //conection instanciada
			try {
			rs.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
