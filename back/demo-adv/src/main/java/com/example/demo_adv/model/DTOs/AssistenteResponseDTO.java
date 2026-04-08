package com.example.demo_adv.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistenteResponseDTO {
    private UUID id;
    private String cpf;
    private String name;
    private String username;
    private String email;
    private UUID advogadoChefeId;
    private String advogadoChefeNome;
}
