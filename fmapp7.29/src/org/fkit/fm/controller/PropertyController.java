package org.fkit.fm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.service.FmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
		
	@RequestMapping(value="/findProperty")
	public ModelAndView findProperty(ModelAndView mv, HttpSession session, Model model, Integer id,String flag,
			MyProperty property){
		property = fmService.findProperty();
		if(flag.equals("1")){
			//进行第二步设置
			model.addAttribute("property", property);
			mv.setViewName("setup/setLookup");
		}else{
			//model.addAttribute("property", property);
			session.setAttribute("property", property);
			mv.setViewName("redirect:/mainForm");
		}
			

		return mv;
	}
	
	@RequestMapping(value="/addProperty")
	public ModelAndView addProperty(ModelAndView mv, HttpSession session,
			MyProperty property, Model model, String mark, Integer id){			
		if(mark.equals("1")){
			//第一步设置
			property = fmService.findProperty();
			if(property.getId() == null){
				fmService.addProperty(property);
				model.addAttribute("property", property);
				//session.setAttribute("property", property);
				mv.setViewName("redirect:/findProperty?flag=1");
			}				
			else{
				session.setAttribute("property_update", property);
				mv.setViewName("redirect:/updatePropertyForm");		
			}	
			
		}else{
			//第二步设置
			List<String> lookup_list = property.getPropertyInfo();
			property = fmService.findProperty();			
			if(lookup_list != null )
				property.setPlookup(fmService.ListToString(lookup_list));
				property.setPlookupArr(fmService.ListToString(lookup_list).split(","));

			System.out.println(id);
			fmService.updateProperty(property);
			session.setAttribute("property", property);
			session.setAttribute("lookup_list", lookup_list);
			mv.setViewName("redirect:/mainForm");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/updateProperty")
	public ModelAndView updateProperty(ModelAndView mv, HttpSession session,
			MyProperty property, Model model, String mark, Integer id){	
			String p1=property.getProperty1();
			fmService.updateProperty(property);
			model.addAttribute("property", property);
			//session.setAttribute("property", property);
			mv.setViewName("redirect:/findProperty?flag=1");
			return mv;
			}	
//	@RequestMapping(value="/addLookup")
//	public ModelAndView addLookup(ModelAndView mv, HttpSession session,
//			MyProperty property, Model model, Integer id){	
//		List<String> lookup_list = property.getPropertyInfo();
//		property.setPlookup(fmService.ListToString(lookup_list));
//		String pl = property.getPlookup();
//		id=property.getId();
//		String p1=property.getProperty1();
//		fmService.updateProperty(id);
//		session.setAttribute("property", property);
//		mv.setViewName("main");
//		return mv;
//	}
}
