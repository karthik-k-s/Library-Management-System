package Admin;
import java.sql.*;
import java.util.*;
public class CheckUser {
	public ResultSet rs;
	//public String a;
	String id;
	public CheckUser(String id)
	{
		this.id=id;
	}
	public int user()
		{	//public String a="";
		int count=0;
		try {
			//User1 ob=new User1();
			String url="jdbc:mysql://localhost:3306/library";
			String uname="root";
			String pas="Karu@1101F";
			int no;
			//Scanner in=new Scanner(System.in);
			//System.out.println("enter the userid");
			//id=in.next();
			//System.out.println("enter the password");
			//String pass=in.next();
			String query="select * from users where Name = ?";
			//System.out.println("enter the username and number");
			//no=in.nextInt();
			//name=in.next();
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection(url,uname,pas);
	        PreparedStatement st=con.prepareStatement(query);
	        st.setString(1,id);
	        rs=st.executeQuery(); 
	        String a="";
	        while(rs.next())
	        {
	        	count++;
	        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if((count==0))
		    return 0;
	        return 1;
		
		}

}
