package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Appointment;
import com.cg.cars.dao.IAppointmentRepository;
import com.cg.cars.dao.IAppointmentRepositoryImpl;
import com.cg.cars.exception.AppointmentIdNotFoundException;
import com.cg.cars.exception.InvalidAppointmentException;

public class IAppointmentServiceImpl implements IAppointmentService{
	private IAppointmentRepository dao;
	public IAppointmentServiceImpl() {
		dao =new IAppointmentRepositoryImpl();
	}
	@Override
	public Appointment addAppointment(Appointment appointment) {
		 dao.beginTransaction();
	     appointment=dao.addAppointment(appointment);
	     dao.commitTransaction();
	     return appointment;
		
		
	}

	@Override
	public Appointment removeAppointment(long id) {
		 dao.beginTransaction();
    	 Appointment appointment=null;
	     try {
			appointment=dao.removeAppointment(id);
		} catch (AppointmentIdNotFoundException e) {
			e.getMessage();
		}
	     dao.commitTransaction();
	     return appointment;
		
		
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		 dao.beginTransaction();
	     try {
			appointment=dao.updateAppointment(id,appointment);
		} catch (InvalidAppointmentException e) {
			e.printStackTrace();
		}
	     dao.commitTransaction();
	     return appointment;
		
		
	}

	@Override
	public Appointment getAppointment(long id) {
		 dao.beginTransaction();
		 Appointment appointment=dao.getAppointment(id);
	     dao.commitTransaction();
    	 return appointment;
		
	}

	@Override
	public List<Appointment> getAllAppointments() {
		dao.beginTransaction();
		List<Appointment> appointmentList=dao.getAllAppointments();
		dao.commitTransaction();
		return appointmentList;
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		dao.beginTransaction();
		List<Appointment> appointmentList=dao.getAllAppointments();
		dao.commitTransaction();
		return appointmentList;
	}

}
