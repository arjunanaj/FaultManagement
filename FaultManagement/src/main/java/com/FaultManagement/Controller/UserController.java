package com.FaultManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FaultManagement.Model.User;
import com.FaultManagement.Service.UserService;

@RestController
@RequestMapping("/FaultManagement")
public class UserController {
	@Autowired
	private UserService userserviceimpl;
	
	@Autowired
	private Environment environment;
	

	@PostMapping("/adduser")
	public ResponseEntity<String> addNewUser(@RequestBody User user) throws Exception {

		String msg = null;
		ResponseEntity<String> response = null;

		try {
			String id = userserviceimpl.addUser(user);
			msg = environment.getProperty("UserInterface.ADD_SUCCESS") + id;
			response = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}


	@GetMapping("/getuserlist")
	public ResponseEntity<List<User>> getUserList() throws Exception {
		ResponseEntity<List<User>> response=null;
		try {
		List<User> UserList = userserviceimpl.getAllUser();
		 response = new ResponseEntity<List<User>>(UserList, HttpStatus.OK);
		}catch (Exception e) {
			 throw e;
		}
		return response;

	}

	@GetMapping("/getuser")
	public ResponseEntity<User> getUser(@RequestParam("username")String username) throws Exception {
		ResponseEntity<User> response = null;
        try {
		User user = userserviceimpl.getUser(username);
		response = new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (Exception e) {
			 throw e;
		}

		return response;

	}

}
