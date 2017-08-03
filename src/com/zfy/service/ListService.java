package com.zfy.service;

import java.util.List;

import com.zfy.bean.Message;
import com.zfy.dao.MessageDao;

public class ListService {
	public List<Message> queryMessageList(String command, String description){
		MessageDao messageDao=new MessageDao();		
		return messageDao.queryMessageList(command, description);
	}
}
