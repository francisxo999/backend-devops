package com.spotify.ms_catalog.controller;

import com.spotify.ms_catalog.model.Catalog;
import com.spotify.ms_catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService service;

    @GetMapping
    public List<Catalog> getAllCatalog() {
        return service.listarTodos();
    }

    @PostMapping
    public Catalog addCatalog(@RequestBody Catalog catalog) {
        return service.guardar(catalog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Catalog> updateSong(@PathVariable Long id, @RequestBody Catalog catalogDetails) {
        Catalog catalogActualizado = service.actualizar(id, catalogDetails);

        return ResponseEntity.ok(catalogActualizado);
    }
}