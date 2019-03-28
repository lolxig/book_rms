package com.databaseOperation;

import java.sql.Connection;

/**
 * 
 * @author xig
 *
 * description: JDBC操作数据库接口
 *
 */

public interface JDBCOpetation {
	
	public Connection getConnection();		// 获取连接
	
	public void insert();			// 插入
	public void update();			// 更新
	public void select();			// 查询
	public void delete();			// 删除操作

}
