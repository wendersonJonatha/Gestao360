# 🚀 Gestão360

O **Gestor360** é um sistema de gestão interna voltado para empresas e organizações que precisam acompanhar metas, unidades e equipes de forma integrada. Com ele, é possível cadastrar usuários com diferentes cargos, distribuir metas por unidade e monitorar o desempenho de forma clara e eficiente.

---

## 🧩 Funcionalidades

- ✅ Cadastro e autenticação de usuários
- 🏢 Cadastro de unidades (filiais ou setores)
- 🎯 Registro e acompanhamento de metas por unidade
- 👥 Vinculação de usuários a unidades
- 📊 Dashboard com visualização de desempenho (em desenvolvimento)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Swagger (OpenAPI)**
- **Lombok**
- **Docker** (opcional)
- **Maven**

---

## 📁 Estrutura do Projeto

```bash
src/
 └── main/
     ├── java/
     │    └── com.gestor360
     │         ├── controller/
     │         ├── service/
     │         ├── repository/
     │         ├── model/
     │         └── dto/
     └── resources/
          ├── application.properties
          └── static/
🚀 Como rodar o projeto localmente
Pré-requisitos
Java 17 instalado

PostgreSQL rodando

Maven instalado

# 1. Clone o repositório
git clone https://github.com/seu-usuario/gestor360.git
cd gestor360

# 2. Configure o banco de dados no arquivo application.properties

# 3. Rode o projeto com Maven
./mvnw spring-boot:run

🔐 Acesso à API
Após iniciar o projeto, acesse a documentação interativa no Swagger:
http://localhost:8080/swagger-ui.html

📌 Status do Projeto
✔️ Em desenvolvimento ativo
🔒 Autenticação funcionando com Spring Security
📊 Dashboard e relatórios ainda em construção

👤 Autor
Desenvolvido por Wenderson Jonatha
📫 wendersonjonathadev@gmail.com

📝 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

Se quiser, posso adaptar esse README para incluir instruções com Docker, exemplos de endpoints, ou até um passo a passo de uso. Quer incluir mais alguma coisa específica?
