package org.fkit.fm.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.fm.domain.User;
import static org.fkit.fm.util.commom.FmConstants.USERTABLE;
public class UserDynaSqlProvider {
	

	public String insertUser(User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(user.getId() != null && !user.getId().equals("")){
					VALUES("id", "#{id}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(user.getRepassword() != null && !user.getRepassword().equals("")){
					VALUES("repassword", "#{repassword}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")){
					VALUES("phone", "#{password}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")){
					VALUES("email", "#{email}");
				}
			}
		}.toString();
	}
		
//		public String selectUser(User user){
//			return new SQL(){
//				{
//					SELECT("*");
//					FROM("tb_user");
//					if(user.getId() != null){
//						WHERE("id =# {user.getId()}");
//					}
//				}
//			}.toString();
//	}
	
	
}
