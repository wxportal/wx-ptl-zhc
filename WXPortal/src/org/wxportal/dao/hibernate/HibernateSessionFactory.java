package org.wxportal.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();  
	private  static Configuration configuration = new Configuration();   
	private static org.hibernate.SessionFactory sessionFactory;  
	private static String configFile = CONFIG_FILE_LOCATION;
	
	static{
		try{
			configuration.configure(configFile);
			 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Exception e){
			System.err.println("[ERROR]: An error happened when creainge sessionFactory.. ");
			e.printStackTrace();
		}
		
	}
	
	
	private HibernateSessionFactory(){
		
	}
	
	public static Session getSession() throws HibernateException {
		Session session = threadLocal.get();
		if(session == null || !session.isOpen()){
			if (sessionFactory == null) { 
				rebuildSessionFactory();
			}
			session = sessionFactory.openSession();
		}else{
			session = sessionFactory.getCurrentSession();
		}
		threadLocal.set(session); 
		return session;
	}
	
	
	public static void rebuildSessionFactory(){
		try{
			configuration.configure(configFile);
			 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Exception e){
			System.err.println("[ERROR]: An error happened when creainge sessionFactory.. ");
			e.printStackTrace();
		}
	}
	
	public static void setCongfigFile(String configFile){
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	
	public static Configuration getConfiguration() { 
		return configuration; 
	} 

}
