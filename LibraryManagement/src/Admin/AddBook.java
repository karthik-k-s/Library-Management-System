package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBook {
	long isbn;
	int qty;
	String name,pub,author;
	public AddBook(String name,String pub,String author,long isbn,int qty)
	{
		this.name=name;
		this.isbn=isbn;
		this.pub=pub;
		this.author=author;
		this.qty=qty;
	}
	public void add() throws SQLException
	{
		String p,n,a;long i;int q;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
			/*System.out.println("Enter the Name,Publication,Author and ISBN Number and the number of copies of the book");
			Scanner s=new Scanner(System.in);
			n=s.nextLine();
			p=s.nextLine();
			a=s.nextLine();
			i=s.nextLong();
			q=s.nextInt();
			AddBook ob=new AddBook(n,p,a,i,q);*/
			PreparedStatement st=con.prepareStatement("insert into books values(?,?,?,?,?,?)");
			//Statement stat=con.createStatement();
			st.setLong(1,isbn);
			st.setString(2,name);
			st.setString(3,pub);
			st.setString(4,author);
			st.setInt(5, qty);
			st.setInt(6, qty);
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
