package front;
import java.io.File;

import Admin.CheckUser;
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
public class UserLoginF extends Application {
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		
		Label error=new Label("User does not exist!");
		Label noerror=new Label("User does exist!");
		mystage.setTitle("User Login");
		Label l1=new Label("Enter User Name:");
		TextField t=new TextField();
		//t.setText("Enter Your Password");
		Separator separator = new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		
		
		Button b1=new Button("Login");
		b1.setOnAction((ae)->{try {
			CheckUser ob=new CheckUser(t.getText());
			int c=ob.user();
			if(c==0)
				rootnode.getChildren().add(error);
			else {
				//rootnode.getChildren().add(noerror);
				ModeUser k= new ModeUser(ob.rs);
				k.start(mystage);
			}
				
			/*String s=t.getText();
			if(s.equals(pass))
				System.out.println("Pass");
			else
				System.out.println("Fail");*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}});
		
		
		rootnode.getChildren().addAll(l1,t);
		
		Region p = new Region();
		p.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p);
		
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
		
		rootnode.getChildren().addAll(b1);
		rootnode.getChildren().addAll(b);
		
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();
	}


}
