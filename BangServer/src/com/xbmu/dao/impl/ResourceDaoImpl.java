package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xbmu.bean.Resource;
import com.xbmu.bean.Kind;
import com.xbmu.bean.User;
import com.xbmu.dao.ResourceDao;
import com.xbmu.util.DBCPUtil;

public class ResourceDaoImpl implements ResourceDao
{
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	/**
	 * 获取资源
	 * @param
	 */
	public List<Resource> findAllResource()
	{
		try {
			String sql = "select * from resource";
			List<Resource> resources = qr.query(sql, new BeanListHandler<Resource>(
					Resource.class));
			/*
			sql = "select res_url from resource";
			List<String> urls = qr.query(sql, new BeanListHandler<String>(
					String.class));
			System.out.println(urls.get(1));
			*/
			return resources;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ݷ��࣬��ȡ�÷����µ�ȫ����Դ
	 * @param kindId ����id;
	 * @return �����ȫ����Դ
	 */
	public List<Resource> findResourceByKind(Integer kindId)
	{
		try {
			// 根据种类浏览拍卖中的物品
			String sql = "select * from resource where kind_id=?";
			List<Resource> resources = qr.query(sql, new BeanListHandler<Resource>(
					Resource.class), kindId);
			// 设置竞拍物品的状态和拥有者
			for (Resource resource : resources) {
				// 设置拥有者
				String ownerSql = "select * from user where user_id = any(select owner_id from resource where kind_id=? and res_id=?)";
				User owner = qr.query(ownerSql, new BeanHandler<User>(
						User.class), kindId, resource.getRes_id());
				resource.setOwner_id(owner.getUser_id());
			}
			return resources;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��������߲�����Դ
	 * @param useId ������Id;
	 * @return ָ���û�����Դ
	 */
	public List<Resource> findResourceByOwner(Integer userId)
	{
		try {
			String sql = "select * from resource where owner_id=?";
			List<Resource> resources = qr.query(sql, new BeanListHandler<Resource>(
					Resource.class), userId);
			// 设置物品拥有者，物品种类
			for (Resource resource : resources) {
				// 设置拥有者
				String ownerSql = "select * from user where user_id=any(select owner_id from resource where owner_id=?)";
				User owner = qr.query(ownerSql, new BeanHandler<User>(
						User.class), userId);
				resource.setOwner_id(owner.getUser_id());
				// 设置物品种类
				String kindSql = "select * from kind where kind_id = any(select kind_id from resource where owner_id=?)";
				Kind kind = qr.query(kindSql,
						new BeanHandler<Kind>(Kind.class), userId);
				resource.setKind_id(kind.getKind_id());
			}
			return resources;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void save(Resource resource) {
		try {
			String sql = "insert into resource(res_name,res_desc,res_url,res_size,upload_date,download_cnt,is_encrypt,password,owner_id,kind_id) "
					+ //
					"values(?,?,?,?,?,?,?,?,?,?)";
			qr.update(sql, resource.getRes_name(), resource.getRes_desc(), resource
					.getRes_url(), resource.getRes_size(), resource
					.getUpload_date(), resource.getDownload_cnt(), resource
					.getIs_encrypt(), resource.getPassword(), resource
					.getOwner_id(), resource.getKind_id());
			String sql2 = "select @@identity as res_id";
			Object res_id = qr.query(sql2, new ScalarHandler(1));
			resource.setRes_id(Integer.valueOf(res_id.toString()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public List<Resource> findResourceByKey(String key)
	{
		try {
			String sql = "";
			if (isNumberic(key)) {
				int res_id = Integer.parseInt(key);
				sql = "select * from resource where res_name like '%"+key+"%' or res_id = "+res_id;
			}
			else {
				sql = "select * from resource where res_name like '%"+key+"%'";
			}
			List<Resource> resources = qr.query(sql, new BeanListHandler<Resource>(
					Resource.class));
			return resources;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean isNumberic(String str){ 
		for (int i = str.length()-1; i>=0; --i) { 
			if(!Character.isDigit(str.charAt(i))){ 
				return false; 
			} 
		} 
		return true; 
	} 

	public Resource get(int resourceId) {
		try {
			String sql = "select * from resource where res_id=?";
			Resource resource = qr
					.query(sql, new BeanHandler<Resource>(Resource.class), resourceId);
			// 设置物品种类
			String kindSql = "select * from kind where kind_id = any(select kind_id from resource where res_id=?)";
			Kind kind = qr.query(kindSql, new BeanHandler<Kind>(Kind.class),
					resourceId);
			resource.setKind_id(kind.getKind_id());
			// 设置拥有者
			String ownerSql = "select * from user where user_id = any(select owner_id from resource where res_id=?)";
			User owner = qr.query(ownerSql, new BeanHandler<User>(User.class),
					resource.getRes_id());
			resource.setOwner_id(owner.getUser_id());
			return resource;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void del(Integer userId, Integer resId) {
		try {
			String sql = "delete from resource where res_id=? and owner_id=?";
			qr.update(sql, resId, userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
}