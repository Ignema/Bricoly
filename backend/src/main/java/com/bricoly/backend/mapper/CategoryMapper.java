package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.CategoryDTO;
import com.bricoly.backend.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {
    @Override
    @Mapping(target = "category_id", ignore = false)
    Category asEntity(CategoryDTO dto);
}