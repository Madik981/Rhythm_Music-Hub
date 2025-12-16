package kz.madik.rhythm_musichub.service.impl;

import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Song;
import kz.madik.rhythm_musichub.mapper.SongMapper;
import kz.madik.rhythm_musichub.repository.SongRepository;
import kz.madik.rhythm_musichub.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    public List<SongDto> getAll() {
        return songMapper.toDtoList(songRepository.findAll());
    }

    @Override
    public SongDto getById(Long id) {
        return songMapper.toDto(songRepository.findById(id).orElse(null));
    }

    @Override
    public SongDto add(SongDto songDto) {
        return songMapper.toDto(songRepository.save(songMapper.toEntity(songDto)));
    }

    @Override
    public SongDto updateById(Long id, SongDto songDto) {
        Song song = songMapper.toEntity(songDto);

        Song updateSong = songRepository.findById(id).orElse(null);

        updateSong.setName(song.getName());
        updateSong.setDuration(song.getDuration());
        updateSong.setAlbum(song.getAlbum());
        updateSong.setArtists(song.getArtists());

        return songMapper.toDto(songRepository.save(updateSong));
    }

    @Override
    public boolean deleteById(Long id) {
        songRepository.deleteById(id);

        Song deletedSong = songRepository.findById(id).orElse(null);

        return deletedSong == null;
    }
}
