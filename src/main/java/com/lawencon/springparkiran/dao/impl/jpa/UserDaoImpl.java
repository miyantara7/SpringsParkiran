package com.lawencon.springparkiran.dao.impl.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.springparkiran.dao.UserDao;
import com.lawencon.springparkiran.model.User;

@Repository("ken_dao_jpa")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User validUser(String user, String pass) throws Exception {
		return userRepo.findByUsername(user, pass);
	}

}
