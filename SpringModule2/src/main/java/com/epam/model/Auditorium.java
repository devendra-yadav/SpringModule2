package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="auditorium")
public class Auditorium {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@NotNull(message="Name should not be null")
	private String name;
	
	@Column(name="seats_number")
	@NotNull(message="Please input auditorium capacity")
	private int seatsNumber;
	
	@Column(name="vip_seats")
	@Pattern(regexp="^\\d*(,\\d*)*$", message="Please enter comma separated numbers")
	private String vipSeats;
	
	public Auditorium() {
		// TODO Auto-generated constructor stub
	}

	public Auditorium(int id, String name, int seatNumber, String vipSeats) {
		this.id = id;
		this.name = name;
		this.seatsNumber = seatNumber;
		this.vipSeats = vipSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(int seatNumber) {
		this.seatsNumber = seatNumber;
	}

	public String getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(String vipSeats) {
		this.vipSeats = vipSeats;
	}

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", name=" + name + ", seatNumber=" + seatsNumber + ", vipSeats=" + vipSeats
				+ "]";
	}
	
	
	
}	
