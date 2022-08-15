package com.samples.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Class;
import com.samples.domain.Student;
import com.samples.utils.HibernateUtil;

public class StudentService {

	public List<Student> getStudents() {

		List<Student> students = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			students = session.createQuery("from Student").list();

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

		return students;
	}

	public void addStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			session.save(student);

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

	public void updateStudent(int id, String email) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			Student student = session.get(Student.class, id);
			student.setEmail(email);

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

	public void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			Student student = session.get(Student.class, id);
			session.delete(student);

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

	public void assignStudent(int sid, int cid) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.getTransaction();
		try {
		txn.begin();
		Student student=session.get(Student.class,sid);
		Class c1=session.get(Class.class,cid);
		student.setClass1(c1);
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


