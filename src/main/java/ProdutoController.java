package com.example.inventarioapi.controller;

import com.example.inventarioapi.dto.ProdutoRequestDTO;
import com.example.inventarioapi.dto.ProdutoResponseDTO;
import com.example.inventarioapi.service.ProdutoService;
import jakarta.validation.Valid; // Pacote mudou no Spring Boot 3
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    // Injeção de dependências via construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosProdutos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO produtoCriado = produtoService.criar(produtoRequestDTO);
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO produtoAtualizado = produtoService.atualizar(id, produtoRequestDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarProduto(@PathVariable Long id) {
        produtoService.apagar(id);
        return ResponseEntity.noContent().build();
    }
}