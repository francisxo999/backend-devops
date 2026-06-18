package com.spotify.ms_playlists.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ElementCollection
    private List<String> cancionesIds = new ArrayList<>(); // <-- MUY IMPORTANTE
}