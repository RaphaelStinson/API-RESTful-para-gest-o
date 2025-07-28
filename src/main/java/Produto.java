package com.example.inventarioapi.model;

// Importações atualizadas para o pacote 'jakarta'
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @Size(max = 255, message = "A descrição não pode exceder 255 caracteres.")
    @Column(length = 255)
    private String descricao;

    @NotNull(message = "O preço não pode ser nulo.")
    @PositiveOrZero(message = "O preço deve ser um valor positivo ou zero.")
    @Column(nullable = false)
    private Double preco;

    @NotNull(message = "A quantidade em estoque não pode ser nula.")
    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa.")
    @Column(nullable = false)
    private Integer quantidadeEstoque;

    // Construtores, Getters e Setters
    public Produto() {
    }

    public Produto(String nome, String descricao, Double preco, Integer quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
}