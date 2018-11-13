package org.fkit.fm.controller;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fkit.fm.domain.Clazznum;
import org.fkit.fm.domain.Education;
import org.fkit.fm.domain.Grade;
import org.fkit.fm.domain.Major;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.service.FmService;
import org.fkit.fm.util.BasicInfoUtil;
import org.fkit.fm.util.TitleUtil;
import org.fkit.fm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.aip.oas.oas;
import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
@Controller
public class StudentController {
	@Autowired
	@Qualifier("fmService")
	private FmService fmService;

	oas client = new oas();
	StringBuilder file_result = new StringBuilder();

	private String displayPath;
	
	// �ϴ��ļ����Զ����浽file��
	@RequestMapping("/import")
	public String impotr(HttpServletRequest request, Model model,
			@RequestParam("file") MultipartFile file) throws Exception {
		// ��ȡ�ϴ����ļ�
		String fileName=file.getOriginalFilename();
		InputStream in = file.getInputStream();

		// ���ݵ���
		fmService.importExcelInfo(in, file);
		in.close();
		return "redirect:/selectStudent";
	}

//	/**
//	 * excel����
//	 * 
//	 * @param student
//	 * @param request
//	 * @param response
//	 * @throws ClassNotFoundException
//	 * @throws IntrospectionException
//	 * @throws IllegalAccessException
//	 * @throws ParseException
//	 * @throws InvocationTargetException
//	 * @throws UnsupportedEncodingException
//	 */
//	@RequestMapping("/export")
//	public void export(Student student, HttpServletRequest request,
//			HttpServletResponse response, HttpSession session)
//			throws ClassNotFoundException, IntrospectionException,
//			IllegalAccessException, ParseException, InvocationTargetException,
//			UnsupportedEncodingException {
//		// String salaryDate = request.getParameter("salaryDate");
//		if (student != null) {
//			ArrayList<Student> stuList = (ArrayList) session
//					.getAttribute("studentss");
//			student = (Student) stuList.get(0);
//			response.reset(); // ���buffer����
//			Map<String, Object> map = new HashMap<String, Object>();
//			// ָ�����ص��ļ��������������ʹ�ñ��ر��룬��GBK��������յ�����ļ�������ISO-8859-1�����룬Ȼ����GBK����ʾ
//			// ����������GBK���룬ISO-8859-1�����룬��������Ǳ߻ᷴ����ִ�С�
//			response.setHeader(
//					"Content-Disposition",
//					"attachment;filename="
//							+ new String(student.getClazzname()
//									.getBytes("GBK"), "ISO-8859-1") +
//									 new String(student.getParty()
//									.getBytes("GBK"), "ISO-8859-1")+ ".xlsx");
//			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//			response.setHeader("Pragma", "no-cache");
//			response.setHeader("Cache-Control", "no-cache");
//			response.setDateHeader("Expires", 0);
//			XSSFWorkbook workbook = null;
//			// ����Excel����
//			workbook = fmService.exportExcelInfo(stuList);
//			OutputStream output;
//			try {
//				output = response.getOutputStream();
//				BufferedOutputStream bufferedOutPut = new BufferedOutputStream(
//						output);
//				bufferedOutPut.flush();
//				workbook.write(bufferedOutPut);
//				bufferedOutPut.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	/**
	 * ����ѧ��
	 * 
	 * @param mv
	 * @param education_id
	 * @param grade_id
	 * @param major_id
	 * @param clazznum_id
	 * @param pageIndex
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectStudent")
	public ModelAndView selectStudent(ModelAndView mv, Integer education_id,
			Integer grade_id, Integer major_id, Integer clazznum_id,
			Integer pageIndex, @ModelAttribute Student student, Model model, HttpSession session) {
		// ģ����ѯʱ�ж��Ƿ��й������󴫵ݣ�����У���������װ��������
		this.genericAssociation(education_id, grade_id, major_id, clazznum_id,
				student);
		// ������ҳ����
		PageModel pageModel = new PageModel();
		// �������pageIndex��Ϊnull������pageIndex������ʾ�ڼ�ҳ
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
//		List<Education> educations = fmService.findAllEducation();
//		List<Grade> grades = fmService.findAllGrade();
//		List<Major> majors = fmService.findAllMajor();
//		List<Clazznum> clazznums = fmService.findAllClazznum();
		
		List<Student> studentss = fmService.findStudent(student, pageModel);
		String p1 = student.getParam1();
		
//		model.addAttribute("educations", educations);
//		model.addAttribute("grades", grades);
//		model.addAttribute("majors", majors);
//		model.addAttribute("clazznums", clazznums);
		model.addAttribute("studentss", studentss);
		model.addAttribute("pageModel", pageModel);

		session.setAttribute("studentss", studentss);
		mv.setViewName("student");
		
		

		return mv;
	}
	
