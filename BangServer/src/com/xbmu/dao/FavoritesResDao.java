package com.xbmu.dao;

import java.util.List;

import com.xbmu.bean.Resource;
import com.xbmu.bean.FavoritesRes;

public interface FavoritesResDao {
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的资源列表
	 */
	List<Resource> findFavoritesResByOwner(Integer userId);
	
	/**
	 * 添加收藏资源
	 * @param resource 待添加的资源
	 */
	void save(FavoritesRes favoritesRes);
}
