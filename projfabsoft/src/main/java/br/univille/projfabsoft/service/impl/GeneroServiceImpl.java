package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Genero;
import br.univille.projfabsoft.repository.GeneroRepository;
import br.univille.projfabsoft.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository repository;

    @Override
    public Genero save(Genero genero) {
        repository.save(genero);
        return genero;
    }

    @Override
    public List<Genero> getAll() {
        return repository.findAll();
    }

    @Override
    public Genero getById(Long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Genero delete(Long id) {
        var genero = getById(id);
        if (genero != null)
            repository.deleteById(id);
        return genero;
    }
}