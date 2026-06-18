package com.spotify.ms_bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(name = "ms-playlists", url = "http://localhost:8082")
public interface PlaylistClient {

    @GetMapping("/playlists")
    List<Object> getPlaylists();

    @PostMapping("/playlists")
    Object createPlaylist(@RequestBody Map<String, Object> playlist);

    @PostMapping("/playlists/{id}/songs/{songId}")
    Object addSongToPlaylist(@PathVariable("id") Long id, @PathVariable("songId") String songId); // Cambiado a String

    @DeleteMapping("/playlists/{id}")
    void deletePlaylist(@PathVariable("id") Long id);
}