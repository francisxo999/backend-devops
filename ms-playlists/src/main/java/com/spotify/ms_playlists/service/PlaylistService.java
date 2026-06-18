package com.spotify.ms_playlists.service;

import com.spotify.ms_playlists.model.Playlist;
import com.spotify.ms_playlists.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository repository;

    public List<Playlist> listarTodas() {
        return repository.findAll();
    }

    public Playlist guardar(Playlist playlist) {
        return repository.save(playlist);
    }

    public Playlist agregarCancion(Long id, String songId) {
        // 1. Buscamos la playlist
        Playlist playlist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist no encontrada"));

        // 2. Agregamos el ID de la canción
        playlist.getCancionesIds().add(songId);

        // 3. Guardamos los cambios en la base de datos
        return repository.save(playlist);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}