package com.technoglitz.domain;

import java.util.Arrays;
import java.util.List;

public class ManagerDeciForm {

	private String terId;
	
	private String manId;
	
	private List<String> manStatus = Arrays.asList("SUBMIT_TO_FIN","REJECT","REQUEST_FOR_INFO");

	private Status manStat;
	
	public List<String> getManStatus() {
		return manStatus;
	}

	public void setManStatus(List<String> manStatus) {
		this.manStatus = manStatus;
	}


	public Status getManStat() {
		return manStat;
	}

	public void setManStat(Status manStat) {
		this.manStat = manStat;
	}

	/**
	 * @return the terId
	 */
	public String getTerId() {
		return terId;
	}

	/**
	 * 
	 */
	public ManagerDeciForm() {
		
	}

	/**
	 * @param terId the terId to set
	 */
	public void setTerId(String terId) {
		this.terId = terId;
	}


	/**
	 * @return the manId
	 */
	public String getManId() {
		return manId;
	}

	/**
	 * @param manId the manId to set
	 */
	public void setManId(String manId) {
		this.manId = manId;
	}

}
