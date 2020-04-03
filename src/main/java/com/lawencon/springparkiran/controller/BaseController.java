package com.lawencon.springparkiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.lawencon.springparkiran.service.KendaraanService;

abstract class BaseController {
	
	@Autowired
	protected KendaraanService k_service;
	
	abstract String authUser(String user) throws Exception; 
}
