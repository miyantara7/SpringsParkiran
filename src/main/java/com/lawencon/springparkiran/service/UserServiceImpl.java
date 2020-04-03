package com.lawencon.springparkiran.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.springparkiran.dao.UserDao;
import com.lawencon.springparkiran.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("ken_dao_hibernate")
	private UserDao userDaoHiber;
	
	@Autowired
	@Qualifier("ken_dao_jpa")
	private UserDao userDaoJpa;

	@Override
	public Boolean validUserHiber(String user, String pass) throws Exception {
		User users = null;
		try {
			users = userDaoHiber.validUser(user, pass);
		} catch (Exception e) {
		}

		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean validUserJpa(String user, String pass) throws Exception {
		User users = null;
		try {
			users = userDaoJpa.validUser(user, pass);
		} catch (Exception e) {
		}

		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

}
