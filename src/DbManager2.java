import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager2 {
	public static Connection ConnectDatabase() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root","");
			  System.out.println("Connection Established is success");
			return con;
			
		}
		
		catch(ClassNotFoundException e)
		{
		System.out.println("Connection error");	
		return null;
		}
		catch(SQLException e)
		{
		System.out.println("Sql related error");	
		return null;
		}
	}

}
