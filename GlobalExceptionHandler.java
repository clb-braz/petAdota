package com.petadota.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PetNotFoundException.class)
    public String handlePetNotFound(PetNotFoundException ex, Model model) {
        model.addAttribute("mensagemErro", ex.getMessage());
        return "erro";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("mensagemErro", "Ocorreu um erro inesperado: " + ex.getMessage());
        return "erro";
    }
}
