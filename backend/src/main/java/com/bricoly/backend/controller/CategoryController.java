package com.bricoly.backend.controller;

import com.bricoly.backend.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Category", description = "Category API")
public interface CategoryController {
    @Operation(summary = "Add new data")
    public CategoryDTO save(@RequestBody CategoryDTO category);

    @Operation(summary = "Find by Id")
    public CategoryDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<CategoryDTO> list();

    @Operation(summary = "Pagination request")
    public Page<CategoryDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public CategoryDTO update(@RequestBody CategoryDTO dto, @PathVariable("id") Long id);
}