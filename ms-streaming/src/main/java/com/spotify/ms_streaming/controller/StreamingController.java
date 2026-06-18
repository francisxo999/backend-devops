package com.spotify.ms_streaming.controller;

import com.spotify.ms_streaming.model.Streaming;
import com.spotify.ms_streaming.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping
    public List<Streaming> getAllStreaming() {
        return service.listarTodos();
    }

    @PostMapping
    public Streaming createStreaming(@RequestBody Streaming streaming) {
        return service.guardar(streaming);
    }
}