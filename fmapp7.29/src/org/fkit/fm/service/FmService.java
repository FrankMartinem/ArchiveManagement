package org.fkit.fm.service;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fkit.fm.domain.Back;
import org.fkit.fm.domain.Clazznum;
import org.fkit.fm.domain.Education;
import org.fkit.fm.domain.Grade;
import org.fkit.fm.domain.Major;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.User;
import org.fkit.fm.domain.Visitor;
import org.fkit.fm.util.tag.PageModel;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.oas.oas;

public interface FmService {
	void importExcelInfo(InputStream in, MultipartFile file) throws Exception;
	
	//XSSFWorkbook exportExcelInfo(ArrayList<Student> stuList) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException;
	
	void addUser(User user);

	User findUser(String id);

	User loginUser(String id, String password);

	List<Grade> findAllGrade();

	List<Major> findAllMajor();

	List<Clazznum> findAllClazznum();

	List<Education> findAllEducation();

	List<Student> findStudent(Student student, PageModel pageModel);
	
	void addStudent(Student student);
	
	void modifyStudent(Student student);
	
	Student findStudentById(Integer integer);

	void removeStuentById(Integer id);
	
	Student findUiByCardid(String cardid);

	void saveUinfo(Student student);

	void addVisitor(Visitor vs);

	List<Visitor> selectVisitor(Visitor vs);

	Student findStudentByCardid(String cardid);

	Student findPiByCardid(String cardid);

	void savePinfo(Student student);

//	void updateVisitor(Visitor vs);

	void addBack(Back back);

	Back selectBack(String sid,String unifoType);

	void modifyVisitor(Visitor vs);


	void addProperty(MyProperty property);

	MyProperty findProperty();
	
	String ListToString(List<String> stringList);

	void updateProperty(MyProperty property);
	
	void autoAddStudent(Student student);
	
	List<String> findPropertyList(MyProperty property);

	Student ocrSetStudent(oas client, Student student, String path);

	Student ocrSetUFile(oas client, Student student, String path, String suffixName, String title);

	Student ocrSetPFile(oas client, Student student, String path, String suffixName, String title);
 
	void renameFile(String file, String toFile);
	
	Integer countDay(String day);
	
	List<Student> selectStudent(Student student);

	
	
}
