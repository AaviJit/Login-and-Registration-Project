package backendPackage;
import java.sql.*;
public class ConnectionClass implements DataBaseProperty {
	static Connection con=null;
	public static Connection getConnection()
	{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
