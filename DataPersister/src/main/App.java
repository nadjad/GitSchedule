package main;

import hibernate.HibernateUtil;

import java.util.Date;

import org.hibernate.Session;

import datamodel.Task;
import datamodel.Workflow;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Workflow w = new Workflow();
		w.setStatus("running");
		w.setStart(new Date());
		w.setTitle("pppp");
		session.save(w);
		Task t = new Task(12, "aaa", "waiting");
		t.setWorkflow(w);

		// stock.setStockCode("4715");
		// stock.setStockName("GENM");

		session.save(t);
		session.getTransaction().commit();
	}
}
