package com.spring.mvc.home.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campusmind")
public class CampusMind {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int campusMindMID;
	private String campusMindName;
	private String track;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batchId")
	private Orchard orchardDetails;

	public Orchard getOrchardDetails() {
		return orchardDetails;
	}

	public void setOrchardDetails(Orchard orchardDetails) {
		this.orchardDetails = orchardDetails;
	}

	public int getCampusMindMID() {
		return campusMindMID;
	}

	public void setCampusMindMID(int campusMindMID) {
		this.campusMindMID = campusMindMID;
	}

	public String getCampusMindName() {
		return campusMindName;
	}

	public void setCampusMindName(String campusMindName) {
		this.campusMindName = campusMindName;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
