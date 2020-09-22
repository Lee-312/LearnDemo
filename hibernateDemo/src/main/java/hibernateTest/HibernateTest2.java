package hibernateTest;

import hibernateTest.bean.User2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest2 {
	public static void main(String[] args) throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		User2 user = (User2) session.get(User2.class,2);
		System.out.println(user.toString());
	}

}
