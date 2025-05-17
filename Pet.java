package com.petadota.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "O tipo é obrigatório")
    @Size(max = 30)
    private String tipo; // Cachorro, Gato, etc.

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 0, message = "A idade não pode ser negativa")
    private Integer idade;

    @NotBlank(message = "A raça é obrigatória")
    @Size(max = 40)
    private String raca;

    @NotBlank(message = "O status de adoção é obrigatório")
    private String statusAdocao; // Disponível, Em processo, Adotado

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 255)
    private String descricao;

    @NotBlank(message = "A URL da imagem é obrigatória")
    private String imagemUrl;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public String getStatusAdocao() { return statusAdocao; }
    public void setStatusAdocao(String statusAdocao) { this.statusAdocao = statusAdocao; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }
}
