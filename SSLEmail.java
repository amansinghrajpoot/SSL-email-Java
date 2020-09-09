package extmethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SSLEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 465
	 * 
	 */
	//    :https://www.google.com/settings/security/lesssecureapps
	public static void main(String[] args) throws FileNotFoundException {
		
		Properties cred =new Properties();
		try {
		FileInputStream ip= new FileInputStream("C:\\Users\\Aman Singh Rajpoot\\eclipse-workspace\\extmethod\\src\\extmethod\\creds.properties");
		cred.load(ip);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		final String fromEmail = cred.getProperty("fromemail"); //email address from the properties
		final String password = cred.getProperty("password"); // password from the properties
		final String toEmail = cred.getProperty("toemail"); // recipient from the properties
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		
		
	        //EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

	        //EmailUtil.sendAttachmentEmail(session, toEmail,"Job file", "Please find the attachment");

	}
	


} 
