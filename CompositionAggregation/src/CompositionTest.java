import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Address;
import com.samples.domain.User;
import com.samples.utils.HibernateUtil;

public class CompositionTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();
			Address billAddress = new Address("111", "Main Street", "Indore", "123456");
			Address shipAddress = new Address("34/12", "Busy Street", "Noida", "114563");
			User user = new User("Ajay", 29, billAddress, shipAddress);
			session.save(user);
			txn.commit();
		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
