package front;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Admin.AddUser;
import Admin.DynamicCreation;
import javafx.application.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.Text;
public class AddUserF extends Application{
	int c=0;
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		String url="jdbc:mysql://localhost:3306/library";
		String uname="root";
		String pass="Karu@1101F";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		
		mystage.setTitle("Add User");
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		Label l5=new Label("Added successfully");
		
		Label l1=new Label("USN:");
		TextField usn=new TextField();
		rootnode.getChildren().add(l1);
		rootnode.getChildren().add(usn);
		
		Region p1 = new Region();
		p1.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p1);
		
		Label l2=new Label("Name:");
		TextField name=new TextField();
		rootnode.getChildren().addAll(l2,name);

		Region p2 = new Region();
		p2.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p2);
		
		Label l3=new Label("Email ID:");
		TextField email=new TextField();
		rootnode.getChildren().addAll(l3,email);

		Region p3 = new Region();
		p3.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p3);
		
		Label l4=new Label("Phone Number:");
		TextField ph=new TextField();
		rootnode.getChildren().addAll(l4,ph);

		Region p4 = new Region();
		p4.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p4);
		
		Region p6 = new Region();
		p6.setPrefSize(Double.MAX_VALUE, 0.0);
		
		Button b1=new Button("Add");
		b1.setOnAction((ae)->{try {
			String u=usn.getText();
			String n=name.getText();
			String e=email.getText();
			long p=Long.parseLong(ph.getText());
			String q="select * from users WHERE Name = ?";
			PreparedStatement check=con.prepareStatement(q);
			check.setString(1, n);
			ResultSet r1=check.executeQuery();
			while(r1.next())
			{
				if(r1.getString("USN").equals(u)&& r1.getString("Name").equals(n)&& r1.getString("Email").equals(e)
						&& r1.getLong("phno")==(p))
					c=-1;
			}
			/*System.out.println(u);
			System.out.println(n);
			System.out.println(e);
			System.out.println(p);*/
			if(c!=-1){
				AddUser ob=new AddUser(n,e,p,u);
			ob.add();
			DynamicCreation o=new DynamicCreation(n);
			o.create();
			rootnode.getChildren().add(p6);
			rootnode.getChildren().add(l5);
			}
			else
			{
				Label error=new Label("User already exists!");
				rootnode.getChildren().add(p6);
				rootnode.getChildren().add(error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}});
		File imageFile = new File("C:\\Users\\Karthik k s\\Downloads\\app-1646213_1920.png");
		Image imageDecline = new Image(imageFile.toURI().toString());
		ImageView i=new ImageView(imageDecline);
		Button b=new Button("Back",i);
		i.setFitWidth(20);
		i.setFitHeight(20);
		b.setOnAction((ae)->{try {
			AdminModeF ob=new AdminModeF();
			ob.start(mystage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		
		rootnode.getChildren().add(b1);
		rootnode.getChildren().add(b);
		
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();

}
}
