package com.databaseOperation;

import java.sql.Connection;

/**
 * 
 * @author xig
 *
 * description: JDBC�������ݿ�ӿ�
 *
 */

public interface JDBCOpetation {
	
	public Connection getConnection();		// ��ȡ����
	
	public void insert();			// ����
	public void update();			// ����
	public void select();			// ��ѯ
	public void delete();			// ɾ������

}
