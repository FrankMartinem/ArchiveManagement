package org.fkit.fm.dao.provider;


import static org.fkit.fm.util.commom.FmConstants.STUDENTTABLE;
import static org.fkit.fm.util.commom.FmConstants.VISITORTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.Visitor;

public class StudentDynaSqlProvider {
	
	/*//批量添加
	public String insertStuList(Map map){
		List<Student> studentList=(List<Student>) map.get("studentList");
		return new SQL(){
			{
				INSERT_INTO (STUDENTTABLE);
				for(int i=0;i<studentList.size();i++){
					VALUES("cardid", "#{cardid}");
				}
			}
		}.toString();
	}*/
	
	
	//添加学生
	public String insertStudent(Student student){
		return new SQL(){
			
			{
				INSERT_INTO(STUDENTTABLE);
				if(student.getCardid() != null){
					VALUES("cardid", "#{cardid}");
				}	
				if(student.getStname() != null){
					VALUES("stname", "#{stname}");
				}	
				if(student.getParty() != null){
					VALUES("party", "#{party}");
				}			
				if(student.getParam1() != null){
					VALUES("param1", "#{param1}");
				}
				if(student.getParam2() != null){
					VALUES("param2", "#{param2}");
				}
				if(student.getParam3() != null){
					VALUES("param3", "#{param3}");
				}
				if(student.getParam4() != null){
					VALUES("param4", "#{param4}");
				}
				if(student.getParam5() != null){
					VALUES("param5", "#{param5}");
				}
				if(student.getParam6() != null){
					VALUES("param6", "#{param6}");
				}
				if(student.getParam7() != null){
					VALUES("param7", "#{param7}");
				}
				if(student.getParam8() != null){
					VALUES("param8", "#{param8}");
				}
				if(student.getParam9() != null){
					VALUES("param9", "#{param9}");
				}
				if(student.getParam10() != null){
					VALUES("param10", "#{param10}");
				}
			}
		}.toString();
	}
	
