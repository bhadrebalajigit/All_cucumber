import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;




public class my {

	/**
	 * @param args
	 * @throws EmailException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws EmailException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Abc");
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qa//config//config.properties");
		prop.load(file);
		EmailAttachment attachment=new EmailAttachment();
		attachment.setPath("E://Mobile_testing//cucumber_framework//target//cucumber-reports//Amazon_Report.html");
		attachment.setDescription("Report of myntra");
		attachment.setName("Report of myntra");
		
		MultiPartEmail mail=new MultiPartEmail();
		String hostname=prop.getProperty("setHostName");
		mail.setHostName(""+hostname+"");
		String port=prop.getProperty("setSmtpPort");
		int port_number=Integer.parseInt(port);
		mail.setSmtpPort(port_number);
		mail.setAuthentication("bhadrebalaji@gmail.com", "sufi@143");
		mail.setSSL(true);
		
		String[] email={"bhadrebalaji@gmail.com","tupekarsupriya@gmail.com"};
		for(String s: email)
		{
			mail.addTo(""+s+"");
		}
			
		//mail.addTo(""+email+"");
		//mail.addTo(""+prop.getProperty("To")+"");
		mail.setFrom("bhadrebalaji@gmail.com");
		  mail.setSubject("The picture");
		  mail.setMsg("Here is the picture you wanted");
		  mail.attach(attachment);
		  mail.send();
	}

		//Mailer.send_mail();
	//}	
}
