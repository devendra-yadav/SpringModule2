package com.epam.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.UserDao;
import com.epam.model.User;

@Service
@Transactional
public class UsersServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int create(User user) {
		// TODO Auto-generated method stub
		return userDao.create(user);
	}

	
	@Override
	public void createUsers(List<User> users) {
		
		for(User user:users) {
			userDao.create(user);
		}
	}
	
	@Override
	public void delete(User user) {
		
		userDao.delete(user);

	}

	@Override
	public User getUserById(int id) {
		User theUser=null;
		try {
			theUser=userDao.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return theUser;
	}

	@Override
	public User getUserByEmail(String email) {
		
		User theUser=null;
		try {
			theUser=userDao.getUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return theUser;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public User getUserByName(String name) {
		User theUser=null;
		try {
			theUser=userDao.getUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return theUser;
	}



}
