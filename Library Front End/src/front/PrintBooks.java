package front;
import java.io.File;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import front.ModeUser;
//import front.AdminModeF;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class PrintBooks extends Application{
	public String un;
	public PrintBooks(String un)
	{
		this.un=un;
	}
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage)
	{
		 TilePane tilePane = new TilePane(); 
		 //FlowPane rootnode=new FlowPane(20,20);
			//rootnode.setAlignment(Pos.CENTER);
		try
		{
			String url="jdbc:mysql://localhost:3306/library";
			String uname="root";
			String pass="Karu@1101F";
			//User1 ob=new User1();
			//ob.user();
			//getname(a);
			//System.out.println(b);
			//System.out.println("enter the username");
			//Scanner in=new Scanner(System.in);
			//String un=in.next();
			//String b;
			 
		      //gridPane.setMinSize(400, 200);   
		      //gridPane.setPadding(new Insets(10, 10, 10, 10));
			
			File imageFile = new File("C:\\Users\\Karthik k s\\Downloads\\app-1646213_1920.png");
			Image imageDecline = new Image(imageFile.toURI().toString());
			ImageView i=new ImageView(imageDecline);
			Button b=new Button("Back",i);
			i.setFitWidth(20);
			i.setFitHeight(20);
			b.setOnAction((ae)->{try {
				ModeUser ob=new ModeUser();
				ob.start(mystage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}});
			
		      tilePane.setVgap(10); 
		      tilePane.setHgap(10); 
		      tilePane.setPrefColumns(4);
		      //tilePane.setMinSize(700.00,350.00);
		      tilePane.setAlignment(Pos.CENTER);
			
			String query="select * from "+un+";";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			int i1=1,j=0;
			Text text1 = new Text("Book Name");
			Text text2 = new Text("Issue Date"); 
			Text text3 = new Text("No.of days due"); 
			Text text4 = new Text("Fine"); 
			tilePane.add(text1); 
			tilePane.add(text2);
			tilePane.add(text3);
			tilePane.add(text4);
			while(rs.next())
			{	
			/*System.out.println(rs.getString(1));
			System.out.println(rs.getDate(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getFloat(4));*/
				String b1=rs.getString(1);
				Label lb=new Label(b1);
				String d=rs.getString(2);
				Label ld=new Label(d);
				int ex=rs.getInt(3);
				Label lex=new Label(Integer.toString(ex));
				double f=rs.getFloat(4);
				Label lf=new Label(Double.toString(f));
				tilePane.add(lb);
				tilePane.add(ld);
				j++;
				tilePane.add(lex);
				j++;
				tilePane.add(lf);
				i1++;
				j=0;
				
	}
			tilePane.add(b);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Scene scene = new Scene(tilePane,700,350);  
	      
	      //Setting title to the Stage 
	      mystage.setTitle("User Books"); 
	         
	      //Adding scene to the stage 
	      mystage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      mystage.show(); 

}}
