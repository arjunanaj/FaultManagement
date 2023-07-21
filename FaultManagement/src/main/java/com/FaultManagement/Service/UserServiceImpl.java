package com.FaultManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FaultManagement.Dao.UserDao;

import com.FaultManagement.Model.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userdao;

	@Override
	public List<User> getAllUser() throws Exception {
		List<User> list = userdao.getAllUser();

		return list;
	}

	@Override
	public String addUser(User user) throws Exception {
		if (userdao.getUser(user.getUserName()) != null) {
			throw new Exception("Service.DEVICE_ALREADY_EXISTS");

		}

		return userdao.addUser(user);
	}

	@Override
	public User getUser(String id) throws Exception {
		if (userdao.getUser(id) == null) {
			throw new Exception("Service.DUPLICATE_FOUND");
		}

		return userdao.getUser(id);
	}

}
