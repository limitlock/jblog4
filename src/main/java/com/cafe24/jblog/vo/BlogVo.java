package com.cafe24.jblog.vo;

public class BlogVo {

	private Long no;
	private String title;
	private String logo;
	private Long userNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", logo=" + logo + ", userNo=" + userNo + "]";
	}

}
