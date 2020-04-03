package com.lawencon.springparkiran.dao.impl.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.springparkiran.dao.KendaraanDao;
import com.lawencon.springparkiran.model.Kendaraan;

@Repository("ken_repo_jpa")
public class KendaraanDaoImpl implements KendaraanDao {

	@Autowired
	private KendaraanRepo kendaraanRepos;

	@Override
	public void insertKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		kendaraanRepos.save(kendaraan);

	}

	@Override
	public Kendaraan validKendaraanCheckIn(Kendaraan kendaraan) throws Exception {
		return kendaraanRepos.findByjenisKendaraan(kendaraan.getNoPlat().toLowerCase());
	}

	@Override
	public void insertCheckoutKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		kendaraanRepos.save(kendaraan);

	}

	@Override
	public List<Kendaraan> viewKendaraanCheckIn(String user, String pass) throws Exception {
		return kendaraanRepos.findBytanggalKeluar();
	}

	@Override
	public List<Kendaraan> viewKendaraanCheckOut(String user, String pass) throws Exception {
		return kendaraanRepos.findAlltanggalMasuk();
	}

	@Override
	public Kendaraan cekKendaraan(Kendaraan kendaraan) throws Exception {
		return kendaraanRepos.fingBynoPlat(kendaraan.getNoPlat().toLowerCase());
	}

	@Override
	public Kendaraan cekOutKendaraan(Kendaraan kendaraan) throws Exception {
		return kendaraanRepos.fingBynoPlat(kendaraan.getNoPlat().toLowerCase());
	}

}
