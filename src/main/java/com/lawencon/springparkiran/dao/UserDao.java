package com.lawencon.springparkiran.dao;

import com.lawencon.springparkiran.model.User;


public interface UserDao  {

	abstract User validUser(String user, String pass) throws Exception;

}
