package com.xbmu.bean;

import java.io.Serializable;
import java.util.Date;

/**
CREATE TABLE `resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(255) NOT NULL,
  `res_desc` varchar(255) NOT NULL,
  `res_url` varchar(255) NOT NULL,
  `res_size` double NOT NULL,
  `upload_date` date NOT NULL,
  `download_cnt` int(11) NOT NULL DEFAULT '0',
  `is_encrypt` int(11) NOT NULL DEFAULT '0',
  `password` varchar(50) DEFAULT NULL,
  `owner_id` int(11) NOT NULL,
  `kind_id` int(11) NOT NULL,
  `teacher_name` varchar(50) DEFAULT NULL,
  `lesson_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `owner_id` (`owner_id`),
  KEY `kind_id` (`kind_id`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `resource_ibfk_2` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 */
//每个资源
public class Resource implements Serializable {
	// 标识属性
	private Integer res_id;
	// 名称
	private String res_name;
	// 描述
	private String res_desc;
	// url
	private String res_url;
	// 资源大小
	private double res_size;
	// 上传日期
	private Date upload_date;
	// 下载量
	private Integer download_cnt;
	// 是否加密
	private Integer is_encrypt;
	// 密码
	private String password;
	// 资源拥有者
	private Integer owner_id;
	// 资源种类
	private Integer kind_id;
	
	private String teacher_name;
	
	private String lesson_name;

	public Resource()
	{
		super();
	}
	
	public Resource(String res_name, String res_desc, String res_url, 
			double res_size, Integer is_encrypt, String password)
	{
			super();
			this.res_name = res_name;
			this.res_desc = res_desc;
			this.res_url = res_url;
			this.res_size = res_size;
			this.upload_date = upload_date;
			this.download_cnt = download_cnt;
			this.is_encrypt = is_encrypt;
			this.password = password;
	}

	public Integer getRes_id() {
		return res_id;
	}

	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_desc() {
		return res_desc;
	}

	public void setRes_desc(String res_desc) {
		this.res_desc = res_desc;
	}

	public String getRes_url() {
		return res_url;
	}

	public void setRes_url(String res_url) {
		this.res_url = res_url;
	}

	public double getRes_size() {
		return res_size;
	}

	public void setRes_size(double res_size) {
		this.res_size = res_size;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public Integer getDownload_cnt() {
		return download_cnt;
	}

	public void setDownload_cnt(Integer download_cnt) {
		this.download_cnt = download_cnt;
	}

	public Integer getIs_encrypt() {
		return is_encrypt;
	}

	public void setIs_encrypt(Integer is_encrypt) {
		this.is_encrypt = is_encrypt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}
}