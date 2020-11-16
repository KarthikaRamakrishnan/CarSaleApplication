package com.cg.cars.dao;

import java.util.List;

import com.cg.cars.beans.Appointment;
import com.cg.cars.exception.AppointmentIdNotFoundException;
import com.cg.cars.exception.InvalidAppointmentException;

public interface IAppointmentRepository {

	public Appointment addAppointment(Appointment appointment);
	public Appointment removeAppointment(long id) throws AppointmentIdNotFoundException; 
	public Appointment updateAppointment(long id, Appointment appointment) throws InvalidAppointmentException;
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
	void beginTransaction();
	void commitTransaction();
}
