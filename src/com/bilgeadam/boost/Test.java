package com.bilgeadam.boost;

import java.util.ArrayList;

import com.bilgeadam.boost.controller.UserController;
import com.bilgeadam.boost.model.UserEntity;
import com.bilgeadam.boost.view.UserView;

public class Test {

	public static void main(String[] args) {
		
		UserController userController = new UserController();
		UserView userView = new UserView();
		
		UserEntity user1 = new UserEntity("gözde", "yalçın");
		user1.setEmail("gozde@gmail.com");
		System.out.println(user1.toString());
		userController.create(user1);
		
		UserEntity user2 = new UserEntity("boncuk", "yalçın");
		user2.setEmail("boncuk@gmail.com");
		userController.create(user2);
	
		userController.retrieve();
		
		ArrayList<UserEntity> users =userController.retrieve();
		System.out.println("\n");
		for (UserEntity user : users) {
			System.out.println(user);
		}
		
		users = userController.findByEmail("gozde@gmail.com");
		for (UserEntity user : users) {
			System.out.println(user);

		}
		System.out.println();
	}
}
