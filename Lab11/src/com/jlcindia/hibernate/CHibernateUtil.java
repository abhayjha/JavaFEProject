package com.jlcindia.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class CHibernateUtil {
public static SessionFactory factory;
static{
	try{
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		factory=cfg.buildSessionFactory();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public static SessionFactory getSessionFactory(){
	return factory;
}
}
