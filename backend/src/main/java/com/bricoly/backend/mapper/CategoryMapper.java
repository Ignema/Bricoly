package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Category;
import com.bricoly.backend.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> {
    @Override
    @Mapping(target = "category_id", ignore = true)
    Category asEntity(CategoryDTO dto);
}