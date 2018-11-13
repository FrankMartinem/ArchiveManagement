package org.fkit.fm.dao;

import static org.fkit.fm.util.commom.FmConstants.EDUCATIONTEBLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.fm.domain.Education;

public interface EducationDao {
	@Select("select * from "+EDUCATIONTEBLE+" ")
	List<Education> selectAllEducation();
	
	@Select("select * from "+EDUCATIONTEBLE+" where id=#{id}")
	List<Education> selectById(Integer id);
	
}
