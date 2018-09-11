package com.epam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.AuditoriumDao;
import com.epam.model.Auditorium;

@Service
@Transactional
public class AuditoriumServiceImpl implements AuditoriumService {

	@Autowired
	private AuditoriumDao theAuditoriumDao;
	
	@Override
	public int create(Auditorium auditorium) {
		// TODO Auto-generated method stub
		return theAuditoriumDao.create(auditorium);
	}

	@Override
	public List<Auditorium> getAll() {
		// TODO Auto-generated method stub
		return theAuditoriumDao.getAll();
	}

}
