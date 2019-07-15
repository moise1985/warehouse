package com.sda.warehouseManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.warehouseManagement.model.Order;

public class OrderDao {

	/**
	 * Method will save this order into the database
	 */
	public static void createNewOrder(Order order) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.save(order);

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
	public static List<Order> getAllOrders() {

		List<Order> orderList = new ArrayList<Order>();

		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			orderList = session.createQuery("from Order").list();

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}

		return orderList;

	}

	/**
	 * Method will update the database entry for the corresponding id
	 */
	public static void updateOrder(Order order) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.update(order);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}
	}

	public static void deleteOrder(Order order) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.delete(order);

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
