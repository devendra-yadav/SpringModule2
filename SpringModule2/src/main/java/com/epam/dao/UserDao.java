package com.epam.dao;

import java.util.List;
import java.util.Objects;

import com.epam.model.User;

public interface UserDao {
	public int create(User user);
	public void delete(User user);
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public User getUserByName(String name);
	public List<User> getAll();
	
	public static void validateUser(User user) {
		if(Objects.isNull(user)) {
			throw new NullPointerException("User is null");
		}
		if(Objects.isNull(user.getEmail())){
			throw new NullPointerException("User email is null. user : "+user);
		}
		if(Objects.isNull(user.getName())){
			throw new NullPointerException("User name is null. user : "+user);
		}
		
	}
	
}
