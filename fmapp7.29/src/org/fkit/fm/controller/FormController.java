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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController{
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;
	
	@RequestMapping(value="/{formName}")
	 public String reg(@PathVariable String formName,Model model){
		User user = new User();
		model.addAttribute("user",user);
		return formName;
	}
	
	@RequestMapping(value="/addClazz")
	 public String addClass(){
		System.out.println("addClazz");
		return "addClass";
	}
	
	@RequestMapping(value="/addStudentForm")
	 public String addStudentForm(HttpSession session,
			 @RequestParam("clazzname") String clazzname){
		System.out.println("��ȡ���İ༶�����ǣ�"+clazzname);
		session.setAttribute("clazzname", clazzname);
		System.out.println("addStudent");
		return "addStudent";
	}
	
	@RequestMapping(value="/editInfo")
	 public String editInfo(){
		System.out.println("editInfo");
		return "showUndergraduateInfo";
	}
	
	@RequestMapping(value="/addAsLast")
	 public String addAsLast(){
		System.out.println("addAsLast");
//		model.addAttribute("student",student);
//		session.setAttribute("student",student);
		return "addAsLast";
	}
	
	@RequestMapping(value="/insertUinfoForm")
	 public String insertUinfoForm(){
		return "editBlankUinfo";
	}
	
	@RequestMapping(value="/insertPinfoForm")
	 public String insertPinfoForm(){
		return "editBlankPinfo";
	}
	
	@RequestMapping(value="/batchImport")
	 public String batchImport(){
		return "batchImport";
	}
	
	@RequestMapping(value="/selectVisitorForm")
	 public String selectVisitorForm(){
		return "borrow/searchRecord";
	}
	
	//ת������¼��ҳ��
	@RequestMapping(value="/loginForm")
	 public String loginForm(){
		return "loginForm";
	}
	
	//ת������������ҳ��
	@RequestMapping(value="/setProp")
	 public String setProp(){
		return "setup/setProperty";
	}
	
	//ת��������������ҳ��
	@RequestMapping(value="/setLook")
	 public String setLook(){
		return "setup/setLookup";
	}
	
	//ת�����޸�����ҳ��
	@RequestMapping(value="/updatePropertyForm")
	 public String updatePropertyForm(){
		return "setup/showUpdateProperty";
	}
	
	//ת�����������ѧ������ҳ��
	@RequestMapping(value="/autoAddUFileForm")
	public String autoAddUFileForm(Model model, String cardid){
		model.addAttribute("cardid", cardid);
		return "showAutoAddUFile";
	}

	//ת����������ӵ�������ҳ��
	@RequestMapping(value="/autoAddPFileForm")
	public String autoAddPFileForm(Model model, String cardid){
		model.addAttribute("cardid", cardid);
		return "showAutoAddPartyFile";
	}
	
	//ת�����������ѧ��ҳ��
	@RequestMapping(value="/showAutoAddStudent")
	public String showAutoAddStudent(){
		return "showAutoAddStudent";
	}
	
	@RequestMapping(value="/mainForm")
	public String mainForm(){
		return "main";
	}
	
	@RequestMapping(value="/addStudentFromImageForm")
	public String addStudentFromImageForm(HttpSession session){
		MyProperty property = fmService.findProperty();
		session.setAttribute("property", property);
		return "addStudentFromImage";
	}
	
	@RequestMapping(value="/addFileFromImageForm")
	public String addFileFromImageForm(HttpSession session){
		MyProperty property = fmService.findProperty();
		session.setAttribute("property", property);
		return "addFileFromImage";
	}
	
	@RequestMapping(value="/chartsForm")
	public String chartsForm(){
		return "charts";
	}
	


}

