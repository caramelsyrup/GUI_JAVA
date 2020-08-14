package com.events.model;

public class EventsDTO {
	private int eventnum;
	private String eventname,eventhost,eventsche,eventlocation,eventdescip,filename;
	
	public int getEventnum() {
		return eventnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setEventnum(int eventnum) {
		this.eventnum = eventnum;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventhost() {
		return eventhost;
	}
	public void setEventhost(String eventhost) {
		this.eventhost = eventhost;
	}
	public String getEventsche() {
		return eventsche;
	}
	public void setEventsche(String eventsche) {
		this.eventsche = eventsche;
	}
	public String getEventlocation() {
		return eventlocation;
	}
	public void setEventlocation(String eventlocation) {
		this.eventlocation = eventlocation;
	}
	public String getEventdescip() {
		return eventdescip;
	}
	public void setEventdescip(String eventdescip) {
		this.eventdescip = eventdescip;
	}
	
	
}
