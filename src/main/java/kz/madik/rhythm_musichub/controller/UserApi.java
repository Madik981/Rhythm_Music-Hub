package kz.madik.rhythm_musichub.controller;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.dto.UserModelDto;
import kz.madik.rhythm_musichub.entity.UserModel;
import kz.madik.rhythm_musichub.service.AlbumService;
import kz.madik.rhythm_musichub.service.ArtistService;
import kz.madik.rhythm_musichub.service.MyUserService;
import kz.madik.rhythm_musichub.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final MyUserService myUserService;
    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    @GetMapping
    public String getUser() {
        return "Authorized";
    }

    @PostMapping("/register")
    public UserModelDto register(@RequestBody UserModel model) {
        return myUserService.register(model);
    }


    // ADD MAPPINGS STARTS

    @PostMapping("/song/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<SongDto> addSong(
            @RequestBody SongDto songDto
    ) {
        return ResponseEntity.ok(songService.addSong(songDto));
    }

    @PostMapping("/album/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AlbumDto> addAlbum(
            @RequestBody AlbumDto albumDto
    ) {
        return ResponseEntity.ok(albumService.addAlbum(albumDto));
    }

    @PostMapping("/artist/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ArtistDto> addArtist(
            @RequestBody ArtistDto artistDto
    ) {
        return ResponseEntity.ok(artistService.addArtist(artistDto));
    }

    // ADD MAPPINGS ENDS


    // UPDATE MAPPINGS STARTS

    @PutMapping("/song/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<SongDto> updateSong(
            @PathVariable("id") Long id,
            @RequestBody SongDto songDto
    ) {
        return ResponseEntity.ok(songService.updateById(id, songDto));
    }

    @PutMapping("/album/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AlbumDto> updateAlbum(
            @PathVariable("id") Long id,
            @RequestBody AlbumDto albumDto
    ) {
        return ResponseEntity.ok(albumService.updateById(id, albumDto));
    }

    @PutMapping("/artist/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ArtistDto> updateArtist(
            @PathVariable("id") Long id,
            @RequestBody ArtistDto artistDto
    ) {
        return ResponseEntity.ok(artistService.updateById(id, artistDto));
    }

    // UPDATE MAPPINGS ENDS


    // DELETE MAPPINGS STARTS

    @DeleteMapping("/song/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteSong(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(songService.deleteById(id));
    }

    @DeleteMapping("/album/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteAlbum(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(albumService.deleteById(id));
    }

    @DeleteMapping("/artist/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteArtist(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(artistService.deleteById(id));
    }

    // DELETE MAPPINGS ENDS
}
