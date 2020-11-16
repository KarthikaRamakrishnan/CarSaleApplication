package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Car;
import com.cg.cars.service.ICarService;
import com.cg.cars.service.ICarServiceImpl;

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
		car.setCarId(1234);
		car.setBrand("Maruthi");
		car.setModel("Alto800");
		car.setVariant("e6250");
		//car.setRegistrationYear(LocalDate.of(2020, 11, 12));
		assertEquals(car.getCarId(),1234);
		assertEquals(car.getBrand(),"Maruthi");
		assertEquals(car.getModel(),"Alto800");
		assertEquals(car.getVariant(),"e6250");
		//assertTrue(car.getRegistrationYear(),LocalDate.of(2020, 11, 12));
	}

	@Test
	void testRemoveCar()  {
		car.setCarId(1112);
		assertEquals(car.getCarId(),1112);
		
	}

	@Test
	void testUpdateCar() {
		car.setCarId(1113);
		assertEquals(car.getCarId(),1113);
	}

	@Test
	void testGetCar() {
		car.setCarId(1111);
		//List<Car> cars=carRepository.getCar(1111);
	}

	@Test
	void testGetAllCars() {
		car.setCarId(1234);
		car.setBrand("Maruthi");
		car.setModel("Alto800");
		car.setVariant("e6250");
		List<Car> cars=carRepository.getAllCars();
		assertNotNull(cars);
	}

	@Test
	void testGetCarsByLocation() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarsByModel() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarsByBrand() {
		fail("Not yet implemented");
	}

}
