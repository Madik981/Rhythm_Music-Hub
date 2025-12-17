package kz.madik.rhythm_musichub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDto {
    private Long idDto;

    private String nameDto;

    private String nationalityDto;

    private String birthDateDto;
}
