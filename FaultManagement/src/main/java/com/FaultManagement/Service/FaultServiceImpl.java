package com.FaultManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FaultManagement.Dao.FaultDao;

import com.FaultManagement.Model.Fault;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FaultServiceImpl implements FaultService {

	@Autowired
	private FaultDao faultdao;

	@Override
	public List<Fault> getallFault() throws Exception {
		List<Fault> list = faultdao.getAllFault();
		if (list.size() == 0) {
			throw new Exception("Service.List_Not_Found");
		}

		return list;
	}

}
