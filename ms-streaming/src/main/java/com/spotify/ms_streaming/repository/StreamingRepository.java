package com.spotify.ms_streaming.repository;

import com.spotify.ms_streaming.model.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}