package dao;

import hibernate.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datamodel.Task;

public class TaskDAO {
	private org.hibernate.classic.Session session;

	public boolean insertTask(Task task) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			// insertTask(input.getTask());
			session.save(task);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public Task getTask(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Task) session.get(Task.class, id);
	}

	public boolean deleteTask(Integer id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Workflow where wid = :id ");
		q.setParameter("id", id);

		if (!q.list().isEmpty()) {
			try {
				Task task = (Task) q.list().get(0);
				Transaction t = session.beginTransaction();
				session.delete(task);
				t.commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
			}
		}
		return false;
	}
}
