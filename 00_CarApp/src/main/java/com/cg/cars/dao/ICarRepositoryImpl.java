package com.cg.cars.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.cg.cars.beans.Car;
import com.cg.cars.exception.InvalidCarIdException;
//import com.cg.cars.exception.InvalidCarIdException;
//import com.cg.cars.exception.RegYearException;



public class ICarRepositoryImpl implements ICarRepository{
	
	private EntityManager entityManager;
	
	public ICarRepositoryImpl() {
		entityManager=JPAUtil.getEntityManager();
	}
	@Override
	public Car addCar(Car car) {
	       entityManager.persist(car);
	     return car;
	}

	@Override
	public Car removeCar(long id) throws InvalidCarIdException{
		Car car= entityManager.find(Car.class, id);
		if(car==null) {
			throw new InvalidCarIdException("Invalid CarId");
		}
	        entityManager.remove(car);
	        return car;
	    }

	@Override
	public Car updateCar(long id, Car car) {
		  entityManager.find(Car.class,car.getCarId());
	        entityManager.merge(car);
	        return car;
	}

	@Override
	public Car getCar(long id) {
	       //Car car =entityManager.find(Car.class, id);
		Car car=null;
		Query query=entityManager.createQuery("Select c from Appointment c where c.CarId=id",Car.class);
		car=(Car) query.getSingleResult();
	       return car;
	}

	@Override
	public List<Car> getAllCars() {
		   List<Car> carsList= entityManager.createQuery("Select c from Car c",Car.class).getResultList();
	   return carsList;
	}

	@Override
	public List<Car> getCarsByLocation() {
		TypedQuery<Car> query=entityManager.createQuery("select c from Car c where c.registrationState=REG_STATE",Car.class);
		List<Car> car=query.getResultList();
		return car;
	}

	@Override
	public List<Car> getCarsByModel() {
		TypedQuery<Car> query=entityManager.createQuery("select c from Car c where c.model=MODEL",Car.class);
		List<Car> car=query.getResultList();
		return car;
	}

	@Override
	public List<Car> getCarsByBrand() {
		TypedQuery<Car> query=entityManager.createQuery("select c from Car c where c.brand=BRAND",Car.class);
		List<Car> car=query.getResultList();
		return car;
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

}
