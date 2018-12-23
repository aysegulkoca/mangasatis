package com.mangasatis.Model;

public class Musteri {

	private int musteriId;
	private String musteriAdi;
	private String musteriSoyadi;
	private String musteriEmail;
	private String musteriPassword;
	private String musteriAdres;
	private int pozisyon_pozisyonId;
	
	public Musteri() {
		super();
	}
	
	public Musteri (String musteriAdi, String musteriSoyadi) {
		super();
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
	}

	public Musteri (int musteriId, String musteriAdi, 
			String musteriSoyadi, String musteriEmail,
			String musteriPassword, String musteriAdres) {
		super();
		this.musteriId = musteriId;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.musteriEmail = musteriEmail;
		this.musteriPassword = musteriPassword;
		this.musteriAdres = musteriAdres;
	
	}
	

	public int getPozisyon_pozisyonId() {
		return pozisyon_pozisyonId;
	}

	public void setPozisyon_pozisyonId(int pozisyon_pozisyonId) {
		this.pozisyon_pozisyonId = pozisyon_pozisyonId;
	}

	public String getMusteriPassword() {
		return musteriPassword;
	}

	public void setMusteriPassword(String musteriPassword) {
		this.musteriPassword = musteriPassword;
	}

	public String getMusteriEmail() {
		return musteriEmail;
	}

	public void setMusteriEmail(String musteriEmail) {
		this.musteriEmail = musteriEmail;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	public String getMusteriAdres() {
		return musteriAdres;
	}

	public void setMusteriAdres(String musteriAdres) {
		this.musteriAdres = musteriAdres;
	}
}
