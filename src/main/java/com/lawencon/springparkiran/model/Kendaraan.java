package com.lawencon.springparkiran.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "c_kendaraan", columnNames = {"noPlat","tanggalMasuk"})})
public class Kendaraan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String noPlat;
	private String tanggalMasuk;
	private String tanggalKeluar;
	private String jenisKendaraan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoPlat() {
		return noPlat;
	}
	public void setNoPlat(String noPlat) {
		this.noPlat = noPlat;
	}
	public String getTanggalMasuk() {
		return tanggalMasuk;
	}
	public void setTanggalMasuk(String tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}
	public String getTanggalKeluar() {
		return tanggalKeluar;
	}
	public void setTanggalKeluar(String tanggalKeluar) {
		this.tanggalKeluar = tanggalKeluar;
	}
	public String getJenisKendaraan() {
		return jenisKendaraan;
	}
	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

}
