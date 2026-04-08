package com.example.demo_adv.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_adv.model.DTOs.AssistenteRequestDTO;
import com.example.demo_adv.model.DTOs.AssistenteResponseDTO;
import com.example.demo_adv.model.service.AssistenteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/assistentes")
@CrossOrigin(origins = "http://localhost:8081")
public class AssistenteController {

    @Autowired
    private AssistenteService service;

    // 1. CREATE (Criar)
    @PostMapping
    public AssistenteResponseDTO criar(@Valid @RequestBody AssistenteRequestDTO assistente) {
        return service.salvar(assistente);
    }

    // 2. READ (Listar todos)
    @GetMapping
    public List<AssistenteResponseDTO> listar() {
        return service.listarTodos();
    }

    // 3. READ (Buscar por ID específico)
    @GetMapping("/{id}")
    public AssistenteResponseDTO buscarPorId(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }

    // 4. UPDATE (Atualizar)
    @PutMapping("/{id}")
    public AssistenteResponseDTO atualizar(@PathVariable UUID id, @Valid @RequestBody AssistenteRequestDTO assistenteAtualizado) {
        return service.atualizar(id, assistenteAtualizado);
    }

    // 5. DELETE (Remover)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        service.deletar(id);
    }
}