package org.fkit.fm.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User implements Serializable {
	@NotBlank(message="�û�������Ϊ��")
	public String username;
	
	@NotBlank(message="ѧ�Ż�̹��Ų���Ϊ��")
	public String id;
	
	@NotBlank(message="���벻��Ϊ��")
	@Length(min=6,message="���볤�ȱ��������λ")
	public String password;
	
	public String repassword;
	
	@Pattern(regexp="[1][3|4|5|7|8|9][0-9]{9}",message="��Ч���ֻ�����")
	public String phone;
	
	@Email(message="�����ǺϷ��������ַ")
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
