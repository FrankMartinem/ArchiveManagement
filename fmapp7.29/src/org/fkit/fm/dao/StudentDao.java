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
	 * ��������
	 * 
	 * @param studentList
	 *            collection�� ָ��Ҫ�����ļ��ϣ�������� list��array��map�� ��������������ʹ��ע��sql������£���������дmapper�����м��ϵ�����
	 *            item������ǰ��������Ԫ�ظ�ֵ��ָ���ı��� ���൱��forѭ���е�i�� separator:ÿ��Ԫ��֮��ķָ���
	 *            open�����������н��ƴ��һ����ʼ���ַ� close:���������н��ƴ��һ���������ַ�
	 *            index:����������list��ʱ����index����������item���ǵ�ǰֵ
	 *            #{������}����ȡ��������ֵҲ���ǵ�ǰ��������Ԫ��
	 */
	// @InsertProvider(method = "insertStuList", type =
	// StudentDynaSqlProvider.class)
	@Insert({ "<script> insert into tb_student6(cardid,stname,param1,param2,param3,param4,param5,param6,param7,param8,param9,param10)"
			+ "values "
			+ "<foreach collection=\"list\" item=\"item\" index=\"index\"  separator=\",\"> "
			+ "(#{item.cardid},#{item.stname},#{item.param1},#{item.param2},#{item.param3},#{item.param4},#{item.param5},#{item.param6},#{item.param7},#{item.param8},#{item.param9},#{item.param10})"
			+ "</foreach> </script>" })
	void insertInfoBatch(@Param("list") List<Student> studentList);

//	// ��ѯѧ��
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
	
	// ��ѯѧ��
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

	// ���ݲ�����ѯ����
	@SelectProvider(type = StudentDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// ���ѧ��
	@InsertProvider(type = StudentDynaSqlProvider.class, method = "insertStudent")
	void addStudent(Student student);

	// ͨ��id��ѯѧ��������Ϣ
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

	// �༭ѧ����Ϣ
	@UpdateProvider(type = StudentDynaSqlProvider.class, method = "updateStudent")
	void modifyStudent(Student student);

	// ɾ��ѧ��
	@Delete("delete from " + STUDENTTABLE + " where id=#{id}")
	void delStudentById(Integer id);

	// ͨ��ѧ��cardid��ѯ����
	@Select("select * from " + STUDENTTABLE + " where cardid=#{cardid}")
	Student findUiByCardid(String cardid);

	// �༭ѧ��������Ϣ
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
	
	//��ѯ
	@SelectProvider( type = StudentDynaSqlProvider.class,method = "selectStudent")
	List<Student> selectStudent(Student student);
	

}
