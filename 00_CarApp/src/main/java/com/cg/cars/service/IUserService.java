package com.cg.cars.service;

import com.cg.cars.beans.User;

public interface IUserService {
	public User addNewUser(User user);
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}
