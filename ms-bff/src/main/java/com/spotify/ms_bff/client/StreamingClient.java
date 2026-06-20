package com.spotify.ms_bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-streaming")
public interface StreamingClient {

    @PostMapping("/streaming")
    Object saveStream(@RequestBody Object streamData);

    @GetMapping("/streaming/current")
    Object getCurrentStream();
}