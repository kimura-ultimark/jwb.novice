package jwb.novice.javaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLDatabase {
	
	
	private String jndiName;
	
	
	public MySQLDatabase(String jndiName) {
		
		this.jndiName = jndiName;
	}
	
	public Connection connect() throws SQLException {
		
		Connection conn = null;
		
		try {
			
			// JNDIからConnectionを取得できる場合はJNDIより取得
			DataSource ds = InitialContext.doLookup("java:comp/env/" + jndiName);
			conn = ds.getConnection();
			
		} catch (NamingException e) {
			
			// JNDIからの取得に失敗した場合はDriverManagerより取得
			String url = "jdbc:mysql://192.168.1.15:3306/javaweb?characterEncoding=UTF-8&serverTimezone=JST&autoReconnect=true&useSSL=false";
			String user = "jwbuser";
			String password = "EqI`Iay6";
			
			conn = DriverManager.getConnection(url, user, password);
		}
		
		return conn;
	}
}