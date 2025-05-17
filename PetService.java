package com.petadota.service;

import com.petadota.model.Pet;
import com.petadota.repository.PetRepository;
import com.petadota.exception.PetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> listarTodosPets() {
        return petRepository.findAll();
    }

    public Pet buscarPetPorId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Pet não encontrado com id: " + id));
    }

    @Transactional
    public Pet salvarPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Transactional
    public Pet atualizarPet(Long id, Pet petAtualizado) {
        Pet petExistente = buscarPetPorId(id);
        petExistente.setNome(petAtualizado.getNome());
        petExistente.setTipo(petAtualizado.getTipo());
        petExistente.setIdade(petAtualizado.getIdade());
        petExistente.setRaca(petAtualizado.getRaca());
        petExistente.setStatusAdocao(petAtualizado.getStatusAdocao());
        petExistente.setDescricao(petAtualizado.getDescricao());
        petExistente.setImagemUrl(petAtualizado.getImagemUrl());
        return petRepository.save(petExistente);
    }

    @Transactional
    public void deletarPet(Long id) {
        Pet pet = buscarPetPorId(id);
        petRepository.delete(pet);
    }
}
