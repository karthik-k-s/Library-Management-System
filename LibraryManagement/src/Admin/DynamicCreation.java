package Admin;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class DynamicCreation {
	public String b;
	public void create()
	{
	try
	{
		//String b="";
		//String b="";
		String url="jdbc:mysql://localhost:3306/library";
		String uname="root";
		String pass="Karu@1101F";
		//CheckUser ob=new CheckUser();
		//ob.user();
		//getname(a);
		//System.out.println(b);
		String query="create table IF NOT EXISTS "+b+"(bookname varchar(20),idate Date,extradays int(3),fine float(3,2));";
		//String query1="select * from log WHERE username = ?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		//PreparedStatement st=con.prepareStatement(query);
		Statement st=con.createStatement();
		//PreparedStatement st1=con.prepareStatement(query1);
	    //st1.setString(1,b);
	    st.executeUpdate(query);
	    int i=0,j=0;
	    //st1.executeQuery();
	    //ResultSet rs=st1.executeQuery();
	    //String query3="insert into "+b+" values (?,?,?);";
	    /*PreparedStatement st2=con.prepareStatement(query3);
	    while(rs.next())
	    {
	    	String s1=rs.getString(2);
		    Date d1=rs.getDate(3);
		    st2.setString(1,s1);
			st2.setDate(2,d1);
			st2.setDate(3,d1);
			st2.executeUpdate();
	    }*/
	    //String s1=rs.getString(2);
	    //Date d1=rs.getDate(3);
	    //System.out.println(d1);
	    //System.out.println(rs.getString(2));
	    st.close();
		//st1.close();
		//st2.close();
		con.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}
public DynamicCreation(String b)
{
	this.b=b;
}

}
