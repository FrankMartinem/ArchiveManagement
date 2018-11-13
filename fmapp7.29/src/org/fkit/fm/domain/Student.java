package org.fkit.fm.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Student {
	private Integer id;
	private String cardid;//学号或工号
	private String stname;//姓名
	private String party;
//	private String phone;
//	private String clazzname;
//	private String party;
//	private String location;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	private String param10;
	
	private String summary;
	private String uinfo;
	private List<String> undergraduateInfo;
	private String udate;
	private String state;
	private String pstate;
	private List<String> partyInfo;
	private String pinfo;
	private String into_report;
	private String pre_report;
	private String pdate;
	private String remark;
	private Education education;
	private Grade grade;
	private Major major;
	private Clazznum clazznum;
	
	private String image;
	private MultipartFile imageFile;
	
	public Student() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public String getClazzname() {
//		return clazzname;
//	}
//	public void setClazzname(String clazzname) {
//		this.clazzname = clazzname;
//	}
//	public String getParty() {
//		return party;
//	}
//	public void setParty(String party) {
//		this.party = party;
//	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
			
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam4() {
		return param4;
	}
	public void setParam4(String param4) {
		this.param4 = param4;
	}
	public String getParam5() {
		return param5;
	}
	public void setParam5(String param5) {
		this.param5 = param5;
	}
	public String getParam6() {
		return param6;
	}
	public void setParam6(String param6) {
		this.param6 = param6;
	}
	public String getParam7() {
		return param7;
	}
	public void setParam7(String param7) {
		this.param7 = param7;
	}
	public String getParam8() {
		return param8;
	}
	public void setParam8(String param8) {
		this.param8 = param8;
	}
	public String getParam9() {
		return param9;
	}
	public void setParam9(String param9) {
		this.param9 = param9;
	}
	public String getParam10() {
		return param10;
	}
	public void setParam10(String param10) {
		this.param10 = param10;
	}
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Clazznum getClazznum() {
		return clazznum;
	}
	public void setClazznum(Clazznum clazznum) {
		this.clazznum = clazznum;
	}
	public String getUinfo() {
		return uinfo;
	}
	public void setUinfo(String uinfo) {
		this.uinfo = uinfo;
	}
	public List<String> getUndergraduateInfo() {
		return undergraduateInfo;
	}
	public void setUndergraduateInfo(List<String> undergraduateInfo) {
		this.undergraduateInfo = undergraduateInfo;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPstate() {
		return pstate;
	}
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	public List<String> getPartyInfo() {
		return partyInfo;
	}
	public void setPartyInfo(List<String> partyInfo) {
		this.partyInfo = partyInfo;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public String getInto_report() {
		return into_report;
	}
	public void setInto_report(String into_report) {
		this.into_report = into_report;
	}
	public String getPre_report() {
		return pre_report;
	}
	public void setPre_report(String pre_report) {
		this.pre_report = pre_report;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	
}
