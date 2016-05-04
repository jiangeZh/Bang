package com.xbmu.business;

import java.util.Date;

public class ResourceBean
{
	private Integer id;
	private String name;
	private String desc;
	private String url;
	private double size;
	private Date uploadDate;
	private Integer downloadCnt;
	private Integer isEncrypt;
	private String password;
	private String owner;
	private String kind;
	private String teacherName;
	private String lessonName;
	
	// �޲���Ĺ�����
	public ResourceBean()
	{
	}
	// ��ʼ��ȫ�����ԵĹ�����
	public ResourceBean(Integer id, String name, String desc, String url, 
						double size, Date uploadDate, Integer downloadCnt,
						Integer isEncrypt, String password, String owner, String kind)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.url = url;
		this.size = size;
		this.uploadDate = uploadDate;
		this.downloadCnt = downloadCnt;
		this.isEncrypt = isEncrypt;
		this.password = password;
		this.owner = owner;
		this.kind = kind;
	}

	// id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	// description���Ե�setter��getter����
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}
	
	// url���Ե�setter��getter����
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}
	
	// size���Ե�setter��getter����
	public void setSize(double size)
	{
		this.size = size;
	}
	public double getSize()
	{
		return this.size;
	}

	// uploadDate���Ե�setter��getter����
	public void setUploadDate(Date uploadDate)
	{
		this.uploadDate = uploadDate;
	}
	public Date getUploadDate()
	{
		return this.uploadDate;
	}
	
	// downloadCnt���Ե�setter��getter����
	public void setDownloadCnt(Integer downloadCnt)
	{
		this.downloadCnt = downloadCnt;
	}
	public Integer getDownloadCnt()
	{
		return this.downloadCnt;
	}
	
	// isEncrypt���Ե�setter��getter����
	public void setIsEncrypt(Integer isEncrypt)
	{
		this.isEncrypt = isEncrypt;
	}
	public Integer getIsEncrypt()
	{
		return this.isEncrypt;
	}
	
	// password���Ե�setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	// owner���Ե�setter��getter����
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public String getOwner()
	{
		return this.owner;
	}

	// kind���Ե�setter��getter����
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		return this.kind;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
}