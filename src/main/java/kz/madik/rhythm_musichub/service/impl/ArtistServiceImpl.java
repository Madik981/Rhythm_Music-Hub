package kz.madik.rhythm_musichub.service.impl;

import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.entity.Artist;
import kz.madik.rhythm_musichub.mapper.ArtistMapper;
import kz.madik.rhythm_musichub.repository.ArtistRepository;
import kz.madik.rhythm_musichub.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;


    @Override
    public List<ArtistDto> getAll() {
        return artistMapper.toDtoList(artistRepository.findAll());
    }

    @Override
    public ArtistDto getById(Long id) {
        return artistMapper.toDto(artistRepository.findById(id).orElse(null));
    }

    @Override
    public ArtistDto addArtist(ArtistDto artistDto) {
        return artistMapper.toDto(artistRepository.save(artistMapper.toEntity(artistDto)));
    }

    @Override
    public ArtistDto updateById(Long id, ArtistDto artistDto) {
        Artist artist = artistMapper.toEntity(artistDto);

        Artist updateArtist = artistRepository.findById(id).orElse(null);

        updateArtist.setName(artist.getName());
        updateArtist.setNationality(artist.getNationality());
        updateArtist.setBirthDate(artist.getBirthDate());

        return artistMapper.toDto(artistRepository.save(updateArtist));
    }

    @Override
    public boolean deleteById(Long id) {
        artistRepository.deleteById(id);

        Artist deletedArtist = artistRepository.findById(id).orElse(null);

        return deletedArtist == null;
    }
}
