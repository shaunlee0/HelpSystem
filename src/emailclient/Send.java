package emailclient;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Send {
    
    private String user = "shaunlee0@googlemail.com";
    private String pass = "havfmtfuanidqypp";
    

    
    Send(String to, String sub, String msg){
        //to store gmail servers
        Properties prop = new Properties();
        
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");//ssl
        prop.put("mail.smtp.auth",true);//authentication
        prop.put("mail.smtp.starttls.enable",true);//
        prop.put("mail.smtp.host", "smtp.gmail.com");//host
        prop.put("mail.smtp.port", "587");//port
        
        
        Session sess = Session.getInstance(prop, new GMailAuthenticator(user, pass));    
        
        
        try{
            
            javax.mail.Message message = new MimeMessage(sess);
            message.setFrom(new InternetAddress("shaunlee0@googlemail.com"));// who the message is from.
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(sub);
            message.setText(msg);
            
            //send method = Transport
            Transport.send(message);
            
            System.out.println("Mail sent");
        }//try
        catch(Exception e){
            System.out.println(e);
        }
}

}//Class
