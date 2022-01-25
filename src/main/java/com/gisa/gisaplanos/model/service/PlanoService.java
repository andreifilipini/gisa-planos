package com.gisa.gisaplanos.model.service;

import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository repository;

	public List<Plano> findAll() {
		return repository.findAll();
	}

	public boolean isAtivo(Long id) {
		Optional<Plano> plano = repository.findById(id);
		return plano.isPresent() && plano.get().isAtivo();
	}
}
