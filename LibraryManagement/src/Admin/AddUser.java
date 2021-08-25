package Admin;

import java.sql.*;

import java.util.Scanner;

public class AddUser {
	String Name;
	 String email;
	 String USN; long phno;
	/*public static void main(String args[]) throws SQLException
	{
		add();
	}*/
	 public  void add() throws SQLException
	{
String u,n,e;long p;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			/*System.out.println("Enter the USN,Name,Email and Phone Number of the user");
			Scanner s=new Scanner(System.in);
			u=s.next();
			n=s.next();
			e=s.next();
			p=s.nextLong();*/
			//AddUser ob=new AddUser(n,e,p,u);
			PreparedStatement st=con.prepareStatement("insert into users values(?,?,?,?,?)");
			//Statement stat=con.createStatement();
			st.setString(1,USN);
			st.setString(2,Name);
			st.setString(3,email);
			st.setLong(4,phno);
			st.setString(5, "N");
			st.executeUpdate();
			/*ResultSet rs=stat.executeQuery("select* from users");
			while(rs.next())
			{
				System.out.println("USN="+rs.getNString(0)+"  Name="+rs.getNString(1)+"  Email="+rs.getNString(3)+"  Phone Number="+rs.getLong(0));
			}*/
			con.close();
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public AddUser(String Name,String email,long phno,String USN)
	{
		
		this.Name=Name;
		this.email=email;
		this.phno=phno;
		this.USN=USN;
	}
	} 

