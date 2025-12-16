package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.AlbumDto;

import java.util.List;

public interface AlbumService {
    List<AlbumDto> getAll();
    AlbumDto getById(Long id);
    AlbumDto addAlbum(AlbumDto song);
    AlbumDto updateById(Long id, AlbumDto songDto);
    boolean deleteById(Long id);
}
