package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xbmu.bean.Kind;
import com.xbmu.dao.KindDao;
import com.xbmu.util.DBCPUtil;

public class KindDaoImpl implements KindDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public List<Kind> findAll() {		
		try {
			String sql = "select * from kind";
			List<Kind> kinds = qr.query(sql, new BeanListHandler<Kind>(Kind.class));
			return kinds;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 添加种类：
	 * 遇到问题：需求，想将添加的新数据的id返回，
	 * 使用insert into kind (kind_name,kind_desc) values(?,?);select @@identity as kind_id;语句
	 * 
	 */
	public void save(Kind kind) {
		try {
			String sql = "insert into kind (kind_name,kind_desc) values(?,?)";
			qr.update(sql, kind.getKind_name(),kind.getKind_desc());
			String sql2 = "select @@identity as kind_id";
			//ScalarHandler 的参数为空或null时，返回第一行第一列的数据 
			//ScalarHandler 的参数可以是列的索引（从1开始）或列名 
			Object kind_id = qr.query(sql2, new ScalarHandler(1));
			//因为kind_id在数据库中定义为int型，上面语句返回后为BigInteger型，
			kind.setKind_id(Integer.valueOf(kind_id.toString()));//容易发生类型转换异常
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Kind get(int kindId) {
		try {
			String sql = "select * from kind where kind_id=?";
			Kind kind = qr.query(sql, new BeanHandler<Kind>(Kind.class), kindId);
			return kind;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
