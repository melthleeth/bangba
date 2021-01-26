package com.bangba.project730.model.service;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.UserDao;
import com.bangba.project730.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private  UserDao dao;
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void createUser(User user) throws Exception {
		dao.createUser(user);
	}

	@Override
	public User login(Map<String, String> map) throws Exception {
		if(map.get("email") == null || map.get("password") == null) {
			return null;
		}
		return dao.login(map);
	}

	@Override
	public void sendEmail(String toAddress, String subject, String body) {
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		sender.send(message);
	}

	@Override
	public boolean isDuplicated(String toAddress) {
		return dao.isDuplicated(toAddress);
	}
}