	/**
	 * �༭ѧ��������Ϣ
	 * 
	 * @param mv
	 * @param flag
	 * @param gender
	 * @param id
	 * @param education_id
	 * @param grade_id
	 * @param major_id
	 * @param clazznum_id
	 * @param pageIndex
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStudent")
	public ModelAndView updateStudent(ModelAndView mv, String flag,
			String gender, Integer id, Integer education_id, Integer grade_id,
			Integer major_id, Integer clazznum_id, Integer pageIndex,
			@ModelAttribute Student student, Model model) {
		if (flag.equals("1")) {

			Student st = fmService.findStudentById(student.getId());
//			List<Education> educations = fmService.findAllEducation();
//			List<Grade> grades = fmService.findAllGrade();
//			List<Major> majors = fmService.findAllMajor();
//			List<Clazznum> clazznums = fmService.findAllClazznum();
//
//			model.addAttribute("educations", educations);
//			model.addAttribute("grades", grades);
//			model.addAttribute("majors", majors);
//			model.addAttribute("clazznums", clazznums);
			model.addAttribute("student", st);
			mv.setViewName("showUpdateStudent");
		} else {

//			this.genericAssociation(education_id, grade_id, major_id,
//					clazznum_id, student);
			fmService.modifyStudent(student);
			mv.setViewName("redirect:/selectStudent");
		}
		return mv;
	}

	/**
	 * ɾ��ѧ��
	 * 
	 * @param mv
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/removeStudent")
	public ModelAndView removeStudent(ModelAndView mv, String ids) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// ����idɾ��Ա��
			fmService.removeStuentById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/selectStudent");
		// ����ModelAndView
		return mv;
	}

	
//	@RequestMapping(value = "/addStudent")
//	public ModelAndView addStudent(ModelAndView mv, String flag, String gender,
//			Integer education_id, Integer grade_id, Integer major_id,
//			Integer clazznum_id, Integer pageIndex, String cardid,
//			@ModelAttribute Student student, Model model, HttpSession session) {
//		if (flag.equals("1")) {
//			// List<Education> educations = fmService.findAllEducation();
//			List<Grade> grades = fmService.findAllGrade();
//			List<Major> majors = fmService.findAllMajor();
//			List<Clazznum> clazznums = fmService.findAllClazznum();
//			// model.addAttribute("educations", educations);
//			model.addAttribute("grades", grades);
//			model.addAttribute("majors", majors);
//			model.addAttribute("clazznums", clazznums);
//			mv.setViewName("showAddStudent");
//		} else {
//			System.out.println("ѧ����" + education_id);
//			System.out.println("�꼶��" + grade_id);
//			System.out.println("רҵ��" + major_id);
//			System.out.println("��ţ�" + clazznum_id);
//			this.genericAssociation(education_id, grade_id, major_id,
//					clazznum_id, student);
//			fmService.addStudent(student);
//
//			Student student_new = fmService.findStudentByCardid(cardid);
//			session.setAttribute("student", student_new);
//			mv.setViewName("addOrNot1");
//		}
//		return mv;
//	}
	/**
	 * ���ѧ��
	 * 
	 * @param mv
	 * @param flag
	 * @param gender
	 * @param education_id
	 * @param grade_id
	 * @param major_id
	 * @param clazznum_id
	 * @param pageIndex
	 * @param cardid
	 * @param student
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(ModelAndView mv, String flag, String gender,
			Integer education_id, Integer grade_id, Integer major_id,
			Integer clazznum_id, Integer pageIndex, String cardid,
			@ModelAttribute Student student, Model model, HttpSession session) {
		if (flag.equals("1")) {
			mv.setViewName("showAddStudent");
		} else {
			fmService.addStudent(student);
//			Student student_new = fmService.findStudentByCardid(cardid);
//			session.setAttribute("student", student_new);
//			mv.setViewName("addOrNot1");
			mv.setViewName("redirect:/selectStudent");
		}
		return mv;
	}

//	// ����о���/��ʿ
//	@RequestMapping(value = "/addPostgraduate")
//	public ModelAndView addPostgraduate(ModelAndView mv, String flag,
//			String gender, String cardid, Integer education_id,
//			Integer grade_id, Integer major_id, Integer clazznum_id,
//			Integer pageIndex, @ModelAttribute Student student, Model model,
//			HttpSession session) {
//		if (flag.equals("1")) {
//			List<Education> educations = fmService.findAllEducation();
//			List<Grade> grades = fmService.findAllGrade();
//			List<Major> majors = fmService.findAllMajor();
//			List<Clazznum> clazznums = fmService.findAllClazznum();
//			model.addAttribute("educations", educations);
//			model.addAttribute("grades", grades);
//			model.addAttribute("majors", majors);
//			model.addAttribute("clazznums", clazznums);
//			session.setAttribute("educations", educations);
//			session.setAttribute("grades", grades);
//			session.setAttribute("majors", majors);
//			session.setAttribute("clazznums", clazznums);
//			mv.setViewName("showAddPostgraduate");
//		} else {
//			System.out.println("ѧ����" + education_id);
//			System.out.println("�꼶��" + grade_id);
//			System.out.println("רҵ��" + major_id);
//			System.out.println("��ţ�" + clazznum_id);
//			this.genericAssociation(education_id, grade_id, major_id,
//					clazznum_id, student);
//			fmService.addStudent(student);
//			Student student_new = fmService.findStudentByCardid(cardid);
//			session.setAttribute("student", student_new);
//			mv.setViewName("addOrNot2");
//		}
//		return mv;
//	}



	// ͨ��ѧ�Ų�ѯѧ������
	@RequestMapping(value = "/findUiByCardid")
	public ModelAndView findUiByCardid(ModelAndView mv, HttpSession session,
			@RequestParam("cardid") String cardid, Model model, Student student) {
		student = fmService.findUiByCardid(cardid);
		String uinfo = student.getUinfo();
		model.addAttribute("student", student);
		if(uinfo!=null){
			List<String> uinfo_list = java.util.Arrays.asList(uinfo.split(","));
			student.setUndergraduateInfo(uinfo_list);			
			session.setAttribute("uinfo_list", uinfo_list);
			if (cardid.subSequence(0, 1).equals("3")){
				mv.setViewName("showUndergraduateInfo");
			}else{
				mv.setViewName("showPostgraduateInfo");
			}
			System.out.println("��ʾ������Ϣ");
		}else{
			if (cardid.subSequence(0, 1).equals("3")){
				mv.setViewName("showBlankUinfo");
			}else{
				mv.setViewName("showBlankPinfo");
			}
		}
		return mv;
	}
	

	// �༭ѧ��������Ϣ
	@RequestMapping(value = "/editUndergraduate")
	public ModelAndView editUndergraduate(ModelAndView mv, HttpSession session,
			Model model, Student student, @RequestParam("cardid") String cardid) {
		student = fmService.findUiByCardid(cardid);
		String uinfo = student.getUinfo();
		model.addAttribute("student", student);
		if(uinfo!=null){
			List<String> uinfo_list = java.util.Arrays.asList(uinfo.split(","));
			student.setUndergraduateInfo(uinfo_list);
			session.setAttribute("uinfo_list", uinfo_list);
		}
		//student.setReader(true);
		if (cardid.subSequence(0, 1).equals("3")) {
			mv.setViewName("editUndergraduateInfo");
		} else {
			mv.setViewName("editPostgraduateInfo");
		}
		return mv;
	}

	/**
	 * ����ѧ�������޸���Ϣ
	 * 
	 * @param mv
	 * @param session
	 * @param model
	 * @param student
	 * @param cardid
	 * @return
	 */
	@RequestMapping(value = "/saveUndergraduate")
	public ModelAndView saveUndergraduate(ModelAndView mv, HttpSession session,
			Model model, @ModelAttribute Student student,
			@RequestParam("cardid") String cardid) {
		if(student.getUndergraduateInfo()!=null){
			List<String> undergraduateInfo = student.getUndergraduateInfo();
			System.out.println(undergraduateInfo.size());
			student.setUinfo(fmService.ListToString(undergraduateInfo));
		}
		// System.out.println(student.getUinfo());
		model.addAttribute("student", student);
		fmService.saveUinfo(student);
		System.out.println("���浵����Ϣ���");
		mv.setViewName("redirect:/selectStudent");
		return mv;
	}

	
	
