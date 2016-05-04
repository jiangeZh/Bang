package com.xbmu.business;

import java.util.Date;

public class PostBean
{
	// 标识属性
	private Integer postId;
	// 标题
	private String postTitle;
	// 内容
	private String postText;
	// 发布日期
	private Date postDate;
	// 感谢数
	private Integer thxCnt;
	// 图片链接
	private String imgUrl;
	// 资源拥有者
	private String owner;
	// 资源种类
	private String kind;
	
	public PostBean()
	{
	}

	public PostBean(Integer postId, String postTitle, String postText, 
			Date postDate, Integer thxCnt, String imgUrl, String owner, 
			String kind)
	{
		this.postId = postId;
		this.postTitle = postTitle;
		this.postText = postText;
		this.postDate = postDate;
		this.thxCnt = thxCnt;
		this.imgUrl = imgUrl;
		this.setOwner(owner);
		this.setKind(kind);
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getThxCnt() {
		return thxCnt;
	}

	public void setThxCnt(Integer thxCnt) {
		this.thxCnt = thxCnt;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}