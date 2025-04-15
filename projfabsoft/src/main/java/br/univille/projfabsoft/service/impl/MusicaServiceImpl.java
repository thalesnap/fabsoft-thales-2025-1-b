package br.univille.projfabsoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Musica;
import br.univille.projfabsoft.repository.MusicaRepository;
import br.univille.projfabsoft.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Override
    public List<Musica> findAll() {
        return musicaRepository.findAll();
    }

    @Override
    public Optional<Musica> findById(Long id) {
        return musicaRepository.findById(id);
    }

    @Override
    public Musica save(Musica musica) {
        return musicaRepository.save(musica);
    }

    @Override
    public void deleteById(Long id) {
        musicaRepository.deleteById(id);
    }
}