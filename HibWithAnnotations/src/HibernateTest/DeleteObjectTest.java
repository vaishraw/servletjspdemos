package HibernateTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.getTransaction();
		try { 
		txn.begin();
		 Message message=session.get(Message.class, 5);
		 session.delete(message);
		 txn.commit();
		}catch(Exception ex) {
			if(txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}

	}

}
