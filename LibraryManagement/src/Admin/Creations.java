package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creations {
	public static void main(String args[]) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			Statement stat=con.createStatement();
			stat.executeUpdate("create table if not exists users(USN varchar(10),Name char(15),Email varchar(30),phno bigint(10),fine char(1))");
			stat.executeUpdate("create table if not exists books(isbn bigint(11),name varchar(30),pub varchar(30),author char(20),quantity int(3),Available int(3))");
			stat.executeUpdate("create table if not exists log(user_name char(15),book_name varchar(30),date Date,type char(1))");
			
			con.close();
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	}
