package com.lawencon.springparkiran.dao.impl.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class BaseHibernate {
	
	@PersistenceContext
	protected EntityManager em;
}
