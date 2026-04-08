package com.example.demo_adv.model.DTOs;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvogadoResponseDTO {
    private UUID id;
    private String cpf;
    private String name;
    private String username;
    private String email;
    private String oab;
    private String role;
}
