package org.fkit.fm.service.impl;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fkit.fm.dao.ClazznumDao;
import org.fkit.fm.dao.EducationDao;
import org.fkit.fm.dao.GradeDao;
import org.fkit.fm.dao.MajorDao;
import org.fkit.fm.dao.PropertyDao;
import org.fkit.fm.dao.StudentDao;
import org.fkit.fm.dao.UserDao;
import org.fkit.fm.dao.VisitorDao;
import org.fkit.fm.domain.Back;
import org.fkit.fm.domain.Clazznum;
import org.fkit.fm.domain.Education;
import org.fkit.fm.domain.ExcelBean;
import org.fkit.fm.domain.Grade;
import org.fkit.fm.domain.Major;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.User;
import org.fkit.fm.domain.Visitor;
import org.fkit.fm.service.FmService;
import org.fkit.fm.util.BasicInfoUtil;
import org.fkit.fm.util.ExcelUtil;
import org.fkit.fm.util.TitleUtil;
import org.fkit.fm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.oas.oas;

@Service("fmService")
public class FmServiceImpl implements FmService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private GradeDao gradeDao;

	@Autowired
	private MajorDao majorDao;

	@Autowired
	private ClazznumDao clazznumDao;

	@Autowired
	private EducationDao educationDao;

	@Autowired
	private VisitorDao visitorDao;
	
	@Autowired
	private PropertyDao propertyDao;
	
	//�û���¼
	@Override
	public User loginUser(String id, String password) {
		return userDao.selectByIdAndPassword(id, password);
	}
	
	//����ѧ��
	@Override
	public List<Student> findStudent(Student student, PageModel pageModel) {
		Map<String, Object> params = new HashMap<>();
		params.put("student", student);

		int recordCount = studentDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			/** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
			params.put("pageModel", pageModel);
		}
		return studentDao.selectByPage(params);
	}
	
	
	//����excel
	@Override
	public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	    List<Student> studentList = new ArrayList<Student>();
	    //��ȡ��ͷ���ƺ�����
	    //List<Object> ob = listob.get(0);//ȡ����1��(��ͷ) 
	    //����listob���ݣ������ݷŵ�List��
	    for (int i = 0; i < listob.size(); i++) {        
	    	List<Object> ob = listob.get(i);//ȡ����i��
	    	//int colNum = ob.size();//��ȡ����
	        Student student =new Student();        
	        //ͨ������ʵ�ְ�ÿһ�з�װ��һ��model�У��ٰ����е�model��List����װ��
//	        student.setCardid(String.valueOf(ob.get(0)));//ȡ����j��
//	        student.setStname(String.valueOf(ob.get(1)));
//	        //student.setGender(String.valueOf(ob.get(3)));
//	        student.setPhone(String.valueOf(ob.get(2)));
//	        student.setClazzname(String.valueOf(ob.get(3)));
//	        student.setParty(String.valueOf(ob.get(4)));
//	        student.setLocation(String.valueOf(ob.get(5)));
//	        //student.setUinfo(String.valueOf(ob.get(5)));
	        student.setCardid(String.valueOf(ob.get(0)));//ȡ����j��
	        student.setStname(String.valueOf(ob.get(1)));
	        MyProperty property = findProperty();
	        String p1 = property.getProperty1();
	        String p2 = property.getProperty10();	        
	        if(property.getProperty1().equals("") == false)
	        	student.setParam1(String.valueOf(ob.get(2)));//ȡ����j��
	        else
	        	student.setParam1("��");
	        if(property.getProperty2().equals("") == false)
	        	student.setParam2(String.valueOf(ob.get(3)));//ȡ����j��
	        else
	        	student.setParam2("��");
	        if(property.getProperty3().equals("") == false)
	        	student.setParam3(String.valueOf(ob.get(4)));//ȡ����j��
	        else
	        	student.setParam3("��");
	        if(property.getProperty4().equals("") == false)
	        	student.setParam4(String.valueOf(ob.get(5)));//ȡ����j��
	        else
	        	student.setParam4("��");
	        if(property.getProperty5().equals("") == false)
	        	student.setParam5(String.valueOf(ob.get(6)));//ȡ����j��
	        else
	        	student.setParam5("��");
	        if(property.getProperty6().equals("") == false)
	        	student.setParam6(String.valueOf(ob.get(7)));//ȡ����j��
	        else
	        	student.setParam6("��");
	        if(property.getProperty7().equals("") == false)
	        	student.setParam7(String.valueOf(ob.get(8)));//ȡ����j��
	        else
	        	student.setParam7("��");
	        if(property.getProperty8().equals("") == false)
	        	student.setParam8(String.valueOf(ob.get(9)));//ȡ����j��
	        else
	        	student.setParam8("��");
	        if(property.getProperty9().equals("") == false)
	        	student.setParam9(String.valueOf(ob.get(10)));//ȡ����j��
	        else
	        	student.setParam9("��");
	        if(property.getProperty10().equals("") == false)
	        	student.setParam10(String.valueOf(ob.get(11)));//ȡ����j��	
	        else
	        	student.setParam10("��");
	        studentList.add(student);
	    }
	    //��������
	    studentDao.insertInfoBatch(studentList);
	}

//	// ����excel
//	@Override
//	public XSSFWorkbook exportExcelInfo(ArrayList<Student> stuList)
//			throws IllegalArgumentException, IllegalAccessException,
//			InvocationTargetException, ClassNotFoundException,
//			IntrospectionException, ParseException {
//		// ����������ѯ���ݣ�������װ�ص�һ��list��
//		/*
//		 * Map<String,Object> params = new HashMap<>(); params.put("student",
//		 * student); List<Student> list = studentDao.selectByPage(params);
//		 * 
//		 * for(int i=0;i<list.size();i++){ //��ѯ�������� int adminId =
//		 * list.get(i).getAdminId(); String adminName =
//		 * salarymanageDao.selectAdminNameById(adminId);
//		 * list.get(i).setAdminName(adminName); list.get(i).setId(i+1); }
//		 */
//		List<ExcelBean> excel = new ArrayList<>();
//		Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
//		XSSFWorkbook xssfWorkbook = null;
//		// ���ñ�����
//		excel.add(new ExcelBean("ѧ��", "cardid", 0));
//		excel.add(new ExcelBean("����", "stname", 0));
//		excel.add(new ExcelBean("�绰", "phone", 0));
//		excel.add(new ExcelBean("�༶", "clazzname", 0));
//		excel.add(new ExcelBean("��֧��", "party", 0));
//		excel.add(new ExcelBean("����λ��", "location", 0));
//		excel.add(new ExcelBean("ѧ��������Ϣ", "uinfo", 0));
//		excel.add(new ExcelBean("ѧ��С������ƣ�", "summary", 0));
//		excel.add(new ExcelBean("����������Ϣ", "pinfo", 0));
//		excel.add(new ExcelBean("�뵳��������˼��㱨", "into_report", 0));
//		excel.add(new ExcelBean("Ԥ����Ա��������˼��㱨", "pre_report", 0));
//		map.put(0, excel);
//		String sheetName = stuList.get(0).getClazzname() + " ������Ϣ";
//		// ����ExcelUtil�ķ���
//		xssfWorkbook = ExcelUtil.createExcelFile(Student.class, stuList, map,
//				sheetName);
//		return xssfWorkbook;
//	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public User findUser(String id) {
		return userDao.findUser(id);
	}



	@Override
	public List<Grade> findAllGrade() {
		return gradeDao.selectAllGrade();
	}

	@Override
	public List<Major> findAllMajor() {
		return majorDao.selectAllMajor();
	}

	@Override
	public List<Clazznum> findAllClazznum() {
		return clazznumDao.selectAllClazznum();
	}

	@Override
	public List<Education> findAllEducation() {
		return educationDao.selectAllEducation();
	}



	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public Student findStudentById(Integer id) {
		return studentDao.selectStudentById(id);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDao.modifyStudent(student);
	}

	@Override
	public void removeStuentById(Integer id) {
		studentDao.delStudentById(id);
	}

	@Override
	public Student findUiByCardid(String cardid) {
		return studentDao.findUiByCardid(cardid);
	}

	@Override
	public void saveUinfo(Student student) {
		studentDao.saveUinfo(student);
	}

	// ���ӽ��ļ�¼
	@Override
	public void addVisitor(Visitor vs) {
		// TODO Auto-generated method stub
		visitorDao.addVisitor(vs);
	}

	// ��ѯ���ļ�¼
	@Override
	public List<Visitor> selectVisitor(Visitor vs) {

		return visitorDao.selectVisitor(vs);
	}

	@Override
	public Student findStudentByCardid(String cardid) {
		return studentDao.selectStudentByCardid(cardid);
	}
	
	
	
	@Override
	public Student findPiByCardid(String cardid){
		return studentDao.findPiByCardid(cardid);
	}
	@Override
	public void savePinfo(Student student){
		studentDao.savePinfo(student);
	}
	
