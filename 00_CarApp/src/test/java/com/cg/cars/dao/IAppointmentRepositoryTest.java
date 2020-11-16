package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Appointment;
import com.cg.cars.exception.AppointmentIdNotFoundException;

class IAppointmentRepositoryTest {
	private IAppointmentRepository repository=new IAppointmentRepositoryImpl();
	Appointment appointment=new Appointment();
	
	@Test
	void theAppointmentIsAdded() {
		appointment.setAppointmentId(1L);
		appointment.setLocation("Chennai");
		appointment.setInspectionType("Branch");
		appointment.setPreferredDate(LocalDate.of(2020, 11, 29));
		appointment.setPreferredTime(LocalTime.of(12, 20, 00));
		/*appointment.setCustomer(c1);
		appointment.setPayment(payment);*/
		Appointment checkAppointment=repository.addAppointment(appointment);
		//assertNotNull(checkAppointment);
		assertEquals(checkAppointment, appointment);
	}
	/*@Test
	void theAppointmentIsRemoved() throws AppointmentIdNotFoundException {
		Appointment appointment=new Appointment();
	    appointment.setAppointmentId(2L);
		Appointment checkAppointment=repository.removeAppointment(appointment);
		assertEquals(checkAppointment, appointment);
		
	}
	@Test
	void testUpdateAppointment() {
		appointment.setAppointmentId(2L);
		appointment.setLocation("Coimbatore");
		Appointment checkAppointment=repository.updateAppointment(id,appointment);
		assertEquals(checkAppointment, appointment);
		
	}*/
	
	
	

}
