package com.FaultManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FaultManagement.Model.Fault;
import com.FaultManagement.Service.FaultService;

@RestController
@RequestMapping("/FaultManagement")
public class FaultController {

	@Autowired
	private FaultService faultserviceimpl;

	@GetMapping("/getfaultlist")
	public ResponseEntity<List<Fault>> getFault() throws Exception {
		ResponseEntity<List<Fault>> response = null;
		try {
			List<Fault> faultList = faultserviceimpl.getallFault();
			response = new ResponseEntity<List<Fault>>(faultList, HttpStatus.OK);

		} catch (Exception e) {
			throw e;
		}

		return response;

	}

}
