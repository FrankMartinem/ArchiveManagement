package org.fkit.fm.dao;

import static org.fkit.fm.util.commom.FmConstants.STUDENTTABLE;
import static org.fkit.fm.util.commom.FmConstants.BACKTABLE;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.fkit.fm.dao.provider.StudentDynaSqlProvider;
import org.fkit.fm.dao.provider.VisitorDynaSqlProvider;
import org.fkit.fm.domain.Back;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.Visitor;

public interface VisitorDao {
	
	//增添借阅人
	@InsertProvider(type=VisitorDynaSqlProvider.class,method="insertVisitor")
	void addVisitor(Visitor vs);
	
	//查询借阅记录
	@SelectProvider( type = VisitorDynaSqlProvider.class,method = "selectVisitor")
	List<Visitor> selectVisitor(Visitor vs);
	
//	@UpdateProvider(type = VisitorDynaSqlProvider.class, method = "updateVisitor")
//	void updateVisitor(Visitor vs);

	
	@InsertProvider(type=VisitorDynaSqlProvider.class,method="insertBack")
	void addBack(Back back);

	@Select(("select * from " + BACKTABLE + " where sid=#{sid} and unifoType=#{unifoType}") )
	Back selectBack(String sid, String unifoType);

	@UpdateProvider(type = VisitorDynaSqlProvider.class, method = "updateVisitor")
	void modifyVisitor(Visitor vs);
}