//	@Override
//	public void updateVisitor(Visitor vs){
//		visitorDao.updateVisitor(vs);
//	}
	@Override
	public void addBack(Back back){
		visitorDao.addBack(back);
	}
	@Override
	public Back selectBack(String sid,String unifoType){
		return visitorDao.selectBack(sid,unifoType);
	}
	@Override
	public void modifyVisitor(Visitor vs){
		visitorDao.modifyVisitor(vs);
	}
	
	@Override
	public void addProperty(MyProperty property){
		propertyDao.addProperty(property);
	}
	
	@Override
	public MyProperty findProperty(){
		return propertyDao.findProperty();
	}
	
	@Override
	// list����ת��Ϊstring����
	public String ListToString(List<String> stringList) {
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {
			if (flag) {
				result.append(",");// append�������ַ������ӵ�StringBuilderĩβ
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
	@Override
	public void updateProperty(MyProperty property){
		propertyDao.updateProperty(property);
	}
	
	@Override
	public void autoAddStudent(Student student){
		studentDao.autoAddStudent(student);
	}
	
	@Override
	public List<String> findPropertyList(MyProperty property){
		property = propertyDao.findProperty();
		List<String> list_property = new ArrayList<String>();
		if(property.getProperty1().length() != 0)
			list_property.add(property.getProperty1());
		if(property.getProperty2().length() != 0)
			list_property.add(property.getProperty1());
		if(property.getProperty3().length() != 0)
			list_property.add(property.getProperty3());
		if(property.getProperty4().length() != 0)
			list_property.add(property.getProperty4());
		if(property.getProperty5().length() != 0)
			list_property.add(property.getProperty5());
		if(property.getProperty6().length() != 0)
			list_property.add(property.getProperty6());
		if(property.getProperty7().length() != 0)
			list_property.add(property.getProperty7());
		if(property.getProperty8().length() != 0)
			list_property.add(property.getProperty8());
		if(property.getProperty9().length() != 0)
			list_property.add(property.getProperty9());
		if(property.getProperty10().length() != 0)
			list_property.add(property.getProperty10());
		return list_property;
	}
	
	@Override
	public Student ocrSetStudent(oas client,Student student, String path){
		//ʶ��ͼƬ��ѧ���Ļ�����Ϣ
	      MyProperty property = new MyProperty();
	      List<String> list_property = findPropertyList(property);
	      HashMap<String, String> mapBasicInfo = BasicInfoUtil.getBasicInfo(path,list_property);//ʶ���ȡѧ���Ļ�����Ϣ���
	      String name =  mapBasicInfo.get("����");
	      String cid =  mapBasicInfo.get("ѧ(��)��");
	      String p1 =  mapBasicInfo.get(list_property.get(0));
	      if(mapBasicInfo.get("����") != null)
	    	  student.setStname(mapBasicInfo.get("����"));
	      if(mapBasicInfo.get("ѧ(��)��") != null)
	      student.setCardid(mapBasicInfo.get("ѧ(��)��"));
	      int i=0;
	      if(i<list_property.size()){
	    	  student.setParam1(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam2(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam3(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam4(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam5(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam6(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam7(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam8(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam9(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      if(i<list_property.size()){
	    	  student.setParam10(mapBasicInfo.get(list_property.get(i)));
	    	  i++;
	      }
	      
	      for(i=0;i<list_property.size();i++)
	    	  System.out.println(mapBasicInfo.get(list_property.get(i)));
	      
	      return student;
	}
	
	@Override
	public Student ocrSetUFile(oas client, Student student, String path, String suffixName, String title){
//		HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//ʶ���ȡ����
//	    String title = mapTitle.get("Title");    
	    String uinfo = student.getUinfo();
	    List<String> uinfo_list = new ArrayList<String>();
	    //List<String> uinfo_tmplist = new ArrayList<String>();
	    int flag_add = 0;
	    if(uinfo != null){
	    	List<String> uinfo_tmplist = java.util.Arrays.asList(uinfo.split(","));
	    	uinfo_list = new ArrayList(uinfo_tmplist);
	    	for(int i=0; i<uinfo_list.size();i++){
	    		if(uinfo_list.get(i).equals(title))
	    			flag_add = 1;  		
	    	}	
	    }
	    if(flag_add == 0){
	    	uinfo_list.add(title);
	    	//�洢ͼƬ·�������ݿ���
	    	
	    	//student.getImageFile().transferTo(new File(localPath+filename_new));
	    	//.renameTo(new File("E:"+File.separator+"������.txt"));   //����   
	    	String filename_new = student.getCardid()+title+"."+suffixName;
	    	String sqlPath = "/images/"+filename_new;  
	        String image = student.getImage();
	        image = image + "," + sqlPath;
//	        List<String> list_image= new ArrayList<String>();
//	        if(image != null){
//	        	list_image = Arrays.asList(image.split(","));
//	 	        list_image = new ArrayList(list_image);
//	        }
//	        list_image.add(sqlPath);
//	        image = ListToString(list_image);
	        System.out.println(image);  
	        student.setImage(image);  
	        modifyStudent(student);  
	    }	    		
	    student.setUndergraduateInfo(uinfo_list);
	    student.setUinfo(ListToString(uinfo_list));
		System.out.println(student.getUinfo());
		saveUinfo(student);
	    return student;
	    }
	
	@Override
	public Student ocrSetPFile(oas client, Student student, String path, String suffixName, String title){
//		HashMap<String, String> mapTitle = TitleUtil.getTitle(client,path);//ʶ���ȡ����
//	    String title = mapTitle.get("Title");
	    String pinfo = student.getPinfo();
	    List<String> pinfo_list = new ArrayList<String>();
	    int flag_add = 0;
	    if(pinfo != null){
	    	List<String> pinfo_tmplist = java.util.Arrays.asList(pinfo.split(","));
	    	pinfo_list = new ArrayList(pinfo_tmplist);
	    	for(int i=0; i<pinfo_list.size();i++){
	    		if(pinfo_list.get(i).equals(title))
	    			flag_add = 1;  		
	    	}	
	    }
	    if(flag_add == 0){
	    	pinfo_list.add(title);	
	    	//�洢ͼƬ·�������ݿ���
	    	String filename_new = student.getCardid()+title+"."+suffixName;
	    	String sqlPath = "/images/"+filename_new;  
	        String image = student.getImage();
	        image = image + "," + sqlPath;
//	        List<String> list_image= new ArrayList<String>();
//	        if(image != null){
//	        	list_image = Arrays.asList(image.split(","));
//	 	        list_image = new ArrayList(list_image);
//	        }
//	        list_image.add(sqlPath);
//	        image = ListToString(list_image);
	        System.out.println(image);  
	        student.setImage(image);  
	        modifyStudent(student);  
	    }
	    	
	    student.setPartyInfo(pinfo_list);
	    student.setPinfo(ListToString(pinfo_list));
		System.out.println(student.getPinfo());
		savePinfo(student);
	    return student;
	    }
	
	@Override
   public void renameFile(String file, String toFile) {
	   
        File toBeRenamed = new File(file);
        //���Ҫ���������ļ��Ƿ���ڣ��Ƿ����ļ�
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
 
            System.out.println("File does not exist: " + file);
            return;
        }
 
        File newFile = new File(toFile);
 
        //�޸��ļ���
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }
 
    }

	@Override
	public Integer countDay(String day){
		String date_day = day.substring(8,10);
		String date_month = day.substring(5,7);
		Integer date_dayi= Integer.valueOf(date_day);
		Integer date_monthi= Integer.valueOf(date_month);
		Integer value = date_monthi * 12 + date_dayi;
		return value;
	}
	
	@Override
	public List<Student> selectStudent(Student student){
		return studentDao.selectStudent(student);
	}
	
}

