/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ezine
 */
public class MailUtils {
    public static void SendMail(String recepient, String code) throws MessagingException{      
        System.out.println("Preparing to send the message");
        Properties pr = new Properties();
        
  
        pr.put("mail.smtp.auth","true");
        pr.put("mail.smtp.starttls.enable","true");
        pr.put("mail.smtp.host","smtp.gmail.com");
        pr.put("mail.smtp.port","587");
        pr.put("mail.smtp.ssl.trust", "*");
        pr.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        pr.put("mail.smtp.starttls.required", "true");
        pr.put("mail.smtp.ssl.protocols", "TLSv1.2");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        String email = "postuli.tn@gmail.com";
        String pass = "kdkgibsfbagototq";

          Session session  = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(email, pass);
            }
        });
          
          Message msg = prepareMessage(session,email,recepient, code);   
          Transport.send(msg);
          System.out.println("Message envoyé");
          System.out.println(code);
    }

    private static Message prepareMessage(Session session, String email,String recepient, String code) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject("Bienvenue à Postuli.tn ! \n"  );
            msg.setText("Bonjour ! \n" + "Voici votre code :" + code );
               return msg;
                    
                    } catch (MessagingException ex) {
            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    
//       public static String getRandomCode() 
//    {
//        String code = "0123456789"; 
//  
//        StringBuilder s = new StringBuilder(4); 
//  
//        for (int i = 0; i < 4; i++) { 
//            int index = (int)(code.length() * Math.random()); 
//            s.append(code.charAt(index)); 
//        } 
//        return s.toString();  
//    } 
    
//    public static void sendmail2(String recipient, String password) throws MessagingException{
//        Properties pr = new Properties();
//    pr.put("mail.smtp.auth", "true");
//    pr.put("mail.smtp.starttls.enable", "true");
//    pr.put("mail.smtp.host", "smtp.gmail.com");
//    pr.put("mail.smtp.port", "587");
//    
//    String email = "Postulitn@gmail.com";
//    String pass = "postuli";
//    
//    Session session  = Session.getInstance(pr, new javax.mail.Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                
//                return new PasswordAuthentication(email, pass);          
//            }    
//});
//    
//    Message message = prepareMessage2(session,email,recipient,password);
//    Transport.send(message);
//        System.out.println("message envoyé");
//    }
//
//    private static Message prepareMessage2( Session session, String email,String recipient,String password ) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email)) ;
//            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
//            message.setSubject("Nouveau mot de passe");
//            message.setText("Bonjour, votre nouveau mot de passe = "+password );
//      return message;
//        } catch (MessagingException ex) {
//            Logger.getLogger(MailUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    return null; 
//    }    
}
