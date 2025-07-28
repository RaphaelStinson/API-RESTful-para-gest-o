package com.example.inventarioapi.dto;

// Importações atualizadas para o pacote 'jakarta'
import jakarta.validation.constraints.*;

// Cada 'record' público deve estar no seu próprio ficheiro.
public record ProdutoRequestDTO(
    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres.")
    String nome,

    @Size(max = 255, message = "A descrição não pode exceder 255 caracteres.")
    String descricao,

    @NotNull(message = "O preço não pode ser nulo.")
    @PositiveOrZero(message = "O preço deve ser um valor positivo ou zero.")
    Double preco,

    @NotNull(message = "A quantidade em estoque não pode ser nula.")
    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa.")
    Integer quantidadeEstoque
) {}