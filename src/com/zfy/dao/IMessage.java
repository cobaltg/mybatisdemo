package com.zfy.dao;

import java.util.List;
import java.util.Map;

import com.zfy.bean.Message;

/**
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter);
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message);
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);
	
	/**
	 * 单条删除
	 */
	public void deleteOne(int id);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch(List<Integer> ids);
}
