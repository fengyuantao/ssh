package com.spring.domain;

public class Customer {

	private int cid;
	private String cname;
	//private String clevel;
	//private String sourceFrom;
	private String linkMan;
	private String officePhone;
	private String mobilePhone;
	//引用关联的数据字典对象
	private BaseDict clevel;
	private BaseDict sourceFrom;
	private BaseDict cust_industry;//客户行业
	
	public BaseDict getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(BaseDict cust_industry) {
		this.cust_industry = cust_industry;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public BaseDict getClevel() {
		return clevel;
	}
	public void setClevel(BaseDict clevel) {
		this.clevel = clevel;
	}

	public BaseDict getSourceFrom() {
		return sourceFrom;
	}
	public void setSourceFrom(BaseDict sourceFrom) {
		this.sourceFrom = sourceFrom;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", linkMan=" + linkMan + ", officePhone=" + officePhone
				+ ", mobilePhone=" + mobilePhone + ", clevel=" + clevel + ", sourceFrom=" + sourceFrom
				+ ", cust_industry=" + cust_industry + "]";
	}
	
}
