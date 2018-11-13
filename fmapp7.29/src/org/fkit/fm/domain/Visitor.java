package org.fkit.fm.domain;

import java.io.Serializable;

public class Visitor implements Serializable{
	private Integer id;
	private String sname;
	private String sid;
	private String visitorName;
	private String visitorPhone;
	private String date;
	private String backdate;
	private String unifoType;
	private String remark;
	
	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public Visitor(String visitorName, String visitorPhone, String date,
//			String sname, String education, String major, String clazz,
//			String unifoType) {
//		super();
//		this.visitorName = visitorName;
//		this.visitorPhone = visitorPhone;
//		this.date = date;
//		this.sname = sname;
//		this.unifoType = unifoType;
//	}
	
	public String getVisitorName() {
		return visitorName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getVisitorPhone() {
		return visitorPhone;
	}
	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getBackdate() {
		return backdate;
	}

	public void setBackdate(String backdate) {
		this.backdate = backdate;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getUnifoType() {
		return unifoType;
	}
	public void setUnifoType(String unifoType) {
		this.unifoType = unifoType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
