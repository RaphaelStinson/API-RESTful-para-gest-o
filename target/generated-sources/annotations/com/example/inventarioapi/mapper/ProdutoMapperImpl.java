package com.example.inventarioapi.mapper;

import com.example.inventarioapi.dto.ProdutoRequestDTO;
import com.example.inventarioapi.dto.ProdutoResponseDTO;
import com.example.inventarioapi.model.Produto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T12:13:41-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toEntity(ProdutoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setNome( dto.nome() );
        produto.setDescricao( dto.descricao() );
        produto.setPreco( dto.preco() );
        produto.setQuantidadeEstoque( dto.quantidadeEstoque() );

        return produto;
    }

    @Override
    public ProdutoResponseDTO toResponseDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String descricao = null;
        Double preco = null;
        Integer quantidadeEstoque = null;

        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
        quantidadeEstoque = produto.getQuantidadeEstoque();

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO( id, nome, descricao, preco, quantidadeEstoque );

        return produtoResponseDTO;
    }

    @Override
    public void updateProdutoFromDto(ProdutoRequestDTO dto, Produto produto) {
        if ( dto == null ) {
            return;
        }

        produto.setNome( dto.nome() );
        produto.setDescricao( dto.descricao() );
        produto.setPreco( dto.preco() );
        produto.setQuantidadeEstoque( dto.quantidadeEstoque() );
    }
}
