package org.model;

public class Person {
	private String name;
	private String id;
	private String passwd;
	private String job;
	private String[] notice;
	private String gender;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getNotice() {
		return notice;
	}
	public void setNotice(String[] notice) {
		this.notice = notice;
	}
	
}
