package com.bricoly.backend.controller;

import com.bricoly.backend.dto.DayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Day", description = "Day API")
public interface DayController {
    @Operation(summary = "Add new data")
    public DayDTO save(@RequestBody DayDTO day);

    @Operation(summary = "Find by Id")
    public DayDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<DayDTO> list();

    @Operation(summary = "Pagination request")
    public Page<DayDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public DayDTO update(@RequestBody DayDTO dto, @PathVariable("id") Long id);
}