package com.member.model;

public class AddressDTO {
	private String zipcode,sido,gugun,dong,bunji;

	public String getZipcode() {
		return zipcode == null ? "" : zipcode.trim();
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido == null ? "" : sido.trim();
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun == null ? "" : gugun.trim();
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong == null ? "" : dong.trim();
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBunji() {
		return bunji == null ? "" : bunji.trim();
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	
	
	
}
