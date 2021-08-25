package front;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import Admin.DelBook;
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
public class DelBookF extends Application{
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Karu@1101F");
		
		Label l3=new Label("Some copies have been issued.Try returning them and then deleting");
		Label l4=new Label("Not Possible!");
		Label l5=new Label("Deleted successfully");
		
		mystage.setTitle("Delete Book");
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		
		Label l1=new Label("Name of the Book:");
		TextField name=new TextField();
		rootnode.getChildren().addAll(l1,name);
		
		Region p1 = new Region();
		p1.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p1);
		
		Label l2=new Label("Number of Copies:");
		TextField no=new TextField();
		rootnode.getChildren().addAll(l2,no);

		Region p2 = new Region();
		p2.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p2);
		
		Button b1=new Button("OK");
		b1.setOnAction((ae)->{try {
			String n=name.getText();
			int p=Integer.parseInt(no.getText());
			DelBook d=new DelBook(n,p);
			if(d.no>d.a && d.no<=d.max)
				rootnode.getChildren().add(l3);
			else if(d.no>d.max)
				rootnode.getChildren().add(l4);
			else {
			d.del();
			rootnode.getChildren().add(l5);
			}
			

		}catch (Exception e) {
			e.printStackTrace();}});
		
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
	/*public void ifcondition(Stage mystage)
	{
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		Label l1=new Label("Some copies have been issued.Try returning them and then deleting");
		rootnode.getChildren().addAll(l1);
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();
	}
	public void elseif(Stage mystage)
	{
		Label l2=new Label("Not Possible!");
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		rootnode.getChildren().addAll(l2);
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();
	}*/
}
