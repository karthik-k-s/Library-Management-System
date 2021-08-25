package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewBooks {
	public static void main(String args[]) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from books");
			System.out.printf("ISBN\t\tName\tPublication\tAuthor\t   Quantity\tAvailable\n");
			while(r.next())
			{
				System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\n",r.getLong(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6));
			}
			con.close();
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

