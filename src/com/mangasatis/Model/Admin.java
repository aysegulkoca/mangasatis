package com.mangasatis.Model;

public class Admin {
	
	private int adminId;
	private String adminAdi;
	private String adminSoyadi;
	private String adminEmail;
	private String adminPassword;
	private int pozisyon_pozisyonId;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String adminAdi, String adminSoyadi, String adminEmail,
			String adminPassword, int pozisyon_pozisyonId) {
		super();
		this.adminId = adminId;
		this.adminAdi = adminAdi;
		this.adminSoyadi = adminSoyadi;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.pozisyon_pozisyonId = pozisyon_pozisyonId;
	}
	

	public int getPozisyon_pozisyonId() {
		return pozisyon_pozisyonId;
	}

	public void setPozisyon_pozisyonId(int pozisyon_pozisyonId) {
		this.pozisyon_pozisyonId = pozisyon_pozisyonId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminSoyadi() {
		return adminSoyadi;
	}

	public void setAdminSoyadi(String adminSoyadi) {
		this.adminSoyadi = adminSoyadi;
	}

	public String getAdminAdi() {
		return adminAdi;
	}

	public void setAdminAdi(String adminAdi) {
		this.adminAdi = adminAdi;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
