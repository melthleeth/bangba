package com.bangba.project730.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangba.project730.model.dto.UserDto;
import com.bangba.project730.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "회원가입 실행", response = String.class)
	@PostMapping("/signup")
	@ResponseBody public String createUser(UserDto userDto, Model model) throws Exception {
		if(userService.isDuplicatedEmail(userDto.getEmail()) != 0 || userService.isDuplicatedName(userDto.getUser_name()) != 0) {
			return "FAIL";
		} else {
			try {
				userService.createUser(userDto);
				model.addAttribute("msg", "회원가입 완료");
				return "SUCCESS";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "회원가입중 문제가 발생했습니다.");
				return "FAIL";
			}
		}
	}
	
	@ApiOperation(value = "로그인", response = String.class)
	@PostMapping(value="/login")
	@ResponseBody public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		try {
			UserDto user = userService.login(map);
			if(user != null) {
				session.setAttribute("userinfo", user);
				return "SUCCESS";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호를 확인 후 로그인해 주세요.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
		return "FAIL";
	}
	
	@ApiOperation(value = "로그아웃", response = String.class)
	@GetMapping(value="/logout")
	@ResponseBody public String logout(HttpSession session) {
		session.invalidate();
		return "SUCCESS";
	}
	
	@ApiOperation(value = "이메일 중복 확인 및 인증", response = String.class)
	@PostMapping(value="/mail")
	@ResponseBody public String messageSend(@RequestBody String toAddress, Model model) {
		int result = userService.isDuplicatedEmail(toAddress);
		if(result != 0) { // 이미 이메일이 존재할 때
			model.addAttribute("msg", "증복되는 이메일입니다.");
		} else { // 이메일이 존재하지 않을 때 
			try {
				String code = makeCode();
				String codeMsg = "인증코드는 " + code + " 입니다.";
				userService.sendEmail(toAddress, "방바! 이메일 인증 발송 코드입니다.", codeMsg);
				model.addAttribute("authCode", code);
				model.addAttribute("msg", "인증번호가 발송되었습니다.");
				return "SUCCESS";
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "이메일 인증에 실패했습니다.");
			}
		}
		return "FAIL";
	}
	
	@ApiOperation(value = "닉네임 중복 확인", response = String.class)
	@PostMapping(value="/name")
	@ResponseBody public String confirmName(@RequestBody String user_name, Model model) {
		int result = userService.isDuplicatedName(user_name);
		
		if(result != 0) { //이미 사용중인 닉네임일 경우 
			model.addAttribute("msg","이미 사용중인 닉네임입니다.");
			return "FAIL";
		} else {
			model.addAttribute("msg", "사용가능한 닉네임입니다.");
			return "SUCCESS";
		}
	}	
	
	@ApiOperation(value = "마이페이지 수정 - 먼저 패스워드만 가능", response = String.class)
	@PutMapping(value="/update")
	@ResponseBody public UserDto updateMyPage(UserDto userDto) {
		userService.updateMyPage(userDto);
		return userService.getMyPage(userDto.getPk_user());
	}
	
	@ApiOperation(value = "회원 탈퇴", response = String.class)
	@DeleteMapping(value="/delete")
	@ResponseBody public String deleteMyPage(int pk_user, Model model) {
		userService.deleteMyPage(pk_user);
		return "SUCCESS";
	}
	
	@ApiOperation(value = "비밀번호찾기", response = String.class)
	@PostMapping(value="/findpw")
	@ResponseBody public String findPassword(String toAddress, Model model) {
		int result = userService.isDuplicatedEmail(toAddress);
		if(result == 0) { // 이메일이 존재하지 않을 때 
			model.addAttribute("msg", "회원가입이 되어있지 않은 이메일입니다.");
		} else { // 회원가입된 이메일일 경우
			try {
				String code = makeCode();
				String codeMsg = "인증코드는 " + code + " 입니다.";
				userService.sendEmail(toAddress, "방바! 이메일 인증 발송 코드입니다.", codeMsg);
				model.addAttribute("authCode", code);
				model.addAttribute("msg", "인증번호가 발송되었습니다.");
				return code;
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "이메일 인증에 실패했습니다.");
			}
		}
		return "FAIL";
	}
	
//  인증 코드 생성 
	public String makeCode() {
		String temp = "";
		Random rnd = new Random();
		for(int i = 0; i < 12; i++) {
			int rIndex = rnd.nextInt(3);
			switch(rIndex) {
			case 0:
				temp += ((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				temp += ((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2: 
				temp += ((rnd.nextInt(10)));
				break;
			}
		}
		return temp;
	}
}