	//��ѯ��������
	@RequestMapping(value = "/findPiByCardid")
	public ModelAndView findPiByCardid(ModelAndView mv, HttpSession session,
			@RequestParam("cardid") String cardid, Model model, Student student) {
		student = fmService.findPiByCardid(cardid);
		String pinfo = student.getPinfo();
		model.addAttribute("student", student);
		// student.setReader(true);
		if(pinfo!=null){
			List<String> pinfo_list = java.util.Arrays.asList(pinfo.split(","));
			student.setPartyInfo(pinfo_list);
			model.addAttribute("student", student);
			session.setAttribute("pinfo_list", pinfo_list);
			mv.setViewName("partyInfo/showPartyInfo");
		}else{
			//if(!student.getParty().equals("��")){		
				mv.setViewName("partyInfo/showBlankPartyInfo");
			//}
//			else{
//				mv.setViewName("partyInfo/noPartyInfo");
//			}
		}
		return mv;
	}
	

	// �༭����������Ϣ
	@RequestMapping(value = "/editPartyInfo")
	public ModelAndView editPartyInfo(ModelAndView mv, HttpSession session,
			Model model, Student student, @RequestParam("cardid") String cardid) {
		student = fmService.findPiByCardid(cardid);
		String pinfo = student.getPinfo();
		model.addAttribute("student", student);
		if(pinfo!=null){
			List<String> pinfo_list = java.util.Arrays.asList(pinfo.split(","));
			student.setPartyInfo(pinfo_list);			
			session.setAttribute("pinfo_list", pinfo_list);
		}
		mv.setViewName("partyInfo/editPartyInfo");
		return mv;
	}
	
