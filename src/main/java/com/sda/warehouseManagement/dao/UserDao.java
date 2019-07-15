package com.sda.warehouseManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.warehouseManagement.model.User;

public class UserDao {

	public static void createNewUser(User user) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}
	}

	/**
	 * Method will retrieve all orders from the database
	 */
	public static List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>();

		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			userList = session.createQuery("from User").list();

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}

		return userList;

	}

	/**
	 * Method will update the database entry for the corresponding id
	 */
	public static void updateUser(User user) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.update(user);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}
	}

	public static void deleteUser(User user) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.delete(user);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}
	}

}
