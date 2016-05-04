package com.xbmu.bean;

import java.io.Serializable;
import java.util.Date;
/**
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(255) NOT NULL,
  `post_text` varchar(255) NOT NULL,
  `post_date` date NOT NULL,
  `thx_cnt` int(10) unsigned NOT NULL DEFAULT '0',
  `owner_id` int(11) NOT NULL,
  `kind_id` int(11) NOT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `owner_id` (`owner_id`),
  KEY `kind_id` (`kind_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
//每个资源
public class Post implements Serializable {
	// 标识属性
	private Integer post_id;
	// 标题
	private String post_title;
	// 内容
	private String post_text;
	// 发布日期
	private Date post_date;
	// 感谢数
	private Integer thx_cnt;
	// 图片链接
	private String img_url;
	// 资源拥有者
	private Integer owner_id;
	// 资源种类
	private Integer kind_id;

	public Post()
	{
		super();
	}
	
	public Post(String post_title, String post_text, String img_url)
	{
			super();
			this.post_title = post_title;
			this.post_text = post_text;
			this.img_url = img_url;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public Integer getThx_cnt() {
		return thx_cnt;
	}

	public void setThx_cnt(Integer thx_cnt) {
		this.thx_cnt = thx_cnt;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public Integer getKind_id() {
		return kind_id;
	}

	public void setKind_id(Integer kind_id) {
		this.kind_id = kind_id;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}