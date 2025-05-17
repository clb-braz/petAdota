package com.petadota.repository;

import com.petadota.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByStatusAdocao(String statusAdocao);
}
