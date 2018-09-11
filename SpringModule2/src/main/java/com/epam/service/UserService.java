package com.epam.service;

import java.util.List;

import com.epam.model.User;

public interface UserService {
	public int create(User user);
	public void createUsers(List<User> users);
	public void delete(User user);
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public User getUserByName(String name);
	public List<User> getAll();
}
