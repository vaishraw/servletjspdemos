package com.samples.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Class;

import com.samples.domain.Subject;
import com.samples.domain.Teacher;
import com.samples.utils.HibernateUtil;

public class TeacherService {

	public List<Teacher> getTeachers() {
		List<Teacher> teachers = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			teachers = session.createQuery("from Teacher").list();

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

		return teachers;
	}

	public void addteacher(Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			session.save(teacher);
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

	public void updateTeacher(int id, String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();
			Teacher teacher=session.get(Teacher.class, id);
			teacher.setEmail(email);
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

	public void deleteTeacher(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();
			Teacher teacher=session.get(Teacher.class, id);
			session.delete(teacher);
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

	public void assignTeacher(int tid, int cid, int sid) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.getTransaction();
		try {
		txn.begin();
		Teacher teacher=session.get(Teacher.class,tid);
		Class c1=session.get(Class.class,cid);
		Subject subject=session.get(Subject.class, sid);
		teacher.setClass1(c1);
		teacher.setSubject(subject);
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


		

	
