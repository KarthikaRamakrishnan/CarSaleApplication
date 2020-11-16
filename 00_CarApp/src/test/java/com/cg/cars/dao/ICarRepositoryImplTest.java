package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cg.cars.bean.Car;
import com.cg.cars.exception.InvalidCarIdException;


class ICarRepositoryImplTest {
	ICarRepositoryImpl carRepository;
	 Car car;
	@BeforeEach
	public void setUp() throws Exception {
		car=new Car();
		carRepository=new ICarRepositoryImpl();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		car=null;
		carRepository=null;
	}
	@Test
	void testAddCar() {
		car.setCarId(123);
		car.setBrand("Rover");
		car.setModel("Velar2");
		car.setVariant("s4320");
		car.setRegistrationYear(LocalDate.of(2011, 11, 10));
		car.setRegistrationState("AP");
		Car result1=carRepository.addCar(car);
		assertEquals(result1.hashCode(),car.hashCode());
		System.out.println(result1.toString());
		}

	@Test
	void testRemoveCar() throws InvalidCarIdException {
		car.setCarId(123);
		Car result4=carRepository.removeCar(123);
		System.out.println(result4.toString());
		assertEquals(result4.hashCode(),car.hashCode());
		
		
	}

	@Test
	void testUpdateCar() {
		car.setBrand("Mercedes");
		Car result2=carRepository.updateCar(123, car);
		assertEquals(result2.hashCode(),car.hashCode());
		System.out.println(result2.toString());
	}

	@Test
	void testGetCar() {
		car.setCarId(1234);
		Car result3=carRepository.getCar(1234);
		System.out.println(result3.toString());
		assertEquals(result3.hashCode(),car.hashCode());
	}

	@Test
	void testGetAllCars() {
		List<Car> cars=carRepository.getAllCars();
		System.out.println(cars.toString());
		
	}

	@Test
	void testGetCarsByLocation() {
		List<Car> cars=carRepository.getCarsByLocation();
		System.out.println(cars.toString());
	}

	@Test
	void testGetCarsByModel() {
		List<Car> cars=carRepository.getCarsByModel();
		System.out.println(cars.toString());
	}

	@Test
	void testGetCarsByBrand() {
		List<Car> cars=carRepository.getCarsByBrand();
		System.out.println(cars.toString());
	}

}
