package utils;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.InternetAddress;

public class EmailSender{

	public static void sendEmail(String toEmail,String verfMsg){
		Properties props = new Properties();

		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");

		Session session = Session.getInstance(props,new EmailAuthenticator());

		Message msg = new MimeMessage(session);

		try{
			msg.setFrom(new InternetAddress("ganeshji22922@gmail.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Hello....");			
			msg.setContent(verfMsg,"text/html");

			Transport.send(msg);
		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
}


class EmailAuthenticator extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("ganeshji22922@gmail.com","Krishna#2992$13");
	}
}


/*
static String str = "<style>"+
	
	"#a1{
		width: 80%;
		margin: 20px auto;
		border: 1px solid #bbb;
	}"+

	"#a2{
		height: 70px;
		background-color: #f37652;
		position: relative;
	}"+

	"#a2a1{
		position: absolute;
		left: 30px;
		top: 10px;
		font-size: 32px;
		font-weight: bold;
		color: white;
		font-family: verdana;
	}"+

	"#a3{
		width: 90%;
		margin: 20px auto;
		font-family: verdana;
	}"+
  "</style>"+
  
  "<div id='a1'>"+
	"<div id='a2'>"+
		"<span id='a2a1'>eShop</span>"+
	"</div>"+
	"<div id='a3'>"+
		"<span>Hello! <a href='http://localhost:8080/eshop'>The Link</a></span>"+
	"</div>"+
  "</div>";
*/