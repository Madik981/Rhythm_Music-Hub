package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AlbumMapperTest {

    @Autowired
    private AlbumMapper albumMapper;

    @Test
    void convertEntityToDtoTest(){

        Album albumEntity = new Album(1L, "test album", 2021);

        AlbumDto albumDto = albumMapper.toDto(albumEntity);

        Assertions.assertNotNull(albumDto);

        Assertions.assertNotNull(albumDto.getIdDto());
        Assertions.assertNotNull(albumDto.getTitleDto());
        Assertions.assertNotNull(albumDto.getReleaseYearDto());



        Assertions.assertEquals(albumEntity.getId(), albumDto.getIdDto());
        Assertions.assertEquals(albumEntity.getTitle(), albumDto.getTitleDto());
        Assertions.assertEquals(albumEntity.getReleaseYear(), albumDto.getReleaseYearDto());

    }

    @Test
    void convertDtoToEntityTest(){

        AlbumDto albumDto = new AlbumDto(1L, "test album", 2021);

        Album albumEntity = albumMapper.toEntity(albumDto);

        Assertions.assertNotNull(albumEntity);

        Assertions.assertNotNull(albumEntity.getId());
        Assertions.assertNotNull(albumEntity.getTitle());
        Assertions.assertNotNull(albumEntity.getReleaseYear());

        Assertions.assertEquals(albumDto.getIdDto(), albumEntity.getId());
        Assertions.assertEquals(albumDto.getTitleDto(), albumEntity.getTitle());
        Assertions.assertEquals(albumDto.getReleaseYearDto(), albumEntity.getReleaseYear());

    }

    @Test
    void convertEntityListToDtoListTest(){

        List<Album> albumEntityList = new ArrayList<>();
        albumEntityList.add(new Album(1L, "Album One", 2020));
        albumEntityList.add(new Album(2L, "Album Two", 2021));
        albumEntityList.add(new Album(3L, "Album Three", 2022));


        List<AlbumDto> albumDtoList = albumMapper.toDtoList(albumEntityList);

        Assertions.assertNotNull(albumDtoList);

        Assertions.assertNotEquals(0, albumDtoList.size());

        Assertions.assertEquals(albumEntityList.size(), albumDtoList.size());

        for (int i = 0; i < albumEntityList.size(); i++) {

            Album albumEntity = albumEntityList.get(i);

            AlbumDto albumDto = albumDtoList.get(i);

            Assertions.assertNotNull(albumDto);

            Assertions.assertNotNull(albumDto.getIdDto());
            Assertions.assertNotNull(albumDto.getTitleDto());
            Assertions.assertNotNull(albumDto.getReleaseYearDto());

            Assertions.assertEquals(albumEntity.getId(), albumDto.getIdDto());
            Assertions.assertEquals(albumEntity.getTitle(), albumDto.getTitleDto());
            Assertions.assertEquals(albumEntity.getReleaseYear(), albumDto.getReleaseYearDto());

        }

    }
}
