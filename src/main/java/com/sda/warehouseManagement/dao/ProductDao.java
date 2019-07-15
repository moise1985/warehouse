package com.sda.warehouseManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.warehouseManagement.model.Product;

public class ProductDao {

	public static void createNewProduct(Product product) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.save(product);

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
	public static List<Product> getAllProducts() {

		List<Product> productList = new ArrayList<Product>();

		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			productList = session.createQuery("from Product").list();

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}

		return productList;

	}

	/**
	 * Method will update the database entry for the corresponding id
	 */
	public static void updateProduct(Product product) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.update(product);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println("There was an error : " + e.getMessage());
			session.getTransaction().rollback();
		} finally {
			// cleanup
			session.close();
		}
	}

	public static void deleteProduct(Product product) {
		Session session = HibernateUtil.getSession().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			session.delete(product);

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
