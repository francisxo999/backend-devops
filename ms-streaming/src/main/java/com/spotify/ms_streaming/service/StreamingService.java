package com.spotify.ms_streaming.service;

import com.spotify.ms_streaming.model.Streaming;
import com.spotify.ms_streaming.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository repository;

    public List<Streaming> listarTodos() {
        return repository.findAll();
    }

    public Streaming guardar(Streaming streaming) {
        return repository.save(streaming);
    }
}