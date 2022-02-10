package com.bricoly.backend.controller;

import com.bricoly.backend.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "User", description = "User API")
public interface UserController {
    @Operation(summary = "Add new data")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user);

    @Operation(summary = "Find by Id")
    public UserDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(summary = "Find all data")
    public List<UserDTO> list();

    @Operation(summary = "Pagination request")
    public Page<UserDTO> pageQuery(Pageable pageable);

    @Operation(summary = "Update one data")
    public UserDTO update(@RequestBody UserDTO dto, @PathVariable("id") Long id);
}