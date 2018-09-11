package com.epam.dao;

import java.util.List;

import com.epam.model.Auditorium;

public interface AuditoriumDao {
	public int create(Auditorium auditorium);
	public List<Auditorium> getAll();
}
