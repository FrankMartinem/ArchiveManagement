package org.fkit.fm.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.fkit.fm.domain.User;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperLogInterceptor {
	@AfterReturning(pointcut="execution(*org.fkit.fm.StudentController.editUndergraduate(..)")
	public void log(User user){
		//获取归档人
		String username = user.getUsername();
		//获取归档日期
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String datenow = dateFormat.format(now); 
		System.out.println("归档人:"+username+",归档日期："+datenow);
	}
}
