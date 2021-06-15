package conn;
import java.sql.*;

public class dbconnect {
	private static dbconnect db = new dbconnect();
	private dbconnect() {   }
	public static dbconnect getInstance() {
		return db;
	}
	
	public Connection getConnect(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection ("jdbc:oracle:thin:@//localhost:1521/xe","USER10","USER10");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
