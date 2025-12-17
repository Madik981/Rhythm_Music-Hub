package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.entity.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ArtistMapperTest {

    @Autowired
    private ArtistMapper artistMapper;

    @Test
    void convertEntityToDtoTest(){

        Artist artistEntity = new Artist(1L, "madik", "Kazakh", LocalDate.parse("2005-06-19"));

        ArtistDto artistDto = artistMapper.toDto(artistEntity);

        Assertions.assertNotNull(artistDto);

        Assertions.assertNotNull(artistDto.getIdDto());
        Assertions.assertNotNull(artistDto.getNameDto());
        Assertions.assertNotNull(artistDto.getNationalityDto());
        Assertions.assertNotNull(artistDto.getBirthDateDto());

        Assertions.assertEquals(artistEntity.getId(), artistDto.getIdDto());
        Assertions.assertEquals(artistEntity.getName(), artistDto.getNameDto());
        Assertions.assertEquals(artistEntity.getNationality(), artistDto.getNationalityDto());
        Assertions.assertEquals(artistEntity.getBirthDate(), artistDto.getBirthDateDto());

    }

    @Test
    void convertDtoToEntityTest(){

        ArtistDto artistDto = new ArtistDto(1L, "madik", "Kazakh", LocalDate.parse("2005-06-19"));

        Artist artistEntity = artistMapper.toEntity(artistDto);

        Assertions.assertNotNull(artistEntity);

        Assertions.assertNotNull(artistEntity.getId());
        Assertions.assertNotNull(artistEntity.getName());
        Assertions.assertNotNull(artistEntity.getNationality());
        Assertions.assertNotNull(artistEntity.getBirthDate());

        Assertions.assertEquals(artistDto.getIdDto(), artistEntity.getId());
        Assertions.assertEquals(artistDto.getNameDto(), artistEntity.getName());
        Assertions.assertEquals(artistDto.getNationalityDto(), artistEntity.getNationality());
        Assertions.assertEquals(artistDto.getBirthDateDto(), artistEntity.getBirthDate());

    }

    @Test
    void convertEntityListToDtoListTest(){

        List<Artist> artistEntityList = new ArrayList<>();
        artistEntityList.add(new Artist(1L, "madik)", "Kazakh", LocalDate.parse("2005-06-19")));
        artistEntityList.add(new Artist(2L, "aigerim", "Kazakh", LocalDate.parse("2003-08-15")));
        artistEntityList.add(new Artist(3L, "john", "American", LocalDate.parse("2000-11-25")));


        List<ArtistDto> artistDtoList = artistMapper.toDtoList(artistEntityList);

        Assertions.assertNotNull(artistDtoList);

        Assertions.assertNotEquals(0, artistDtoList.size());

        Assertions.assertEquals(artistEntityList.size(), artistDtoList.size());

        for (int i = 0; i < artistEntityList.size(); i++) {

            Artist artistEntity = artistEntityList.get(i);

            ArtistDto artistDto = artistDtoList.get(i);

            Assertions.assertNotNull(artistDto);

            Assertions.assertNotNull(artistDto.getIdDto());
            Assertions.assertNotNull(artistDto.getNameDto());
            Assertions.assertNotNull(artistDto.getNationalityDto());
            Assertions.assertNotNull(artistDto.getBirthDateDto());

            Assertions.assertEquals(artistEntity.getId(), artistDto.getIdDto());
            Assertions.assertEquals(artistEntity.getName(), artistDto.getNameDto());
            Assertions.assertEquals(artistEntity.getNationality(), artistDto.getNationalityDto());
            Assertions.assertEquals(artistEntity.getBirthDate(), artistDto.getBirthDateDto());

        }

    }
}
