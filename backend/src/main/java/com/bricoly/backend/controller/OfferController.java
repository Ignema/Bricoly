package com.bricoly.backend.controller;

import com.bricoly.backend.dto.OfferDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Offer", description = "Offer API")
public interface OfferController {
    @Operation(summary = "Add new data")
    public OfferDTO save(@RequestBody OfferDTO offer);

    @Operation(summary = "Find by Id")
    public OfferDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<OfferDTO> list();

    @Operation(summary = "Pagination request")
    public Page<OfferDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public OfferDTO update(@RequestBody OfferDTO dto, @PathVariable("id") Long id);
}