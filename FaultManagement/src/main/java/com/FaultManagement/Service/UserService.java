package com.FaultManagement.Service;

import java.util.List;

import com.FaultManagement.Model.User;

public interface UserService {
	public List <User> getAllUser() throws Exception;
	public String addUser(User user) throws Exception;
	public User getUser(String id) throws Exception;
	
	

}
