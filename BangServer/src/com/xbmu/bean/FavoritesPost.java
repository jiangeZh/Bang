package com.xbmu.bean;

import java.io.Serializable;
/*
DROP TABLE IF EXISTS `favorites_post`;
CREATE TABLE `favorites_post` (
  `user_id` int(11) NOT NULL COMMENT '0=文章，1=资源',
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`post_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `favorites_post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `favorites_post_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

public class FavoritesPost implements Serializable{

	private Integer user_id;

	private Integer post_id;
	
	public FavoritesPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FavoritesPost(Integer user_id, Integer post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}
	
	@Override
	public String toString() {
		return "FavoritesPost [user_id=" + user_id + ", post_id=" + post_id + "]";
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	
}
