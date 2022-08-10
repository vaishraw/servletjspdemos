package HibernateTest;
import org.hibernate.Session;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class HibernateTest {
public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message message1 = new Message("Hello world with Hibernate with Annotations"); 
		Message message2 = new Message("Hello world Message2"); 
		Message message3 = new Message("Hello world Message3"); 
		Message message4 = new Message("Hello world Message4"); 
		
		session.save(message1);
		session.save(message2);
		session.save(message3);
		session.save(message4);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}

