package com.bricoly.backend.controller;

import com.bricoly.backend.dto.DetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Detail", description = "Detail API")
public interface DetailController {
    @Operation(summary = "Add new data")
    public DetailDTO save(@RequestBody DetailDTO detail);

    @Operation(summary = "Find by Id")
    public DetailDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<DetailDTO> list();

    @Operation(summary = "Pagination request")
    public Page<DetailDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public DetailDTO update(@RequestBody DetailDTO dto, @PathVariable("id") Long id);
}