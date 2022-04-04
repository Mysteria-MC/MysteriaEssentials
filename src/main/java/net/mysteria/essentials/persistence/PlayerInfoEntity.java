package net.mysteria.essentials.persistence;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "playerinfo")
public class PlayerInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "lastTimeSeen", nullable = false) 
	private Date lastTimeSeen;
	
	@Column(name = "firstTimeSeen", nullable = false)
	private Date firstTimeSeen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
