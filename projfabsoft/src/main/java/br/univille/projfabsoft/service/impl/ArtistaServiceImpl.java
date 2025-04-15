package br.univille.projfabsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Artista;
import br.univille.projfabsoft.repository.ArtistaRepository;
import br.univille.projfabsoft.service.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    @Override
    public Optional<Artista> findById(Long id) {
        return artistaRepository.findById(id);
    }

    @Override
    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    @Override
    public void deleteById(Long id) {
        artistaRepository.deleteById(id);
    }
}