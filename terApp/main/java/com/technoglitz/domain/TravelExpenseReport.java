package com.technoglitz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ter")
public class TravelExpenseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "startDate", nullable = false)
    private String startDate;

    @Column(name = "endDate", nullable = false)
    private String endDate;
    
    @Column(name = "modeOfTravel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TravelMode modeOfTravel;
    
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "cost", nullable = false)
    private String cost;
    
    @Column(name = "costFromHomeToAirport", nullable = false)
    private String costFromHomeToAirport;
    
    @Column(name = "costFromAirportToAccomodation", nullable = false)
    private String costFromAirportToAccomodation;
    
    @Column(name = "costOfHotelAccomodation", nullable = false)
    private String costOfHotelAccomodation;
    
    @Column(name = "costOfLocalConvayance", nullable = false)
    private String costOfLocalConvayance;

    @Column(name = "userId", nullable = false)
    private Long userId;
    
    @Column(name = "manId")
    private Long manId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public TravelMode getModeOfTravel() {
		return modeOfTravel;
	}

	public void setModeOfTravel(TravelMode modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCostFromHomeToAirport() {
		return costFromHomeToAirport;
	}

	public void setCostFromHomeToAirport(String costFromHomeToAirport) {
		this.costFromHomeToAirport = costFromHomeToAirport;
	}

	public String getCostFromAirportToAccomodation() {
		return costFromAirportToAccomodation;
	}

	public void setCostFromAirportToAccomodation(String costFromAirportToAccomodation) {
		this.costFromAirportToAccomodation = costFromAirportToAccomodation;
	}

	public String getCostOfHotelAccomodation() {
		return costOfHotelAccomodation;
	}

	public void setCostOfHotelAccomodation(String costOfHotelAccomodation) {
		this.costOfHotelAccomodation = costOfHotelAccomodation;
	}

	public String getCostOfLocalConvayance() {
		return costOfLocalConvayance;
	}

	public void setCostOfLocalConvayance(String costOfLocalConvayance) {
		this.costOfLocalConvayance = costOfLocalConvayance;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getManId() {
		return manId;
	}

	public void setManId(Long manId) {
		this.manId = manId;
	}


}
