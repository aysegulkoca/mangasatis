package com.mangasatis.Model;

public class Siparis {
	
	private int siparisId;
	private String siparisTarihi;
	private String teslimTarihi;
	private int urunMiktari;
	private float toplamFiyat;
	private int manga_mangaId;
	private int yayinevi_yayineviId;
	private int musteri_musteriId;
	

	public Siparis() {
		super();
	}
	
	public Siparis(int siparisId, String siparisTarihi, 
			String teslimTarihi, int urunMiktari, 
			float toplamFiyat, int manga_mangaId, 
			int yayinevi_yayineviId, int musteri_musteriId) {
		super();
		this.siparisId = siparisId;
		this.siparisTarihi = siparisTarihi;
		this.teslimTarihi = teslimTarihi;
		this.urunMiktari = urunMiktari;
		this.toplamFiyat = toplamFiyat;
		this.manga_mangaId = manga_mangaId;
		this.yayinevi_yayineviId = yayinevi_yayineviId;
		this.musteri_musteriId = musteri_musteriId;
	}


	public int getSiparisId() {
		return siparisId;
	}


	public void setSiparisId(int siparisId) {
		this.siparisId = siparisId;
	}


	public String getSiparisTarihi() {
		return siparisTarihi;
	}


	public void setSiparisTarihi(String siparisTarihi) {
		this.siparisTarihi = siparisTarihi;
	}


	public String getTeslimTarihi() {
		return teslimTarihi;
	}


	public void setTeslimTarihi(String teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
	}


	public int getUrunMiktari() {
		return urunMiktari;
	}


	public void setUrunMiktari(int urunMiktari) {
		this.urunMiktari = urunMiktari;
	}


	public float getToplamFiyat() {
		return toplamFiyat;
	}


	public void setToplamFiyat(float toplamFiyat) {
		this.toplamFiyat = toplamFiyat;
	}


	public int getManga_mangaId() {
		return manga_mangaId;
	}


	public void setManga_mangaId(int manga) {
		this.manga_mangaId = manga;
	}


	public int getYayinevi_yayineviId() {
		return yayinevi_yayineviId;
	}


	public void setYayinevi_yayineviId(int yayinevi_yayineviId) {
		this.yayinevi_yayineviId = yayinevi_yayineviId;
	}

	public int getMusteri_musteriId() {
		return musteri_musteriId;
	}

	public void setMusteri_musteriId(int musteri) {
		this.musteri_musteriId = musteri;
	}

}
