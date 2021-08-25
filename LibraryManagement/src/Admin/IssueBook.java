package Admin;

import java.sql.Connection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IssueBook {
	String book_n,user_n;
	java.util.Date date;
	java.sql.Date sqldate;
	
	public IssueBook(String book_n,String user_n)
	{
		this.book_n=book_n;
		this.user_n=user_n;
	}
	public void issue() throws SQLException, ParseException
	{
		int av;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
		PreparedStatement st=con.prepareStatement("select Available from books where name=?");
		st.setString(1, book_n);
		ResultSet r=st.executeQuery();
		r.beforeFirst();
		r.next();
		av=r.getInt(1);
		System.out.println(av);
		if(av==0)
			System.out.println("No copies left!");
		else
		{
			av=av-1;
			PreparedStatement stat1=con.prepareStatement("update books set Available = ? where name = ? ");
			stat1.setInt(1, av);
			stat1.setString(2, book_n);
			stat1.executeUpdate();
			
			PreparedStatement stat2=con.prepareStatement("insert into log(user_name,book_name,type) values(?,?,?)");
			stat2.setString(1, user_n);
			stat2.setString(2, book_n);
			//String timestamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			//Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(timestamp1);
			stat2.setString(4, "I");
			stat2.executeUpdate();
			PreparedStatement st1=con.prepareStatement("update log set date=select curdate() where user_name=?");
			st1.setString(1, user_n);
			st1.executeUpdate();
			
			PreparedStatement stat3=con.prepareStatement("insert into "+user_n+"(bookname,extradays,fine) values(?,?,?)");
			//stat3.setString(1, user_n);
			stat3.setString(1, book_n);
			//stat3.setDate(2,(java.sql.Date) date1);
			stat3.setInt(3, 0);
			stat3.setFloat(4, (float) 0.00);
			stat3.executeUpdate();
			
			PreparedStatement st2=con.prepareStatement("update "+user_n+" set idate=select curdate() where bookname=?");
			st1.setString(1, book_n);
			st1.executeUpdate();
		}
				con.close();
				
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

