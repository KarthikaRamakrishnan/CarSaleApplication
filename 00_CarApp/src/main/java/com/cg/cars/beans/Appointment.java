package com.cg.cars.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Appointment implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@Column(name="APPOINTMENT_ID")
	private long appointmentId;
	@Column(name="LOCATION")
	private String location;
	@Column(name="INSPECTION_TYPE")
	private String inspectionType;
	@Column(name="PREFERRED_DATE")
	private LocalDate preferredDate;
	@Column(name="PREFERRED_TIME")
	private LocalTime preferredTime;
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="Customer")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name="Payment")
	private Payment payment;
	public Appointment() {
		
	}
	public Appointment(long appointmentId, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Customer customer, Payment payment) {
		super();
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.customer = customer;
		this.payment = payment;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getInspectionType() {
		return inspectionType;
	}
	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public LocalTime getPreferredTime() {
		return preferredTime;
	}
	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (appointmentId ^ (appointmentId >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((inspectionType == null) ? 0 : inspectionType.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((preferredDate == null) ? 0 : preferredDate.hashCode());
		result = prime * result + ((preferredTime == null) ? 0 : preferredTime.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentId != other.appointmentId)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (inspectionType == null) {
			if (other.inspectionType != null)
				return false;
		} else if (!inspectionType.equals(other.inspectionType))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (preferredDate == null) {
			if (other.preferredDate != null)
				return false;
		} else if (!preferredDate.equals(other.preferredDate))
			return false;
		if (preferredTime == null) {
			if (other.preferredTime != null)
				return false;
		} else if (!preferredTime.equals(other.preferredTime))
			return false;
		return true;
	}
	

}
