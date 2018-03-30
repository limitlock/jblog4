package com.cafe24.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private Long postNum;
	private String content;
	private Long blogNo;
	private String id;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPostNum() {
		return postNum;
	}

	public void setPostNum(Long postNum) {
		this.postNum = postNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryVo ['no'=" + no + ", 'name'=" + name + ", 'postNum'=" + postNum + ", 'content'=" + content + ", 'blogNo'="
				+ blogNo + "]";
	}

}
