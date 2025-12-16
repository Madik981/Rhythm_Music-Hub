package kz.madik.rhythm_musichub.controller;

import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistApi {

    private final ArtistService artistService;

    @GetMapping
    public List<ArtistDto> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getById(
            @PathVariable("id") Long id
    ) {
        ArtistDto artistDto = artistService.getById(id);

        if(artistDto != null)
            return ResponseEntity.ok(artistDto);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ArtistDto> addArtist(
            @RequestBody ArtistDto artistDto
    ) {
        return ResponseEntity.ok(artistService.addArtist(artistDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistDto> updateById(
            @PathVariable("id") Long id,
            @RequestBody ArtistDto artistDto
    ) {
        ArtistDto updatedArtistDto = artistService.updateById(id, artistDto);

        if(updatedArtistDto != null)
            return ResponseEntity.ok(updatedArtistDto);
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArtistDto> deleteById(
            @PathVariable("id") Long id
    ) {
        boolean isDeleted = artistService.deleteById(id);

        if(isDeleted)
            return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }
}
