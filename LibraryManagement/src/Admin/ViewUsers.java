package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewUsers {
	public static void main(String args[]) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from users");
			System.out.printf("USN\t\tName\tEmail ID\tPhone Number\n");
			while(r.next())
			{
				System.out.printf("%s\t%s\t%s\t%d\n",r.getString(1),r.getString(2),r.getString(3),r.getLong(4));
			}
			con.close();
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
