package com.zfy.db;

import java.io.IOException;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	/**
	 * 访问数据库
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException{
		//ͨ通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("com/zfy/config/Configuration.xml");
		//ͨ通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//通过sqlSessionFactory打开一个数据库会话
		SqlSession sqlsession=sqlSessionFactory.openSession();
		return sqlsession;
	}
}
