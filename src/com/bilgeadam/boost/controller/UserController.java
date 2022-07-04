package com.bilgeadam.boost.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.boost.hibernate.CRUDable;
import com.bilgeadam.boost.model.UserEntity;

public class UserController implements CRUDable<UserEntity>{

	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionViaHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void update(UserEntity entity) {
		
	}

	@Override
	public void delete(UserEntity entity) {
		
	}

	@Override
	public ArrayList<UserEntity> retrieve() {
		
		return null;
	}
}
