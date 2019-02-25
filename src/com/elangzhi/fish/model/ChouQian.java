package com.elangzhi.fish.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

public class ChouQian {
	
	@JsonSerialize(using = ToStringSerializer.class)
	private Long personId;
	private String personName;
	private Integer personNumber;
	private Long gameId;
	private Integer chang;
    private Integer qu;
	private Integer room;
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(Integer personNumber) {
		this.personNumber = personNumber;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Integer getChang() {
		return chang;
	}
	public void setChang(Integer chang) {
		this.chang = chang;
	}
	public Integer getQu() {
		return qu;
	}
	public void setQu(Integer qu) {
		this.qu = qu;
	}
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
}
