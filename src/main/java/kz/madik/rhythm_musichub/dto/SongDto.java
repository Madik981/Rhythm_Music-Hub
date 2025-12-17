package kz.madik.rhythm_musichub.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDto {
    private Long idDto;

    private String nameDto;

    private Integer durationDto;

    private String spotifyLinkDto;

    private String appleMusicLinkDto;

    private AlbumDto albumDto;

    private List<ArtistDto> artistsDto;
}
