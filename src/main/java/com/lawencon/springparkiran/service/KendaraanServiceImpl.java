package com.lawencon.springparkiran.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.springparkiran.dao.KendaraanDao;
import com.lawencon.springparkiran.model.Kendaraan;

@Service
@Transactional
public class KendaraanServiceImpl implements KendaraanService {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("ken_repo_hibernate") 
	private KendaraanDao h_dao;
	
	@Autowired
	@Qualifier("ken_repo_jpa") 
	private KendaraanDao jpa_dao;

	@Override
	public String insertKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		if (userService.validUserHiber(user, pass) == true) {
			if (validKendaraanCheckIn(kendaraan) == true) {
				h_dao.insertKendaraan(kendaraan, user, pass);
				return "Berhasil";
			} else {
				return "Gagal insert kendaraan ";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public Boolean validKendaraanCheckIn(Kendaraan kendaraan) throws Exception {
		Kendaraan ken2 = null;
		try {
			ken2 = h_dao.validKendaraanCheckIn(kendaraan);
		} catch (Exception e) {

		}
		if (ken2 != null) {
			if (cekPlat(kendaraan, ken2)) {
				if (ken2.getNoPlat().toLowerCase().equals(kendaraan.getNoPlat().toLowerCase())
						&& ken2.getTanggalMasuk().equals(kendaraan.getTanggalMasuk())) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			if (cekPlat(kendaraan, ken2)) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public Kendaraan cekKendaraan(Kendaraan kendaraan) throws Exception {
		Kendaraan ken2 = null;
		try {
			ken2 = h_dao.cekKendaraan(kendaraan);
		} catch (Exception e) {

		}
		return ken2;
	}

	@Override
	public Boolean cekPlat(Kendaraan kendaraan, Kendaraan ken2) throws Exception {
		if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().length() <= 8) {
			if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().substring(0, 1).equals("b")) {
				try {
					Integer.parseInt(kendaraan.getNoPlat().substring(1, 5));
					if (kendaraan.getNoPlat().substring(1, 5).length() <= 4
							&& kendaraan.getNoPlat().substring(1, 5).length() >= 1) {
						try {
							Integer.parseInt(kendaraan.getNoPlat().substring(5, 8));
							return false;
						} catch (Exception e) {
							return true;
						}
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String insertCheckoutKendaraan(Kendaraan kendaraan, String user, String pass) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		kendaraan = cekKendaraan(kendaraan);
		kendaraan.setTanggalKeluar(String.valueOf(dateFormat.format(date)));
		if (userService.validUserHiber(user, pass) == true) {
			if (validKendaraanCheckOut(kendaraan) == false) {
				h_dao.insertCheckoutKendaraan(kendaraan, user, pass);
				return "Berhasil";
			} else {
				return "Kendaraan tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public Boolean validKendaraanCheckOut(Kendaraan kendaraan) throws Exception {
		Kendaraan ken2 = cekKendaraan(kendaraan);
		if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().length() <= 8) {
			if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().substring(0, 1).equals("b")) {
				try {
					Integer.parseInt(kendaraan.getNoPlat().substring(1, 5));
					if (kendaraan.getNoPlat().substring(1, 5).length() <= 4
							&& kendaraan.getNoPlat().substring(1, 5).length() >= 1) {
						try {
							Integer.parseInt(kendaraan.getNoPlat().substring(5, 8));
							return false;
						} catch (Exception e) {
							if (ken2 != null) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public List<Kendaraan> viewKendaraanCheckIn(String user, String pass) throws Exception {
		if (userService.validUserHiber(user, pass) == true) {
			return h_dao.viewKendaraanCheckIn(user, pass);
		}else {
			return null;
		}
	}

	@Override
	public List<Kendaraan> viewKendaraanCheckOut(String user, String pass) throws Exception {
		if (userService.validUserHiber(user, pass) == true) {
			return h_dao.viewKendaraanCheckOut(user, pass);
		}
		return null;
	}

	@Override
	public String insertKendaraanJpa(Kendaraan kendaraan, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			if (validKendaraanCheckIn(kendaraan) == false) {
				return "Gagal insert kendaraan";
			} else {
				jpa_dao.insertKendaraan(kendaraan, user, pass);
				return "Berhasil";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String insertCheckoutKendaraanJpa(Kendaraan kendaraan, String user, String pass) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		try {
			kendaraan = jpa_dao.cekOutKendaraan(kendaraan);
			kendaraan.setTanggalKeluar(String.valueOf(dateFormat.format(date)));
		} catch (Exception e) {

		}
		if (userService.validUserJpa(user, pass) == true) {
			if (validKendaraanCheckOut(kendaraan) == false) {
				jpa_dao.insertCheckoutKendaraan(kendaraan, user, pass);
				return "Berhasil";
			} else {
				return "Kendaraan tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<Kendaraan> viewKendaraanCheckInJpa(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return jpa_dao.viewKendaraanCheckIn(user, pass);
		}
		return null;
	}

	@Override
	public List<Kendaraan> viewKendaraanCheckOutJpa(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return jpa_dao.viewKendaraanCheckOut(user, pass);
		}
		return null;
	}

}
