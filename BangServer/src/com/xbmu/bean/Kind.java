package com.xbmu.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/*
#物品种类表
create table kind(
  kind_id int(11) auto_increment,
  kind_name varchar(50) not null, 
  kind_desc varchar(255) not null,
  primary key(kind_id)
);
 */
//种类
public class Kind implements Serializable{
	// 标识属性
	private Integer kind_id;
	// 种类名
	private String kind_name;
	// 种类描述
	private String kind_desc;
	// 该种类下的所有物品
	private Set<Resource> resources = new HashSet<Resource>();
	public Integer getKind_id() {
		return kind_id;
	}
	public void setKind_id(Integer kind_id) {
		this.kind_id = kind_id;
	}
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	public String getKind_desc() {
		return kind_desc;
	}
	public void setKind_desc(String kind_desc) {
		this.kind_desc = kind_desc;
	}
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kind(String kind_name, String kind_desc) {
		super();
		this.kind_name = kind_name;
		this.kind_desc = kind_desc;
	}
	public Kind(Integer kind_id, String kind_name, String kind_desc,
			Set<Resource> resources) {
		super();
		this.kind_id = kind_id;
		this.kind_name = kind_name;
		this.kind_desc = kind_desc;
		this.resources = resources;
	}
	@Override
	public String toString() {
		return "Kind [kind_id=" + kind_id + ", kind_name=" + kind_name
				+ ", kind_desc=" + kind_desc + "]";
	}
	
}
