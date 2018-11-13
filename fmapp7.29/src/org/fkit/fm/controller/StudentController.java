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
	
	// 上传文件会自动保存到file中
	@RequestMapping("/import")
	public String impotr(HttpServletRequest request, Model model,
			@RequestParam("file") MultipartFile file) throws Exception {
		// 获取上传的文件
		String fileName=file.getOriginalFilename();
		InputStream in = file.getInputStream();

		// 数据导入
		fmService.importExcelInfo(in, file);
		in.close();
		return "redirect:/selectStudent";
	}

//	/**
//	 * excel下载
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
//			response.reset(); // 清除buffer缓存
//			Map<String, Object> map = new HashMap<String, Object>();
//			// 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
//			// 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
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
//			// 导出Excel对象
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
	 * 查找学生
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
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(education_id, grade_id, major_id, clazznum_id,
				student);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
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
	 * 编辑学生所有信息
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
	 * 删除学生
	 * 
	 * @param mv
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/removeStudent")
	public ModelAndView removeStudent(ModelAndView mv, String ids) {
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			// 根据id删除员工
			fmService.removeStuentById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/selectStudent");
		// 返回ModelAndView
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
//			System.out.println("学历：" + education_id);
//			System.out.println("年级：" + grade_id);
//			System.out.println("专业：" + major_id);
//			System.out.println("班号：" + clazznum_id);
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
	 * 添加学生
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

//	// 添加研究生/博士
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
//			System.out.println("学历：" + education_id);
//			System.out.println("年级：" + grade_id);
//			System.out.println("专业：" + major_id);
//			System.out.println("班号：" + clazznum_id);
//			this.genericAssociation(education_id, grade_id, major_id,
//					clazznum_id, student);
//			fmService.addStudent(student);
//			Student student_new = fmService.findStudentByCardid(cardid);
//			session.setAttribute("student", student_new);
//			mv.setViewName("addOrNot2");
//		}
//		return mv;
//	}



	// 通过学号查询学生档案
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
			System.out.println("显示档案信息");
		}else{
			if (cardid.subSequence(0, 1).equals("3")){
				mv.setViewName("showBlankUinfo");
			}else{
				mv.setViewName("showBlankPinfo");
			}
		}
		return mv;
	}
	

	// 编辑学生档案信息
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
	 * 保存学生档案修改信息
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
		System.out.println("保存档案信息完毕");
		mv.setViewName("redirect:/selectStudent");
		return mv;
	}

	
	
	//查询党建档案
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
			//if(!student.getParty().equals("无")){		
				mv.setViewName("partyInfo/showBlankPartyInfo");
			//}
//			else{
//				mv.setViewName("partyInfo/noPartyInfo");
//			}
		}
		return mv;
	}
	

	// 编辑党建档案信息
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
	 * 保存党建档案修改信息
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
		System.out.println("保存档案信息完毕");
		mv.setViewName("redirect:/selectStudent");
		return mv;
	}
	

	// 借阅管理——查找学生
	@RequestMapping(value = "/selectLoanStudent")
	public ModelAndView selectLoanStudent(ModelAndView mv,
			Integer education_id, Integer grade_id, Integer major_id,
			Integer clazznum_id, Integer pageIndex,
			@ModelAttribute Student student, Model model) {
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(education_id, grade_id, major_id, clazznum_id,
				student);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
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
	 * 借阅管理——归还
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
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
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
	 * 借阅管理-借出
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
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
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

		//上传图片
		@RequestMapping("/upload")  
	    public ModelAndView upload(ModelAndView mv, Student student,HttpServletRequest request,Model model,String flag, String cardid,
	    		HttpSession session) throws Exception{  
	    System.out.println(request.getParameter("name"));  
	      //保存数据库的路径  
	      String sqlPath = null;   
	      //定义文件保存的本地路径  
	      String localPath="D:\\File\\";  
	//      //定义 文件名  
	//      String filename=null;    
	//      //定义标题名
	        String title = null;
	        String path=null;
			//      //定义后缀名
	        String suffixName=null;
	//      String suffixName = null;
	      if(!student.getImageFile().isEmpty()){    
	          //生成uuid作为文件名称    
	          String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	          //获得文件类型（可以判断如果不是图片，禁止上传）    
	          String contentType=student.getImageFile().getContentType();    
	          //获得文件后缀名   
	          suffixName=contentType.substring(contentType.indexOf("/")+1);  
	          //得到 文件名  
	          
	          String filename=uuid+"."+suffixName;   
	          System.out.println(filename);  
	          //文件保存路径  
	          student.getImageFile().transferTo(new File(localPath+filename));
	          path=localPath+filename;
	          //student.getImageFile().transferTo(new File(file_result.toString()));
	      }else{
	    	  suffixName= "png";
	    	  path=file_result.toString();
	      }
	       
	      //student.setCardid(cardid);
	      //识别学生的基本信息     点击添加按钮后可以添加学生
	      if(flag.equals("basic")){//识别学生基本信息
	    	  MyProperty property = fmService.findProperty();
	    	  student = fmService.ocrSetStudent(client, student, path);
	    	  model.addAttribute("student", student); 
	    	  model.addAttribute("property", property); 
	    	  mv.setViewName("addStudentFromImage");
	      }else{
	    	  HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//识别获取标题
		      title = mapTitle.get("Title");
	      }
	      if(flag.equals("u")){//识别学生档案		  
	    	  student = fmService.findUiByCardid(cardid);
	    	  student = fmService.ocrSetUFile(client, student, path, suffixName, title);
	    	  model.addAttribute("student", student); 
	    	  if (cardid.subSequence(0, 1).equals("3")) 
	  			mv.setViewName("showUndergraduateInfoContinue");
	  		  else 
	  			mv.setViewName("showPostgraduateInfoContinue");
	      }
	      if(flag.equals("p")){//识别党建档案
	//  	  HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//识别获取标题
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
		
		//显示图片
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
 * 图像添加档案
 * 
 * @param request
 * @return String 图像路径
 */
@ResponseBody
@RequestMapping(value = "/addFileByImage")
public String addFileByImage(HttpServletRequest request)  {
		
	
 	String basePath = "upload/";
    String filePath = request.getSession().getServletContext().getRealPath("/") + basePath;
   // String fileName = DateUtils.getDate("yyyyMMddHHmmss") + ".png";
    String fileName = (new Date()).getTime()+".png";
    //默认传入的参数带类型等参数：data:image/png;base64,
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
 * 图像添加学生
 * 
 * @param request
 * @return String 图像路径
 */	
@ResponseBody
@RequestMapping(value = "/addStudentByImage")
public String addStudentByImage(HttpServletRequest request)  {
		
 	String basePath = "upload/";
    String filePath = request.getSession().getServletContext().getRealPath("/") + basePath;
   // String fileName = DateUtils.getDate("yyyyMMddHHmmss") + ".png";
    String fileName = (new Date()).getTime()+".png";
    //默认传入的参数带类型等参数：data:image/png;base64,
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
        //Base64解码
        byte[] b = decoder.decodeBuffer(imgStr);
        //如果目录不存在，则创建
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //生成图片
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
