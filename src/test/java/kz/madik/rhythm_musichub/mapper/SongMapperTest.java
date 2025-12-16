package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
import kz.madik.rhythm_musichub.entity.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SongMapperTest {

    @Autowired
    private SongMapper songMapper;

    @Test
    void convertEntityToDtoTest(){

        Song songEntity = new Song(1L, "madi", 210, new Album(1L, "madi", 2025), List.of(new Artist(1L, "madik", "Kazakh", 20, "Male")));

        SongDto songDto = songMapper.toDto(songEntity);

        Assertions.assertNotNull(songDto);

        Assertions.assertNotNull(songDto.getIdDto());
        Assertions.assertNotNull(songDto.getNameDto());
        Assertions.assertNotNull(songDto.getDurationDto());
        Assertions.assertNotNull(songDto.getAlbumDto());
        Assertions.assertNotNull(songDto.getArtistsDto());


        Assertions.assertEquals(songEntity.getId(), songDto.getIdDto());
        Assertions.assertEquals(songEntity.getName(), songDto.getNameDto());
        Assertions.assertEquals(songEntity.getDuration(), songDto.getDurationDto());
        Assertions.assertEquals(songEntity.getAlbum().getId(), songDto.getAlbumDto().getId());
        Assertions.assertEquals(songEntity.getArtists().size(), songDto.getArtistsDto().size());

        List<Artist> songArtists = songEntity.getArtists();
        List<Artist> songDtoArtists = songDto.getArtistsDto();

        for (int i = 0; i < songArtists.size(); i++) {
            Assertions.assertEquals(songArtists.get(i).getId(), songDtoArtists.get(i).getId());
        }

    }

    @Test
    void convertDtoToEntityTest(){

        SongDto songDto = new SongDto(1L, "madi", 210, new Album(1L, "madi", 2025), List.of(new Artist(1L, "madik", "Kazakh", 20, "Male")));

        Song songEntity = songMapper.toEntity(songDto);

        Assertions.assertNotNull(songEntity);

        Assertions.assertNotNull(songEntity.getId());
        Assertions.assertNotNull(songEntity.getName());
        Assertions.assertNotNull(songEntity.getDuration());
        Assertions.assertNotNull(songEntity.getAlbum());
        Assertions.assertNotNull(songEntity.getArtists());

        Assertions.assertEquals(songDto.getIdDto(), songEntity.getId());
        Assertions.assertEquals(songDto.getNameDto(), songEntity.getName());
        Assertions.assertEquals(songDto.getDurationDto(), songEntity.getDuration());
        Assertions.assertEquals(songDto.getAlbumDto().getId(), songEntity.getAlbum().getId());
        Assertions.assertEquals(songDto.getArtistsDto().size(), songEntity.getArtists().size());

        List<Artist> songDtoArtists = songDto.getArtistsDto();
        List<Artist> songEntityArtists = songEntity.getArtists();

        for (int i = 0; i < songDtoArtists.size(); i++) {
            Assertions.assertEquals(songDtoArtists.get(i).getId(), songEntityArtists.get(i).getId());
        }

    }

    @Test
    void convertEntityListToDtoListTest(){

        List<Song> songEntityList = new ArrayList<>();
        songEntityList.add(new Song(1L, "song1", 200, new Album(1L, "album1", 2020), List.of(new Artist(1L, "artist1", "Kazakh", 30, "Male"))));
        songEntityList.add(new Song(2L, "song2", 180, new Album(2L, "album2", 2021), List.of(new Artist(2L, "artist2", "Kazakh", 25, "Female"))));
        songEntityList.add(new Song(3L, "song3", 240, new Album(3L, "album3", 2022), List.of(new Artist(3L, "artist3", "Kazakh", 28, "Male"))));


        List<SongDto> songDtoList = songMapper.toDtoList(songEntityList);

        Assertions.assertNotNull(songDtoList);

        Assertions.assertNotEquals(0, songDtoList.size());

        Assertions.assertEquals(songEntityList.size(), songDtoList.size());

        for (int i = 0; i < songEntityList.size(); i++) {

            Song songEntity = songEntityList.get(i);

            SongDto songDto = songDtoList.get(i);

            Assertions.assertNotNull(songDto);

            Assertions.assertNotNull(songDto.getIdDto());
            Assertions.assertNotNull(songDto.getNameDto());
            Assertions.assertNotNull(songDto.getDurationDto());
            Assertions.assertNotNull(songDto.getAlbumDto());
            Assertions.assertNotNull(songDto.getArtistsDto());

            Assertions.assertEquals(songEntity.getId(), songDto.getIdDto());
            Assertions.assertEquals(songEntity.getName(), songDto.getNameDto());
            Assertions.assertEquals(songEntity.getDuration(), songDto.getDurationDto());
            Assertions.assertEquals(songEntity.getAlbum(), songDto.getAlbumDto());
            Assertions.assertEquals(songEntity.getArtists().size(), songDto.getArtistsDto().size());

            List<Artist> songArtists = songEntity.getArtists();
            List<Artist> songDtoArtists = songDto.getArtistsDto();

            for (int j = 0; j < songArtists.size(); j++) {
                Assertions.assertEquals(songArtists.get(j).getId(), songDtoArtists.get(j).getId());
            }

        }

    }
}
