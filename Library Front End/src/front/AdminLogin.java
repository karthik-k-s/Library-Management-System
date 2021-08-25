package front;
import java.io.File;

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

public class AdminLogin extends Application{
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		mystage.setTitle("Admin Authentication");
		Label l1=new Label("Enter Admin Password:");
		PasswordField t=new PasswordField();
		t.setText("Enter Your Password");
		Separator separator = new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		Label l3=new Label("Password Incorrect!");
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		
		
		String pass="Admin123";
		Button b1=new Button("OK");
		b1.setOnAction((ae)->{try {
			String s=t.getText();
			if(s.equals(pass)) {
				AdminModeF ob=new AdminModeF();
				ob.start(mystage);
			}
			else {
				Region p1 = new Region();
				p1.setPrefSize(Double.MAX_VALUE, 0.0);
				rootnode.getChildren().add(p1);
				rootnode.getChildren().add(l3);}
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
