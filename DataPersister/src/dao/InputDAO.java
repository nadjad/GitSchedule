package dao;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import datamodel.Input;

public class InputDAO {

	private org.hibernate.classic.Session session;

	public InputDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insertInput(Input input) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			// insertTask(input.getTask());
			session.save(input);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public Input getInput(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Input) session.get(Input.class, id);
	}
}
