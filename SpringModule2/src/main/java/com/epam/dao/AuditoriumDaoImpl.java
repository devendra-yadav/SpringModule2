package com.epam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.model.Auditorium;

@Repository
public class AuditoriumDaoImpl extends AbstractDao implements AuditoriumDao{

	@Override
	public int create(Auditorium auditorium) {
		int auditoriumId=(int)getCurrentSession().save(auditorium);
		
		return auditoriumId;
	}

	@Override
	public List<Auditorium> getAll() {
		List<Auditorium> allAuditoriums=getCurrentSession().createQuery("from Auditorium",Auditorium.class).getResultList();
		return allAuditoriums;
	}

}
