package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Song;

import java.util.List;

public interface SongMapper {
    SongDto toDto(Song song);

    Song toEntity(SongDto songDto);

    List<SongDto> toDtoList(List<Song> songs);

}
