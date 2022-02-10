package com.bricoly.backend.controller;

import com.bricoly.backend.dto.ProviderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Provider", description = "Provider API")
public interface ProviderController {
    @Operation(summary = "Add new data")
    public ProviderDTO save(@RequestBody ProviderDTO provider);

    @Operation(summary = "Find by Id")
    public ProviderDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<ProviderDTO> list();

    @Operation(summary = "Pagination request")
    public Page<ProviderDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public ProviderDTO update(@RequestBody ProviderDTO dto, @PathVariable("id") Long id);
}