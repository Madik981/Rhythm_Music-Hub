package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;

    @Test
    void getAllTest() {

        AlbumDto addAlbum = AlbumDto
                .builder()
                .titleDto("Initial Album")
                .releaseYearDto(1990)
                .build();

        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);



        List<AlbumDto> albumDtos = albumService.getAll();

        Assertions.assertNotNull(albumDtos);

        Assertions.assertNotEquals(0, albumDtos.size());

        for (AlbumDto dto : albumDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getTitleDto());
            Assertions.assertNotNull(dto.getReleaseYearDto());
        }

    }

    @Test
    void getByIdTest() {

        AlbumDto addAlbum = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2000)
                .build();

        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);



        Random random = new Random();
        int randomId = random.nextInt(albumService.getAll().size());
        Long someId = albumService.getAll().get(randomId).getIdDto();

        AlbumDto albumDto = albumService.getById(someId);

        Assertions.assertNotNull(albumDto);

        Assertions.assertNotNull(albumDto.getIdDto());
        Assertions.assertNotNull(albumDto.getTitleDto());
        Assertions.assertNotNull(albumDto.getReleaseYearDto());

        AlbumDto check = albumService.getById(-1L);
        Assertions.assertNull(check);

    }

    @Test
    void addTest() {

        AlbumDto albumDto = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2000)
                .build();


        AlbumDto add = albumService.addAlbum(albumDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getTitleDto());
        Assertions.assertNotNull(add.getReleaseYearDto());


        Assertions.assertEquals(add.getTitleDto(), albumDto.getTitleDto());
        Assertions.assertEquals(add.getReleaseYearDto(), albumDto.getReleaseYearDto());


        AlbumDto added = albumService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getTitleDto());
        Assertions.assertNotNull(added.getReleaseYearDto());


        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getTitleDto(), add.getTitleDto());
        Assertions.assertEquals(added.getReleaseYearDto(), add.getReleaseYearDto());

    }

    @Test
    void updateTest() {

        AlbumDto addAlbum = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2000)
                .build();

        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);



        Random random = new Random();
        int randomId = random.nextInt(albumService.getAll().size());
        Long someId = albumService.getAll().get(randomId).getIdDto();

        AlbumDto updateAlbum = AlbumDto
                .builder()
                .idDto(someId)
                .titleDto("Test Album Update")
                .releaseYearDto(2025)
                .build();

        AlbumDto update = albumService.updateById(updateAlbum.getIdDto(), updateAlbum);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getTitleDto());
        Assertions.assertNotNull(update.getReleaseYearDto());


        Assertions.assertEquals(update.getIdDto(), updateAlbum.getIdDto());
        Assertions.assertEquals(update.getTitleDto(), updateAlbum.getTitleDto());
        Assertions.assertEquals(update.getReleaseYearDto(), updateAlbum.getReleaseYearDto());


        AlbumDto updated = albumService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getTitleDto());
        Assertions.assertNotNull(updated.getReleaseYearDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getTitleDto(), update.getTitleDto());
        Assertions.assertEquals(updated.getReleaseYearDto(), update.getReleaseYearDto());

    }

    @Test
    void deleteTest() {

        AlbumDto addAlbum = AlbumDto
                .builder()
                .titleDto("Test Album")
                .releaseYearDto(2000)
                .build();

        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);
        albumService.addAlbum(addAlbum);



        Random random = new Random();
        int randomId = random.nextInt(albumService.getAll().size());
        Long someId = albumService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(albumService.deleteById(someId));

        AlbumDto deleted = albumService.getById(someId);

        Assertions.assertNull(deleted);

    }
}
