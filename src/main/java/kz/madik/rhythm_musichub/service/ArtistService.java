package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.ArtistDto;

import java.util.List;

public interface ArtistService {
    List<ArtistDto> getAll();
    ArtistDto getById(Long id);
    ArtistDto addArtist(ArtistDto song);
    ArtistDto updateById(Long id, ArtistDto songDto);
    boolean deleteById(Long id);
}
