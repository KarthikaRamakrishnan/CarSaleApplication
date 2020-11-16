package com.cg.cars.dao;

import com.cg.cars.beans.User;
import com.cg.cars.exception.InvalidPasswordOrUserIdException;

public interface IUserRepository {
	public User addnewUser(User user);
	public User signIn(User user) throws InvalidPasswordOrUserIdException;
	public User signOut(User user);
	public User changePassword(long id, User user);
	public void beginTransaction();
	public void commitTransaction();
	public User signInUser(User id);
	
}
