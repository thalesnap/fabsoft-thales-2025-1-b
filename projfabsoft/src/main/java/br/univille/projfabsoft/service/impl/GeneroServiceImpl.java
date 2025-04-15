package br.univille.projfabsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Genero;
import br.univille.projfabsoft.repository.GeneroRepository;
import br.univille.projfabsoft.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}