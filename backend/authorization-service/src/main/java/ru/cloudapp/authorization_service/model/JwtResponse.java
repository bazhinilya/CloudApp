package ru.cloudapp.authorization_service.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JwtResponse {

    @Column(nullable = false)
    private final String jwttoken;
}