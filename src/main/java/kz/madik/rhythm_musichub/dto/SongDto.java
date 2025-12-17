package kz.madik.rhythm_musichub.dto;

import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
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

    private int durationDto;

    private String spotifyLinkDto;

    private String appleMusicLinkDto;

    private Album albumDto;

    private List<Artist> artistsDto;
}
