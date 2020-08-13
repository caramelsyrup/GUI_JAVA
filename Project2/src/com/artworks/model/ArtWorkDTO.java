package com.artworks.model;

public class ArtWorkDTO {
	private int artid;
	private String arttitle,artmaker,artdescription,filename;
	
	public int getArtid() {
		return artid;
	}
	public void setArtid(int artid) {
		this.artid = artid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getArttitle() {
		return arttitle;
	}
	public void setArttitle(String arttitle) {
		this.arttitle = arttitle;
	}
	public String getArtmaker() {
		return artmaker;
	}
	public void setArtmaker(String artmaker) {
		this.artmaker = artmaker;
	}
	public String getArtdescription() {
		return artdescription;
	}
	public void setArtdescription(String artdescription) {
		this.artdescription = artdescription;
	}
	
	
}
