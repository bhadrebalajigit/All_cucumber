package com.qa.utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Send_email {
	
	private static EmailAttachment attachment;
	private static MultiPartEmail email;
	private final static String[] email_id={"bhadrebalaji@gmail.com","sunil.kumar17@tatacommunications.com"};
	
	public static void attachment() 
	{
		
		attachment=new EmailAttachment();
		attachment.setPath(System.getProperty("user.dir")+"//target//cucumber-reports//myntra_Report.html");
		attachment.setDescription("Test_summary_report_Myntra");
		attachment.setName("Test_summary_report_Myntra");
		
	}
	
	public static void send_email() throws Exception
	{
		attachment();
		ExcelHandler.getTestDataInMap("","", "");
		email=new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setAuthentication("bhadrebalaji@gmail.com", "sufi@143");
		email.setSSL(true);
		for(String s:email_id)
		{
			email.addTo(s);
		}
		email.setFrom("bhadrebalaji@gmail.com");
		email.setSubject("Test summary report Myntra");
		email.setMsg("Hi All\n," +
				"Build is triggered for Myntra site.\n" +
				"Please find attached report\n" +
				"Thanks,\n" +
				"Balaji Bhadre");
		email.attach(attachment);
		email.send();
		
		
		
	}

}
