package net.mysteria.essentials.model;

import java.sql.Date;

public class PlayerInfoModel {
	
	private String username;
	private String lastTimeSeen;
	private String firstTimeSeen;
	
	public PlayerInfoModel() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastTimeSeen() {
		return lastTimeSeen;
	}

	public void setLastTimeSeen(String lastTimeSeen) {
		this.lastTimeSeen = lastTimeSeen;
	}

	public String getFirstTimeSeen() {
		return firstTimeSeen;
	}

	public void setFirstTimeSeen(String firstTimeSeen) {
		this.firstTimeSeen = firstTimeSeen;
	}

}
