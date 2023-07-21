package com.FaultManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fault ")
public class FaultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public Integer faultNumber;
	@Column
	public String faultStatus;

	public Integer getFaultNumber() {
		return faultNumber;
	}

	public void setFaultNumber(Integer faultNumber) {
		this.faultNumber = faultNumber;
	}

	public String getFaultStatus() {
		return faultStatus;
	}

	public void setFaultStatus(String faultStatus) {
		this.faultStatus = faultStatus;
	}

}
