package Mail;
import java.io.FileInputStream;
import java.util.Properties;
import pack.*;
public class Email2 {
	public  static void readConfig() throws Exception
	{
		try
		{

		    Properties pro = new Properties();
		    String path = System.getProperty("user.dir")+"/java4s_Props.properties";
		    pro.load(new FileInputStream(path));	   
		    ClassConstants.delay = pro.getProperty("delay");
		    ClassConstants.timetoquery = pro.getProperty("timetoquery");
		    ClassConstants.setFrom = pro.getProperty("setFrom");
		    ClassConstants.setPassword = pro.getProperty("setPassword");
		    ClassConstants.emailTO = pro.getProperty("emailTO");	  		   

		}
		catch(Exception e)
		{
            throw new Exception(e);
		}

	}


}