	/**
	 * ���浳�������޸���Ϣ
	 * 
	 * @param mv
	 * @param session
	 * @param model
	 * @param student
	 * @param cardid
	 * @return
	 */
	@RequestMapping(value = "/savePartyInfo")
	public ModelAndView savePartyInfo(ModelAndView mv, HttpSession session,
			Model model, @ModelAttribute Student student,
			@RequestParam("cardid") String cardid) {
		if(student.getPartyInfo()!=null){
			List<String> partyInfo = student.getPartyInfo();
			System.out.println(partyInfo.size());
			student.setPinfo(fmService.ListToString(partyInfo));
		}
		// System.out.println(student.getUinfo());
		model.addAttribute("student", student);
		fmService.savePinfo(student);
		System.out.println("���浵����Ϣ���");
		mv.setViewName("redirect:/selectStudent");
		return mv;
	}
	

	// ���Ĺ���������ѧ��
	@RequestMapping(value = "/selectLoanStudent")
	public ModelAndView selectLoanStudent(ModelAndView mv,
			Integer education_id, Integer grade_id, Integer major_id,
			Integer clazznum_id, Integer pageIndex,
			@ModelAttribute Student student, Model model) {
		// ģ����ѯʱ�ж��Ƿ��й������󴫵ݣ�����У���������װ��������
		this.genericAssociation(education_id, grade_id, major_id, clazznum_id,
				student);
		// ������ҳ����
		PageModel pageModel = new PageModel();
		// �������pageIndex��Ϊnull������pageIndex������ʾ�ڼ�ҳ
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
//		List<Education> educations = fmService.findAllEducation();
//		List<Grade> grades = fmService.findAllGrade();
//		List<Major> majors = fmService.findAllMajor();
//		List<Clazznum> clazznums = fmService.findAllClazznum();
		List<Student> studentss = fmService.findStudent(student, pageModel);

//		model.addAttribute("educations", educations);
//		model.addAttribute("grades", grades);
//		model.addAttribute("majors", majors);
//		model.addAttribute("clazznums", clazznums);
		model.addAttribute("studentss", studentss);
		model.addAttribute("pageModel", pageModel);

		mv.setViewName("borrow/searchStuIfo");

		return mv;
	}

