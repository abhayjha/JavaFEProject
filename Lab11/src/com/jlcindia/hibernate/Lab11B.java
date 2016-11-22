package com.jlcindia.hibernate;

import org.hibernate.*;

public class Lab11B {

	public static void main(String[] args) {
		Transaction tx=null;
		try{
			SessionFactory sf=CHibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			tx=session.beginTransaction();
			Customer cust=(Customer)session.load(Customer.class, 1);
			System.out.println(cust.getCid()+"\t"+cust.getFirstName()+"\t"+cust.getLastName()+"\t"+cust.getEmail()+"\t"+cust.getPhone());
			Address add=cust.getAddress();
			System.out.println(add.getAid()+"\t"+add.getCity()+"\t"+add.getStreet()+"\t"+add.getState());
			Address add1=(Address)session.load(Address.class, 1);
			System.out.println(add1.getAid()+"\t"+add1.getCity()+"\t"+add1.getStreet()+"\t"+add1.getState());
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
}

}
