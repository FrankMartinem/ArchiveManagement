package org.fkit.fm.dao.provider;

import static org.fkit.fm.util.commom.FmConstants.PROPERTYTABLE;
import static org.fkit.fm.util.commom.FmConstants.STUDENTTABLE;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.fm.domain.MyProperty;
import org.fkit.fm.domain.Student;

public class PropertyDynaSqlProvider {
	//添加设置属性
		public String insertProperty(MyProperty property){
			return new SQL(){
				{
					INSERT_INTO(PROPERTYTABLE);					
					if(property.getProperty1() != null){
						VALUES("property1", "#{property1}");
					}
					if(property.getProperty2() != null){
						VALUES("property2", "#{property2}");
					}
					if(property.getProperty3() != null){
						VALUES("property3", "#{property3}");
					}
					if(property.getProperty4() != null){
						VALUES("property4", "#{property4}");
					}
					if(property.getProperty5() != null){
						VALUES("property5", "#{property5}");
					}
					if(property.getProperty6() != null){
						VALUES("property6", "#{property6}");
					}
					if(property.getProperty7() != null){
						VALUES("property7", "#{property7}");
					}
					if(property.getProperty8() != null){
						VALUES("property8", "#{property8}");
					}
					if(property.getProperty9() != null){
						VALUES("property9", "#{property9}");
					}
					if(property.getProperty10() != null){
						VALUES("property10", "#{property10}");
					}		
					if(property.getPlookup() != null){
						VALUES("plookup", "#{plookup}");
					}	
				}
			}.toString();
		}
		
		//编辑学生
		public String updateProperty(MyProperty property){
			return new SQL(){
				{
					UPDATE(PROPERTYTABLE);
					//if(property.getProperty1()!= null){
						SET(" property1 = #{property1} ");
					//}
					//if(property.getProperty2()!= null){
						SET(" property2 = #{property2} ");
					//}
					//if(property.getProperty3()!= null){
						SET(" property3 = #{property3} ");
					//}
					//if(property.getProperty4() != null){
						SET(" property4 = #{property4} ");
					//}
					//if(property.getProperty5() != null){
						SET(" property5 = #{property5} ");
					//}
					//if(property.getProperty6() != null){
						SET(" property6 = #{property6} ");
					//}
					//if(property.getProperty7() != null){
						SET(" property7 = #{property7} ");
					//}
					//if(property.getProperty8() != null){
						SET(" property8 = #{property8} ");
					//}
					//if(property.getProperty9() != null){
						SET(" property9 = #{property9} ");
					//}
					//if(property.getProperty10() != null){
						SET(" property10 = #{property10} ");
					//}
					//if(property.getPlookup() != null){
						SET(" plookup = #{plookup} ");
					//}
					WHERE("id = #{id}");
				}
			}.toString();
		}
}
