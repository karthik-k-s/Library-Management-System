package Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class DelBook{
	String Name;public int no;
	public int max;
	public int a;
	public DelBook(String Name,int no) throws Exception
	{
		this.Name=Name;
		this.no=no;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
		PreparedStatement stat=con.prepareStatement("select quantity from books where name=?");
		stat.setString(1, Name);
		ResultSet r=stat.executeQuery();
		r.beforeFirst();
		r.next();
		max=r.getInt(1);
		
		PreparedStatement stat3=con.prepareStatement("select Available from books where name=?");
		stat.setString(1, Name);
		ResultSet r1=stat.executeQuery();
		r1.beforeFirst();
		r1.next();
		a=r1.getInt(1);
	}
		public void del() throws ClassNotFoundException
	{
		String n;
		try {
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			/*System.out.println("Enter the Name of the Book to be deleted");
			Scanner s=new Scanner(System.in);
			n=s.next();
			System.out.println("Enter the number of copies to be deleted");
			q=s.nextInt();
			//DelBook ob=new DelBook(n,q);*/
			/*PreparedStatement stat=con.prepareStatement("select quantity from books where name=?");
			stat.setString(1, Name);
			ResultSet r=stat.executeQuery();
			r.beforeFirst();
			r.next();
			max=r.getInt(1);
			
			PreparedStatement stat3=con.prepareStatement("select Available from books where name=?");
			stat.setString(1, Name);
			ResultSet r1=stat.executeQuery();
			r1.beforeFirst();
			r1.next();
			a=r1.getInt(1);*/
			//if(q>a && q<=max) {
				//System.out.println("Some copies have been issued.Try returning them and then deleting");
				/*Label l1=new Label("Some copies have been issued.Try returning them and then deleting");
				rootnode.getChildren().addAll(l1);
			Scene scene=new Scene(rootnode,700,350);
			Stage mystage.setScene(scene);
			mystage.show();*/
				//DelBookF d=new DelBookF();
				//d.ifcondition(mystage);
			//}

			//else if (q>max) {
				//System.out.println("Not Possible");
				/*Label l2=new Label("Not Possible!");
				rootnode.getChildren().addAll(l2);
				Scene scene=new Scene(rootnode,700,350);
				Stage mystage.setScene(scene);
				mystage.show();*/
				//DelBookF d=new DelBookF();
				//d.elseif(mystage);
				//}
			if(no==max)
			{
			PreparedStatement st=con.prepareStatement("delete from books where name=?");
			st.setString(1,Name);
			st.executeUpdate();
			}
			else
			{
				max=max-no;
				PreparedStatement stat1=con.prepareStatement("update books set quantity=? where name=?");
				stat1.setInt(1, max);
				stat1.setString(2, Name);
				stat1.executeUpdate();
				a=a-no;
				PreparedStatement stat2=con.prepareStatement("update books set Available=? where name=?");
				stat2.setInt(1, a);
				stat2.setString(2, Name);
				stat2.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
