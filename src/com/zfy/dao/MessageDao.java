package com.zfy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zfy.bean.Message;
import com.zfy.db.DBAccess;

public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	
	public List<Message> queryMessageList(Map<String,Object> parameter){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		List<Message> messageList=new ArrayList<Message>();
		try {
			sqlSession=dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
		//	messageList=sqlSession.selectList("Message.queryMessageList",message);
			IMessage imessage=sqlSession.getMapper(IMessage.class);
			messageList=imessage.queryMessageList(parameter);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return messageList;		
	}
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 传统的JDBC连接数据库，操作数据，手动来映射表和对象的关系
	 */
	//	List<Message> messageList=new ArrayList<Message>();
		//连接数据库
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MybatisDemo?useSSL=false","root","714342");	
//			StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paramList=new ArrayList<String>();
//			if(command!=null&&!"".equals(command.trim())){
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(description!=null&&!"".equals(description.trim())){
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}			
//			PreparedStatement statement= conn.prepareStatement(sql.toString());
//			for(int i=0; i<paramList.size(); i++){
//				statement.setString(i+1, paramList.get(i));
//			}			
//			ResultSet rs=statement.executeQuery();
//			//手动来映射表和对象的关系
//			while(rs.next()){
//				Message message=new Message();
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//				messageList.add(message);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			
//		}
//		return messageList;
//		
//}
	/**
	 * 单条删除
	 */	
	public void deleteOne(int id){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//接口式编程
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			imessage.deleteOne(id);
			//sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
	}
	/**
	 * 批量删除
	 */	
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//接口式编程
			IMessage iMessage=sqlSession.getMapper(IMessage.class);
			iMessage.deleteBatch(ids);
			//sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
	}
}
