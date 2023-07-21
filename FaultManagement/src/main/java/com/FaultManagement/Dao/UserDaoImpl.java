package com.FaultManagement.Dao;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;

import com.FaultManagement.Entity.UserEntity;
import com.FaultManagement.Model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
	
	
	@PersistenceContext
	private EntityManager entitymanager;
	

	@Override
	public List<User> getAllUser() throws Exception {
		List<User>  userlist= new ArrayList<User>();
		String querystr ="Select u from UserEntity u";
		Query query=entitymanager.createQuery(querystr);
		List<UserEntity> userList=query.getResultList();
		for(UserEntity list:userList) {
			User  userobj= new User();
			userobj.setUserId(list.getUserId());
			userobj.setUserName(list.getUserName());
			userobj.setPassword(list.getPassword());
			userobj.setUserRole(list.getUserRole());
			userobj.setUserState(list.getUserState());
			userlist.add(userobj);
			
			
		}
		
	
		return userlist;
	}


	@Override
	public String addUser(User user) throws Exception {
		UserEntity entity=new UserEntity();
		
		entity.setUserName(user.getUserName());
		entity.setPassword(user.getPassword());
		entity.setUserRole(user.getUserRole());
		entity.setUserState(user.getUserState());
		entitymanager.persist(entity);
		
		String id =entity.getUserName();
		return id;
	}


	@Override
	public User getUser(String id) throws Exception {
		User user=null;
		UserEntity entity= entitymanager.find(UserEntity.class, id);
		if(entity!=null) {
			 user=new User();
			 user.setUserId(entity.getUserId());
			 user.setUserName(entity.getUserName());
			 user.setPassword(entity.getPassword());
			 user.setUserRole(entity.getUserRole());
			 user.setUserState(entity.getUserState());
			
		}
		
		
		return user;
	}



	

}
