package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.UserModelDto;
import kz.madik.rhythm_musichub.entity.Permission;
import kz.madik.rhythm_musichub.entity.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void convertEntityToDtoTest(){

        UserModel userEntity = new UserModel(1L, "test user", "test@example.com", "12345", List.of(new Permission(1L, "ROLE_USER")));

        UserModelDto userDto = userMapper.toDto(userEntity);

        Assertions.assertNotNull(userDto);

        Assertions.assertNotNull(userDto.getIdDto());
        Assertions.assertNotNull(userDto.getUsernameDto());
        Assertions.assertNotNull(userDto.getEmailDto());

        Assertions.assertEquals(userEntity.getId(), userDto.getIdDto());
        Assertions.assertEquals(userEntity.getUsername(), userDto.getUsernameDto());
        Assertions.assertEquals(userEntity.getEmail(), userDto.getEmailDto());

    }

    @Test
    void convertDtoToEntityTest(){

        UserModelDto userDto = new UserModelDto(1L, "test user", "test@example");

        UserModel userEntity = userMapper.toEntity(userDto);

        Assertions.assertNotNull(userEntity);

        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertNotNull(userEntity.getUsername());
        Assertions.assertNotNull(userEntity.getEmail());

        Assertions.assertEquals(userDto.getIdDto(), userEntity.getId());
        Assertions.assertEquals(userDto.getUsernameDto(), userEntity.getUsername());
        Assertions.assertEquals(userDto.getEmailDto(), userEntity.getEmail());

    }

    @Test
    void convertEntityListToDtoListTest(){

        List<UserModel> userEntityList = new ArrayList<>();
        userEntityList.add(new UserModel(1L, "UserModel One", "test1@example.com", "123451", List.of(new Permission(1L, "ROLE_USER"))));
        userEntityList.add(new UserModel(2L, "UserModel Two", "test2@example.com", "123452", List.of(new Permission(1L, "ROLE_USER"))));
        userEntityList.add(new UserModel(3L, "UserModel Three", "test3@example.com", "123453", List.of(new Permission(1L, "ROLE_USER"))));


        List<UserModelDto> userDtoList = userMapper.toDtoList(userEntityList);

        Assertions.assertNotNull(userDtoList);

        Assertions.assertNotEquals(0, userDtoList.size());

        Assertions.assertEquals(userEntityList.size(), userDtoList.size());

        for (int i = 0; i < userEntityList.size(); i++) {

            UserModel userEntity = userEntityList.get(i);

            UserModelDto userDto = userDtoList.get(i);

            Assertions.assertNotNull(userDto);

            Assertions.assertNotNull(userDto.getIdDto());
            Assertions.assertNotNull(userDto.getUsernameDto());
            Assertions.assertNotNull(userDto.getEmailDto());

            Assertions.assertEquals(userEntity.getId(), userDto.getIdDto());
            Assertions.assertEquals(userEntity.getUsername(), userDto.getUsernameDto());
            Assertions.assertEquals(userEntity.getEmail(), userDto.getEmailDto());

        }

    }
}
