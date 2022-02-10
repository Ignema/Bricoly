package com.bricoly.backend.controller;

import com.bricoly.backend.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Customer", description = "Customer API")
public interface CustomerController {
    @Operation(summary = "Add new data")
    public CustomerDTO save(@RequestBody CustomerDTO customer);

    @Operation(summary = "Find by Id")
    public CustomerDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<CustomerDTO> list();

    @Operation(summary = "Pagination request")
    public Page<CustomerDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public CustomerDTO update(@RequestBody CustomerDTO dto, @PathVariable("id") Long id);
}