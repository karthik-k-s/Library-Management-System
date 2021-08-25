package front;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.Text;

public class FirstPage extends Application {

	@Override
	public void start(Stage mystage) throws Exception {
		mystage.setTitle("Library System");
		Label l1=new Label("Welcome to RVCE Library");
		l1.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 45));
		Label l2=new Label("Enter the Mode of Operation");
		l2.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 30));
		Button b1=new Button("Admin");
		Button b2=new Button("User");
		VBox rootnode=new VBox(20);
        rootnode.setAlignment(Pos.CENTER);
		rootnode.getChildren().addAll(l1,l2,b1,b2);
		Scene scene=new Scene(rootnode,700,350);
		mystage.setScene(scene);
		mystage.show();
		AdminLogin ob=new AdminLogin();
		b1.setOnAction((ae)->{try {
			ob.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
		b2.setOnAction((ae)->{try {
			UserLoginF ob1=new UserLoginF();
			ob1.start(mystage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}
	public static void main(String args[])
	{
		launch(args);
	}

}
