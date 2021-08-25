package Mail;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;
import pack.*;
import java.io.OutputStream;
import java.io.FileOutputStream;
public class DBS {
	public static String usr;
	public void callScheduler() throws Exception
	{

		System.out.println("Scheduler Starterd...");
		Email2.readConfig();
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new Testing(), getTimePrecision(ClassConstants.delay), getTimePrecision(ClassConstants.timetoquery));

	}

	public long getTimePrecision(String value) throws Exception
	{
		long  l = 0;
		String val="";
		try
		{
			if(value.endsWith("d") || value.endsWith("D"))
			{
				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 24 * 60 * 60 * 1000;
			}

			else if(value.endsWith("h") || value.endsWith("H"))
			{

			 val  = value.substring(0,value.length()-1);
			 l = Long.parseLong(val) * 60 * 60 * 1000;

			}
			else if(value.endsWith("m") || value.endsWith("M"))
			{
				 val  = value.substring(0,value.length()-1);
				 l = Long.parseLong(val) * 60 * 1000;
			}
			else if(value.endsWith("s") || value.endsWith("S"))
			{

				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 1000;
			}
			else
			{

				l = Long.parseLong(value);
			}

		}
		catch(Exception e)
		{

            throw new Exception(e);
		}

		return l;
	}
	public static void main(String a[]) throws Exception
	{
		DBS dbs = new DBS();
		try
		{
			String url="jdbc:mysql://localhost:3306/library";
			String uname="root";
			String pass="Karu@1101F";
			Properties p=new Properties();
			OutputStream os=new FileOutputStream("java4s_Props.properties");
			//User1 ob=new User1();
			//ob.user();
			//getname(a);
			//System.out.println(b);
			//System.out.println("enter the username");
			//Scanner in=new Scanner(System.in);
			//String b=in.next();
			//String b;
			String query="select * from users";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			p.setProperty("setFrom","karthikks0812@gmail.com");
			p.setProperty("Password" , "karuat1101");
			p.setProperty("timetoquery", "100000000000000000s");
			p.setProperty("delay","2s");
			//usr=rs.getString(1);
			while(rs.next()) {
			if(rs.getString(5).equals("Y"))
		{
				p.setProperty("emailTO",rs.getString(3));
				p.store(os, null);
				dbs.callScheduler();
		}
	}}
		catch(Exception e)
		{
			e.printStackTrace();
		}


}}
