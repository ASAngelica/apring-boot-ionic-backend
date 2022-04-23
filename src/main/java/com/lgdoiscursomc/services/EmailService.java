package com.lgdoiscursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.lgdoiscursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
