package com.cg.cars.dao;

/*import java.time.LocalDate;
import java.time.LocalTime;*/
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.cars.beans.Appointment;
//import com.cg.cars.beans.Customer;
import com.cg.cars.exception.AppointmentIdNotFoundException;
import com.cg.cars.exception.InvalidAppointmentException;

public class IAppointmentRepositoryImpl implements IAppointmentRepository{
	private EntityManager entityManager;
	public IAppointmentRepositoryImpl() {
		entityManager =JPAUtil.getEntityManager();
	}
	/*
	 * This method adds the appointment for inspection
	 */
	@Override
	public Appointment addAppointment(Appointment appointment) {
		
		entityManager.persist(appointment);
		return appointment;
	}
	/*
	 * This method removes the appointment
	 */
	@Override
	public Appointment removeAppointment(long id) throws AppointmentIdNotFoundException{
		Appointment appointment1=entityManager.find(Appointment.class, id);
		
		if(appointment1==null) {
			throw new AppointmentIdNotFoundException("Appointment Id not found");
		}
		entityManager.remove(appointment1);
		return appointment1;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) throws InvalidAppointmentException
	{
		Appointment appointment1=entityManager.find(Appointment.class, id);
		if(appointment1==null)
			throw new InvalidAppointmentException("Invalid AppointmentId");
		appointment=entityManager.merge(appointment);
		return appointment;
	}

	@Override
	public Appointment getAppointment(long id) {
		Appointment appointment=null;
		Query query=entityManager.createQuery("Select appointment from Appointment appointment where appointment.appointmentId=id",Appointment.class);
		//query.setParameter("app", id);
		appointment=(Appointment) query.getSingleResult();
		return appointment;
	}
	/*
	 * This method returns the list of all appointments fixed
	 */
	@Override
	public List<Appointment> getAllAppointments() {
			List<Appointment> appointmentlist=entityManager.createQuery("Select appointment From Appointment appointment",Appointment.class).getResultList();
		return appointmentlist;
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		List<Appointment> appointmentlist=entityManager.createQuery("Select appointment From Appointment appointment",Appointment.class).getResultList();
		return appointmentlist;
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
