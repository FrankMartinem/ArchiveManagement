package org.fkit.fm.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User implements Serializable {
	@NotBlank(message="用户名不能为空")
	public String username;
	
	@NotBlank(message="学号或教工号不能为空")
	public String id;
	
	@NotBlank(message="密码不能为空")
	@Length(min=6,message="密码长度必须大于六位")
	public String password;
	
	public String repassword;
	
	@Pattern(regexp="[1][3|4|5|7|8|9][0-9]{9}",message="无效的手机号码")
	public String phone;
	
	@Email(message="必须是合法的邮箱地址")
	public String email;
	
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
