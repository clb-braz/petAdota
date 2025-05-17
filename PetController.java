package com.petadota.controller;

import com.petadota.model.Pet;
import com.petadota.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/")
    public String home() {
        return "redirect:/pets";
    }

    @GetMapping("/pets")
    public String listarPets(Model model) {
        model.addAttribute("pets", petService.listarTodosPets());
        return "pets";
    }

    @GetMapping("/pets/{id}")
    public String detalhesPet(@PathVariable Long id, Model model) {
        Pet pet = petService.buscarPetPorId(id);
        model.addAttribute("pet", pet);
        return "detalhesPet";
    }

    @GetMapping("/pets/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("pet", new Pet());
        return "formularioPet";
    }

    @PostMapping("/pets")
    public String salvarPet(@Valid @ModelAttribute Pet pet, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "formularioPet";
        }
        petService.salvarPet(pet);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Pet cadastrado com sucesso!");
        return "redirect:/pets";
    }

    @GetMapping("/pets/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Pet pet = petService.buscarPetPorId(id);
        model.addAttribute("pet", pet);
        return "formularioPet";
    }

    @PostMapping("/pets/atualizar/{id}")
    public String atualizarPet(@PathVariable Long id, @Valid @ModelAttribute Pet pet, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "formularioPet";
        }
        petService.atualizarPet(id, pet);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Pet atualizado com sucesso!");
        return "redirect:/pets";
    }

    @GetMapping("/pets/excluir/{id}")
    public String excluirPet(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        petService.deletarPet(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Pet excluído com sucesso!");
        return "redirect:/pets";
    }
}
