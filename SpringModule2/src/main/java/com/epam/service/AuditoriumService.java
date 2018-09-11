package com.epam.service;

import java.util.List;

import com.epam.model.Auditorium;

public interface AuditoriumService {
	public int create(Auditorium auditorium);
	public List<Auditorium> getAll();
}
