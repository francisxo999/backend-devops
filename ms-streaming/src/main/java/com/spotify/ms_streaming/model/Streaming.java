package com.spotify.ms_streaming.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Streaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String artista;
    private String urlAudio;
}