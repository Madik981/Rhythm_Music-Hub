package kz.madik.rhythm_musichub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumDto {
    private Long idDto;

    private String titleDto;

    private int releaseYearDto;
}
