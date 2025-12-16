package kz.madik.rhythm_musichub.service.impl;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.mapper.AlbumMapper;
import kz.madik.rhythm_musichub.repository.AlbumRepository;
import kz.madik.rhythm_musichub.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;


    @Override
    public List<AlbumDto> getAll() {
        return albumMapper.toDtoList(albumRepository.findAll());
    }

    @Override
    public AlbumDto getById(Long id) {
        return albumMapper.toDto(albumRepository.findById(id).orElse(null));
    }

    @Override
    public AlbumDto add(AlbumDto albumDto) {
        return albumMapper.toDto(albumRepository.save(albumMapper.toEntity(albumDto)));
    }

    @Override
    public AlbumDto updateById(Long id, AlbumDto albumDto) {
        Album album = albumMapper.toEntity(albumDto);

        Album updateAlbum = albumRepository.findById(id).orElse(null);

        updateAlbum.setTitle(album.getTitle());
        updateAlbum.setReleaseYear(album.getReleaseYear());

        return albumMapper.toDto(albumRepository.save(updateAlbum));
    }

    @Override
    public boolean deleteById(Long id) {
        albumRepository.deleteById(id);

        Album deletedAlbum = albumRepository.findById(id).orElse(null);

        return deletedAlbum == null;
    }
}
