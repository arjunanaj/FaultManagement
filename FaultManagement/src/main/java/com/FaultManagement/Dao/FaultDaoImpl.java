package com.FaultManagement.Dao;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;

import com.FaultManagement.Entity.FaultEntity;
import com.FaultManagement.Model.Fault;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;



@Repository

public class FaultDaoImpl implements FaultDao{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public List<Fault> getAllFault() throws Exception {
		List<Fault> faultlist= new ArrayList<Fault>();
		String querystr= "Select u from  FaultEntity u";
		Query query =entitymanager.createQuery(querystr);
		List<FaultEntity> faultList=query.getResultList();
		 for(FaultEntity List: faultList) {
			 Fault faultobj=new Fault();
			 faultobj.setFaultNumber(List.getFaultNumber());
			 faultobj.setFaultStatus(List.getFaultStatus());
			 faultlist.add(faultobj);
			 
			 
		 }
		
		return faultlist;
	}

}
