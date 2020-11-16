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
		car= carRepository.addCar(car);
		return car;
		   
	    }

	@Override
	public Car removeCar(long id) {
		Car car=null;
		try {
         car= carRepository.removeCar(id);
		}catch(InvalidCarIdException e) {
			e.printStackTrace();
			e.getMessage();
		}
     return car;
	}

	@Override
	public Car updateCar(long id, Car car) {
	    carRepository.updateCar(id, car);
		return car;
	      
	}

	@Override
	public Car getCar(long id) { 
		Car car=carRepository.getCar(id);
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
