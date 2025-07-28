package com.example.inventarioapi.service;

import com.example.inventarioapi.dto.ProdutoRequestDTO;
import com.example.inventarioapi.dto.ProdutoResponseDTO;
import com.example.inventarioapi.exception.ResourceNotFoundException;
import com.example.inventarioapi.mapper.ProdutoMapper;
import com.example.inventarioapi.model.Produto;
import com.example.inventarioapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    // Injeção de dependências via construtor (melhor prática)
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(produtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o id: " + id));
        return produtoMapper.toResponseDTO(produto);
    }

    @Transactional
    public ProdutoResponseDTO criar(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.toEntity(produtoRequestDTO);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoMapper.toResponseDTO(produtoSalvo);
    }

    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o id: " + id));

        // Usa o mapper para atualizar a entidade existente com os dados do DTO
        produtoMapper.updateProdutoFromDto(produtoRequestDTO, produtoExistente);

        Produto produtoAtualizado = produtoRepository.save(produtoExistente);
        return produtoMapper.toResponseDTO(produtoAtualizado);
    }

    @Transactional
    public void apagar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com o id: " + id);
        }
        produtoRepository.deleteById(id);
    }
}