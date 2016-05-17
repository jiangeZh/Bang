package com.xbmu.dao;

import com.xbmu.bean.User;

/**
 * 数据访问层，用户接口
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 验证用户登录
	 * @param username 用户名
	 * @param pass 用户密码
	 * @return 验证成功，返回一个用户；否则返回null
	 */
	User findUserByNameAndPass(String username, String pass);
	
	/**
	 * 根据用户名获取用户id
	 * @param username 用户名
	 * @return 用户id
	 */
	Integer findUserIdByName(String username);
	
	/**
	 * 根据用户id查找用户
	 * @param userId 用户id
	 * @return 用户对象
	 */
	User get(Integer userId);
	
	int addUser(User user);
}
