import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Guide;
import com.samples.domain.Student;
import com.samples.utils.HibernateUtil;

public class StudentTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();
			
			Guide guide=new Guide("1001ABC012","Harry Jones",55000);
			Student student1=new Student("ORG123","Mary Smith", guide);
			Student student2=new Student("ORG124","Sam Thomas", guide);
			
			session.save(guide);
			session.save(student1);
			session.save(student2);
			
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