	/**
	 * ���Ĺ������黹
	 * 
	 * @param mv
	 * @param cardid
	 * @param pageIndex
	 * @param student
	 * @return
	 */
	@RequestMapping("/back")
	public ModelAndView back(ModelAndView mv, String cardid, Integer pageIndex,
			Student student) {

		student.setCardid(cardid);
		// ������ҳ����
		PageModel pageModel = new PageModel();
		// �������pageIndex��Ϊnull������pageIndex������ʾ�ڼ�ҳ
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Student> students = fmService.findStudent(student, pageModel);

		mv.addObject("student", students.get(0));
		mv.setViewName("borrow/back");
		//mv.setViewName("redirect:/selectLoanStudent");
		return mv;
	}

	/**
	 * ���Ĺ���-���
	 * 
	 * @param mv
	 * @param cardid
	 * @param pageIndex
	 * @param student
	 * @return
	 */
	@RequestMapping("/loan")
	public ModelAndView load(ModelAndView mv, String cardid, Integer pageIndex,
			Student student) {

		student.setCardid(cardid);
		// ������ҳ����
		PageModel pageModel = new PageModel();
		// �������pageIndex��Ϊnull������pageIndex������ʾ�ڼ�ҳ
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		List<Student> students = fmService.findStudent(student, pageModel);
		mv.addObject("student", students.get(0));
		mv.setViewName("borrow/loan");
		return mv;
	}

	private void genericAssociation(Integer education_id, Integer grade_id,
			Integer major_id, Integer clazznum_id, Student student) {
		if (education_id != null) {
			Education education = new Education();
			education.setId(education_id);
			student.setEducation(education);
		}
		if (grade_id != null) {
			Grade grade = new Grade();
			grade.setId(grade_id);
			student.setGrade(grade);
		}
		if (clazznum_id != null) {
			Clazznum clazznum = new Clazznum();
			clazznum.setId(clazznum_id);
			student.setClazznum(clazznum);
		}
		if (major_id != null) {
			Major major = new Major();
			major.setId(major_id);
			student.setMajor(major);
		}
	}

		//�ϴ�ͼƬ
		@RequestMapping("/upload")  
	    public ModelAndView upload(ModelAndView mv, Student student,HttpServletRequest request,Model model,String flag, String cardid,
	    		HttpSession session) throws Exception{  
	    System.out.println(request.getParameter("name"));  
	      //�������ݿ��·��  
	      String sqlPath = null;   
	      //�����ļ�����ı���·��  
	      String localPath="D:\\File\\";  
	//      //���� �ļ���  
	//      String filename=null;    
	//      //���������
	        String title = null;
	        String path=null;
			//      //�����׺��
	        String suffixName=null;
	//      String suffixName = null;
	      if(!student.getImageFile().isEmpty()){    
	          //����uuid��Ϊ�ļ�����    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���    
	          String contentType=student.getImageFile().getContentType();    
	          //����ļ���׺��   
	          suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //�õ� �ļ���  
	          
	          String filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //�ļ�����·��  
	          student.getImageFile().transferTo(new File(localPath+filename));
	          path=localPath+filename;
	          //student.getImageFile().transferTo(new File(file_result.toString()));
	      }else{
	    	  suffixName= "png";
	    	  path=file_result.toString();
	      }
	       
	      //student.setCardid(cardid);
	      //ʶ��ѧ���Ļ�����Ϣ     �����Ӱ�ť��������ѧ��
	      if(flag.equals("basic")){//ʶ��ѧ��������Ϣ
	    	  MyProperty property = fmService.findProperty();
	    	  student = fmService.ocrSetStudent(client, student, path);
	    	  model.addAttribute("student", student); 
	    	  model.addAttribute("property", property); 
	    	  mv.setViewName("addStudentFromImage");
	      }else{
	    	  HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//ʶ���ȡ����
		      title = mapTitle.get("Title");
	      }
	      if(flag.equals("u")){//ʶ��ѧ������		  
	    	  student = fmService.findUiByCardid(cardid);
	    	  student = fmService.ocrSetUFile(client, student, path, suffixName, title);
	    	  model.addAttribute("student", student); 
	    	  if (cardid.subSequence(0, 1).equals("3")) 
	  			mv.setViewName("showUndergraduateInfoContinue");
	  		  else 
	  			mv.setViewName("showPostgraduateInfoContinue");
	      }
	      if(flag.equals("p")){//ʶ�𵳽�����
	//  	  HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//ʶ���ȡ����
	//	      title = mapTitle.get("Title");
	    	  student = fmService.findPiByCardid(cardid);
	    	  student = fmService.ocrSetPFile(client, student, path, suffixName, title);
	    	  model.addAttribute("student", student);  
	  		  mv.setViewName("partyInfo/showPartyInfoContinue");
	      }
	      String filename_new = student.getCardid()+title+"."+suffixName;
	      String path_new = localPath+filename_new;
	      fmService.renameFile(path,path_new);
	      String markfile="auto";
	      //model.addAttribute("markfile",markfile);
	      session.setAttribute("markfile", markfile);
	      return mv;  
	    }  
		
