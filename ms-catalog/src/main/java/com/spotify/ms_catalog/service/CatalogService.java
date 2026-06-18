package com.spotify.ms_catalog.service;

import com.spotify.ms_catalog.model.Catalog;
import com.spotify.ms_catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository repository;

    public List<Catalog> listarTodos() {
        return repository.findAll();
    }

    public Catalog guardar(Catalog catalog) {
        return repository.save(catalog);
    }
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    public Catalog actualizar(Long id, Catalog catalogDetails) {
        Catalog existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Canción no encontrada"));
        existente.setTitulo(catalogDetails.getTitulo());
        existente.setArtista(catalogDetails.getArtista());
        existente.setAlbum(catalogDetails.getAlbum());
        existente.setGenero(catalogDetails.getGenero());
        existente.setAudioUrl(catalogDetails.getAudioUrl());

        return repository.save(existente);
    }
}