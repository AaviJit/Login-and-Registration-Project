package backendPackage;
import java.sql.*;

public class StudentDAOClass {
	static Connection con;
	static PreparedStatement ps;
	public void insertStudent(BasicStudentClass obj) {
		try {
			con=ConnectionClass.getConnection();
			ps=con.prepareStatement("insert into loginDB values(?,?,?,?)");
			ps.setString(1, obj.getUserName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getPassword());
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	public void updateStudent(BasicStudentClass obj,String username)
	{
		try {
			
			con=ConnectionClass.getConnection();
			ps=con.prepareStatement("update loginDB set FirstName=?,LastName=?,Password=? where UserName=?");
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getPassword());
			ps.setString(4, username);
			ps.executeUpdate();
			con.close();
			System.out.println(obj.getFirstName()+" "+obj.getLastName()+" "+username+" "+ obj.getPassword());
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	

	public BasicStudentClass getStudent(String username, String password) {
		
		BasicStudentClass basic_student_class_object =new BasicStudentClass();
		try {
			con=ConnectionClass.getConnection();
			ps=con.prepareStatement("select * from loginDB where UserName=? and  Password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				basic_student_class_object.setUserName(rs.getString(1));
				basic_student_class_object.setFirstName(rs.getString(2));
				basic_student_class_object.setLastName(rs.getString(3));
				basic_student_class_object.setPassword(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return basic_student_class_object;
	}
}
