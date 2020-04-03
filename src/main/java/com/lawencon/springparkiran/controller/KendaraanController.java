package com.lawencon.springparkiran.controller;
/*
 * 
 * @Author I KADEK ARYA YOGIMIYAANTARA
 * 
 */

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.springparkiran.model.Kendaraan;

@RestController
@RequestMapping("/kendaraan")
public class KendaraanController extends BaseController {


	@Override
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	
	@PostMapping("/checkin")
	public ResponseEntity<?> insertHhiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "" ;
		try {
			String[] auth = authUser(user).split(":");
			Kendaraan kendaraan = new ObjectMapper().readValue(content, Kendaraan.class);
			pesan = k_service.insertKendaraan(kendaraan,auth[0],auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		
	}

	@PostMapping("/checkout")
	public ResponseEntity<?> checkOut(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "" ;
		try {
			String[] auth = authUser(user).split(":");
			Kendaraan kendaraan = new ObjectMapper().readValue(content, Kendaraan.class);
			pesan = k_service.insertCheckoutKendaraan(kendaraan,auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Kendaraan tidak ada !", HttpStatus.OK);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}

	@GetMapping("/listcheckin")
	public ResponseEntity<List<Kendaraan>> getListCheckIn(@RequestHeader("Authorization") String user) {
		List<Kendaraan> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = k_service.viewKendaraanCheckIn(auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

	@GetMapping("/listcheckout")
	public ResponseEntity<List<Kendaraan>> getListCheckOut(@RequestHeader("Authorization") String user) {
		List<Kendaraan> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = k_service.viewKendaraanCheckOut(auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

	
	
	@PostMapping("/checkin/jpa")
	public ResponseEntity<?> insertJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Kendaraan kendaraan = new ObjectMapper().readValue(content, Kendaraan.class);
			pesan = k_service.insertKendaraanJpa(kendaraan,auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}

	@PostMapping("/checkout/jpa")
	public ResponseEntity<?> checkOutJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Kendaraan kendaraan = new ObjectMapper().readValue(content, Kendaraan.class);
			pesan = k_service.insertCheckoutKendaraanJpa(kendaraan,auth[0],auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}

	@GetMapping("/listcheckin/jpa")
	public ResponseEntity<List<Kendaraan>> getListCheckInJpa(@RequestHeader("Authorization") String user) {
		List<Kendaraan> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = k_service.viewKendaraanCheckInJpa(auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

	@GetMapping("/listcheckout/jpa")
	public ResponseEntity<List<Kendaraan>> getListCheckOutJpa(@RequestHeader("Authorization") String user) {
		List<Kendaraan> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = k_service.viewKendaraanCheckOutJpa(auth[0],auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

}
