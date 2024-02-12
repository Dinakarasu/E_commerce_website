package com.website.buyer.passwordreset.servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.User;
import com.website.buyer.repository.LoginRepository;


/**
 * Servlet implementation class Forgetpassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			RequestDispatcher dispatcher = null;
			int otpvalue = 0;
			HttpSession mySession = request.getSession();
			LoginRepository repo= new LoginRepository(JdbcConnection.dbGetconnection());
			User forget = repo.Forgetpassword(email);
			if(forget!=null) {
			if(email!=null || !email.equals("")) {
				// sending otp
				Random rand = new Random();
				otpvalue = rand.nextInt(172320);

				String to = email;// change accordingly
				// Get the session object
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("selvadina17@gmail.com", "dreawkwearyukzld");// Put your email
																										// id and
																										// password here
					}
				});
				// compose message
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(email));// change accordingly
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					message.setSubject("Reset password");
					message.setText("Hi "+email+","+"\n\n We received a request to reset your account password."+" your OTP is: " + otpvalue+"\n\n please don't share otp from others"+"\n\n Regards, \n E Commerce Online Shopping.");
					// send message
					Transport.send(message);
					System.out.println("message sent successfully");
				
			}
				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				dispatcher = request.getRequestDispatcher("otp.jsp");
				request.setAttribute("message","OTP is sent to your email id");
				//request.setAttribute("connection", con);
				mySession.setAttribute("otp",otpvalue); 
				mySession.setAttribute("email",email); 
				dispatcher.forward(request, response);
				//request.setAttribute("status", "success");
			} }else {
				//System.out.println("Enter valid email address!!!!");
				response.sendRedirect("forgetpassword.jsp");
				mySession.setAttribute("failedMsg", "Enter valid email address !!!!");

			}
			
			}catch(Exception e){
				System.out.println("Error!!!!");
			}
			}

}
