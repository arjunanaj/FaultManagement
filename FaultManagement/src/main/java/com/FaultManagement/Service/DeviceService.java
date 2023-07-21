package com.FaultManagement.Service;

import java.util.List;

import com.FaultManagement.Model.Device;

public interface DeviceService {
	
	public List<Device> getDeviceList()throws Exception;
	public String addNewDevice(Device device ) throws Exception;
	public Device getDevice(String id) throws Exception;
	public String deleteDevice(String id ) throws Exception;
	public String updateDevice(String id,String devicetype ) throws Exception;
	
}
