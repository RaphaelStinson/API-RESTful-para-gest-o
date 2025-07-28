# API RESTful de Gestão de Inventário

Esta é uma API RESTful desenvolvida com o ecossistema Spring Boot para a gestão de um inventário de produtos. A aplicação permite realizar operações CRUD (Criar, Ler, Atualizar, Apagar) de forma completa, seguindo as melhores práticas de desenvolvimento de microsserviços, como o uso de DTOs (Data Transfer Objects) para desacoplar a API da camada de persistência.

---

## 🚀 Funcionalidades

- **Criar Produtos:** Adicionar novos produtos ao inventário.
- **Listar Produtos:** Obter uma lista de todos os produtos cadastrados.
- **Buscar Produto por ID:** Obter os detalhes de um produto específico.
- **Atualizar Produtos:** Modificar as informações de um produto existente.
- **Apagar Produtos:** Remover um produto do inventário.
- **Validação de Dados:** Garante que os dados enviados para a API sejam válidos.
- **Tratamento de Erros:** Respostas de erro padronizadas para uma melhor experiência do cliente.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17:** Versão da linguagem de programação.
- **Spring Boot 3:** Framework principal para a criação da aplicação.
- **Spring Web:** Para a criação de endpoints RESTful.
- **Spring Data JPA:** Para a persistência de dados e comunicação com o banco.
- **Maven:** Gestor de dependências e build do projeto.
- **H2 Database:** Banco de dados em memória para ambiente de desenvolvimento e testes.
- **MapStruct:** Para o mapeamento automático entre Entidades e DTOs.
- **Hibernate Validator:** Para a validação dos dados de entrada.

---

## 📋 Pré-requisitos

Antes de começar, certifique-se de que tem os seguintes softwares instalados na sua máquina:

- **JDK (Java Development Kit)**: Versão 17 ou superior.
- **Apache Maven**: Versão 3.8 ou superior.

---

## ▶️ Como Executar a Aplicação

1.  **Clone o repositório** (ou certifique-se de que tem todos os arquivos no seu computador).

2.  **Abra um terminal** na pasta raiz do projeto (onde o arquivo `pom.xml` está localizado).

3.  **Execute o seguinte comando Maven** para compilar e iniciar a aplicação:

    ```bash
    mvn spring-boot:run
    ```

4.  A API estará em execução e pronta para receber pedidos na porta `8080`.

---

## 📖 Endpoints da API

A URL base para todos os endpoints é: `http://localhost:8080/api/v1/produtos`

### 1. Listar Todos os Produtos

- **Método:** `GET`
- **URL:** `/`
- **Descrição:** Retorna uma lista com todos os produtos cadastrados no inventário.
- **Resposta de Sucesso (200 OK):**
  ```json
  [
      {
          "id": 1,
          "nome": "Notebook Gamer Pro",
          "descricao": "Notebook com placa de vídeo dedicada e 32GB RAM",
          "preco": 8500.50,
          "quantidadeEstoque": 15
      },
      {
          "id": 2,
          "nome": "Monitor 4K",
          "descricao": "Monitor de 27 polegadas com resolução Ultra HD",
          "preco": 1800.00,
          "quantidadeEstoque": 25
      }
  ]
  ```

### 2. Buscar Produto por ID

- **Método:** `GET`
- **URL:** `/{id}`
- **Descrição:** Retorna os detalhes de um produto específico.
- **Resposta de Sucesso (200 OK):**
  ```json
  {
      "id": 1,
      "nome": "Notebook Gamer Pro",
      "descricao": "Notebook com placa de vídeo dedicada e 32GB RAM",
      "preco": 8500.50,
      "quantidadeEstoque": 15
  }
  ```

### 3. Criar um Novo Produto

- **Método:** `POST`
- **URL:** `/`
- **Descrição:** Adiciona um novo produto ao inventário.
- **Corpo da Requisição (Request Body):**
  ```json
  {
      "nome": "Teclado Mecânico RGB",
      "descricao": "Teclado com switches blue e iluminação RGB",
      "preco": 350.75,
      "quantidadeEstoque": 50
  }
  ```
- **Resposta de Sucesso (201 Created):**
  ```json
  {
      "id": 3,
      "nome": "Teclado Mecânico RGB",
      "descricao": "Teclado com switches blue e iluminação RGB",
      "preco": 350.75,
      "quantidadeEstoque": 50
  }
  ```

### 4. Atualizar um Produto

- **Método:** `PUT`
- **URL:** `/{id}`
- **Descrição:** Atualiza os dados de um produto existente.
- **Corpo da Requisição (Request Body):**
  ```json
  {
      "nome": "Teclado Mecânico RGB (Modelo Novo)",
      "descricao": "Teclado com switches blue, iluminação RGB e apoio de pulso",
      "preco": 399.90,
      "quantidadeEstoque": 45
  }
  ```
- **Resposta de Sucesso (200 OK):**
  ```json
  {
      "id": 3,
      "nome": "Teclado Mecânico RGB (Modelo Novo)",
      "descricao": "Teclado com switches blue, iluminação RGB e apoio de pulso",
      "preco": 399.90,
      "quantidadeEstoque": 45
  }
  ```

### 5. Apagar um Produto

- **Método:** `DELETE`
- **URL:** `/{id}`
- **Descrição:** Remove um produto do inventário.
- **Resposta de Sucesso:** `204 No Content` (sem corpo na resposta).

---

## 🗄️ Acesso à Base de Dados (H2 Console)

Enquanto a aplicação estiver em execução, você pode aceder a uma interface web para visualizar o banco de dados em memória.

1.  Abra o seu navegador e aceda a: `http://localhost:8080/h2-console`
2.  Use as seguintes credenciais para fazer login:
    - **JDBC URL:** `jdbc:h2:mem:inventariodb`
    - **User Name:** `sa`
    - **Password:** `password`
3.  Clique em **Connect**.