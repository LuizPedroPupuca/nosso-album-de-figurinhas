package com.zup.edu.gerenciadorde.albumdefigurinhas;

import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Album;
import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Figurinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private FigurinhaRepository figurinhaRepository;

    @PostMapping("/album")
    public ResponseEntity<Void> cadastra(@RequestBody @Valid AlbumRequest albumRequest, UriComponentsBuilder uri){
        Album album = albumRequest.toModel();

        albumRepository.save(album);

        URI location = uri.path("/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/figurinha/{id}")
    public ResponseEntity<Void> removeFigurinha(@PathVariable Long id){
        Figurinha figurinha = figurinhaRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Figurinha não encontrado"));

        figurinhaRepository.delete(figurinha);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity<Void> removeAlbum(@PathVariable Long id){
        Album album = albumRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum não encontrado"));

        albumRepository.delete(album);

        return ResponseEntity.noContent().build();
    }
}
