package com.example.inventarioapi.repository;

import com.example.inventarioapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A interface JpaRepository recebe dois parâmetros:
 * 1. A classe da entidade que ela gerenciará (Produto).
 * 2. O tipo da chave primária da entidade (Long).
 *
 * O Spring Data JPA fornecerá a implementação em tempo de execução.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Nenhum código é necessário aqui!
    // Métodos como save(), findById(), findAll(), deleteById() já estão disponíveis.
}