package com.example.demo.dao.mapper;
import com.example.demo.dao.dto.UserDto;
import com.example.demo.security.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password",source="password",ignore = true )
    UserDto UserToUserDTO (User user);
    User UserDTOToUser (UserDto userDTO);
    User upDateUserFromDto(UserDto userDTO ,@MappingTarget User user);
    List<UserDto> mapToUsers(List<User> userEntityList);
}
