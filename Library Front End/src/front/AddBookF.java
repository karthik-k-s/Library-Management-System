package front;
import java.io.File;

import Admin.AddBook;
import Admin.AddUser;
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
public class AddBookF extends Application{
	public static void main(String args[])
	{
		launch(args);
	}
	public void start(Stage mystage) throws Exception {
		mystage.setTitle("Add Book");
		FlowPane rootnode=new FlowPane(20,20);
		rootnode.setAlignment(Pos.CENTER);
		Label l5=new Label("Added successfully");
		
		Label l1=new Label("Name:");
		TextField name=new TextField();
		rootnode.getChildren().add(l1);
		rootnode.getChildren().add(name);
		
		Region p1 = new Region();
		p1.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p1);
		
		Label l4=new Label("ISBN Number:");
		TextField isbn=new TextField();
		rootnode.getChildren().addAll(l4,isbn);

		Region p4 = new Region();
		p4.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p4);
		
		
		Label l2=new Label("Publicaton:");
		TextField pub=new TextField();
		rootnode.getChildren().addAll(l2,pub);

		Region p2 = new Region();
		p2.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p2);
		
		Label l3=new Label("Author:");
		TextField auth=new TextField();
		rootnode.getChildren().addAll(l3,auth);

		Region p3 = new Region();
		p3.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p3);
		
		
		Label l6=new Label("Number of copies:");
		TextField no=new TextField();
		rootnode.getChildren().addAll(l6,no);

		Region p5 = new Region();
		p5.setPrefSize(Double.MAX_VALUE, 0.0);
		rootnode.getChildren().add(p5);
		
		Region p6 = new Region();
		p6.setPrefSize(Double.MAX_VALUE, 0.0);
		//rootnode.getChildren().add(p6);
		
		Button b1=new Button("Add");
		b1.setOnAction((ae)->{try {
			String n=name.getText();
			String p=pub.getText();
			String a=auth.getText();
			long i=Long.parseLong(isbn.getText());
			int c=Integer.parseInt(no.getText());
			/*System.out.println(u);
			System.out.println(n);
			System.out.println(e);
			System.out.println(p);*/
			AddBook ob=new AddBook(n,p,a,i,c);
			ob.add();
			rootnode.getChildren().add(p6);
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
		
		rootnode.getChildren().add(b1);
		rootnode.getChildren().add(b);
		Scene scene=new Scene(rootnode,700,400);
		mystage.setScene(scene);
		mystage.show();

}

}
