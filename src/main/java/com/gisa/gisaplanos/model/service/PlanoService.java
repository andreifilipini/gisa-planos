package com.gisa.gisaplanos.model.service;

import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository repository;

	public List<Plano> findAll() {
		return repository.findAll();
	}

	public Plano findById(Long id) {
		return repository.findById(id).orElse(null);
	}
}
