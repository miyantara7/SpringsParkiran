package com.lawencon.springparkiran.service;

import java.util.List;

import com.lawencon.springparkiran.model.Kendaraan;

public interface KendaraanService {
	
	abstract String insertKendaraan(Kendaraan kendaraan,String user,String pass) throws Exception;
	abstract Boolean validKendaraanCheckIn(Kendaraan kendaraan) throws Exception;
	abstract Boolean validKendaraanCheckOut(Kendaraan kendaraan) throws Exception;
	abstract String insertCheckoutKendaraan(Kendaraan kendaraan,String user,String pass) throws Exception;
	abstract List<Kendaraan> viewKendaraanCheckIn(String user,String pass) throws Exception;
	abstract List<Kendaraan> viewKendaraanCheckOut(String user,String pass) throws Exception;
	
	abstract String insertKendaraanJpa(Kendaraan kendaraan,String user,String pass) throws Exception;
	abstract String insertCheckoutKendaraanJpa(Kendaraan kendaraan,String user,String pass) throws Exception;
	abstract List<Kendaraan> viewKendaraanCheckInJpa(String user,String pass) throws Exception;
	abstract List<Kendaraan> viewKendaraanCheckOutJpa(String user,String pass) throws Exception;
	
	abstract Kendaraan cekKendaraan(Kendaraan kendaraan) throws Exception;
	abstract Boolean cekPlat(Kendaraan kendaraan, Kendaraan ken2) throws Exception;
}
