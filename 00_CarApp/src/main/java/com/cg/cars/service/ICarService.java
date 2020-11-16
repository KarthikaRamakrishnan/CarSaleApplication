package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Car;
import com.cg.cars.exception.InvalidAppointmentException;

public interface ICarService {
	public Car addCar(Car car);
	public Car removeCar(long id) throws InvalidAppointmentException;
	public Car updateCar(long id, Car car);
	public Car getCar(long id);
	public List<Car> getAllCars();
	public List<Car> getCarsByLocation();
	public List<Car> getCarsByModel();
	public List<Car> getCarsByBrand();

}
