package kz.madik.rhythm_musichub.dto;

import kz.madik.rhythm_musichub.entity.Album;
import kz.madik.rhythm_musichub.entity.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private Long idDto;

    private String nameDto;

    private int durationDto;

    private Album albumDto;

    private List<Artist> artistsDto;
}
