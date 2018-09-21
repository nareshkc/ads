package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	private static Properties TestProperties = null;
	private static FileInputStream fisTestConfig = null;

	public static void main(String[] arg) {
		sendEmail("Test Email","Allure Report");
	}
	public static void sendEmail(String subject, String message) {

		TestProperties = new Properties();
		try {
			fisTestConfig = new FileInputStream("./TestConfig.properties");

			TestProperties.load(fisTestConfig);

			String host = TestProperties.getProperty("host").trim();
			String port = TestProperties.getProperty("port").trim();
			final String mailFrom = TestProperties.getProperty("mailFrom")
					.trim();
			final String password = TestProperties.getProperty("password")
					.trim();

			String[] to = TestProperties.getProperty("to").trim().split(",");
			String[] cc = {};
			String ccString = TestProperties.getProperty("cc").trim();
			if (ccString.length() > 0) {
				cc = ccString.split(",");
			}

			String[] bcc = {};
			String bccString = TestProperties.getProperty("bcc").trim();
			if (bccString.length() > 0) {
				bcc = bccString.split(",");
			}

			String[] attachFilesPaths = TestProperties
					.getProperty("attachFilesPaths").trim().split(",");
			// sets SMTP server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port);
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.user", mailFrom);
			properties.put("mail.password", password);
			
			

			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailFrom, password);
				}
			};
			Session session = Session.getInstance(properties, auth);

			// creates a new e-mail message
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(mailFrom));
			// InternetAddress[] toAddresses = { new InternetAddress(toAddress)
			// };

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));
			}
			// msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// adds attachments
			if (attachFilesPaths != null && attachFilesPaths.length > 0) {
				for (String filePath : attachFilesPaths) {
					MimeBodyPart attachPart = new MimeBodyPart();

					try {
						attachPart.attachFile(filePath);
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					multipart.addBodyPart(attachPart);
				}
			}

			// sets the multi-part as e-mail's content
			msg.setContent(multipart);

			// sends the e-mail
			Transport.send(msg);
			System.out.println("Email sent successfully ------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}