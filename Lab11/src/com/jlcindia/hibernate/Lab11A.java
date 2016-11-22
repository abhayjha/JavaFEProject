package com.jlcindia.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab11A {

	public static void main(String[] args) {
		Transaction tx=null;
		try{
			SessionFactory sf=CHibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Customer cust=new Customer("sri","Nivas","sri@jlc","1234");
			session.save(cust);
			Address add=new Address("HMT Main","Blore","karnataka");
			session.save(add);
			cust.setAddress(add);
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}

	}

}
