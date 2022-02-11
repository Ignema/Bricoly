package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.User;
import com.bricoly.backend.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends GenericMapper<User, UserDTO> {
    @Override
    @Mapping(target = "user_id", ignore = true)
    User asEntity(UserDTO dto);
}