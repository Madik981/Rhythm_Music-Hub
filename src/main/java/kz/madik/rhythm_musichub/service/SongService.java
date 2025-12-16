package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.SongDto;

import java.util.List;

public interface SongService {
    List<SongDto> getAll();
    SongDto getById(Long id);
    SongDto add(SongDto song);
    SongDto updateById(Long id, SongDto songDto);
    boolean deleteById(Long id);
}
