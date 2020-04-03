package com.lawencon.springparkiran.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.springparkiran.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query(value ="select *from tb_user u where u.username = ?1 and u.password = ?2",  nativeQuery = true)
	abstract User findByUsername(String user, String pass) throws Exception;
}
