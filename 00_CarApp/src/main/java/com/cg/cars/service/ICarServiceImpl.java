package com.cg.cars.service;

import java.util.List;
import com.cg.cars.dao.*;

import com.cg.cars.exception.InvalidCarIdException;

import com.cg.cars.bean.Car;

public class ICarServiceImpl implements ICarService{
	
	private ICarRepository carRepository;
	
	public ICarServiceImpl() {
		carRepository=new ICarRepositoryImpl();
	}
	@Override
	public Car addCar(Car car) {
		carRepository.beginTransaction();
		car= carRepository.addCar(car);
		carRepository.commitTransaction();
		return car;
		   
	    }

	@Override
	public Car removeCar(long id) {
		Car car=null;
		try {
		carRepository.beginTransaction();
        	 car= carRepository.removeCar(id);
		}catch(InvalidCarIdException e) {
			e.printStackTrace();
			e.getMessage();
		carRepository.commitTransaction();
		}
     return car;
	}

	@Override
	public Car updateCar(long id, Car car) {
	    carRepository.beginTransaction();
	    carRepository.updateCar(id, car);
	    carRepository.commitTransaction();
		return car;
	      
	}

	@Override
	public Car getCar(long id) { 
		carRepository.beginTransaction();
		Car car=carRepository.getCar(id);
		carRepository.commitTransaction();
		return car;
	}

	@Override
	public List<Car> getAllCars() {
	        return carRepository.getAllCars();
	}

	@Override
	public List<Car> getCarsByLocation() {
		return carRepository.getCarsByLocation();
	}

	@Override
	public List<Car> getCarsByModel() {
		return carRepository.getCarsByLocation();
	}

	@Override
	public List<Car> getCarsByBrand() {
		return carRepository.getCarsByBrand();
	}

}
