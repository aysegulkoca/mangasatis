package com.mangasatis.Model;

public class YayinEvi {

	private int yayineviId;
	private String yayineviAdi;
	
	public YayinEvi() {
		super();
	}
	
	public YayinEvi(int yayineviId, String yayineviAdi) {
		super();
		this.yayineviId = yayineviId;
		this.yayineviAdi = yayineviAdi;
	}

	public String getYayinEviAdi() {
		return yayineviAdi;
	}

	public void setYayinEviAdi(String yayineviAdi) {
		this.yayineviAdi = yayineviAdi;
	}

	public int getYayineviId() {
		return yayineviId;
	}

	public void setYayineviId(int yayineviId) {
		this.yayineviId = yayineviId;
	}

}
