package crm.stud.domain;

import crm.clazz.domain.CrmClass;
import crm.course.domain.CrmCourseType;

public class CrmStudent {

	private String stuId;
	private String gender;
	private String stuName;
	private String qq;
	private Integer phoneNum;
	private String totalpay;
	private String payd;
	private String idCard;
	private String email;
	private String school;
	private String degere;
	private String major;
	private String idCardAddr;
	private String bjAddr;
	private String remark;
	private String homeNum;//
	private String emergNum;//
	private String status;
	private CrmClass crmClass;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPayd() {
		return payd;
	}

	public void setPayd(String payd) {
		this.payd = payd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public CrmClass getCrmClass() {
		return crmClass;
	}

	public void setCrmClass(CrmClass crmClass) {
		this.crmClass = crmClass;
	}

	public String getGender() {
		return gender;
	}

	public String getTotalpay() {
		return totalpay;
	}

	public String getIdCard() {
		return idCard;
	}

	public String getEmail() {
		return email;
	}

	public String getSchool() {
		return school;
	}

	public String getDegere() {
		return degere;
	}

	public String getMajor() {
		return major;
	}

	public String getIdCardAddr() {
		return idCardAddr;
	}

	public String getBjAddr() {
		return bjAddr;
	}

	public String getRemark() {
		return remark;
	}

	public String getHomeNum() {
		return homeNum;
	}

	public String getEmergNum() {
		return emergNum;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTotalpay(String totalpay) {
		this.totalpay = totalpay;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setDegere(String degere) {
		this.degere = degere;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setIdCardAddr(String idCardAddr) {
		this.idCardAddr = idCardAddr;
	}

	public void setBjAddr(String bjAddr) {
		this.bjAddr = bjAddr;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setHomeNum(String homeNum) {
		this.homeNum = homeNum;
	}

	public void setEmergNum(String emergNum) {
		this.emergNum = emergNum;
	}

}
