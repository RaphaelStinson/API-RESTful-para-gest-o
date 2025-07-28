package com.example.inventarioapi.dto;

// Este DTO define a estrutura da resposta da API.
public record ProdutoResponseDTO(
    Long id,
    String nome,
    String descricao,
    Double preco,
    Integer quantidadeEstoque
) {}