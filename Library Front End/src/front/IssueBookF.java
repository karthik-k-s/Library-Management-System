package front;
import java.io.File;

import Admin.CheckUser;
import Admin.IssueBook;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.Stage.*;
public class IssueBookF extends Application{
	
	public static void main(String args[])
	{
		launch(args);
		
	}
	public void start(Stage mystage)
	{
		FlowPane rootnode=new FlowPane(20,20);
	    rootnode.setPadding(new Insets(10));
        rootnode.setAlignment(Pos.CENTER);
       
		mystage.setTitle("Issue Book");
		Label l1=new Label("Username:");
		TextField t1=new TextField();
	    Label l2=new Label("Book Name:");
		TextField t2=new TextField();
        Button b1=new Button("Issue");
        Label l5=new Label("Issued Successfully!");
        b1.setOnAction((ae)->{try {
			String un=t1.getText();
			String bn=t2.getText();
			IssueBook i=new IssueBook(bn,un);
			i.issue();
			 Region p1=new Region();
		        p1.setPrefSize(Double.MAX_VALUE, 0.0);
		        rootnode.getChildren().add(p1);
			rootnode.getChildren().add(l5);
			
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
        

        rootnode.getChildren().addAll(l1,t1);
        Region p=new Region();
        p.setPrefSize(Double.MAX_VALUE, 20.0);
        rootnode.getChildren().add(p);
        
        rootnode.getChildren().addAll(l2,t2);
        
        Region p1=new Region();
        p1.setPrefSize(Double.MAX_VALUE, 20.0);
        rootnode.getChildren().add(p1);
        
        rootnode.getChildren().addAll(b1,b);
        rootnode.setPadding(new Insets(10));
        rootnode.setAlignment(Pos.CENTER);
        Scene scene=new Scene(rootnode,700,350);
        mystage.setScene(scene);
        mystage.show();
	}

}
