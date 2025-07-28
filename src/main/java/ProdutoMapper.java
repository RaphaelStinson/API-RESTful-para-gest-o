package com.example.inventarioapi.mapper;

import com.example.inventarioapi.dto.ProdutoRequestDTO;
import com.example.inventarioapi.dto.ProdutoResponseDTO;
import com.example.inventarioapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

// A anotação @Mapper diz ao MapStruct para criar uma implementação desta interface.
// componentModel = "spring" permite que seja injetado como um bean do Spring.
@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // Converte um DTO de request para uma entidade Produto.
    Produto toEntity(ProdutoRequestDTO dto);

    // Converte uma entidade Produto para um DTO de resposta.
    ProdutoResponseDTO toResponseDTO(Produto produto);

    // Atualiza uma entidade existente a partir de um DTO.
    // @MappingTarget garante que o objeto 'produto' seja atualizado em vez de criar um novo.
    void updateProdutoFromDto(ProdutoRequestDTO dto, @MappingTarget Produto produto);
}