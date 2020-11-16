package com.cg.cars.dao;

import java.util.List;


import com.cg.cars.exception.InvalidCarIdException;
//import com.cg.cars.exception.RegYearException;

import com.cg.cars.beans.Car;
public interface ICarRepository {
	public Car addCar(Car car);// throws RegYearException;
	public Car removeCar(long id) throws InvalidCarIdException; 
	public Car updateCar(long id, Car car);// throws InvalidCarIdException;
	public Car getCar(long id);
	public List<Car> getAllCars();
	public List<Car> getCarsByLocation();
	public List<Car> getCarsByModel();
	public List<Car> getCarsByBrand();
	
	public abstract void commitTransaction();

	public abstract void beginTransaction();
	

}
