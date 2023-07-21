package com.FaultManagement.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FaultManagement.Dao.DeviceDao;
import com.FaultManagement.Model.Device;
import com.FaultManagement.Validation.Validation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao devicedaoimpl;
	
	@Autowired
	private Validation validation;

	
	@Override
	public String addNewDevice(Device device) throws Exception {

		if (devicedaoimpl.getDevice(device.getSerialNumber()) != null) {
			throw new Exception("Service.DEVICE_ALREADY_EXISTS");
		}

		else if (!(validation.isValidIp(device.getIpAddress()))) {
			throw new Exception("Service.INVALID_IP");

		}

		return devicedaoimpl.addNewDevice(device);
	}

	@Override
	public Device getDevice(String id) throws Exception {
		if (devicedaoimpl.getDevice(id) == null) {
			throw new Exception("Service.DEVICE_CAN'T_FOUND");

		}
		return devicedaoimpl.getDevice(id);
	}

	@Override
	public String deleteDevice(String id) throws Exception {
		if (devicedaoimpl.getDevice(id) == null) {
			throw new Exception("Service.DEVICE_CAN'T_FOUND");

		}
		return devicedaoimpl.deleteDevice(id);
	}

	@Override
	public String updateDevice(String id, String deviceType) throws Exception {
		if (devicedaoimpl.getDevice(id) == null) {
			throw new Exception("Service.DEVICE_CAN'T_FOUND");

		}

		return devicedaoimpl.updateDevice(id, deviceType);
	}

	public List<Device> getDeviceList() throws Exception {
		List<Device> deviceList = devicedaoimpl.getAllDevice();
		if (deviceList.isEmpty()) {
			throw new Exception("Service.List_Not_Found");
		}
		return deviceList;
	}

}
