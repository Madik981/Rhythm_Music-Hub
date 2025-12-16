package kz.madik.rhythm_musichub.controller;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/album")
public class AlbumApi {

    private final AlbumService albumService;

    @GetMapping
    public List<AlbumDto> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> getById(
            @PathVariable("id") Long id
    ) {
        AlbumDto albumDto = albumService.getById(id);

        if(albumDto != null)
            return ResponseEntity.ok(albumDto);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AlbumDto> addAlbum(
            @RequestBody AlbumDto albumDto
    ) {
        return ResponseEntity.ok(albumService.addAlbum(albumDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDto> updateById(
            @PathVariable("id") Long id,
            @RequestBody AlbumDto albumDto
    ) {
        AlbumDto updatedAlbumDto = albumService.updateById(id, albumDto);

        if(updatedAlbumDto != null)
            return ResponseEntity.ok(updatedAlbumDto);
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlbumDto> deleteById(
            @PathVariable("id") Long id
    ) {
        boolean isDeleted = albumService.deleteById(id);

        if(isDeleted)
            return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }
}
