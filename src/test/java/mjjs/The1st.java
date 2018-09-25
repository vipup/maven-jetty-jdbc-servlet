package mjjs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import junit.framework.TestCase;

public class The1st extends TestCase {
	
	public void test1() throws SQLException {
		
		
		Properties props = new Properties();
		props.setProperty("user", "SYSDBA");
		props.setProperty("password", "gesha123");
		props.setProperty("encoding", "UTF8");
		 
		Connection connection = DriverManager.getConnection(
		   "jdbc:firebirdsql://firebirddb_Host//var/lib/firebird/2.5/data/employee.fdb", 
		   props);
		   
		   Statement stm= connection.createStatement();
		        ResultSet res= stm.executeQuery("SELECT * FROM EMPLOYEE");
		        while (res.next()) {
		        	log_debug("EMPLOYEE NAME:"  + res.getString("FIRST_NAME"));
		        }
		
	}

	private void log_debug(String string) {
		System.out.println(string);
		
	}

}
