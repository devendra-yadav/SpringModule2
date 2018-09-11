package com.epam.model;

import java.time.LocalDateTime;

public class Ticket {
	private long id;
	private Event event;
	private LocalDateTime time;
	private String seats;
	private User user;
	private Double price;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(long id, Event event, LocalDateTime time, String seats, User user, Double price) {
		this.id = id;
		this.event = event;
		this.time = time;
		this.seats = seats;
		this.user = user;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", event=" + event + ", time=" + time + ", seats=" + seats + ", user=" + user
				+ ", price=" + price + "]";
	}
	
	
}
