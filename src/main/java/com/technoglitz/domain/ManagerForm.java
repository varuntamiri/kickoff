package com.technoglitz.domain;

public class ManagerForm {

	private String terId;
	
	private String manId;
	
	private String email;
	
	/**
	 * @return the terId
	 */
	public String getTerId() {
		return terId;
	}

	/**
	 * 
	 */
	public ManagerForm() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManagerForm [terId=" + terId + ", manId=" + manId + ", email="
				+ email + "]";
	}

	/**
	 * @param terId the terId to set
	 */
	public void setTerId(String terId) {
		this.terId = terId;
	}

	/**
	 * @param terId
	 * @param manId
	 * @param email
	 */
	public ManagerForm(String terId, String manId, String email) {
		this.terId = terId;
		this.manId = manId;
		this.email = email;
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
