package com.example.demo_adv.model.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    
    private String username;
    private String email;
    private String password;
    
    private UUID advogadoId;
}
