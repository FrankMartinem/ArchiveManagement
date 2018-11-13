package org.fkit.fm.dao;

import static org.fkit.fm.util.commom.FmConstants.MAJORTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.fm.domain.Major;

public interface MajorDao {

	@Select("select * from "+MAJORTABLE+" ")
	List<Major> selectAllMajor();
	
	@Select("select * from "+MAJORTABLE+" where id=#{id}")
	List<Major> selectById(Integer id);

}
