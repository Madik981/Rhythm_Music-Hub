package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "durationDto", source = "duration")
    @Mapping(target = "spotifyLinkDto", source = "spotifyLink")
    @Mapping(target = "appleMusicLinkDto", source = "appleMusicLink")
    @Mapping(target = "albumDto", source = "album")
    @Mapping(target = "artistsDto", source = "artists")
    SongDto toDto(Song song);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "duration", source = "durationDto")
    @Mapping(target = "spotifyLink", source = "spotifyLinkDto")
    @Mapping(target = "appleMusicLink", source = "appleMusicLinkDto")
    @Mapping(target = "album", source = "albumDto")
    @Mapping(target = "artists", source = "artistsDto")
    Song toEntity(SongDto songDto);

    List<SongDto> toDtoList(List<Song> songs);

}
