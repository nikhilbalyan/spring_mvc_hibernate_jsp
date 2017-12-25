package com.spring.mvc.home.mapping;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.mvc.home.beans.ALLClass;
import com.spring.mvc.home.beans.CampusMind;
import com.spring.mvc.home.beans.Lead;
import com.spring.mvc.home.beans.Orchard;

public class UserDAOImpl implements UserDAOInterface {

	static SessionFactory sessionFactory = null;
	static Session session = null;
	static Transaction txn = null;

	@Override
	public boolean add(ALLClass data) {
		/*
		 * int num = 5; try { for (int i = 0; i < num; i++) {
		 */
		try {
			/*CampusMind camp = new CampusMind();
			camp.setCampusMindMID(11);
			camp.setCampusMindName("abc");
			camp.setOrchardDetails(orh);
			camp.setTrack("bpm");
			orh.setCampusMind();*/

			/*Orchard orh = new Orchard();
			Lead tLead = new Lead();
			CampusMind cmpMind = new CampusMind();*/
			// CampusMind camp = new CampusMind();
			
//			orh.setBatchID(data.getBatchID());
//			orh.setLead(data.getLead());
//			orh.setCampusMind(data.getCampusMind());
			
			
			/*
			 * Set<CampusMind> camp = new HashSet<CampusMind>();
			 * orh.setCampusMind(camp);
			 */

			// tLead.set

			// session.save(camp);
			// session.save(tLead);
			session.save(data);
//			session.save(tLead);

			// UserDetails usr = new UserDetails();
			// usr.setUserName("user " + i);
			// session.save(usr);
			// session.save(orh);
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;

	}

	@Override
	public boolean read(int batchId) {

		return false;
	}

	@Override
	public boolean update(Orchard num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		Query qry1 = session.createQuery("DELETE FROM ALLClass WHERE batchID = " + id);
		qry1.executeUpdate();
		return false;
	}

	@Override
	public CampusMind getCampusMindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orchard getOrchardByTrack(String track) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean startConnection() {
		try {
			String hibernateFilePath = "hibernate.cfg.xml";

			sessionFactory = new Configuration().configure(hibernateFilePath).buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			// session.beginTransaction();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public static boolean closeConnection() {
		try {
			// session.getTransaction().commit();
			// txn.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public ALLClass readALL(int batchID) {
		Query qry1 = session.createQuery("FROM ALLClass WHERE batchID = " + batchID);
		List<ALLClass> allClass = qry1.list();
		return allClass.get(0);
	}

	@Override
	public List<ALLClass> getAllDetails() {
		Query qry1 = session.createQuery("FROM ALLClass");
		return qry1.list();
	}

}
