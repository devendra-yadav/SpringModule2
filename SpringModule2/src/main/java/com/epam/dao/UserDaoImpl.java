package com.epam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.model.User;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public int create(User user) {
		UserDao.validateUser(user);
		int userId=(int) getCurrentSession().save(user);
		return userId;
	}

	@Override
	public void delete(User user) {
		UserDao.validateUser(user);
		
		getCurrentSession().delete(user);

	}

	@Override
	public User getUserById(int id) {
		
		User user=getCurrentSession().createQuery("from User where id=:id", User.class).setParameter("id", id).getSingleResult();
		
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user=getCurrentSession().createQuery("from User where email=:email", User.class).setParameter("email", email).getSingleResult();
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users=getCurrentSession().createQuery("from User", User.class).getResultList();
		return users;
	}

	@Override
	public User getUserByName(String name) {
		User user=getCurrentSession().createQuery("from User where name=:name", User.class).setParameter("name", name).getSingleResult();
		return user;
	}

}
