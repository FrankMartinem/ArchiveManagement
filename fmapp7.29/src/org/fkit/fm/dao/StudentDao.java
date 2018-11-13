package org.fkit.fm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.fm.dao.provider.StudentDynaSqlProvider;
import org.fkit.fm.dao.provider.VisitorDynaSqlProvider;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.Visitor;
import org.apache.ibatis.annotations.One;

import static org.fkit.fm.util.commom.FmConstants.STUDENTTABLE;

public interface StudentDao {

	/**
	 * 批量插入
	 * 
	 * @param studentList
	 *            collection： 指定要遍历的集合（三种情况 list，array，map） ！！！！在这种使用注解sql的情况下，这里请填写mapper方法中集合的名称
	 *            item：将当前遍历出的元素赋值给指定的变量 （相当于for循环中的i） separator:每个元素之间的分隔符
	 *            open：遍历出所有结果拼接一个开始的字符 close:遍历出所有结果拼接一个结束的字符
	 *            index:索引。遍历list的时候是index就是索引，item就是当前值
	 *            #{变量名}就能取出变量的值也就是当前遍历出的元素
	 */
	// @InsertProvider(method = "insertStuList", type =
	// StudentDynaSqlProvider.class)
	@Insert({ "<script> insert into tb_student6(cardid,stname,param1,param2,param3,param4,param5,param6,param7,param8,param9,param10)"
			+ "values "
			+ "<foreach collection=\"list\" item=\"item\" index=\"index\"  separator=\",\"> "
			+ "(#{item.cardid},#{item.stname},#{item.param1},#{item.param2},#{item.param3},#{item.param4},#{item.param5},#{item.param6},#{item.param7},#{item.param8},#{item.param9},#{item.param10})"
			+ "</foreach> </script>" })
	void insertInfoBatch(@Param("list") List<Student> studentList);

//	// 查询学生
//	@SelectProvider(type = StudentDynaSqlProvider.class, method = "selectWhitParam")
//	@Results({
//			@Result(id = true, column = "id", property = "id"),
//			@Result(column = "cardid", property = "cardid"),
//			@Result(column = "stname", property = "stname"),
//			@Result(column = "gender", property = "gender"),
//			@Result(column = "phone", property = "phone"),
//			@Result(column = "education_id", property = "education", one = @One(select = "org.fkit.fm.dao.EducationDao.selectById", fetchType = FetchType.EAGER)),
//			@Result(column = "grade_id", property = "grade", one = @One(select = "org.fkit.fm.dao.GradeDao.selectById", fetchType = FetchType.EAGER)),
//			@Result(column = "major_id", property = "major", one = @One(select = "org.fkit.fm.dao.MajorDao.selectById", fetchType = FetchType.EAGER)),
//			@Result(column = "clazznum_id", property = "clazznum", one = @One(select = "org.fkit.fm.dao.ClazznumDao.selectById", fetchType = FetchType.EAGER)) })
//	List<Student> selectByPage(Map<String, Object> params);
	
	// 查询学生
	@SelectProvider(type = StudentDynaSqlProvider.class, method = "selectWhitParam")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "cardid", property = "cardid"),
			@Result(column = "stname", property = "stname"),
			@Result(column = "param1", property = "param1"),
			@Result(column = "param2", property = "param2"),
			@Result(column = "param3", property = "param3"),
			@Result(column = "param4", property = "param4"),
			@Result(column = "param5", property = "param5"),
			@Result(column = "param6", property = "param6"),
			@Result(column = "param7", property = "param7"),
			@Result(column = "param8", property = "param8"),
			@Result(column = "param9", property = "param9"),
			@Result(column = "param10", property = "param10")})
	List<Student> selectByPage(Map<String, Object> params);

	// 根据参数查询总数
	@SelectProvider(type = StudentDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 添加学生
	@InsertProvider(type = StudentDynaSqlProvider.class, method = "insertStudent")
	void addStudent(Student student);

	// 通过id查询学生基本信息
	@Select("select * from " + STUDENTTABLE + " where id=#{id}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "cardid", property = "cardid"),
			@Result(column = "stname", property = "stname"),	
//			@Result(column = "gender", property = "gender"),
//			@Result(column = "phone", property = "phone"),
			@Result(column = "param1", property = "param1"),
			@Result(column = "param2", property = "param2"),
			@Result(column = "param3", property = "param3"),
			@Result(column = "param4", property = "param4"),
			@Result(column = "param5", property = "param5"),
			@Result(column = "param6", property = "param6"),
			@Result(column = "param7", property = "param7"),
			@Result(column = "param8", property = "param8"),
			@Result(column = "param9", property = "param9"),
			@Result(column = "param10", property = "param10"),
			@Result(column = "education_id", property = "education", one = @One(select = "org.fkit.fm.dao.EducationDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "grade_id", property = "grade", one = @One(select = "org.fkit.fm.dao.GradeDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "major_id", property = "major", one = @One(select = "org.fkit.fm.dao.MajorDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "clazznum_id", property = "clazznum", one = @One(select = "org.fkit.fm.dao.ClazznumDao.selectById", fetchType = FetchType.EAGER)) })
	Student selectStudentById(Integer id);

	// 编辑学生信息
	@UpdateProvider(type = StudentDynaSqlProvider.class, method = "updateStudent")
	void modifyStudent(Student student);

	// 删除学生
	@Delete("delete from " + STUDENTTABLE + " where id=#{id}")
	void delStudentById(Integer id);

	// 通过学生cardid查询档案
	@Select("select * from " + STUDENTTABLE + " where cardid=#{cardid}")
	Student findUiByCardid(String cardid);

	// 编辑学生档案信息
	@UpdateProvider(type = StudentDynaSqlProvider.class, method = "saveStuInfo")
	void saveUinfo(Student student);

	@Select("select * from " + STUDENTTABLE + " where cardid=#{cardid}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "cardid", property = "cardid"),
			@Result(column = "stname", property = "stname"),
			@Result(column = "gender", property = "gender"),
			@Result(column = "phone", property = "phone"),
			@Result(column = "education_id", property = "education", one = @One(select = "org.fkit.fm.dao.EducationDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "grade_id", property = "grade", one = @One(select = "org.fkit.fm.dao.GradeDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "major_id", property = "major", one = @One(select = "org.fkit.fm.dao.MajorDao.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "clazznum_id", property = "clazznum", one = @One(select = "org.fkit.fm.dao.ClazznumDao.selectById", fetchType = FetchType.EAGER)) })
	Student selectStudentByCardid(String cardid);

	@Select("select * from " + STUDENTTABLE + " where cardid=#{cardid}")
	Student findPiByCardid(String cardid);

	@UpdateProvider(type = StudentDynaSqlProvider.class, method = "savePartyInfo")
	void savePinfo(Student student);

	@InsertProvider(type = StudentDynaSqlProvider.class, method = "autoAddStudent")
	void autoAddStudent(Student student);
	
	//查询
	@SelectProvider( type = StudentDynaSqlProvider.class,method = "selectStudent")
	List<Student> selectStudent(Student student);
	

}
