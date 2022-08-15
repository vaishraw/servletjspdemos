package com.samples.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Class;

import com.samples.domain.Subject;

import com.samples.utils.HibernateUtil;

public class SubjectService {

	public List<Subject> getSubjects() {
		List<Subject> subjects = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			subjects = session.createQuery("from Subject").list();

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

		return subjects;
	}

	public void addSubject(Subject subject) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			session.save(subject);

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

	public void deleteSubjects(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			Subject subject=session.get(Subject.class,id);
			session.delete(subject);

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

	public void updateSubject(int id, String shortcut,String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();
			Subject subject=session.get(Subject.class, id);
			subject.setShortcut(shortcut);
			subject.setName(name);
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

	public void assignsubject(int sid, int cid) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.getTransaction();
		try {
		txn.begin();
		Subject subject=session.get(Subject.class,sid);
		Class c1=session.get(Class.class,cid);
		subject.setClass1(c1);
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

		




