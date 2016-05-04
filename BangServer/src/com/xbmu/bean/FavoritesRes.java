package com.xbmu.bean;

import java.io.Serializable;
/*
DROP TABLE IF EXISTS `favorites_res`;
CREATE TABLE `favorites_res` (
  `user_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`res_id`),
  KEY `res_id` (`res_id`),
  CONSTRAINT `favorites_resource_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `favorites_resource_ibfk_2` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

public class FavoritesRes implements Serializable{

	private Integer user_id;
	
	private Integer res_id;
	
	public FavoritesRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FavoritesRes(Integer user_id, Integer res_id) {
		super();
		this.user_id = user_id;
		this.res_id = res_id;
	}
	
	@Override
	public String toString() {
		return "FavoritesPost [user_id=" + user_id + ", res_id=" + res_id + "]";
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getRes_id() {
		return res_id;
	}

	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}

	
}
