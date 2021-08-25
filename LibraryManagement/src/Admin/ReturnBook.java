package Admin;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ReturnBook {
	String book_n,user_n;
	public ReturnBook(String book_n,String user_n)
	{
		this.book_n=book_n;
		this.user_n=user_n;
	}
	public void returnbook() throws SQLException
	{
		int av;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
		//String un,bn;
		//Scanner s=new Scanner(System.in);
		//System.out.println("Enter the name of the user");
		//un=s.nextLine();
		//System.out.println("Enter the name of the book");
		//bn=s.nextLine();
		//ReturnBook ob= new ReturnBook(bn,un);
			PreparedStatement st=con.prepareStatement("select Available from books where name=?");
			st.setString(1, book_n);
			ResultSet r=st.executeQuery();
			r.beforeFirst();
			r.next();
			av=r.getInt(1);
			System.out.println(av);
		/*if(av==0)
			System.out.println("No copies left!");
		else
		{*/
			av=av+1;
			PreparedStatement stat1=con.prepareStatement("update books set Available=? where name=?");
			stat1.setInt(1, av);
			stat1.setString(2, book_n);
			stat1.executeUpdate();
			
			PreparedStatement stat2=con.prepareStatement("insert into log values(?,?,?,?)");
			stat2.setString(1, user_n);
			stat2.setString(2, book_n);
			//Date d=new Date();
			//System.out.println(d);
			String timestamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			stat2.setString(3, timestamp);
			stat2.setString(4, "R");
			stat2.executeUpdate();
			

			PreparedStatement stat3=con.prepareStatement("delete from "+user_n+" where bookname=?");
			//stat3.setString(1, user_n);
			stat3.setString(1, book_n);
			//stat3.setString(2, timestamp);
			//stat3.setInt(3, 0);
			//stat3.setFloat(4, (float) 0.00);
			stat3.executeUpdate();
			
				con.close();
				
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
