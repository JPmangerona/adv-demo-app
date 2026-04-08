package com.example.demo_adv.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvogadoRequestDTO {
    private String cpf;
    private String name;
    private String username;
    private String email;
    private String password;
    private String oab;
}
