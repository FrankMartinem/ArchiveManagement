package org.fkit.fm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.fkit.fm.domain.Student;
import org.fkit.fm.service.FmService;
import org.fkit.fm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnalysisController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
	
	@RequestMapping("/analysis")  
    public ModelAndView analysis(ModelAndView mv, Student student,HttpServletRequest request,Model model){  
			List<Student> lists = fmService.selectStudent(student);
			List<String> list_gender = new ArrayList<String>();
			List<String> list_clazz = new ArrayList<String>();
			List<String> list_location = new ArrayList<String>();
			HashMap<String,List<String>> map = new HashMap<String,List<String>>();
			for(int i=0;i<lists.size();i++){
				String param1 = lists.get(i).getParam1();
				list_gender.add(param1);//性别
				String param3 = lists.get(i).getParam3();
				list_clazz.add(param3);//班级
				String param5 = lists.get(i).getParam5();
				list_location.add(param5);//档案位置
			}
			map.put("gender",list_gender);
			map.put("clazz",list_clazz);
			map.put("location",list_location);
			return mv;
	}  
}
