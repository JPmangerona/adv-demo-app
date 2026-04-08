package com.example.demo_adv.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    private String name;
    private String username;
    
    @Column(unique = true)
    private String email;
    
    private String password;

    @ManyToOne
    @JoinColumn(name = "advogado_id") // Cria a chave estrangeira no banco
    private Advogado advogado;
}
