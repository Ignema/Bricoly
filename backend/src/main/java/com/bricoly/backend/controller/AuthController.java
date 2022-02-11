package com.bricoly.backend.controller;

import com.bricoly.backend.controller.impl.AuthControllerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "Authentication", description = "Authentication API")
public interface AuthController {
    @Operation(summary = "Login user")
    public ResponseEntity<AuthControllerImpl.AuthResponse> login(@RequestBody @Valid AuthControllerImpl.AuthRequest request);
}