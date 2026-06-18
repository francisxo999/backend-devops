package com.spotify.ms_playlists.repository;

import com.spotify.ms_playlists.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}