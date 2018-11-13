package org.fkit.fm.dao;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.fm.dao.provider.UserDynaSqlProvider;
import org.fkit.fm.domain.User;

import static org.fkit.fm.util.commom.FmConstants.USERTABLE;


public interface UserDao {

	@InsertProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);

//	@SelectProvider(type=UserDynaSqlProvider.class,method="selectUser")
//	void find(User user);
	@Select("select * from "+USERTABLE+" where id=#{id}")
	User findUser(String id);

	@Select("select * from "+USERTABLE+" where id=#{id} and password=#{password}")
	User selectByIdAndPassword(@Param("id") String id, @Param("password") String password);

	
}
