package com.technoglitz.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class TravelExpenseCreateForm {

    @NotEmpty
    private String purpose = "";

    @NotEmpty
    private String startDate = "";

    @NotEmpty
    private String endDate = "";

    @NotNull
    private TravelMode modeOfTravel = TravelMode.AIR;
    
    @NotNull
    private Status status = Status.DRAFT;
    
    @NotEmpty
    private String cost = "";
    
    @NotEmpty
    private String costFromHomeToAirport = "";
    
    @NotEmpty
    private String costFromAirportToAccomodation = "";
    
    @NotEmpty
    private String costOfHotelAccomodation = "";
    
    @NotEmpty
    private String costOfLocalConvayance = "";
    
    @NotEmpty
    private String userId = "";

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

    public void setEndDate(String EndDate) {
        this.endDate = EndDate;
    }

    public TravelMode getModeOfTravel() {
		return modeOfTravel;
	}

	public void setModeOfTravel(TravelMode modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public void setCostFromAirportToAccomodation(
			String costFromAirportToAccomodation) {
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

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
    public String toString() {
        return "TravelExpenseCreateForm{" +
                "purpose='" + purpose +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", modeOfTravel=" + modeOfTravel +
                ", cost=" + cost +
                ", costFromHomeToAirport=" + costFromHomeToAirport +
                ", costFromAirportToAccomodation=" + costFromAirportToAccomodation +
                ", costOfHotelAccomodation=" + costOfHotelAccomodation +
                ", costOfLocalConvayance=" + costOfLocalConvayance +
                ", userId=" + userId +
                '}';
    }

}
