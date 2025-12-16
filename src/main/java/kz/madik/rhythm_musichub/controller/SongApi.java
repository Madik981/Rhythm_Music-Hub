package kz.madik.rhythm_musichub.controller;

import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/song")
public class SongApi {

    private final SongService songService;

    @GetMapping
    public List<SongDto> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getById(
            @PathVariable("id") Long id
    ) {
        SongDto songDto = songService.getById(id);

        if(songDto != null)
            return ResponseEntity.ok(songDto);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SongDto> addSong(
            @RequestBody SongDto songDto
    ) {
        return ResponseEntity.ok(songService.addSong(songDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongDto> updateById(
            @PathVariable("id") Long id,
            @RequestBody SongDto songDto
    ) {
        SongDto updatedSongDto = songService.updateById(id, songDto);

        if(updatedSongDto != null)
            return ResponseEntity.ok(updatedSongDto);
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SongDto> deleteById(
            @PathVariable("id") Long id
    ) {
        boolean isDeleted = songService.deleteById(id);

        if(isDeleted)
            return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }
}
