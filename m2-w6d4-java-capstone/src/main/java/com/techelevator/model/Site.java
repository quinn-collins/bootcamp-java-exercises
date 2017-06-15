package com.techelevator.model;

public class Site {
	private long site_id;
	private long camp_id;
	private long site_number;
	private long max_occupency;
	private boolean accessible;
	private long max_rv_length;
	private boolean utilities;
	public long getSite_id() {
		return site_id;
	}
	public void setSite_id(long site_id) {
		this.site_id = site_id;
	}
	public long getCamp_id() {
		return camp_id;
	}
	public void setCamp_id(long camp_id) {
		this.camp_id = camp_id;
	}
	public long getSite_number() {
		return site_number;
	}
	public void setSite_number(long site_number) {
		this.site_number = site_number;
	}
	public long getMax_occupency() {
		return max_occupency;
	}
	public void setMax_occupency(long max_occupency) {
		this.max_occupency = max_occupency;
	}
	public boolean isAccessible() {
		return accessible;
	}
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	public long getMax_rv_length() {
		return max_rv_length;
	}
	public void setMax_rv_length(long max_rv_length) {
		this.max_rv_length = max_rv_length;
	}
	public boolean isUtilities() {
		return utilities;
	}
	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
	
	
}
