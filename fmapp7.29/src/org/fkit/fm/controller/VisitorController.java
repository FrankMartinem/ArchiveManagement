package org.fkit.fm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.fm.domain.Back;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.Visitor;
import org.fkit.fm.service.FmService;
import org.fkit.fm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisitorController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;

	/**
	 * ��ӽ�����
	 * 
	 * @param mv
	 * @param vs
	 * @param state
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertVisitor")
	public ModelAndView insertVisitor(ModelAndView mv, Visitor vs,Integer pageIndex,
			String state, String pstate,Integer id, Model model) {
		if(vs.getUnifoType().equals("0")){
			mv.addObject("message","��ѡ�񵵰����ͣ�");
			mv.setViewName("redirect:/loan");
		}
		else{
			fmService.addVisitor(vs);
			model.addAttribute("visitor", vs);
			// System.out.println(state);
			Student student = new Student();
			if(vs.getUnifoType().equals("ѧ������")){
				student.setState(state);
			}
			if(vs.getUnifoType().equals("��������")){
				student.setPstate(pstate);
			}
			student.setId(id);
			fmService.modifyStudent(student);
			//mv.setViewName("borrow/searchStuIfo");
			mv.setViewName("redirect:/selectLoanStudent");
		}
		return mv;	
	}
	
	/**
	 * ��ӹ黹��Ϣ
	 * 
	 */
	@RequestMapping("/addBack")
	public ModelAndView insertBack(ModelAndView mv, Visitor vs, Back back,
			String state, String pstate,Integer id, String sid,Model model) {
		//���ĵ���״̬
		Student student = new Student();
		if(vs.getUnifoType().equals("ѧ������")){
			student.setState(state);
		}
		if(vs.getUnifoType().equals("��������")){
			student.setPstate(pstate);
		}
		student.setId(id);
		fmService.modifyStudent(student);
		//���¹黹ʱ��
		fmService.addBack(back);
		vs.setSid(sid);
		System.out.println(sid);
		vs.setBackdate(back.getBackdate());
		fmService.modifyVisitor(vs);
		
		mv.setViewName("redirect:/selectLoanStudent");
		return mv;
	}
	

	/**
	 * ���ҽ�����
	 * 
	 * @param mv
	 * @param vs
	 * @param state
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectVistor")
	public ModelAndView SelectVisitor(ModelAndView mv, Model model,
			Visitor visitor) {
		
		List<Visitor> visitors=fmService.selectVisitor(visitor);
		model.addAttribute("visitors", visitors);
		mv.setViewName("borrow/searchRecord");
		//mv.setViewName("borrow/searchStuIfo");
		//mv.setViewName("borrow/searchStuIfo");
		return mv;
	}
	
	//���е������ʱ��Ĳ�ѯ
	@RequestMapping(value="/selectDate")
	public ModelAndView selectDate(ModelAndView mv, HttpSession session, Model model,
			Visitor visitor){
		String borrowDate = null; 
		String cardid = null;
		Integer sub=0;
		Integer oldValue=0;
		List<String> list_id = new ArrayList<String>();
		List<Integer> list_date = new ArrayList<Integer>();
		List<String> list_tip = new ArrayList<String>();
		HashMap Mapdate= new HashMap();
		List<Visitor> visitors=fmService.selectVisitor(visitor);
		for(int i=0;i<visitors.size();i++){
			if(visitors.get(i).getDate() != null){
				borrowDate = visitors.get(i).getDate();
				//date_old = backdate.charAt(8);
				oldValue = fmService.countDay(borrowDate);
				cardid = visitors.get(i).getSid();
				//Mapdate.put(cardid,date_old);
				list_date.add(oldValue);
				list_id.add(cardid);
			}				
		}
		SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		String currentDay = current.format(new Date());
		Integer newValue = fmService.countDay(currentDay);
		String tip = null;
		for(int i=0;i<list_date.size();i++){
			sub = newValue - list_date.get(i);
			if(sub >= 7){
				cardid = list_id.get(i);
				Student student = fmService.findUiByCardid(cardid);
				if(student != null){
					String stname = student.getStname();
					tip = "ѧ��"+stname+"��ѧ��"+cardid+"�ĵ����ѱ������������";
					list_tip.add(tip);
					session.setAttribute("list_tip",list_tip);
				}
			}	
		}
		mv.setViewName("showTip");
		return mv;
	}
}
