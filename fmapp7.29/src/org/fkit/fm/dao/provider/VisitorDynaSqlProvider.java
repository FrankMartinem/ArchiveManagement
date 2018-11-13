package org.fkit.fm.dao.provider;

import static org.fkit.fm.util.commom.FmConstants.BACKTABLE;
import static org.fkit.fm.util.commom.FmConstants.VISITORTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.fm.domain.Back;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.Visitor;

public class VisitorDynaSqlProvider {
	//查询借阅信息
	public String selectVisitor(Visitor vs){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(VISITORTABLE);
				if(vs.getVisitorName()!= null && !vs.getVisitorName().equals("")){
					WHERE("visitorName = #{visitorName}");
				}
				if(vs.getSname()!= null && !vs.getSname().equals("")){
					WHERE("sname = #{sname}");
				}
				if(vs.getDate()!= null && !vs.getDate().equals("")){
					WHERE("date = #{date}");
				}
				if(vs.getSid()!= null && !vs.getSid().equals("")){
					WHERE("sid = #{sid}");
				}
			}
		}.toString();
		return sql;
	}
	
	
	
	//新增借阅人信息
	public String insertVisitor(Visitor vs){
		return new SQL() {
			{
				INSERT_INTO(VISITORTABLE);
				if (vs.getSname() != null) {
					VALUES("sname", "#{sname}");
				}
				if (vs.getSid()!= null) {
					VALUES("sid", "#{sid}");
				}
				if (vs.getVisitorName() != null) {
					VALUES("visitorName", "#{visitorName}");
				}
				if (vs.getVisitorPhone() != null) {
					VALUES("visitorPhone", "#{visitorPhone}");
				}
				if (vs.getUnifoType() != null) {
					VALUES("unifoType", "#{unifoType}");
				}
				if (vs.getDate() != null) {
					VALUES("date", "#{date}");
				}
				if (vs.getBackdate() != null) {
					VALUES("backdate", "#{backdate}");
				}
				if (vs.getRemark() != null) {
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}
	
	//更新归还时间
	public String updateVisitor(Visitor vs){
		return new SQL(){
			{
				UPDATE(VISITORTABLE);
				if(vs.getBackdate() != null){
					SET(" backdate = #{backdate} ");
				}
				WHERE("sid=#{sid} AND unifoType =#{unifoType}");
			}
		}.toString();
	}
	
	//新增归还人信息
		public String insertBack(Back back){
			return new SQL() {
				{
					INSERT_INTO(BACKTABLE);
					if (back.getSname() != null) {
						VALUES("sname", "#{sname}");
					}
					if (back.getSid()!= null) {
						VALUES("sid", "#{sid}");
					}
					if (back.getBackName() != null) {
						VALUES("backName", "#{backName}");
					}
					if (back.getBackPhone() != null) {
						VALUES("backPhone", "#{backPhone}");
					}
					if (back.getUnifoType() != null) {
						VALUES("unifoType", "#{unifoType}");
					}
					if (back.getBackdate() != null) {
						VALUES("backdate", "#{backdate}");
					}
				}
			}.toString();
		}
		
}
