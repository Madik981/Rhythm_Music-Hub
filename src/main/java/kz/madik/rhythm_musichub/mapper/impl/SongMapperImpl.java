package kz.madik.rhythm_musichub.mapper.impl;

import kz.madik.rhythm_musichub.dto.AlbumDto;
import kz.madik.rhythm_musichub.dto.ArtistDto;
import kz.madik.rhythm_musichub.dto.SongDto;
import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
import kz.madik.rhythm_musichub.entity.Song;
import kz.madik.rhythm_musichub.mapper.SongMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongMapperImpl implements SongMapper {

    @Override
    public SongDto toDto(Song song) {
        if ( song == null ) {
            return null;
        }

        SongDto.SongDtoBuilder songDto = SongDto.builder();

        songDto.idDto( song.getId() );
        songDto.nameDto( song.getName() );
        songDto.durationDto( song.getDuration() );
        songDto.spotifyLinkDto( song.getSpotifyLink() );
        songDto.appleMusicLinkDto( song.getAppleMusicLink() );
        songDto.albumDto( albumToAlbumDto( song.getAlbum() ) );
        songDto.artistsDto( artistListToArtistDtoList( song.getArtists() ) );

        return songDto.build();
    }

    @Override
    public Song toEntity(SongDto songDto) {
        if ( songDto == null ) {
            return null;
        }

        Song.SongBuilder song = Song.builder();

        song.id( songDto.getIdDto() );
        song.name( songDto.getNameDto() );
        song.duration( songDto.getDurationDto() );
        song.spotifyLink( songDto.getSpotifyLinkDto() );
        song.appleMusicLink( songDto.getAppleMusicLinkDto() );
        song.album( albumDtoToAlbum( songDto.getAlbumDto() ) );
        song.artists( artistDtoListToArtistList( songDto.getArtistsDto() ) );

        return song.build();
    }

    @Override
    public List<SongDto> toDtoList(List<Song> songs) {
        if ( songs == null ) {
            return null;
        }

        List<SongDto> list = new ArrayList<SongDto>( songs.size() );
        for ( Song song : songs ) {
            list.add( toDto( song ) );
        }

        return list;
    }

    protected AlbumDto albumToAlbumDto(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDto.AlbumDtoBuilder albumDto = AlbumDto
                .builder()
                .idDto(album.getId())
                .titleDto(album.getTitle())
                .releaseYearDto(album.getReleaseYear());

        return albumDto.build();
    }

    protected ArtistDto artistToArtistDto(Artist artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistDto.ArtistDtoBuilder artistDto = ArtistDto
                .builder()
                .idDto(artist.getId())
                .nameDto(artist.getName())
                .nationalityDto(artist.getNationality())
                .birthDateDto(artist.getBirthDate());

        return artistDto.build();
    }

    protected List<ArtistDto> artistListToArtistDtoList(List<Artist> list) {
        if ( list == null ) {
            return null;
        }

        List<ArtistDto> list1 = new ArrayList<ArtistDto>( list.size() );
        for ( Artist artist : list ) {
            list1.add( artistToArtistDto( artist ) );
        }

        return list1;
    }

    protected Album albumDtoToAlbum(AlbumDto albumDto) {
        if ( albumDto == null ) {
            return null;
        }

        Album.AlbumBuilder album = Album
                .builder()
                .id(albumDto.getIdDto())
                .title(albumDto.getTitleDto())
                .releaseYear(albumDto.getReleaseYearDto());

        return album.build();
    }

    protected Artist artistDtoToArtist(ArtistDto artistDto) {
        if ( artistDto == null ) {
            return null;
        }

        Artist.ArtistBuilder artist = Artist
                .builder()
                .id(artistDto.getIdDto())
                .name(artistDto.getNameDto())
                .nationality(artistDto.getNationalityDto())
                .birthDate(artistDto.getBirthDateDto());

        return artist.build();
    }

    protected List<Artist> artistDtoListToArtistList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Artist> list1 = new ArrayList<Artist>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistDtoToArtist( artistDto ) );
        }

        return list1;
    }
}