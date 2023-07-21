package com.FaultManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FaultManagement.Model.Device;
import com.FaultManagement.Service.DeviceService;
@RestController
@RequestMapping("/FaultManagement")
public class DeviceController {

	@Autowired
	private DeviceService deviceserviceimpl;

	@Autowired
	private Environment environment;

	@PostMapping("/addDevice")
	public ResponseEntity<String> addNewDevice(@RequestBody Device device) throws Exception {
		ResponseEntity<String> response = null;
		try {
			String id = deviceserviceimpl.addNewDevice(device);
			String msg = environment.getProperty("UserInterface.ADD_SUCCESS") + id;
			response = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			 throw e;
		}
		return response;

	}

	@GetMapping("/getDevice")
	public ResponseEntity<Device> getDevice(@RequestParam("serialnumber") String serialnumber) throws Exception{
		ResponseEntity<Device> response=null;
		try {
		
			Device device=deviceserviceimpl.getDevice(serialnumber);
			
			response = new ResponseEntity<Device>(device,HttpStatus.OK);
		}catch (Exception e) {
			 throw e;
		}
			
	
			
		
		return response;
		
	}

	@GetMapping("/getdevicelist")
	public ResponseEntity<List<Device>> getDeviceList() throws Exception {
		ResponseEntity<List<Device>> response=null;
		try {
		List<Device> deviceList = deviceserviceimpl.getDeviceList();
		 response = new ResponseEntity<List<Device>>(deviceList, HttpStatus.OK);
		}catch (Exception e) {
			 throw e;
		}

		return response;

	}
	
	@DeleteMapping("/deleteDevice")
	public ResponseEntity<String> deleteDevice(@RequestParam("serialnumber") String serialnumber) throws Exception {
		ResponseEntity<String> response = null;
		try {
			String id = deviceserviceimpl.deleteDevice(serialnumber);
			String msg = environment.getProperty("UserInterface.DELETE_SUCCESS") + id;
			response = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			 throw e;
		}
		return response;

	}
	
	@PutMapping("/updateDevice")
	public ResponseEntity<String> updateDevice(@RequestParam("serialnumber") String serialId,@RequestParam("devicetype") String devicetype) throws Exception {
		ResponseEntity<String> response = null;
		try {
			String id = deviceserviceimpl.updateDevice(serialId, devicetype);
			String msg = environment.getProperty("UserInterface.UPDATE_SUCCESS") + id;
			response = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			 throw e;
		}
		return response;

	}


}
