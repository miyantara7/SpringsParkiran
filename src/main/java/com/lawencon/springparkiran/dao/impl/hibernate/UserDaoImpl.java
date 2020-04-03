package com.lawencon.springparkiran.dao.impl.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.springparkiran.dao.UserDao;
import com.lawencon.springparkiran.model.User;

@Repository("ken_dao_hibernate")
public class UserDaoImpl extends BaseHibernate implements UserDao{

	@Override
	public User validUser(String user, String pass) throws Exception {
		Query q = em.createQuery("from User where username =: userParam and password =: passParam")
				.setParameter("userParam", user)
				.setParameter("passParam", pass);
		
		return (User) q.getSingleResult();
	}

}
