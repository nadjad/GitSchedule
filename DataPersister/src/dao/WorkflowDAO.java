package dao;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datamodel.Workflow;

public class WorkflowDAO {

	private org.hibernate.classic.Session session;

	public WorkflowDAO() {
		super();
	}

	public boolean insertWorkflow(Workflow workflow) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(workflow);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}
	}

	public boolean deleteWorkflow(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Workflow where title = :title1 ");
		q.setParameter("title1", title);

		if (!q.list().isEmpty()) {
			try {
				Workflow w = (Workflow) q.list().get(0);
				Transaction t = session.beginTransaction();
				session.delete(w);
				t.commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
			}
		}
		return false;
	}

	public Workflow getWorkflow(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Workflow) session.get(Workflow.class, id);
	}

	public Workflow getWorkflow(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Workflow where title = :title ");
		q.setParameter("title", title);

		List l = q.list();
		if (!l.isEmpty()) {
			return (Workflow) l.get(0);
		}
		return null;
	}
}
