package org.fkit.fm.controller;

import javax.validation.Valid;

import org.fkit.fm.domain.User;
import org.fkit.fm.service.FmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
	@RequestMapping(value="/register")
	public ModelAndView register(@Valid @ModelAttribute User user,Errors errors,Model model,
			ModelAndView mv){	
		if(errors.hasErrors()){
			mv.setViewName("registerForm");
		}
		//�жϸý̹���/ѧ���Ƿ�ע���
		String id = user.getId();
		User id_db = fmService.findUser(id);
		if(id_db != null){
			mv.addObject("message","ע��ʧ�ܣ��ý̹���/ѧ���Ѿ�ע�����");
			mv.setViewName("registerForm");
		}
		else{
			fmService.addUser(user);
			model.addAttribute("user", user);
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	
}
