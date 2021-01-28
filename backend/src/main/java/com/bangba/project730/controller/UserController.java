package com.bangba.project730.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.tools.JavaFileManager.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bangba.project730.model.dto.User;
import com.bangba.project730.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	private String CODE = "";
	
	@ApiOperation(value = "회원가입 실행", response = String.class)
	@PostMapping("/create")
	public String createUser(User user, Model model) throws Exception {
		try {
			userService.createUser(user);
			model.addAttribute("msg", "회원가입 완료");
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입중 문제가 발생했습니다.");
			return "signup";
		}
	}
	
	@ApiOperation(value = "로그인", response = String.class)
	@PostMapping(value="/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		try {
			User user = userService.login(map);
			if(user != null) {
				session.setAttribute("userinfo", user);
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호를 확인 후 로그인해 주세요.");
			}
			return "test";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "test";
	}
	
	@PostMapping(value="/mail")
	public String messageSend(@RequestBody String toAddress, Model model) {
		Boolean result = userService.isDuplicated(toAddress);
		if(result) { // 이미 이메일이 존재할 때
			model.addAttribute("msg", "증복되는 이메일입니다.");
		} else { // 이메일이 존재하지 않을 때 
			try {
				makeCode();
				String codeMsg = "인증코드는 " + CODE + "입니다.";
				userService.sendEmail(toAddress, "방바! 이메일 인증 발송 코드입니다.", codeMsg);
				model.addAttribute("authCode", CODE);
				model.addAttribute("msg", "인증이 완료되었습니다.");
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "이메일 인증에 실패했습니다.");
			}
		}
		return "mail";
	}
	
//  인증 코드 생성 
	public void makeCode() {
		Random rnd = new Random();
		for(int i = 0; i < 12; i++) {
			int rIndex = rnd.nextInt(3);
			switch(rIndex) {
			case 0:
				CODE += ((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				CODE += ((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2: 
				CODE += ((rnd.nextInt(10)));
				break;
			}
		}
	}
}
