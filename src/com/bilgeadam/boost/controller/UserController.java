package com.bilgeadam.boost.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.boost.controller.model.CRUDable;
import com.bilgeadam.boost.logging.MyLogger;
import com.bilgeadam.boost.model.UserEntity;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class UserController implements CRUDable<UserEntity>{
//	private static MyLogger instance = MyLogger.getInstance();
	
	
	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionViaHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			MyLogger.getInstance().debug("Successfully connected");
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void update(UserEntity oldOne, UserEntity newOne) {
		
		Session session = databaseConnectionViaHibernate();
		session.getTransaction().begin();
		
		String hql = "UPDATE UserEntity SET email = :newEmail, firstName = :newFirstName, lastName = :newLastName" 
		+ "WHERE oid = :id";
		
		TypedQuery<UserEntity> query = session.createQuery(hql,UserEntity.class);
		query.setParameter("newEmail", newOne.getEmail());
		query.setParameter("newFirstName", newOne.getFirstName());
		query.setParameter("newLastName", newOne.getLastName());
		query.setParameter("id", oldOne.getOid());
		int status = query.executeUpdate();
	//	Which logger?
		session.getTransaction().commit();
	}

	@Override
	public void delete(UserEntity entity) {
		
		Session session = databaseConnectionViaHibernate();
		session.getTransaction().begin();
		@SuppressWarnings("deprecation")
		Query query = session.createQuery("DELETE UserEntity WHERE oid = :id");
		query.setParameter("id", entity.getOid());
		int status = query.executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public ArrayList<UserEntity> retrieve() {
		
		Session session = databaseConnectionViaHibernate();
		String hql = "SELECT user FROM UserEntity as user";
		TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
		ArrayList<UserEntity> users = (ArrayList<UserEntity>) typedQuery.getResultList();
		return users;
	}
	
	public ArrayList<UserEntity> findByEmail(String email) {
		
		Session session = databaseConnectionViaHibernate();
        String hql = "SELECT user FROM UserEntity as user WHERE email = key ";
        
        TypedQuery<UserEntity> typedQuery = session.createQuery(hql,UserEntity.class);
        typedQuery.setParameter("key", email);

        ArrayList<UserEntity>users = (ArrayList<UserEntity>) typedQuery.getResultList();
        return users;
	}
}