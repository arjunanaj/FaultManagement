package com.FaultManagement.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.FaultManagement.Entity.DeviceEntity;
import com.FaultManagement.Model.Device;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository


public class DeviceDaoImpl  implements DeviceDao{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public List<Device> getAllDevice() throws Exception {
		List<Device> devicelist= new ArrayList<Device>();
		String querystr="Select u from DeviceEntity u";
		Query query = entitymanager.createQuery(querystr);
		@SuppressWarnings("unchecked")
		List<DeviceEntity> deviceList= query.getResultList();
		for(DeviceEntity list:deviceList) {
			Device deviceobj=new Device();
			deviceobj.setSerialNumber(list.getSerialNumber());
			deviceobj.setIpAddress(list.getIpAddress());
			deviceobj.setDeviceType(list.getDeviceType());
			deviceobj.setDeviceStatus(list.getDeviceStatus());
			devicelist.add(deviceobj);
			
		}
		
		
		

		return devicelist ;
	}

	@Override
	public String addNewDevice(Device device) throws Exception {
		DeviceEntity entity=new DeviceEntity();
		entity.setSerialNumber(device.getSerialNumber());
		entity.setIpAddress(device.getIpAddress());
		entity.setDeviceType(device.getDeviceType());
        entity.setDeviceStatus(device.getDeviceStatus());
		entitymanager.persist(entity);
		
		String id=entity.getSerialNumber();
		

		return id;
	}

	@Override
	public Device getDevice(String serialnumber) throws Exception {
		Device device=null;
		DeviceEntity entity =entitymanager.find(DeviceEntity .class,serialnumber);
		if(entity!=null) {
			device =new Device();
			device.setSerialNumber(entity.getSerialNumber());
			device.setIpAddress(entity.getIpAddress());
			device.setDeviceType(entity.getDeviceType());
			device.setDeviceStatus(entity.getDeviceStatus());
		}

		return device;
	}

	@Override
	public String deleteDevice(String id) throws Exception {
		DeviceEntity entity=entitymanager.find(DeviceEntity .class, id);
		entitymanager.remove(entity);
		String deviceid =entity.getSerialNumber();
		
		return deviceid ;
	}

	@Override
	public String updateDevice(String id ,String devicetype) throws Exception {
		DeviceEntity entity=entitymanager.find(DeviceEntity .class, id);
		entity.setDeviceType(devicetype);
		entitymanager.persist(entity);
		return entity.getSerialNumber();
	}


}
