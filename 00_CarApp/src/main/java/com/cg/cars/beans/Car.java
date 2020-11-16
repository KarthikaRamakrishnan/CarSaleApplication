package com.cg.cars.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Car_Details")
public class Car {
	//@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="ID")
	private long carId;
	@Column(name="BRAND") 
	private String brand;
	@Column(name="MODEL") 
	private String model;
	@Column(name="VARIANT") 
	private String variant;
	@Column(name="REG_YEAR") 
	private LocalDate registrationYear;
	@Column(name="REG_STATE") 
	private String registrationState;
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public LocalDate getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}
	public String getRegistrationState() {
		return registrationState;
	}
	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}
	public Car(long carId, String brand, String model, String variant,String registrationState,LocalDate registrationYear) {
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		//this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}
	
	public Car() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + (int) (carId ^ (carId >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((registrationState == null) ? 0 : registrationState.hashCode());
		result = prime * result + ((registrationYear == null) ? 0 : registrationYear.hashCode());
		result = prime * result + ((variant == null) ? 0 : variant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carId != other.carId)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (registrationState == null) {
			if (other.registrationState != null)
				return false;
		} else if (!registrationState.equals(other.registrationState))
			return false;
		if (registrationYear == null) {
			if (other.registrationYear != null)
				return false;
		} else if (!registrationYear.equals(other.registrationYear))
			return false;
		if (variant == null) {
			if (other.variant != null)
				return false;
		} else if (!variant.equals(other.variant))
			return false;
		return true;
	}
	
	

}
