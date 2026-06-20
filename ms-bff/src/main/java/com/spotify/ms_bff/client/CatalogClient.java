package com.spotify.ms_bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "ms-catalog")
public interface CatalogClient {
    @GetMapping("/catalog")
    List<Object> getCatalog();

    @GetMapping("/catalog/{id}")
    Object getSongById(@PathVariable("id") String id);

    @PostMapping("/catalog")
    Object saveCatalog(@RequestBody Object catalog);

    @DeleteMapping("/catalog/{id}")
    void deleteSong(@PathVariable("id") Long id);

    @PutMapping("/catalog/{id}")
    Object updateSong(@PathVariable("id") Long id, @RequestBody Object song);
}