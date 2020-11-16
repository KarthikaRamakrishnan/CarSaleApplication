package com.cg.cars.dao;



import javax.persistence.EntityManager;
import com.cg.cars.beans.User;
import com.cg.cars.exception.InvalidPasswordOrUserIdException;
public class IUserRepositoryImpl implements IUserRepository
{ private EntityManager entityManager;
	public IUserRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override 
	public User addnewUser(User user) {
		entityManager.persist(user);
		return user;
	}
   @Override
     public User signIn(User user) throws InvalidPasswordOrUserIdException{
	   User ur = ((User) entityManager).getUser(user.getUserId());
	if(ur.getPassword().equals(ur.getPassword())|| ur.getUserId().equals(ur.getUserId())) {
		return ur;
	} else {
      throw new InvalidPasswordOrUserIdException("Invalid Password or UserId");
    }
   }
   
		@Override
	public User signOut(User user) {
		entityManager.persist(user);
		return null;
	}

	@Override
	public User changePassword(long id, User user)  {
		User ur1  = entityManager.find(User.class,id);
		ur1.setPassword(user.getPassword());
		return entityManager.merge(ur1);
	}
	

	@Override
	public void beginTransaction() {
   entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public User signInUser(User id) {
		User user = null;
		entityManager.persist(user);
		return null;
	}

	

	
}

