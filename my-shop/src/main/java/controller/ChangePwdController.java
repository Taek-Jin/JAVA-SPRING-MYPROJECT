package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Login.AuthInfo;
import spring.ChangePasswordService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

	private ChangePasswordService chagePasswordService;
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.chagePasswordService = changePasswordService;
	}
	
	@GetMapping
	public String form(ChangePwdCommand pwdCmd, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(authInfo ==null) {
			return "redirect:/login";
		}
		return "edit/changePwdForm";
	}
	
	@PostMapping
	public String submit(ChangePwdCommand pwdCmd, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			chagePasswordService.changePassword(
					authInfo.getEmail(),
					pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
			return "edit/changedPwd";
		} catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
}
