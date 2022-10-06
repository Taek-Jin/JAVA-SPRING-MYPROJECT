package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@GetMapping("/register/step2")
		public String handleStep2Get(RegisterRequest regReq) {
		return "register/step2";
	}
	
	@PostMapping("/register/step3")
		public String handleStep3(RegisterRequest regReq, BindingResult errors){
			new RegisterRequestValidator().validate(regReq, errors);
			if(errors.hasErrors()) {
				return "register/step2";
			}
			try {
				memberRegisterService.regist(regReq);
				return "redirect:/";
			}catch(DuplicateMemberException ex) {
				errors.rejectValue("email", "duplicate");
				return "register/step2";
			}
			
	}
	
}
