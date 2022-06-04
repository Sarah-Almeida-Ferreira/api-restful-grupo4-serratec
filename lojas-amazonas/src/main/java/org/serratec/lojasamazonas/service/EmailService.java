package org.serratec.lojasamazonas.service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.lojasamazonas.exception.EmailException;
import org.serratec.lojasamazonas.model.ItemPedidoModel;
import org.serratec.lojasamazonas.model.PedidoModel;
import org.serratec.lojasamazonas.model.ProdutoModel;
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

	private final String emailRemetente = "lojas.amazonas@yahoo.com";

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

	public void emailCompra(PedidoModel pedido) throws MessagingException, EmailException{
		List<ItemPedidoModel> itemModel = pedido.getItensPedido();
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String email = pedido
				.getCliente()
				.getEmail();
		
		DecimalFormat formato = new DecimalFormat("#.00"); 		
		
		try {
			helper.setFrom(userName);
			helper.setTo(email);
			
			helper.setSubject("Lojas Amazonas");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>");
			sBuilder.append("<body>");
			sBuilder.append("<div style=\"font-weight: 400; color: blue\">");
			sBuilder.append("<center>");
			sBuilder.append("<h1>Olá, " + pedido.getCliente().getNomeCompleto()  + "</h1>");
			sBuilder.append("</center>");
			sBuilder.append("<center>");
			sBuilder.append("<p style=\"text-align: justify\">Seu pedido de número: " + pedido.getCodigoPedido() + " foi finalizado.</p>");                                
			for (ItemPedidoModel itemPedidoModel : itemModel) {
				String valor = formato.format(itemPedidoModel.getValorTotalItem());
			sBuilder.append("<p style=\"text-align: justify\">Produto: " + itemPedidoModel.getProduto().getNomeProduto() + ".</p>");                                
			sBuilder.append("<p style=\"text-align: justify\">Valor Unitário: " + itemPedidoModel.getProduto().getValorUnitario() + ".</p>");
			sBuilder.append("<p style=\"text-align: justify\">Quantidade: "+ itemPedidoModel.getQuantidade()+".</p>");  
			sBuilder.append("<p style=\"text-align: justify\">Total: "+ valor + ".</p>");
			}                              
			sBuilder.append("<center style=\"opacity: 0.4\">");
			sBuilder.append("</center>");
			sBuilder.append("<div>");
			sBuilder.append("<p>Atenciosamente,</p> <br>");
			sBuilder.append("<p><em>Lojas Amazonas</em> <br>");
			sBuilder.append("<p><strong>Produtos Quase Oficiais mais Smarts que você!</strong><br>");
			sBuilder.append("</div>");
			sBuilder.append("<center>");
			sBuilder.append("<p>E-mail automático. Caso já tenha respondido este email e enviado o seu formulário favor desconsiderar essa mensagem.</p>");
			sBuilder.append("</center>");
			sBuilder.append("</div>");
			sBuilder.append("</body>");
			sBuilder.append("</html>");
			sBuilder.append("");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
		} catch(Exception e) {
			throw new EmailException("Houver erro ao enviar o email" + e);
			
		}
	}
	
	public void emailEstoqueBaixo(List<ProdutoModel> listaEstoqueBaixo) throws MessagingException, EmailException {
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		try {
			helper.setFrom(userName);
			helper.setTo("lojas.amazonas@yahoo.com");
			
			helper.setSubject("Estoque Baixo");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>");
			sBuilder.append("<body>");
			sBuilder.append("<div style=\"font-weight: 400; color: blue\">");
			sBuilder.append("<center>");
			sBuilder.append("<h1>Alerta de Estoque Baixo</h1>");
			sBuilder.append("</center>");
			sBuilder.append("<center>");                              
			for (ProdutoModel produto : listaEstoqueBaixo) {
			sBuilder.append("<p style=\"text-align: justify\">Produto: " + produto.getNomeProduto() + ".</p>");
			sBuilder.append("<p style=\"text-align: justify\">Quantidade: "+ produto.getQuantidadeEstoque()+".</p>");
			}                              
			sBuilder.append("<center style=\"opacity: 0.4\">");
			sBuilder.append("</center>");
			sBuilder.append("<div>");
			sBuilder.append("<p>Atenciosamente,</p> <br>");
			sBuilder.append("<p><em>Lojas Amazonas</em> <br>");
			sBuilder.append("<p><strong>Produtos Quase Oficiais mais Smarts que você!</strong><br>");
			sBuilder.append("</div>");
			sBuilder.append("<center>");
			sBuilder.append("<p>E-mail automático. Caso já tenha respondido este email e enviado o seu formulário favor desconsiderar essa mensagem.</p>");
			sBuilder.append("</center>");
			sBuilder.append("</div>");
			sBuilder.append("</body>");
			sBuilder.append("</html>");
			sBuilder.append("");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
		} catch(Exception e) {
			throw new EmailException("Houver erro ao enviar o email" + e);
			
		}
	}
}
