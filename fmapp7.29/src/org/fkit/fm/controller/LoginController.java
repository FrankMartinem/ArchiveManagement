package org.fkit.fm.controller;

import javax.servlet.http.HttpSession;

import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.User;
import org.fkit.fm.service.FmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
	
	/**
	 * 学生登录
	 * @param mv
	 * @param student
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/studentLogin")
	public ModelAndView StudentLogin(ModelAndView mv,
			Student student, @RequestParam("cardid") String cardid,
			HttpSession session,
			@RequestParam("password") String password){
//		String id = user.getId();
//		String password = user.getId();
		System.out.println("进入logincontroller");
		student=fmService.findStudentByCardid(cardid);
		if(student == null ){
			mv.addObject("message","登录失败，学号或密码错误！");
			mv.setViewName("login/studentLogin");
		}else{
			session.setAttribute("student", student);
			mv.addObject("student", student);
			mv.setViewName("showStuInfo");
		}
		return mv;
	}
	
	
	/**
	 * 管理员登录
	 * @param mv
	 * @param id
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(ModelAndView mv,HttpSession session,
			@RequestParam("id") String id,
			@RequestParam("password") String password){
		User user = fmService.loginUser(id,password);
		if(user == null){
			mv.addObject("message","登录失败，教工号/学号或密码错误！");
			mv.setViewName("loginForm");
		}else{
			session.setAttribute("admin", user);
			//mv.setViewName("redirect:/findProperty?flag=2");
			mv.setViewName("redirect:/findProperty?flag=2");
		}
		return mv;
	}
	
	/**
	 * 转跳学生登录页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/student")
	public ModelAndView isStudentLogin(ModelAndView mv){
		mv.setViewName("login/studentLogin");
		return mv;
	}
	
	/**
	 * 转跳管理员登录页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/admin")
	public ModelAndView isAdminLogin(ModelAndView mv){
		mv.setViewName("login/adminLogin");
		return mv;
	}
	
}
