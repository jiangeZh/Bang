package com.xbmu.dao;

import java.util.List;

import com.xbmu.bean.Resource;

public interface ResourceDao
{
	/**
	 * 获取资源
	 * @param
	 */
	List<Resource> findAllResource();
	/**
	 * ��ݷ��࣬��ȡ�÷����µ�ȫ����Դ
	 * @param kindId ����id;
	 * @return �����ȫ����Դ
	 */
	List<Resource> findResourceByKind(Integer kindId);

	List<Resource> findResourceByKey(String key);
	
	/**
	 * ��������߲�����Դ
	 * @param useId ������Id;
	 * @return ָ���û�����Դ
	 */
	List<Resource> findResourceByOwner(Integer userId);
	/**
	 * 添加物品
	 * @param item 物品对象
	 */
	void save(Resource resource);
	/**
	 * 删除资源
	 * @param userId 拥有者ID
	 * @param resId 资源ID
	 */
	void del(Integer userId, Integer resId);
	/**
	 * 获取物品
	 * @param itemId 物品id
	 * @return 返回物品对象
	 */
	Resource get(int resourceId);
}