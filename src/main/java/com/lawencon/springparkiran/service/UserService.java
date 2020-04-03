package com.lawencon.springparkiran.service;

public interface UserService {
	
	abstract Boolean validUserHiber(String user, String pass) throws Exception;
	abstract Boolean validUserJpa(String user, String pass) throws Exception;
}
