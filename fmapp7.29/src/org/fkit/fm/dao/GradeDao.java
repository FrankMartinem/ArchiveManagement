package org.fkit.fm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.fm.domain.Grade;

import static org.fkit.fm.util.commom.FmConstants.GRADETABLE;
public interface GradeDao {
	//��ѯ�����꼶
	@Select("select * from "+GRADETABLE+" ")
	List<Grade> selectAllGrade();
	
	@Select("select * from "+GRADETABLE+" where id=#{id}")
	List<Grade> selectById(Integer id);

}
