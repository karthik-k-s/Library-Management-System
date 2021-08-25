package Admin;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
public class FineCalc {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery("select name from users;");
		while(r.next())
		{
			//String query=" select* from "+r+" ";
			PreparedStatement s1=con.prepareStatement("select * from "+r.getString(1)+";");
            //System.out.println(r.getString(1));
			//s1.setString(1, r.getString(1));
			ResultSet t=s1.executeQuery();
			//t.isBeforeFirst();
			//t.next();
			while(t.next()) {
			int extra=t.getInt(3);
			System.out.println(extra);
			 //System.out.println("here");
			//t.isBeforeFirst();
				System.out.println("here");
			Date i=t.getDate(2);
			System.out.println(i);
			//LocalDate date = i.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			//extra=timestamp-i;
			
			
			 LocalDate now = LocalDate.now();
			 //System.out.println();
			   // sixDaysBehind = now.minusDays(6);
			 
			    //Period period = Period.between(now, i);
			 String timestamp1 = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
				Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(timestamp1);
			    long diff = (date1.getTime()-i.getTime())/(1000*60*60*24);
			    System.out.println(diff);
			    PreparedStatement st=con.prepareStatement("update "+r.getString(1)+" set extradays=?;" );
			    //st.setString(1,r.getString(1));
			    st.setInt(1,(int) diff);
			    st.executeUpdate();
			    if(diff>15)
			    {
			    	int f=(int) diff;
			    	PreparedStatement st1=con.prepareStatement("update "+r+" set fine=?" );
			    	st.setFloat(1,diff);
				    st.executeUpdate();
				    PreparedStatement st2=con.prepareStatement("update users set fine=? where Name=r" );
				    st2.executeUpdate();
			    }
			    
		}
	}

}
}