package com.spring.mvc.home.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lead")
public class Lead {
//	private int batchID;
	@Id
	private int leadMID;
	private String leadName;
	private String track;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batchId")
	private Orchard orchardDetails;

	public int getLeadMID() {
		return leadMID;
	}

	public void setLeadMID(int leadMID) {
		this.leadMID = leadMID;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Orchard getOrchardDetails() {
		return orchardDetails;
	}

	public void setOrchardDetails(Orchard orchardDetails) {
		this.orchardDetails = orchardDetails;
	}

}
