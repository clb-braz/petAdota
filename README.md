# PetAdota

Sistema web completo para adoção de animais, desenvolvido com Spring Boot, H2 e Thymeleaf.

## Funcionalidades
- Cadastro, listagem, edição, exclusão e visualização detalhada de pets
- Validação de dados e mensagens de erro amigáveis
- Layout responsivo com Thymeleaf e fragments
- Banco de dados H2 em memória
- Console H2 disponível em `/h2-console`

## Como rodar

1. **Pré-requisitos:**
   - Java 17+
   - Maven 3.8+

2. **Build e execução:**
   ```bash
   mvn spring-boot:run
   ```
   ou
   ```bash
   mvn clean package
   java -jar target/PetAdota-0.0.1-SNAPSHOT.jar
   ```

3. **Acesse no navegador:**
   - [http://localhost:8080/pets](http://localhost:8080/pets)
   - Console H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Estrutura do projeto
- `src/main/java/com/petadota/model` — Entidade Pet
- `src/main/java/com/petadota/repository` — Repositório JPA
- `src/main/java/com/petadota/service` — Lógica de negócio
- `src/main/java/com/petadota/controller` — Controllers MVC
- `src/main/java/com/petadota/exception` — Tratamento de exceções
- `src/main/resources/templates` — Templates Thymeleaf
- `src/main/resources/static` — CSS, imagens, favicon, logo

## Observações
- O sistema já está pronto para uso e pode ser customizado conforme sua necessidade.
- Para adicionar imagens, coloque URLs válidas ou adicione arquivos em `static/img/pets` e use `/img/pets/nome-da-imagem.jpg` como URL.

---
Desenvolvido para demonstração de arquitetura Spring Boot MVC.
