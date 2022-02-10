package com.bricoly.backend.controller;

import com.bricoly.backend.dto.SkillDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Skill", description = "Skill API")
public interface SkillController {
    @Operation(summary = "Add new data")
    public SkillDTO save(@RequestBody SkillDTO skill);

    @Operation(summary = "Find by Id")
    public SkillDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<SkillDTO> list();

    @Operation(summary = "Pagination request")
    public Page<SkillDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public SkillDTO update(@RequestBody SkillDTO dto, @PathVariable("id") Long id);
}