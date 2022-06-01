package org.serratec.lojasamazonas.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.lojasamazonas.dto.PedidoEmailDTO;
import org.serratec.lojasamazonas.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String userName;

	@Value("${spring.mail.password}")
	private String password;

	@Value("${spring.mail.host}")
	private String host;

	private final String emailRemetente = "novafriburgo.cdl@gmail.com";

	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();

		enviarEmail.setHost(host);
		enviarEmail.setPort(465);
		enviarEmail.setUsername(userName);
		enviarEmail.setPassword(password);
		enviarEmail.setProtocol("smtp");
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);

		return enviarEmail;
	}

	public void sendMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public void emailCompra(PedidoEmailDTO emailDTO) throws MessagingException, EmailException{
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		
		try {
			helper.setFrom("novafriburgo.cdl@gmail.com");
			helper.setTo("patrick.fischer@aluno.senai.br");
			
			helper.setSubject("Servico Mecânico");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>");
			sBuilder.append("<body>");
			sBuilder.append(    "<div style=\"font-weight: 400; color: blue\">");
			sBuilder.append(       "<center>");
			sBuilder.append(           "<h1>Olá, " + emailDTO.getNomeCliente()  + "</h1>");
			sBuilder.append(       "</center>");
			sBuilder.append(       "<center>");
			sBuilder.append(           "<p style=\"text-align: justify\">Seu pedido de número: " + emailDTO.getCodigoPedido() + " foi finalizado.</p>");                                
			sBuilder.append(           "<p style=\"text-align: justify\">Produto: " + emailDTO.getProdutoComprado() + " se encontra .</p>");                                
			sBuilder.append(           "<p style=\"text-align: justify\">Total: "+ emailDTO.getValorComprado() + ".</p>");
			sBuilder.append(           "<p style=\"text-align: justify\">Quantidade: "+emailDTO.getQuantidadeComprada()+".</p>");                                
			//sBuilder.append(           "<p>Segue o link para os formulários: http://localhost:3000/formularios </p>");
			//sBuilder.append(           "<p>Não deseja mais receber esse tipo de email ? Cl </p><br>");
			//sBuilder.append(       "</center>");
			sBuilder.append(       "<center style=\"opacity: 0.4\">");
			sBuilder.append(          "<img src='http://www.cdlnf.com.br/2017/wp-content/themes/cdl/images/g852.png' alt='logo cdl'>");
			sBuilder.append(       "</center>");
			sBuilder.append(        "<div>");
			sBuilder.append(           "<p>Atenciosamente,</p> <br>");
			sBuilder.append(           "<p><em>Equipe Charlles Rodas</em> <br>");
			sBuilder.append(           "<p><strong>Borracharia</strong><br>");
			sBuilder.append(        "</div>");
			sBuilder.append(        "<center>");
			sBuilder.append("<p>E-mail automático. Caso já tenha respondido este email e enviado o seu formulário favor desconsiderar essa mensagem.</p>");
			sBuilder.append(        "</center>");
			sBuilder.append(    "</div>");
			sBuilder.append(    "</body>");
			sBuilder.append("</html>");
			sBuilder.append("");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
		} catch(Exception e) {
			throw new EmailException("Houver erro ao enviar o email" + e);
			
		}
	}
}
