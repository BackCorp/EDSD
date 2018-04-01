package com.edsd.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
	
	private int enabledAgentCount;
	private int disabledAgentCount;
	private int requesterCount;
	private int primesEdsdCount;
	private int nonLogementEdsdCount;
	private int rappelsSalairesEdsdCount;

	public StatsService() {
		super();
	}

	

	public StatsService(int enabledAgentCount, int disabledAgentCount,
			int requesterCount, int primesEdsdCount, int nonLogementEdsdCount,
			int rappelsSalairesEdsdCount) {
		super();
		this.enabledAgentCount = enabledAgentCount;
		this.disabledAgentCount = disabledAgentCount;
		this.requesterCount = requesterCount;
		this.primesEdsdCount = primesEdsdCount;
		this.nonLogementEdsdCount = nonLogementEdsdCount;
		this.rappelsSalairesEdsdCount = rappelsSalairesEdsdCount;
	}

	
	public int getDisabledAgentCount() {
		return disabledAgentCount;
	}

	public void setDisabledAgentCount(int disabledAgentCount) {
		this.disabledAgentCount = disabledAgentCount;
	}

	public int getRequesterCount() {
		return requesterCount;
	}

	public void setRequesterCount(int requesterCount) {
		this.requesterCount = requesterCount;
	}

	public long getEnabledAgentCount() {
		return enabledAgentCount;
	}

	public void setEnabledAgentCount(int agentCount) {
		this.enabledAgentCount = agentCount;
	}

	public int getPrimesEdsdCount() {
		return primesEdsdCount;
	}

	public void setPrimesEdsdCount(int primesEdsdCount) {
		this.primesEdsdCount = primesEdsdCount;
	}

	public int getNonLogementEdsdCount() {
		return nonLogementEdsdCount;
	}

	public void setNonLogementEdsdCount(int nonLogementEdsdCount) {
		this.nonLogementEdsdCount = nonLogementEdsdCount;
	}

	public int getRappelsSalairesEdsdCount() {
		return rappelsSalairesEdsdCount;
	}

	public void setRappelsSalairesEdsdCount(int rappelsSalairesEdsdCount) {
		this.rappelsSalairesEdsdCount = rappelsSalairesEdsdCount;
	}

	@Override
	public String toString() {
		return "StatsService [ enabledAgentCount=" + enabledAgentCount
				+ ", disabledAgentCount=" + disabledAgentCount + ", requesterCount=" + requesterCount
				+ ", totalRequesters=" + ", primesEdsdCount=" + primesEdsdCount
				+ ", nonLogementEdsdCount=" + nonLogementEdsdCount + ", rappelsSalairesEdsdCount="
				+ rappelsSalairesEdsdCount + "]";
	}

}
