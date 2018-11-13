package org.fkit.fm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.fm.domain.Clazznum;

import static org.fkit.fm.util.commom.FmConstants.CLAZZNUMTABLE;

public interface ClazznumDao {
	@Select("select * from "+CLAZZNUMTABLE+" ")
	List<Clazznum> selectAllClazznum();
	
	@Select("select * from "+CLAZZNUMTABLE+" where id=#{id}")
	List<Clazznum> selectById(Integer id);
}
