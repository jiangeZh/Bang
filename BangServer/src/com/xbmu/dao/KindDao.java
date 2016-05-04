package com.xbmu.dao;

import java.util.List;

import com.xbmu.bean.Kind;

public interface KindDao {
	/**
	 * 查询所有种类
	 * @return
	 */
	List<Kind> findAll();
	
	/**
	 * 添加种类
	 * @param kind 待添加的种类
	 */
	void save(Kind kind);
	/**
	 * 根据种类id查找种类对象
	 * @param kindId 种类id
	 * @return 返回种类对象
	 */
	Kind get(int kindId);


}
