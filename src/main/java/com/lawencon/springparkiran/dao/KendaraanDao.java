package com.lawencon.springparkiran.dao;

import java.util.List;

import com.lawencon.springparkiran.model.Kendaraan;

public interface KendaraanDao {
	abstract void insertKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception;

	abstract Kendaraan validKendaraanCheckIn(Kendaraan kendaraan) throws Exception;

	abstract void insertCheckoutKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception;

	abstract List<Kendaraan> viewKendaraanCheckIn(String user, String pass) throws Exception;

	abstract List<Kendaraan> viewKendaraanCheckOut(String user, String pass) throws Exception;

	abstract Kendaraan cekKendaraan(Kendaraan kendaraan) throws Exception;

	abstract Kendaraan cekOutKendaraan(Kendaraan kendaraan) throws Exception;

}
