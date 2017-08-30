package com.technoglitz.domain;

import java.util.Arrays;
import java.util.List;

public class FinDeciForm {
	
	private String id;

	private List<String> finStatus = Arrays.asList("APPROVED","REJECT","REQUEST_FOR_INFO");

	private Status finStat;
	
	public List<String> getFinStatus() {
		return finStatus;
	}

	public void setFinStatus(List<String> finStatus) {
		this.finStatus = finStatus;
	}


	public Status getFinStat() {
		return finStat;
	}

	public void setFinStat(Status finStat) {
		this.finStat = finStat;
	}

	/**
	 * 
	 */
	public FinDeciForm() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
