package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.UserModelDto;
import kz.madik.rhythm_musichub.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "usernameDto", source = "username")
    @Mapping(target = "emailDto", source = "email")
    UserModelDto toDto(UserModel userModel);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "username", source = "usernameDto")
    @Mapping(target = "email", source = "emailDto")
    UserModel toEntity(UserModelDto userModelDto);

    List<UserModelDto> toDtoList(List<UserModel> userModels);

}
