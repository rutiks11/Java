package com.pet.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pet.core.Role;
import com.pet.core.User;
import com.pet.custom_exception.PETException;

public class UserUtils {

	public static List<User> populateUserList() {
		List<User> users = new ArrayList<User>(
				Arrays.asList(new User("user1", "user1", Role.CUSTOMER), new User("s", "admin", Role.ADMIN)));

		return users;
	}

	public static User authenticateUser(String uname, String password, List<User> users) throws PETException {
		User user = new User(uname);
		if (users.contains(user)) {
			System.out.println("in authenticate");
			int pos =  users.indexOf(user);
			User user1 = users.get(pos);
			System.out.println(user1);
			return user1;
		}
		throw new PETException("User Does not Exists");

	}
}
