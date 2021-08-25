package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteUser {
	String Name;
	public DeleteUser(String Name)
	{
		this.Name=Name;
	}
	public void deluser() throws ClassNotFoundException
	{
		//String n;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			//System.out.println("Enter the Name of the User to be deleted");
			//Scanner s=new Scanner(System.in);
			//n=s.next();
			//DeleteUser ob=new DeleteUser(n);
			//n=s.next();
			PreparedStatement st=con.prepareStatement("delete from users where Name=?");
			st.setString(1, Name);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
