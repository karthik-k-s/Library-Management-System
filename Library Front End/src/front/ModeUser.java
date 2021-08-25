package front;

import  javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.sql.ResultSet;

import com.sun.javafx.scene.text.TextLine;

import Admin.AddBook;
import Admin.PrintBooks;
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

import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.Text;
public class ModeUser extends Application{
	ResultSet r;
	public ModeUser(ResultSet r)
	{
		this.r=r;
	}
	public ModeUser()
	{
		//this.r=r;
	}
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		
		FlowPane rootnode=new FlowPane(20,20);
		mystage.setTitle("User Mode");
		Label l=new Label("User Details:");
		l.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 15));
		//l.setTextAlignment(TextAlignment.CENTER);
		r.beforeFirst();
		r.next();

		Label l1=new Label("Name:");		
		//l1.setTextAlignment(TextAlignment.LEFT);
        l1.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 15));
        String n=r.getString(2);
      Label t1=new Label(n);
      
      //rootnode.getChildren().addAll(t1);
                                               
       //t1.getText();
		Label l2=new Label("Email:");
		l2.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 15));
		String e=r.getString(3);
		Label t2=new Label(e);
		//l2.setTextAlignment(TextAlignment.LEFT);
		
		Label l3=new Label("USN:");
        l3.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 15));
        String u=r.getString(1);
        Label t3=new Label(u);
		//l3.setTextAlignment(TextAlignment.LEFT);

        Label l4=new Label("Phone Number:");
        l4.setFont(Font.font("",FontWeight.BOLD, FontPosture.REGULAR, 15));
        String p=Long.toString(r.getLong(4));
        Label t4=new Label(p);
		//l4.setTextAlignment(TextAlignment.LEFT);

        Button b1=new Button("View Books");
        rootnode.setAlignment(Pos.CENTER);
		rootnode.getChildren().add(l1);
		rootnode.getChildren().add(t1);
		
		
		Region p1 = new Region();
		p1.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p1);
		
		rootnode.getChildren().addAll(l2,t2);
		
		Region p2 = new Region();
		p2.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p2);
		
		rootnode.getChildren().addAll(l3,t3);
		
		Region p3 = new Region();
		p3.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p3);
		
		rootnode.getChildren().addAll(l4,t4);
		
		Region p4 = new Region();
		p4.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p4);
		
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
		
		b1.setOnAction((ae)->{try {
			PrintBooks ob1=new PrintBooks(n);
			ob1.start(mystage);
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
