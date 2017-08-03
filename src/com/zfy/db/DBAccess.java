package com.zfy.db;

import java.io.IOException;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	/**
	 * �������ݿ�
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader=Resources.getResourceAsReader("com/zfy/config/Configuration.xml");
		//ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//ͨ��sqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlsession=sqlSessionFactory.openSession();
		return sqlsession;
	}
}
