package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xbmu.bean.FavoritesRes;
import com.xbmu.bean.Resource;
import com.xbmu.dao.FavoritesResDao;
import com.xbmu.util.DBCPUtil;

public class FavoritesResDaoImpl implements FavoritesResDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的资源列表
	 */
	public List<Resource> findFavoritesResByOwner(Integer userId) {		
		try {
			String sql = "select * from resource where res_id in" +
					"(select res_id from favorites_res where user_id=?)";
			List<Resource> resources = qr.query(sql, new BeanListHandler<Resource>(Resource.class), userId);
			return resources;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加收藏资源
	 * @param resource 待添加的资源
	 */
	public void save(FavoritesRes favoritesRes) {
		try {
			String sql = "insert into favorites_res (user_id,res_id) values(?,?)";
			qr.update(sql, favoritesRes.getUser_id(),favoritesRes.getRes_id());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
