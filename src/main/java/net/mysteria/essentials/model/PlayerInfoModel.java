package net.mysteria.essentials.model;

import java.sql.Date;

public class PlayerInfoModel {
	
	private String username;
	private Date lastTimeSeen;
	private Date firstTimeSeen;
	
	public PlayerInfoModel() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastTimeSeen() {
		return lastTimeSeen;
	}

	public void setLastTimeSeen(Date lastTimeSeen) {
		this.lastTimeSeen = lastTimeSeen;
	}

	public Date getFirstTimeSeen() {
		return firstTimeSeen;
	}

	public void setFirstTimeSeen(Date firstTimeSeen) {
		this.firstTimeSeen = firstTimeSeen;
	}

}
