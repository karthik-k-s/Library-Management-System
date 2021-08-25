package front;

import java.io.File;

import Admin.DeleteUser;
import javafx.application.*;
import javafx.geometry.Insets;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class DeleteUserF extends Application {
	public static void main(String args)
	{
		
		launch(args);
	}
	public void start(Stage mystage) throws Exception
	{
		FlowPane rootnode=new FlowPane(20,20);
	    rootnode.setPadding(new Insets(10));
        rootnode.setAlignment(Pos.CENTER);
		mystage.setTitle("Delete User");
		Label l5=new Label("Deleted Successfully!");
		Label l1=new Label("Name:");
		TextField t=new TextField();
		String n=t.getText();
		// t.setPrefColumnCount(5);

		Button b=new Button("Delete");
		
		b.setOnAction((ae)->{try {
			DeleteUser ob1=new DeleteUser(n);
			ob1.deluser();
			 Region p1=new Region();
		        p1.setPrefSize(Double.MAX_VALUE, 0.0);
		        rootnode.getChildren().add(p1);
			rootnode.getChildren().add(l5);
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		
		File imageFile = new File("C:\\Users\\Karthik k s\\Downloads\\app-1646213_1920.png");
		Image imageDecline = new Image(imageFile.toURI().toString());
		ImageView i=new ImageView(imageDecline);
		Button b1=new Button("Back",i);
		i.setFitWidth(20);
		i.setFitHeight(20);
		
		b1.setOnAction((ae)->{try {
			AdminModeF ob=new AdminModeF();
			ob.start(mystage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		
		
        rootnode.getChildren().addAll(l1,t);
        Region p=new Region();
        p.setPrefSize(Double.MAX_VALUE, 0.0);
        rootnode.getChildren().add(p);
        rootnode.getChildren().add(b);
        rootnode.getChildren().add(b1);
		rootnode.setAlignment(Pos.CENTER);
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		
		mystage.show();
		
		
	}
}