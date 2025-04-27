package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Artista;
import br.univille.projfabsoft.repository.ArtistaRepository;
import br.univille.projfabsoft.service.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository repository;

    @Override
    public Artista save(Artista artista) {
        repository.save(artista);
        return artista;
    }

    @Override
    public List<Artista> getAll() {
        return repository.findAll();
    }

    @Override
    public Artista getById(Long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Artista delete(Long id) {
        var artista = getById(id);
        if (artista != null)
            repository.deleteById(id);
        return artista;
    }
}