package ro.msgdemo.app.service;

import java.util.List;

import org.hibernate.Session;

import ro.msgdemo.app.model.Message;

public interface MsgService {

	Message saveMessage(String msg, String username);
	List<Message> getAllMessages();
	Session getSession();
}
