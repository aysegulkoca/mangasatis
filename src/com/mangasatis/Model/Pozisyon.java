package com.mangasatis.Model;

public class Pozisyon {
	
	private int pozisyonId;
	private String pozisyon;

	public Pozisyon() {
		super();
	}
	
	public Pozisyon(int pozisyonId, String pozisyon) {
		super();
		this.pozisyonId = pozisyonId;
		this.pozisyon = pozisyon;
	}

	public int getPozisyonId() {
		return pozisyonId;
	}

	public void setPozisyonId(int pozisyonId) {
		this.pozisyonId = pozisyonId;
	}

	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

}
