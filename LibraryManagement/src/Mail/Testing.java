package Mail;
import java.util.TimerTask;
import pack.*;
public class Testing extends TimerTask{
	public void run()
	{

                SimpleMail sender = new SimpleMail(ClassConstants.setFrom,ClassConstants.setPassword);

	            try {
			    sender.sendMail("Subject","you have fine pending ",ClassConstants.setFrom,ClassConstants.emailTO);
			}
                   catch (Exception e) {
			     e.printStackTrace();
			}  

				System.out.println("Email Sent Succesfully...");

	        }

}
