package com.epam.model;

import java.time.LocalDateTime;

public class Event {
	private long id;
	private String name;
	private Rate rate;
	private double basePrice;
	private LocalDateTime dateTime;
	private Auditorium auditorium;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(long id, String name, Rate rate, double basePrice, LocalDateTime dateTime, Auditorium auditorium) {
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.basePrice = basePrice;
		this.dateTime = dateTime;
		this.auditorium = auditorium;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", rate=" + rate + ", basePrice=" + basePrice + ", dateTime="
				+ dateTime + ", auditorium=" + auditorium + "]";
	}
	
}
