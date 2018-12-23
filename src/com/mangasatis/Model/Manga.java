package com.mangasatis.Model;


public class Manga {
	
	private int mangaId;
	private String mangaAdi;
	private String mangaAciklamasi;
	private float mangaFiyati;
	private int mangaMiktari;
	private String mangaResmi;
	private int yayinevi_yayineviId;
	private int tur_turId;
	
	public Manga() {
		super();
	}
	
	public Manga(int mangaId, String mangaAdi) {
		super();
		this.mangaId = mangaId;
		this.mangaAdi = mangaAdi;
	}

	public Manga(int mangaId, String mangaAdi, String mangaAciklamasi, int mangaFiyati,
			int mangaMiktari) {
		super();
		this.mangaId = mangaId;
		this.mangaAdi = mangaAdi;
		this.mangaAciklamasi = mangaAciklamasi;
		this.mangaFiyati = mangaFiyati;
		this.mangaMiktari = mangaMiktari;

	}
	

	public int getMangaId() {
		return mangaId;
	}

	public void setMangaId(int mangaId) {
		this.mangaId = mangaId;
	}

	public String getMangaAdi() {
		return mangaAdi;
	}

	public void setMangaAdi(String mangaAdi) {
		this.mangaAdi = mangaAdi;
	}

	public String getMangaAciklamasi() {
		return mangaAciklamasi;
	}

	public void setMangaAciklamasi(String mangaAciklamasi) {
		this.mangaAciklamasi = mangaAciklamasi;
	}

	public float getMangaFiyati() {
		return mangaFiyati;
	}

	public void setMangaFiyati(float mangaFiyati) {
		this.mangaFiyati = mangaFiyati;
	}

	public int getMangaMiktari() {
		return mangaMiktari;
	}

	public void setMangaMiktari(int mangaMiktari) {
		this.mangaMiktari = mangaMiktari;
	}

	public String getMangaResmi() {
		return mangaResmi;
	}

	public void setMangaResmi(String mangaResmi) {
		this.mangaResmi = mangaResmi;
	}

	public int getYayinevi_yayineviId() {
		return yayinevi_yayineviId;
	}

	public void setYayinevi_yayineviId(int yayinevi_yayineviId) {
		this.yayinevi_yayineviId = yayinevi_yayineviId;
	}

	public int getTur_turId() {
		return tur_turId;
	}

	public void setTur_turId(int tur_turId) {
		this.tur_turId = tur_turId;
	}

}
