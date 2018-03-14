package com.edsd.service;

import org.springframework.stereotype.Component;

@Component
public class StatsService {
	
	private long userCount;
	private long adminCount;
	private long agentCount;


	public StatsService() {
		super();
	}
	
	public StatsService(long userCount, long adminCount, long agentCount) {
		super();
		this.userCount = userCount;
		this.agentCount = agentCount;
		this.adminCount = adminCount;
	}

	public long getUserCount() {
		return userCount;
	}

	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}
	
	public long getAdminCount() {
		return adminCount;
	}

	public void setAdminCount(long adminCount) {
		this.adminCount = adminCount;
	}

	public long getAgentCount() {
		return agentCount;
	}

	public void setAgentCount(long agentCount) {
		this.agentCount = agentCount;
	}
	
	@Override
	public String toString() {
		return "Stats [userCount=" + userCount + "]";
	}

}
