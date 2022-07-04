package com.bilgeadam.boost.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.boost.model.UserEntity;

import lombok.ToString;

@ToString
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		SessionFactory factory = null;
		try {
			Configuration config = new Configuration(); //instance yaratılıyor
			config.addAnnotatedClass(UserEntity.class); //entity sınıflarını hibernate'e tanıtmak gerekiyor
			
			factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory; 

	}
	

}
