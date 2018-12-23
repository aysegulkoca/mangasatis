package com.mangasatis.Model;

public class Tur {
	
	private int turId;
	private String tur;

	public Tur() {
		super();
	}
	
	public Tur(int turId, String tur) {
		super();
		this.turId = turId;
		this.tur = tur;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public int getTurId() {
		return turId;
	}

	public void setTurId(int turId) {
		this.turId = turId;
	}

}
