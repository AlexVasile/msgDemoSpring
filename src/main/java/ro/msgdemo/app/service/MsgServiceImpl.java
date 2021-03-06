package ro.msgdemo.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.msgdemo.app.model.Message;
import ro.msgdemo.app.model.User;

@Service(value="msgService")
@Transactional
public class MsgServiceImpl implements MsgService {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Message> getAllMessages() {
		Query query = getSession().createQuery("from Message m " +
				"order by m.date desc");
		return (List<Message>) query.list();
	}
	
	@Override
	public Message saveMessage(String content, String username) {
		User user = null;
		if (username == null || username.equals("")) {
			username = User.DEFAULT_USERNAME;
		}
		user = getUser(username);
		if (user == null) {
			user = saveUser(username);
		}
		Message msg = new Message();
		msg.setContent(content);
		msg.setUser(user);
		getSession().save(msg);
		return msg;
	}

	private User getUser(String username) {
		Query query = getSession().createQuery("from User u " +
				"where u.name = :username");
		query.setString("username", username);
		return (User) query.uniqueResult();
	}
	
	private User saveUser(String username) {
		User user = new User();
		user.setName(username);
		getSession().save(user);
		return user;
	}
}
