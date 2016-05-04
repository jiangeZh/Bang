package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xbmu.bean.User;
import com.xbmu.dao.UserDao;
import com.xbmu.util.DBCPUtil;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public User findUserByNameAndPass(String username, String pass) {
		String sql = "select * from user where username=? and userpass=?";
		try {
			List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class), username,pass);
			if (userList.size() == 1)
			{
				return (User)userList.get(0);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据用户名获取用户id
	 * @param username 用户名
	 * @return 用户id
	 */
	public Integer findUserIdByName(String username) {
		String sql = "select * from user where username=?";
		try {
			List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class), username);
			if (userList.size() == 1)
			{
				return (Integer)userList.get(0).getUser_id();
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User get(Integer userId) {
		try {
			String sql = "select * from user where user_id=?";
			User user = qr.query(sql, new BeanHandler<User>(User.class), userId);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
