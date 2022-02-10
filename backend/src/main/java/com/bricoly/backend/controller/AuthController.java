package com.bricoly.backend.controller;

import com.bricoly.backend.controller.impl.AuthControllerImpl;
import com.bricoly.backend.dto.SkillDTO;
import com.bricoly.backend.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Authentication", description = "Authentication API")
public interface AuthController {
    @Operation(summary = "Login user")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid AuthControllerImpl.AuthRequest request);
}