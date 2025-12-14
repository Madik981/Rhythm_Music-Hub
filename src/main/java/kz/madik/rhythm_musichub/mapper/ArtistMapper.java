package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "nationalityDto", source = "nationality")
    @Mapping(target = "ageDto", source = "age")
    @Mapping(target = "genderDto", source = "gender")
    ArtistDto toDto(Artist song);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "nationality", source = "nationalityDto")
    @Mapping(target = "age", source = "ageDto")
    @Mapping(target = "gender", source = "genderDto")
    Artist toEntity(ArtistDto songDto);

    List<ArtistDto> toDtoList(List<Artist> songs);

}
