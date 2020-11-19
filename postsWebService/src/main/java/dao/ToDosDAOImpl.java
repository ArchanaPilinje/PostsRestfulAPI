package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.posts.Status;
import com.posts.ToDos;

public class ToDosDAOImpl implements ToDosDAO {
	private static SessionFactory factory;
	private Session session;
	private Transaction transaction;

	static {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
	}
	
	public ToDosDAOImpl() {
		
	}
	
	
	@Override
	public ToDos insert(ToDos t) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
		return t;
	}

	@Override
	public ToDos update(int id) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		ToDos temp=session.get(ToDos.class, id);
		String comp=temp.getCompleted();
		if(comp.equals("true")) {
			temp.setCompleted("false");
		}
		else
			temp.setCompleted("true");
		session.update(temp);
		transaction.commit();
		session.close();
		return temp;
	}

	@Override
	public Status delete(int id) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		ToDos temp = session.get(ToDos.class, id);
		session.delete(temp);
		transaction.commit();
		session.close();
		return new Status(true);
	}

	@Override
	public List<ToDos> view() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from ToDos");
		List<ToDos> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

}