	//查询学生
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(STUDENTTABLE);
				if(params.get("student") != null){
					Student student = (Student)params.get("student");
//					if(student.getEducation() != null && student.getEducation().getId() != null && student.getEducation().getId() != 0){
//						WHERE(" education_id = #{student.education.id} ");
//					}
//					if(student.getGrade() != null && student.getGrade().getId() != null && student.getGrade().getId() != 0){
//						WHERE(" grade_id = #{student.grade.id} ");
//					}
//					if(student.getMajor() != null && student.getMajor().getId() != null && student.getMajor().getId() != 0){
//						WHERE(" major_id = #{student.major.id} ");
//					}
//					if(student.getClazznum() != null && student.getClazznum().getId() != null && student.getClazznum().getId() != 0){
//						WHERE(" clazznum_id = #{student.clazznum.id} ");
//					}
					if(student.getStname() != null && !student.getStname().equals("")){
						/*WHERE("  stname LIKE CONCAT(CONCAT ('%',#{student.stname}),'%') ");*/
						WHERE("  stname LIKE CONCAT ('%',#{student.stname},'%') ");
					}
					if(student.getCardid() != null && !student.getCardid().equals("")){
						WHERE(" cardid LIKE CONCAT ('%',#{student.cardid},'%') ");
					}
//					if(student.getClazzname() != null && !student.getClazzname().equals("")){
//						WHERE("  clazzname LIKE CONCAT ('%',#{student.clazzname},'%') ");
//					}
					if(student.getParam1() != null && !student.getParam1().equals("")){
						WHERE("  param1 LIKE CONCAT ('%',#{student.param1},'%') ");
					}
					if(student.getParam2() != null && !student.getParam2().equals("")){
						WHERE("  param2 LIKE CONCAT ('%',#{student.param2},'%') ");
					}
					if(student.getParam3() != null && !student.getParam3().equals("")){
						WHERE("  param3 LIKE CONCAT ('%',#{student.param3},'%') ");
					}
					if(student.getParam4() != null && !student.getParam4().equals("")){
						WHERE("  param4 LIKE CONCAT ('%',#{student.param4},'%') ");
					}
					if(student.getParam5() != null && !student.getParam5().equals("")){
						WHERE("  param5 LIKE CONCAT ('%',#{student.param5},'%') ");
					}
					if(student.getParam6() != null && !student.getParam6().equals("")){
						WHERE("  param6 LIKE CONCAT ('%',#{student.param6},'%') ");
					}
					if(student.getParam7() != null && !student.getParam7().equals("")){
						WHERE("  param7 LIKE CONCAT ('%',#{student.param7},'%') ");
					}
					if(student.getParam8() != null && !student.getParam8().equals("")){
						WHERE("  param8 LIKE CONCAT ('%',#{student.param8},'%') ");
					}
					if(student.getParam9() != null && !student.getParam9().equals("")){
						WHERE("  param9 LIKE CONCAT ('%',#{student.param9},'%') ");
					}
					if(student.getParam10() != null && !student.getParam10().equals("")){
						WHERE("  param10 LIKE CONCAT ('%',#{student.param10},'%') ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
		public String count(Map<String, Object> params){
			return new SQL(){
				{
					SELECT("count(*)");
					FROM(STUDENTTABLE);
					if(params.get("student") != null){
						Student student = (Student)params.get("student");
						if(student.getStname() != null && !student.getStname().equals("")){
							WHERE("  stname LIKE CONCAT ('%',#{student.stname},'%') ");
						}
						if(student.getCardid() != null && !student.getCardid().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.cardid},'%') ");
						}
						if(student.getParam1() != null && !student.getParam1().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param1},'%') ");
						}
						if(student.getParam2() != null && !student.getParam2().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param2},'%') ");
						}
						if(student.getParam3() != null && !student.getParam3().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param3},'%') ");
						}
						if(student.getParam4() != null && !student.getParam4().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param4},'%') ");
						}
						if(student.getParam5() != null && !student.getParam5().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param5},'%') ");
						}
						if(student.getParam6() != null && !student.getParam6().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param6},'%') ");
						}
						if(student.getParam7() != null && !student.getParam7().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param7},'%') ");
						}
						if(student.getParam8() != null && !student.getParam8().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param8},'%') ");
						}
						if(student.getParam9() != null && !student.getParam9().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param9},'%') ");
						}
						if(student.getParam10() != null && !student.getParam10().equals("")){
							WHERE(" cardid LIKE CONCAT ('%',#{student.param10},'%') ");
						}
