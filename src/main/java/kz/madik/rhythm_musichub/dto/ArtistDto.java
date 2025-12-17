package kz.madik.rhythm_musichub.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDto {
    private Long idDto;

    private String nameDto;

    private String nationalityDto;

    private LocalDate birthDateDto;
}
