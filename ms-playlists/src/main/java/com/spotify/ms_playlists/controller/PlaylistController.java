package com.spotify.ms_playlists.controller;

import com.spotify.ms_playlists.model.Playlist;
import com.spotify.ms_playlists.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @GetMapping
    public List<Playlist> getPlaylists() {
        return service.listarTodas();
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return service.guardar(playlist);
    }

    @PostMapping("/{id}/songs/{songId}")
    public Playlist addSongToPlaylist(@PathVariable Long id, @PathVariable String songId) {
        return service.agregarCancion(id, songId);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        service.eliminar(id);
    }
}