//						if(student.getClazzname() != null && !student.getClazzname().equals("")){
//							WHERE("  clazzname LIKE CONCAT ('%',#{student.clazzname},'%') ");
//						}
//						if(student.getParty() != null && !student.getParty().equals("")){
//							WHERE("  party LIKE CONCAT ('%',#{student.party},'%') ");
//						}
					}
				}
			}.toString();
		}	
		
		//编辑学生
		public String updateStudent(Student student){
			return new SQL(){
				{
					UPDATE(STUDENTTABLE);
					System.out.println("进入编辑");
					if(student.getCardid()!= null){
						SET(" cardid = #{cardid} ");
					}
					if(student.getStname()!= null){
						SET(" stname = #{stname} ");
					}
					if(student.getParty()!= null){
						SET(" party = #{party} ");
					}
					if(student.getParam1() != null){
						SET(" param1 = #{param1} ");
					}
					if(student.getParam2() != null){
						SET(" param2 = #{param2} ");
					}
					if(student.getParam3() != null){
						SET(" param3 = #{param3} ");
					}
					if(student.getParam4() != null){
						SET(" param4 = #{param4} ");
					}
					if(student.getParam5() != null){
						SET(" param5 = #{param5} ");
					}
					if(student.getParam6() != null){
						SET(" param6 = #{param6} ");
					}
					if(student.getParam7() != null){
						SET(" param7 = #{param7} ");
					}
					if(student.getParam8() != null){
						SET(" param8 = #{param8} ");
					}
					if(student.getParam9() != null){
						SET(" param9 = #{param9} ");
					}
					if(student.getParam10() != null){
						SET(" param10 = #{param10} ");
					}
					if(student.getUinfo() != null){
						SET(" uinfo = #{uinfo} ");
					}
					if(student.getUdate() != null){
						SET(" udate = #{udate} ");
					}
					if(student.getState() != null){
						SET(" state = #{state} ");
					}
					if(student.getPstate() != null){
						SET(" pstate = #{pstate} ");
					}
					if(student.getSummary()!= null){
						SET(" summary = #{summary} ");
					}
					if(student.getImage()!= null){
						SET(" image = #{image} ");
					}

//					if(student.getEducation() != null){
//						SET(" education_id = #{education.id} ");
//					}
//					if(student.getGrade() != null){
//						SET(" grade_id = #{grade.id} ");
//					}
//					if(student.getMajor() != null){
//						SET(" major_id = #{major.id} ");
//					}
//					if(student.getClazznum() != null){
//						SET(" clazznum_id = #{clazznum.id} ");
//					}				
					WHERE("id=#{id}");
				}
			}.toString();
		}
		
		//保存学生档案信息
		public String saveStuInfo(Student student){
			return new SQL(){
				{
					UPDATE(STUDENTTABLE);
					//if(student.getUinfo()!=null){
						SET("uinfo=#{uinfo}");
					//}
					if(student.getUdate()!=null){
						SET("udate=#{udate}");
					}
					if(student.getSummary()!=null){
						SET("summary=#{summary}");
					}
					WHERE ("cardid=#{cardid}");	
				}
				
			}.toString();
		}
		
		
		//保存党建档案信息
			public String savePartyInfo(Student student){
				return new SQL(){
					{
						UPDATE(STUDENTTABLE);
						//if(student.getUinfo()!=null){
							SET("pinfo=#{pinfo}");
						//}
						if(student.getPdate()!=null){
							SET("pdate=#{pdate}");
						}
						if(student.getInto_report()!=null){
							SET("into_report=#{into_report}");
						}
						if(student.getPre_report()!=null){
							SET("pre_report=#{pre_report}");
						}
						WHERE ("cardid=#{cardid}");	
					}
						
				}.toString();
			}
		
		//添加学生
		public String autoAddStudent(Student student){
			return new SQL(){
				
				{
					INSERT_INTO(STUDENTTABLE);
					if(student.getCardid() != null){
						VALUES("cardid", "#{cardid}");
					}	
					if(student.getStname() != null){
						VALUES("stname", "#{stname}");
					}	
					if(student.getParty() != null){
						VALUES("party", "#{party}");
					}			
					if(student.getParam1() != null){
						VALUES("param1", "#{param1}");
					}
					if(student.getParam2() != null){
						VALUES("param2", "#{param2}");
					}
					if(student.getParam3() != null){
						VALUES("param3", "#{param3}");
					}
					if(student.getParam4() != null){
						VALUES("param4", "#{param4}");
					}
					if(student.getParam5() != null){
						VALUES("param5", "#{param5}");
					}
					if(student.getParam6() != null){
						VALUES("param6", "#{param6}");
					}
					if(student.getParam7() != null){
						VALUES("param7", "#{param7}");
					}
					if(student.getParam8() != null){
						VALUES("param8", "#{param8}");
					}
					if(student.getParam9() != null){
						VALUES("param9", "#{param9}");
					}
					if(student.getParam10() != null){
						VALUES("param10", "#{param10}");
					}
					if(student.getImage() != null){
						VALUES("image", "#{image}");
					}
				}
			}.toString();
		}
		
		//查询借阅信息
		public String selectStudent(Student student){
			String sql =  new SQL(){
				{
					SELECT("*");
					FROM(STUDENTTABLE);
				}
			}.toString();
			return sql;
		}
}
