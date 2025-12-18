package kz.madik.rhythm_musichub.mapper;

import kz.madik.rhythm_musichub.dto.PermissionDto;
import kz.madik.rhythm_musichub.entity.Permission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PermissionMapperTest {

    @Autowired
    private PermissionMapper userMapper;

    @Test
    void convertEntityToDtoTest(){

        Permission userEntity = new Permission(1L, "ROLE_TEST");

        PermissionDto userDto = userMapper.toDto(userEntity);

        Assertions.assertNotNull(userDto);

        Assertions.assertNotNull(userDto.getIdDto());
        Assertions.assertNotNull(userDto.getNameDto());

        Assertions.assertEquals(userEntity.getId(), userDto.getIdDto());
        Assertions.assertEquals(userEntity.getName(), userDto.getNameDto());

    }

    @Test
    void convertDtoToEntityTest(){

        PermissionDto userDto = new PermissionDto(1L, "ROLE_TEST");

        Permission userEntity = userMapper.toEntity(userDto);

        Assertions.assertNotNull(userEntity);

        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertNotNull(userEntity.getName());

        Assertions.assertEquals(userDto.getIdDto(), userEntity.getId());
        Assertions.assertEquals(userDto.getNameDto(), userEntity.getName());

    }

    @Test
    void convertEntityListToDtoListTest(){

        List<Permission> userEntityList = new ArrayList<>();
        userEntityList.add(new Permission(1L, "ROLE_TEST1"));
        userEntityList.add(new Permission(2L, "ROLE_TEST2"));
        userEntityList.add(new Permission(3L, "ROLE_TEST3"));


        List<PermissionDto> userDtoList = userMapper.toDtoList(userEntityList);

        Assertions.assertNotNull(userDtoList);

        Assertions.assertNotEquals(0, userDtoList.size());

        Assertions.assertEquals(userEntityList.size(), userDtoList.size());

        for (int i = 0; i < userEntityList.size(); i++) {

            Permission userEntity = userEntityList.get(i);

            PermissionDto userDto = userDtoList.get(i);

            Assertions.assertNotNull(userDto);

            Assertions.assertNotNull(userDto.getIdDto());
            Assertions.assertNotNull(userDto.getNameDto());

            Assertions.assertEquals(userEntity.getId(), userDto.getIdDto());
            Assertions.assertEquals(userEntity.getName(), userDto.getNameDto());

        }

    }
}
