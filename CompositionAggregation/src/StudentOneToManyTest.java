import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Guide;
import com.samples.domain.Student;
import com.samples.utils.HibernateUtil;

public class StudentOneToManyTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();
			
			Guide guide = new Guide("2000XYZ003", "Robert Williams", 2000);
			Student student4 = new Student("SR001", "John Smith", guide);
			Student student5 = new Student("SR002", "Amy Jackson", guide);
			
			guide.getStudents().add(student4);
			guide.getStudents().add(student5);
			session.persist(guide);
			
			
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
