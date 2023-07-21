
package com.FaultManagement.Dao;

import java.util.List;

import com.FaultManagement.Model.User;

public interface UserDao {
	
	public List < User> getAllUser() throws Exception;
	public String addUser(User user) throws Exception;
	public User getUser(String id) throws Exception;
	


}
