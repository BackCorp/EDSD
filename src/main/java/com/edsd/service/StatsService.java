package com.edsd.service;

import org.springframework.stereotype.Component;

@Component
public class StatsService {
	
	private int userCount;
	private int adminCount;
	private int agentCount;
	private int totalRequesters;


	public StatsService() {
		super();
	}
	
	public StatsService(int userCount, int adminCount, int agentCount, int totalRequesters) {
		super();
		this.userCount = userCount;
		this.agentCount = agentCount;
		this.adminCount = adminCount;
		this.totalRequesters = totalRequesters;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
	public int getAdminCount() {
		return adminCount;
	}

	public void setAdminCount(int adminCount) {
		this.adminCount = adminCount;
	}

	public long getAgentCount() {
		return agentCount;
	}

	public void setAgentCount(int agentCount) {
		this.agentCount = agentCount;
	}
	
	@Override
	public String toString() {
		return "Stats [userCount=" + userCount + "]";
	}

	public void setTotalRequesters(int totalRequesters) {
		this.totalRequesters = totalRequesters;
	}

}
