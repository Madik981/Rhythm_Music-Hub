package kz.madik.rhythm_musichub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {
    private Long idDto;

    private String nameDto;

    private String nationalityDto;

    private String birthDateDto;
}
