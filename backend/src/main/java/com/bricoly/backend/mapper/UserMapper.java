package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.User;
import com.bricoly.backend.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserMapper extends GenericMapper<User, UserDTO> {
    @Override
    @Mapping(target = "user_id", ignore = false)
    User asEntity(UserDTO dto);
}