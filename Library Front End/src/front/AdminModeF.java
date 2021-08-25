package front;
import java.awt.TextField;
import java.io.File;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
public class AdminModeF extends Application{
	
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception
	{
		mystage.setTitle("Admin Mode");

		//Label l=new Label("Mode:Admin");
		
		Button b1=new Button("Add User");
		Button b2=new Button("Delete User");
		Button b3=new Button("Issue Book");
		Button b4=new Button("Return Book");
		Button b5=new Button("Add Book");
		Button b6=new Button("Delete Book");
		File imageFile = new File("C:\\Users\\Karthik k s\\Downloads\\app-1646213_1920.png");
		Image imageDecline = new Image(imageFile.toURI().toString());
		ImageView i=new ImageView(imageDecline);
		Button b=new Button("Back",i);
		i.setFitWidth(20);
		i.setFitHeight(20);
		
		b.setOnAction((ae)->{try {
			FirstPage ob=new FirstPage();
			ob.start(mystage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}});

		VBox rootnode=new VBox();
        rootnode.setAlignment(Pos.CENTER);
        rootnode.setPadding(new Insets(10));
	    rootnode.setSpacing(20);
		rootnode.getChildren().addAll(b1,b2,b3,b4,b5,b6,b);
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();
		
		DeleteUserF ob1=new DeleteUserF();
		b2.setOnAction((ae)->{try {
			ob1.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		b1.setOnAction((ae)->{try {
			AddUserF ob4=new AddUserF();
			ob4.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		ReturnBookF ob5=new ReturnBookF();
		b4.setOnAction((ae)->{try {
			ob5.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		b5.setOnAction((ae)->{try {
			AddBookF ob2=new AddBookF();
			ob2.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		b6.setOnAction((ae)->{try {
			DelBookF ob3=new DelBookF();
			ob3.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		IssueBookF ob2=new IssueBookF();
		b3.setOnAction((ae)->{try {
			ob2.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		//returnbook ob3=new returnbook();
		/*b4.setOnAction((ae)->{try {
			//ob3.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});*/
		
	}

}
