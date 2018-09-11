package com.epam.model;

public class Booking {
	private long id;
	private User user;
	private Ticket ticket;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(long id, User user, Ticket ticket) {
		this.id = id;
		this.user = user;
		this.ticket = ticket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", ticket=" + ticket + "]";
	}
	
}
