package com.cg.cars.service;

import com.cg.cars.beans.User;
import com.cg.cars.dao.IUserRepository;
import com.cg.cars.dao.IUserRepositoryImpl;
//import com.cg.cars.dao.InvalidPasswordException;
import com.cg.cars.exception.InvalidPasswordOrUserIdException;
//import com.cg.cars.dao.JPAUtil;

public class IUserServiceImpl implements IUserService {
	private IUserRepository dao;
	public IUserServiceImpl() {
		dao=new IUserRepositoryImpl();
	}
	
	@Override
	public User addNewUser(User user) {
		dao.beginTransaction();
	    user = dao.addnewUser(user);
		dao.commitTransaction();
		return user;
	}

	@Override
	public User signIn(User user) {
		dao.beginTransaction();
		{
			try {
				//User id;
				user  = dao.signInUser(user);
				if(user.getPassword().equals(user.getPassword()) || user.getUserId().equals(user.getUserId())) {
					return user;
					
				}
				else {
					throw new InvalidPasswordOrUserIdException("Invalid Password or UserId");
				}
			}catch(InvalidPasswordOrUserIdException e) {
				e.getMessage();
			}
		}
		dao.commitTransaction();
		return user;
	}

	@Override
	public User signOut(User user) {
		dao.beginTransaction();
		user=dao.signOut(user);
		dao.commitTransaction();
		 return user;
	}

	@Override
	public User changePassword(long id, User user) {
		dao.beginTransaction();
		 {
			 user=dao.changePassword(id, changePassword(0, null));
            dao.commitTransaction();
		return user;
		}
	}
		
	}


