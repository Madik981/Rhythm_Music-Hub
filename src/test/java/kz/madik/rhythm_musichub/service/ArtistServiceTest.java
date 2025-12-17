package kz.madik.rhythm_musichub.service;

import kz.madik.rhythm_musichub.dto.ArtistDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class ArtistServiceTest {

    @Autowired
    private ArtistService artistService;

    @Test
    void getAllTest() {

        ArtistDto addArtist = ArtistDto
                .builder()
                .nameDto("Test Artist")
                .nationalityDto("Test")
                .birthDateDto(LocalDate.parse("2000-01-01"))
                .build();

        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);



        List<ArtistDto> artistDtos = artistService.getAll();

        Assertions.assertNotNull(artistDtos);

        Assertions.assertNotEquals(0, artistDtos.size());

        for (ArtistDto dto : artistDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getNationalityDto());
            Assertions.assertNotNull(dto.getBirthDateDto());

        }

    }

    @Test
    void getByIdTest() {

        ArtistDto addArtist = ArtistDto
                .builder()
                .nameDto("Test Artist")
                .nationalityDto("Test")
                .birthDateDto(LocalDate.parse("2000-01-01"))
                .build();

        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);



        Random random = new Random();
        int randomId = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(randomId).getIdDto();

        ArtistDto artistDto = artistService.getById(someId);

        Assertions.assertNotNull(artistDto);

        Assertions.assertNotNull(artistDto.getIdDto());
        Assertions.assertNotNull(artistDto.getNameDto());
        Assertions.assertNotNull(artistDto.getNationalityDto());
        Assertions.assertNotNull(artistDto.getBirthDateDto());

        ArtistDto check = artistService.getById(-1L);
        Assertions.assertNull(check);

    }

    @Test
    void addTest() {

        ArtistDto artistDto = ArtistDto
                .builder()
                .nameDto("Test Artist")
                .nationalityDto("Test")
                .birthDateDto(LocalDate.parse("2000-01-01"))
                .build();


        ArtistDto add = artistService.addArtist(artistDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getNationalityDto());
        Assertions.assertNotNull(add.getBirthDateDto());


        Assertions.assertEquals(add.getNameDto(), artistDto.getNameDto());
        Assertions.assertEquals(add.getNationalityDto(), artistDto.getNationalityDto());
        Assertions.assertEquals(add.getBirthDateDto(), artistDto.getBirthDateDto());


        ArtistDto added = artistService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getNationalityDto());
        Assertions.assertNotNull(added.getBirthDateDto());


        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getNameDto(), add.getNameDto());
        Assertions.assertEquals(added.getNationalityDto(), add.getNationalityDto());
        Assertions.assertEquals(added.getBirthDateDto(), add.getBirthDateDto());

    }

    @Test
    void updateTest() {

        ArtistDto addArtist = ArtistDto
                .builder()
                .nameDto("Test Artist")
                .nationalityDto("Test")
                .birthDateDto(LocalDate.parse("2000-01-01"))
                .build();

        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);



        Random random = new Random();
        int randomId = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(randomId).getIdDto();

        ArtistDto updateArtist = ArtistDto
                .builder()
                .idDto(someId)
                .nameDto("Update Artist")
                .nationalityDto("Test Update")
                .birthDateDto(LocalDate.parse("2005-01-01"))
                .build();

        ArtistDto update = artistService.updateById(updateArtist.getIdDto(), updateArtist);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getNationalityDto());
        Assertions.assertNotNull(update.getBirthDateDto());


        Assertions.assertEquals(update.getIdDto(), updateArtist.getIdDto());
        Assertions.assertEquals(update.getNameDto(), updateArtist.getNameDto());
        Assertions.assertEquals(update.getNationalityDto(), updateArtist.getNationalityDto());
        Assertions.assertEquals(update.getBirthDateDto(), updateArtist.getBirthDateDto());



        ArtistDto updated = artistService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getNationalityDto());
        Assertions.assertNotNull(updated.getBirthDateDto());


        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getNameDto(), update.getNameDto());
        Assertions.assertEquals(updated.getNationalityDto(), update.getNationalityDto());
        Assertions.assertEquals(updated.getBirthDateDto(), update.getBirthDateDto());

    }

    @Test
    void deleteTest() {

        ArtistDto addArtist = ArtistDto
                .builder()
                .nameDto("Test Artist")
                .nationalityDto("Test")
                .birthDateDto(LocalDate.parse("2000-01-01"))
                .build();

        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);
        artistService.addArtist(addArtist);



        Random random = new Random();
        int randomId = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(artistService.deleteById(someId));

        ArtistDto deleted = artistService.getById(someId);

        Assertions.assertNull(deleted);

    }
}