		//��ʾͼƬ
		@RequestMapping("/displayImage")  
	    public ModelAndView displayImage(ModelAndView mv, Student student,HttpServletRequest request,
	    		HttpSession session, Model model,String flag, String cardid){  
			String displayPath = null;
			student = fmService.findUiByCardid(cardid);
			String image = student.getImage();
			List<String> list_image = Arrays.asList(image.split(","));
			list_image = new ArrayList(list_image);
			for(int i=0;i<list_image.size();i++){
				if(list_image.get(i).contains(flag))
					displayPath = list_image.get(i);
			}
			session.setAttribute("displayPath",displayPath);
			mv.setViewName("showImage");	
			return mv; 
		} 
		
		



/**
 * ͼ����ӵ���
 * 
 * @param request
 * @return String ͼ��·��
 */
@ResponseBody
@RequestMapping(value = "/addFileByImage")
public String addFileByImage(HttpServletRequest request)  {
		
	
 	String basePath = "upload/";
    String filePath = request.getSession().getServletContext().getRealPath("/") + basePath;
   // String fileName = DateUtils.getDate("yyyyMMddHHmmss") + ".png";
    String fileName = (new Date()).getTime()+".png";
    //Ĭ�ϴ���Ĳ��������͵Ȳ�����data:image/png;base64,
    String imgStr = request.getParameter("image");
    if (null != imgStr) {
        imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
    }
    Boolean flag = GenerateImage(imgStr, filePath, fileName);
    String result_t = "";
    if (flag) {
    	result_t = "/fmapp/"+basePath + fileName;
    }

    String savePath="D:\\File\\";
    Boolean flag_2 = GenerateImage(imgStr, savePath, fileName);
    String result_save = "";
    if (flag_2) {
    	result_save = savePath + fileName;
    }
    
    file_result=new StringBuilder(result_save);    
    return (result_t);
}


/**
 * ͼ�����ѧ��
 * 
 * @param request
 * @return String ͼ��·��
 */	
@ResponseBody
@RequestMapping(value = "/addStudentByImage")
public String addStudentByImage(HttpServletRequest request)  {
		
 	String basePath = "upload/";
    String filePath = request.getSession().getServletContext().getRealPath("/") + basePath;
   // String fileName = DateUtils.getDate("yyyyMMddHHmmss") + ".png";
    String fileName = (new Date()).getTime()+".png";
    //Ĭ�ϴ���Ĳ��������͵Ȳ�����data:image/png;base64,
    String imgStr = request.getParameter("image");
    if (null != imgStr) {
        imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
    }
    Boolean flag = GenerateImage(imgStr, filePath, fileName);
    String result_t = "";
    if (flag) {
    	result_t = "/fmapp/"+basePath + fileName;
    }

    String savePath="D:\\File\\";
    Boolean flag_2 = GenerateImage(imgStr, savePath, fileName);
    String result_save = "";
    if (flag_2) {
    	result_save = savePath + fileName;
    }
    
    file_result=new StringBuilder(result_save);    
    return (result_t);
//				return mv;
}
public boolean GenerateImage(String imgStr, String filePath, String fileName) {
    try {
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        //Base64����
        byte[] b = decoder.decodeBuffer(imgStr);
        //���Ŀ¼�����ڣ��򴴽�
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //����ͼƬ
		        OutputStream out = new FileOutputStream(filePath + fileName);
		        out.write(b);
		        out.flush();
		        out.close();
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
		}
		
		

}
