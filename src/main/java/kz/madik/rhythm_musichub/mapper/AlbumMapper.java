package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "titleDto", source = "title")
    @Mapping(target = "releaseYearDto", source = "releaseYear")
    AlbumDto toDto(Album song);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "title", source = "titleDto")
    @Mapping(target = "releaseYear", source = "releaseYearDto")
    Album toEntity(AlbumDto songDto);

    List<AlbumDto> toDtoList(List<Album> songs);

}
