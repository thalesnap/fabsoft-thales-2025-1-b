package br.univille.projfabsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft.entity.Playlist;
import br.univille.projfabsoft.repository.PlaylistRepository;
import br.univille.projfabsoft.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository repository;

    @Override
    public Playlist save(Playlist playlist) {
        repository.save(playlist);
        return playlist;
    }

    @Override
    public List<Playlist> getAll() {
        return repository.findAll();
    }

    @Override
    public Playlist getById(Long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Playlist delete(Long id) {
        var playlist = getById(id);
        if (playlist != null)
            repository.deleteById(id);
        return playlist;
    }
}