package com.spring.mvc.home.mapping;

import java.util.List;

import com.spring.mvc.home.beans.ALLClass;
import com.spring.mvc.home.beans.CampusMind;
import com.spring.mvc.home.beans.Orchard;

public interface UserDAOInterface {
	public ALLClass readALL(int batchID);
	
	public boolean read(int batchId);

	public boolean update(Orchard num);

	public CampusMind getCampusMindById(int id);

	public Orchard getOrchardByTrack(String track);

	boolean add(ALLClass data);
	
	public List<ALLClass> getAllDetails();

	boolean delete(String id);
}
