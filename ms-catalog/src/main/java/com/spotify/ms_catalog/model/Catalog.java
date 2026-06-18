package com.spotify.ms_catalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String audioUrl;
}