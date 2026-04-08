package com.example.demo_adv.model.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo_adv.model.DTOs.AssistenteRequestDTO;
import com.example.demo_adv.model.DTOs.AssistenteResponseDTO;
import com.example.demo_adv.model.entity.Advogado;
import com.example.demo_adv.model.entity.Assistente;
import com.example.demo_adv.model.repositores.AdvogadoRepository;
import com.example.demo_adv.model.repositores.AssitenteRepository;

@Service
public class AssistenteService {

    @Autowired
    private AssitenteRepository assistenteRepository;

    @Autowired
    private AdvogadoRepository advogadoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AssistenteResponseDTO salvar(AssistenteRequestDTO dto) {
        if (dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new RuntimeException("Senha é obrigatória!");
        }
        Assistente assistente = new Assistente();
        assistente.setCpf(dto.getCpf());
        assistente.setName(dto.getName());
        assistente.setUsername(dto.getUsername());
        assistente.setEmail(dto.getEmail());
        assistente.setPassword(passwordEncoder.encode(dto.getPassword()));

        if (dto.getAdvogadoChefeId() != null) {
            Advogado advogado = advogadoRepository.findById(dto.getAdvogadoChefeId())
                    .orElseThrow(() -> new RuntimeException("Advogado não encontrado"));
            assistente.setAdvogadoChefe(advogado);
        }

        Assistente saved = assistenteRepository.save(assistente);
        return convertToResponseDTO(saved);
    }

    public List<AssistenteResponseDTO> listarTodos() {
        return assistenteRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public AssistenteResponseDTO buscarPorId(UUID id) {
        return assistenteRepository.findById(id)
                .map(this::convertToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Assistente não encontrado"));
    }

    public AssistenteResponseDTO atualizar(UUID id, AssistenteRequestDTO dto) {
        return assistenteRepository.findById(id).map(assistente -> {
            assistente.setName(dto.getName());
            assistente.setEmail(dto.getEmail());
            assistente.setUsername(dto.getUsername());

            if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
                assistente.setPassword(passwordEncoder.encode(dto.getPassword()));
            }

            if (dto.getAdvogadoChefeId() != null) {
                Advogado advogado = advogadoRepository.findById(dto.getAdvogadoChefeId())
                        .orElseThrow(() -> new RuntimeException("Advogado não encontrado"));
                assistente.setAdvogadoChefe(advogado);
            }

            Assistente saved = assistenteRepository.save(assistente);
            return convertToResponseDTO(saved);
        }).orElseThrow(() -> new RuntimeException("Assistente não encontrado"));
    }

    public void deletar(UUID id) {
        assistenteRepository.deleteById(id);
    }

    private AssistenteResponseDTO convertToResponseDTO(Assistente assistente) {
        AssistenteResponseDTO dto = new AssistenteResponseDTO();
        dto.setId(assistente.getId());
        dto.setCpf(assistente.getCpf());
        dto.setName(assistente.getName());
        dto.setUsername(assistente.getUsername());
        dto.setEmail(assistente.getEmail());

        if (assistente.getAdvogadoChefe() != null) {
            dto.setAdvogadoChefeId(assistente.getAdvogadoChefe().getId());
            dto.setAdvogadoChefeNome(assistente.getAdvogadoChefe().getName());
        }

        return dto;
    }
}
