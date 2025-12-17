package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class SongServiceTest {

    @Autowired
    private SongService songService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ArtistService artistService;

    @Test
    void getAllTest() {

        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2023)
                .build();

        ArtistDto artistDto1 = ArtistDto
                .builder()
                .nameDto("Test Artist 1")
                .nationalityDto("Test Nationality 1")
                .birthDateDto("1990-01-01")
                .build();

        ArtistDto artistDto2 = ArtistDto
                .builder()
                .nameDto("Test Artist 2")
                .nationalityDto("Test Nationality 2")
                .birthDateDto("1992-02-02")
                .build();

        albumService.addAlbum(albumDto);
        artistService.addArtist(artistDto1);
        artistService.addArtist(artistDto2);

        SongDto addSong = SongDto
                .builder()
                .nameDto("Initial Song")
                .durationDto(200)
                .spotifyLinkDto("https://spotify.com/initiallink")
                .appleMusicLinkDto("https://applemusic.com/initiallink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                                .builder()
                                .id(1L)
                                .build()
                ))
                .build();

        songService.addSong(addSong);
        songService.addSong(addSong);
        songService.addSong(addSong);



        List<SongDto> songDtos = songService.getAll();

        Assertions.assertNotNull(songDtos);

        Assertions.assertNotEquals(0, songDtos.size());

        for (SongDto dto : songDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getDurationDto());
            Assertions.assertNotNull(dto.getSpotifyLinkDto());
            Assertions.assertNotNull(dto.getAppleMusicLinkDto());
            Assertions.assertNotNull(dto.getAlbumDto());
            Assertions.assertNotNull(dto.getArtistsDto());
        }
    }

    @Test
    void getByIdTest() {

        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2023)
                .build();

        ArtistDto artistDto1 = ArtistDto
                .builder()
                .nameDto("Test Artist 1")
                .nationalityDto("Test Nationality 1")
                .birthDateDto("1990-01-01")
                .build();

        ArtistDto artistDto2 = ArtistDto
                .builder()
                .nameDto("Test Artist 2")
                .nationalityDto("Test Nationality 2")
                .birthDateDto("1992-02-02")
                .build();

        albumService.addAlbum(albumDto);
        artistService.addArtist(artistDto1);
        artistService.addArtist(artistDto2);

        SongDto addSong = SongDto
                .builder()
                .nameDto("Initial Song")
                .durationDto(200)
                .spotifyLinkDto("https://spotify.com/initiallink")
                .appleMusicLinkDto("https://applemusic.com/initiallink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                                .builder()
                                .id(1L)
                                .build()
                ))
                .build();

        songService.addSong(addSong);
        songService.addSong(addSong);
        songService.addSong(addSong);



        Random random = new Random();
        int randomId = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(randomId).getIdDto();

        SongDto songDto = songService.getById(someId);

        Assertions.assertNotNull(songDto);

        Assertions.assertNotNull(songDto.getIdDto());
        Assertions.assertNotNull(songDto.getNameDto());
        Assertions.assertNotNull(songDto.getDurationDto());
        Assertions.assertNotNull(songDto.getSpotifyLinkDto());
        Assertions.assertNotNull(songDto.getAppleMusicLinkDto());
        Assertions.assertNotNull(songDto.getAlbumDto());
        Assertions.assertNotNull(songDto.getArtistsDto());

        SongDto check = songService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2023)
                .build();

        ArtistDto artistDto1 = ArtistDto
                .builder()
                .nameDto("Test Artist 1")
                .nationalityDto("Test Nationality 1")
                .birthDateDto("1990-01-01")
                .build();

        ArtistDto artistDto2 = ArtistDto
                .builder()
                .nameDto("Test Artist 2")
                .nationalityDto("Test Nationality 2")
                .birthDateDto("1992-02-02")
                .build();

        albumService.addAlbum(albumDto);
        artistService.addArtist(artistDto1);
        artistService.addArtist(artistDto2);

        SongDto songDto = SongDto
                .builder()
                .nameDto("Test Song")
                .durationDto(123)
                .spotifyLinkDto("https://spotify.com/examplelink")
                .appleMusicLinkDto("https://applemusic.com/examplelink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                        .builder()
                        .id(1L)
                        .build(),
                        Artist
                        .builder()
                        .id(2L)
                        .build()
                ))
                .build();


        SongDto add = songService.addSong(songDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getDurationDto());
        Assertions.assertNotNull(add.getSpotifyLinkDto());
        Assertions.assertNotNull(add.getAppleMusicLinkDto());
        Assertions.assertNotNull(add.getAlbumDto());
        Assertions.assertNotNull(add.getArtistsDto());


        Assertions.assertEquals(add.getNameDto(), songDto.getNameDto());
        Assertions.assertEquals(add.getDurationDto(), songDto.getDurationDto());
        Assertions.assertEquals(add.getSpotifyLinkDto(), songDto.getSpotifyLinkDto());
        Assertions.assertEquals(add.getAppleMusicLinkDto(), songDto.getAppleMusicLinkDto());
        Assertions.assertEquals(add.getAlbumDto().getTitle(), songDto.getAlbumDto().getTitle());
        Assertions.assertEquals(add.getAlbumDto().getReleaseYear(), songDto.getAlbumDto().getReleaseYear());
        Assertions.assertEquals(add.getArtistsDto().size(), songDto.getArtistsDto().size());


        SongDto added = songService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getDurationDto());
        Assertions.assertNotNull(added.getSpotifyLinkDto());
        Assertions.assertNotNull(added.getAppleMusicLinkDto());
        Assertions.assertNotNull(added.getAlbumDto());
        Assertions.assertNotNull(added.getArtistsDto());


        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getNameDto(), add.getNameDto());
        Assertions.assertEquals(added.getDurationDto(), add.getDurationDto());
        Assertions.assertEquals(added.getSpotifyLinkDto(), add.getSpotifyLinkDto());
        Assertions.assertEquals(added.getAppleMusicLinkDto(), add.getAppleMusicLinkDto());
        Assertions.assertEquals(added.getAlbumDto().getId(), add.getAlbumDto().getId());
        Assertions.assertEquals(added.getArtistsDto().size(), add.getArtistsDto().size());

        List<Artist> addedArtists = added.getArtistsDto();
        List<Artist> addArtists = add.getArtistsDto();
        for(int i = 0; i < addedArtists.size(); i++) {
            Assertions.assertEquals(addedArtists.get(i).getId(), addArtists.get(i).getId());
        }
    }

    @Test
    void updateTest() {

        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2023)
                .build();

        ArtistDto artistDto1 = ArtistDto
                .builder()
                .nameDto("Test Artist 1")
                .nationalityDto("Test Nationality 1")
                .birthDateDto("1990-01-01")
                .build();

        ArtistDto artistDto2 = ArtistDto
                .builder()
                .nameDto("Test Artist 2")
                .nationalityDto("Test Nationality 2")
                .birthDateDto("1992-02-02")
                .build();

        albumService.addAlbum(albumDto);
        artistService.addArtist(artistDto1);
        artistService.addArtist(artistDto2);

        SongDto addSong = SongDto
                .builder()
                .nameDto("Initial Song")
                .durationDto(200)
                .spotifyLinkDto("https://spotify.com/initiallink")
                .appleMusicLinkDto("https://applemusic.com/initiallink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                                .builder()
                                .id(1L)
                                .build()
                ))
                .build();

        songService.addSong(addSong);
        songService.addSong(addSong);
        songService.addSong(addSong);



        Random random = new Random();
        int randomId = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(randomId).getIdDto();

        SongDto updateSong = SongDto
                .builder()
                .idDto(someId)
                .nameDto("Test Song")
                .durationDto(123)
                .spotifyLinkDto("https://spotify.com/examplelink")
                .appleMusicLinkDto("https://applemusic.com/examplelink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                                .builder()
                                .id(1L)
                                .build(),
                        Artist
                                .builder()
                                .id(2L)
                                .build()
                ))
                .build();

        SongDto update = songService.updateById(updateSong.getIdDto(), updateSong);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getDurationDto());
        Assertions.assertNotNull(update.getSpotifyLinkDto());
        Assertions.assertNotNull(update.getAppleMusicLinkDto());
        Assertions.assertNotNull(update.getAlbumDto());
        Assertions.assertNotNull(update.getArtistsDto());


        Assertions.assertEquals(update.getIdDto(), updateSong.getIdDto());
        Assertions.assertEquals(update.getNameDto(), updateSong.getNameDto());
        Assertions.assertEquals(update.getDurationDto(), updateSong.getDurationDto());
        Assertions.assertEquals(update.getSpotifyLinkDto(), updateSong.getSpotifyLinkDto());
        Assertions.assertEquals(update.getAppleMusicLinkDto(), updateSong.getAppleMusicLinkDto());
        Assertions.assertEquals(update.getAlbumDto().getId(), updateSong.getAlbumDto().getId());
        Assertions.assertEquals(update.getArtistsDto().size(), updateSong.getArtistsDto().size());

        List<Artist> updateArtists = update.getArtistsDto();
        List<Artist> updateSongArtists = updateSong.getArtistsDto();
        for(int i = 0; i < updateArtists.size(); i++) {
            Assertions.assertEquals(updateArtists.get(i).getId(), updateSongArtists.get(i).getId());
        }


        SongDto updated = songService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getDurationDto());
        Assertions.assertNotNull(updated.getSpotifyLinkDto());
        Assertions.assertNotNull(updated.getAppleMusicLinkDto());
        Assertions.assertNotNull(updated.getAlbumDto());
        Assertions.assertNotNull(updated.getArtistsDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getNameDto(), update.getNameDto());
        Assertions.assertEquals(updated.getDurationDto(), update.getDurationDto());
        Assertions.assertEquals(updated.getSpotifyLinkDto(), update.getSpotifyLinkDto());
        Assertions.assertEquals(updated.getAppleMusicLinkDto(), update.getAppleMusicLinkDto());
        Assertions.assertEquals(updated.getAlbumDto().getId(), update.getAlbumDto().getId());
        Assertions.assertEquals(updated.getArtistsDto().size(), update.getArtistsDto().size());

        List<Artist> updatedArtists = updated.getArtistsDto();
        for(int i = 0; i < updatedArtists.size(); i++) {
            Assertions.assertEquals(updatedArtists.get(i).getId(), updateArtists.get(i).getId());
        }
    }

    @Test
    void deleteTest() {

        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2023)
                .build();

        ArtistDto artistDto1 = ArtistDto
                .builder()
                .nameDto("Test Artist 1")
                .nationalityDto("Test Nationality 1")
                .birthDateDto("1990-01-01")
                .build();

        ArtistDto artistDto2 = ArtistDto
                .builder()
                .nameDto("Test Artist 2")
                .nationalityDto("Test Nationality 2")
                .birthDateDto("1992-02-02")
                .build();

        albumService.addAlbum(albumDto);
        artistService.addArtist(artistDto1);
        artistService.addArtist(artistDto2);

        SongDto addSong = SongDto
                .builder()
                .nameDto("Initial Song")
                .durationDto(200)
                .spotifyLinkDto("https://spotify.com/initiallink")
                .appleMusicLinkDto("https://applemusic.com/initiallink")
                .albumDto(Album
                        .builder()
                        .id(1L)
                        .build()
                )
                .artistsDto(List.of(
                        Artist
                                .builder()
                                .id(1L)
                                .build()
                ))
                .build();

        songService.addSong(addSong);
        songService.addSong(addSong);
        songService.addSong(addSong);



        Random random = new Random();
        int randomId = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(songService.deleteById(someId));

        SongDto deleted = songService.getById(someId);

        Assertions.assertNull(deleted);
    }
}
