package com.lawencon.springparkiran.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.springparkiran.model.Kendaraan;

@Repository
public interface KendaraanRepo extends JpaRepository<Kendaraan, Integer>{

	@Query(value ="select *from Kendaraan k where k.tanggal_keluar is null",  nativeQuery = true)
	abstract List<Kendaraan> findBytanggalKeluar() throws Exception; 
	
	@Query(value ="select *from Kendaraan k where k.no_plat = ?1",  nativeQuery = true)
	abstract Kendaraan findByjenisKendaraan(String noPlat) throws Exception;
	
	@Query(value = "select *from Kendaraan k where k.tanggal_keluar is not null",  nativeQuery = true)
	abstract List<Kendaraan> findAlltanggalMasuk() throws Exception;
	
	@Query(value ="select *from Kendaraan k where k.no_plat = ?1 and k.tanggal_keluar is null",  nativeQuery = true)
	abstract Kendaraan fingBynoPlat(String noPlat) throws Exception;
}
