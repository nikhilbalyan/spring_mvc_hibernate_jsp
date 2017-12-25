package com.spring.mvc.home.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orchard")
public class Orchard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batchID;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orchardDetails", cascade = CascadeType.ALL)
	private Set<CampusMind> campusMind = new HashSet<CampusMind>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orchardDetails", cascade = CascadeType.ALL)
	private Set<Lead> lead = new HashSet<Lead>();	
	

	public Set<CampusMind> getCampusMind() {
		return campusMind;
	}

	public void setCampusMind(Set<CampusMind> campusMind) {
		this.campusMind = campusMind;
	}

	public Set<Lead> getLead() {
		return lead;
	}

	public void setLead(Set<Lead> lead) {
		this.lead = lead;
	}
}
