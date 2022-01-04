package com.gisa.gisaplanos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.repository.PlanoRepository;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository repository;

	public List<Plano> findAll() {
		return repository.findAll();
	}
}
