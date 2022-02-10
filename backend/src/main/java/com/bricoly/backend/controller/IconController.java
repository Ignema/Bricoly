package com.bricoly.backend.controller;

import com.bricoly.backend.dto.IconDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Icon", description = "Icon API")
public interface IconController {
    @Operation(summary = "Add new data")
    public IconDTO save(@RequestBody IconDTO icon);

    @Operation(summary = "Find by Id")
    public IconDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<IconDTO> list();

    @Operation(summary = "Pagination request")
    public Page<IconDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public IconDTO update(@RequestBody IconDTO dto, @PathVariable("id") Long id);
}