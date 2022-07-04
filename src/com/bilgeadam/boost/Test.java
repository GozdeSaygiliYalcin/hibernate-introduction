package com.bilgeadam.boost;

import com.bilgeadam.boost.controller.UserController;
import com.bilgeadam.boost.model.UserEntity;

public class Test {

	public static void main(String[] args) {
		
		UserController userController = new UserController();
		UserEntity user1 = new UserEntity("gözde", "yalçın");
	//	user1.setEmail("gozde@gmail.com");
		System.out.println(user1.toString());
		userController.create(user1);
	
		

	}

}
