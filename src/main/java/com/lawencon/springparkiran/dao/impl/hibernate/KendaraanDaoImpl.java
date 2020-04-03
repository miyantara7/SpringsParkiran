package com.lawencon.springparkiran.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.springparkiran.dao.KendaraanDao;
import com.lawencon.springparkiran.model.Kendaraan;

@Repository("ken_repo_hibernate")
public class KendaraanDaoImpl extends BaseHibernate implements KendaraanDao{

	@Override
	public void insertKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		em.persist(kendaraan);
	}

	@Override
	public Kendaraan validKendaraanCheckIn(Kendaraan kendaraan) throws Exception {
		Query q = em.createQuery("from Kendaraan where noPlat =: noParam").setParameter("noParam",
				kendaraan.getNoPlat().toLowerCase());
		return (Kendaraan) q.getSingleResult();
	}

	@Override
	public void insertCheckoutKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		em.merge(kendaraan);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Kendaraan> viewKendaraanCheckIn(String user, String pass) throws Exception {
		Query q = em.createQuery("from Kendaraan where tanggalKeluar is null");
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Kendaraan> viewKendaraanCheckOut(String user, String pass) throws Exception {
		Query q = em.createQuery("from Kendaraan where tanggalKeluar is not null");
		return q.getResultList();
	}

	@Override
	public Kendaraan cekKendaraan(Kendaraan kendaraan) throws Exception {
		Query q = em.createQuery("from Kendaraan where noPlat =: noParam and tanggalKeluar is null")
				.setParameter("noParam", kendaraan.getNoPlat().toLowerCase());
		return (Kendaraan) q.getSingleResult();
	}

	@Override
	public Kendaraan cekOutKendaraan(Kendaraan kendaraan) throws Exception {
		Query q = em.createQuery("from Kendaraan where noPlat =: noParam and tanggalKeluar is null")
				.setParameter("noParam", kendaraan.getNoPlat().toLowerCase());
		return (Kendaraan) q.getSingleResult();
	}

}
