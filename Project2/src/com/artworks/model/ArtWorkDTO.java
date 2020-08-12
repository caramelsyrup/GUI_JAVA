package com.artworks.model;

public class ArtWorkDTO {
	private int artid;
	private String arttitle,artmaker,artdescription;
	
	public int getArtid() {
		return artid;
	}
	public void setArtid(int artid) {
		this.artid = artid;
	}
	public String getArttitle() {
		return arttitle == null ? "" : arttitle.trim();
	}
	public void setArttitle(String arttitle) {
		this.arttitle = arttitle;
	}
	public String getArtmaker() {
		return artmaker == null ? "" : artmaker.trim();
	}
	public void setArtmaker(String artmaker) {
		this.artmaker = artmaker;
	}
	public String getArtdescription() {
		return artdescription == null ? "" : artdescription.trim();
	}
	public void setArtdescription(String artdescription) {
		this.artdescription = artdescription;
	}
	
	
}
