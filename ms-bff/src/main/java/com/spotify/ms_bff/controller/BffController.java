package com.spotify.ms_bff.controller;

import com.spotify.ms_bff.client.CatalogClient;
import com.spotify.ms_bff.client.UserClient;
import com.spotify.ms_bff.client.PlaylistClient;
import com.spotify.ms_bff.client.StreamingClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BffController {

    // Logger robusto para evitar el uso de printStackTrace() y System.err
    private static final Logger log = LoggerFactory.getLogger(BffController.class);

    @Autowired
    private CatalogClient catalogClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PlaylistClient playlistClient;

    @Autowired
    private StreamingClient streamingClient;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardData() {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("catalog", catalogClient.getCatalog());
        } catch (Exception e) {
            log.error("Error al obtener datos de ms-catalog para el dashboard", e);
            response.put("catalog", new java.util.ArrayList<>());
        }

        try {
            response.put("users", userClient.getUsers());
        } catch (Exception e) {
            log.error("Error al obtener datos de ms-user para el dashboard", e);
            response.put("users", new java.util.ArrayList<>());
        }

        try {
            response.put("playlists", playlistClient.getPlaylists());
        } catch (Exception e) {
            log.error("Error al obtener datos de ms-playlists para el dashboard", e);
            response.put("playlists", new java.util.ArrayList<>());
        }

        return response;
    }

    @PostMapping("/catalog")
    public Object addSongToCatalog(@RequestBody Object catalog) {
        return catalogClient.saveCatalog(catalog);
    }

    @PostMapping("/users/register")
    public Object registerUser(@RequestBody Object user) {
        return userClient.saveUser(user);
    }

    @PostMapping("/users/login")
    public Object login(@RequestBody Map<String, String> credentials) {
        return userClient.loginUser(credentials);
    }

    @DeleteMapping("/catalog/{id}")
    public ResponseEntity<Map<String, String>> deleteSong(@PathVariable Long id) {
        catalogClient.deleteSong(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "OK");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/catalog/{id}")
    public Object updateSong(@PathVariable Long id, @RequestBody Object song) {
        return catalogClient.updateSong(id, song);
    }

    @GetMapping("/playlists")
    public ResponseEntity<?> getAllPlaylists() {
        return ResponseEntity.ok(playlistClient.getPlaylists());
    }

    @PostMapping("/playlists")
    public ResponseEntity<?> createNewPlaylist(@RequestBody Map<String, Object> playlistData) {
        try {
            Object response = playlistClient.createPlaylist(playlistData);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log robusto que captura el contexto y la traza de excepción de manera asíncrona
            log.error("Error en BFF al crear la playlist con datos: {}", playlistData, e);

            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "El microservicio de playlists falló al procesar la solicitud.");
            return ResponseEntity.status(500).body(errorMap);
        }
    }

    @PostMapping("/playlists/{id}/songs/{songId}")
    public ResponseEntity<?> addSongToPlaylist(@PathVariable Long id, @PathVariable String songId) {
        try {
            // El BFF le pasa la orden al microservicio de Playlists
            Object response = playlistClient.addSongToPlaylist(id, songId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al agregar la canción a la playlist");
        }
    }

    @PostMapping("/streaming")
    public ResponseEntity<?> notifyStream(@RequestBody Object streamData) {
        return ResponseEntity.ok(streamingClient.saveStream(streamData));
    }

    @GetMapping("/streaming/current")
    public ResponseEntity<?> getCurrentStream() {
        return ResponseEntity.ok(streamingClient.getCurrentStream());
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Map<String, String>> deletePlaylist(@PathVariable Long id) {
        playlistClient.deletePlaylist(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "OK");
        return ResponseEntity.ok(response);
    }
}