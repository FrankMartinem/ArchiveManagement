package org.fkit.fm.controller;

import org.fkit.fm.domain.User;
import org.fkit.fm.service.FmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LC {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
	@RequestMapping(value="/lc")
	
	public ModelAndView login(ModelAndView mv,User user){
		String id = user.getId();
		String password = user.getPassword();
		System.out.println("����logincontroller");
		User user_db = fmService.loginUser(id,password);
		if(user_db == null){
			mv.addObject("message","��¼ʧ�ܣ��̹���/ѧ�Ż��������");
			mv.setViewName("loginForm");
		}else{
			mv.setViewName("classlist");
		}
		return mv;
	}
}
