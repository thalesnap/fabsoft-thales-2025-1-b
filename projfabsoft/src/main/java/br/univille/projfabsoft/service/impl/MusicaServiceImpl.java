package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Musica;
import br.univille.projfabsoft.repository.MusicaRepository;
import br.univille.projfabsoft.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    @Override
    public Musica save(Musica musica) {
        repository.save(musica);
        return musica;
    }

    @Override
    public List<Musica> getAll() {
        return repository.findAll();
    }

    @Override
    public Musica getById(Long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Musica delete(Long id) {
        var musica = getById(id);
        if (musica != null)
            repository.deleteById(id);
        return musica;
    }
}