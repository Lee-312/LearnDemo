package hibernateTest;

import hibernateTest.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		User user = (User) session.get(User.class,2);
		System.out.println(user.toString());
	}

}
