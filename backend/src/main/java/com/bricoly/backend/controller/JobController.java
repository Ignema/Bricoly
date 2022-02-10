package com.bricoly.backend.controller;

import com.bricoly.backend.dto.JobDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Job", description = "Job API")
public interface JobController {
    @Operation(summary = "Add new data")
    public JobDTO save(@RequestBody JobDTO job);

    @Operation(summary = "Find by Id")
    public JobDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<JobDTO> list();

    @Operation(summary = "Pagination request")
    public Page<JobDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public JobDTO update(@RequestBody JobDTO dto, @PathVariable("id") Long id);
}