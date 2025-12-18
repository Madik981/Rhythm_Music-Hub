package kz.madik.rhythm_musichub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModelDto {
    private Long idDto;

    private String usernameDto;

    private String emailDto;
}
