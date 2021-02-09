package mail;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Random;

public class SendMail implements Runnable {
	ResultSet rs;
	String message;
	String email;
	public SendMail(ResultSet rs, String message) {
		this.rs = rs;
		this.message = message;
	}
	
	public SendMail(String email, String message) {
		this.email = email;
		this.message = message;
	}
	
	public void run() {
		mail.JavaMail j=new mail.JavaMail();
        if (rs != null) {
        	try {
            	while(rs.next()){
                    String mail=rs.getString(1);
                    if(mail!=null)
                    {
                      j.accept(mail,message);
                    }
                }
            } catch (Exception e) {
            	System.out.println(e);
            }
        } else {
        	if (email != null)
        		j.accept(email, message);
        }
	}

	//public String otp = "";
	//public void send_mail(String emailid){
		
		
//		try{
//
//	        Properties props = new Properties();
//	        props.put("mail.smtp.host", "smtp.mail.yahoo.com"); // for gmail use smtp.gmail.com
//	        props.put("mail.smtp.auth", "true");
//	        props.put("mail.debug", "true"); 
//	        props.put("mail.smtp.starttls.enable", "true");
//	        props.put("mail.smtp.port", "465");
//	        props.put("mail.smtp.socketFactory.port", "465");
//	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//	        props.put("mail.smtp.socketFactory.fallback", "false");
//
//	        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
//
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	                return new PasswordAuthentication("suganth.guna@yahoo.com", "nzhgfojlorakqaca");
//	            }
//	        });
//
//	        mailSession.setDebug(true); // Enable the debug mode
//
//	        Message msg = new MimeMessage( mailSession );
//
//	        //--[ Set the FROM, TO, DATE and SUBJECT fields
//	        msg.setFrom( new InternetAddress( "suganth.guna@yahoo.com" ) );
//	        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(emailid) );
//	        msg.setSentDate( new Date());
//	        msg.setSubject( "OTP" );
//
//	        //--[ Create the body of the mail
//	        msg.setText(otp+" is the OTP for Sign up");
//
//	        //--[ Ask the Transport class to send our mail message
//	        Transport.send( msg );
//
//	    }catch(Exception E){
//	        System.out.println( "Error");
//	        System.out.println( E );
//	    }
	//}
}
