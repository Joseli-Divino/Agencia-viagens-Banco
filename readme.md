
# Travel Agency API

API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar destinos de viagem, reservas e usuários.

## 1. Configurações do Projeto e Requisitos Necessários

### Requisitos
- Java 17 ou superior
- Maven 3.6 ou superior
- IDE (como IntelliJ IDEA ou VSCode) ou terminal com suporte a Maven
- Conexão com a internet para baixar as dependências do Maven

### Tecnologias Utilizadas
- Java 17
- Spring Boot 3.1.2
- Spring Data JPA
- PostgreSQL (banco de dados principal)
- H2 Database (em memória para testes)
- Spring Security com autenticação via JWT
- BCrypt para encriptação de senhas

## 2. Instalação

1. Clone este repositório:
   ```bash
   git clone git@github.com:Joseli-Divino/Agencia-viagens-Banco.git
   cd travel-agency-api
   ```

2. Certifique-se de que o Maven está instalado:
   ```bash
   mvn -v
   ```

3. Configure as credenciais do banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/travel_agency_db
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   ```

4. Compile e instale as dependências:
   ```bash
   mvn clean install
   ```

5. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

6. A aplicação estará disponível em `http://localhost:8080`.

## 3. Lista de Endpoints

### **Autenticação**
- **Registrar Usuário**
  - Método: `POST`
  - URL: `/api/auth/register`
- **Fazer Login**
  - Método: `POST`
  - URL: `/api/auth/login`

### **Destinos**
- **Cadastrar Destino**
  - Método: `POST`
  - URL: `/api/destinations`
- **Listar Destinos**
  - Método: `GET`
  - URL: `/api/destinations`
- **Pesquisar Destinos**
  - Método: `GET`
  - URL: `/api/destinations/search`
  - Parâmetro: `query`
- **Visualizar Destino Específico**
  - Método: `GET`
  - URL: `/api/destinations/{id}`
- **Avaliar Destino**
  - Método: `PATCH`
  - URL: `/api/destinations/{id}/rate`
  - Parâmetro: `rating`
- **Excluir Destino**
  - Método: `DELETE`
  - URL: `/api/destinations/{id}`

### **Reservas**
- **Reservar Pacote**
  - Método: `POST`
  - URL: `/api/destinations/{id}/reserve`

## 4. Exemplos de Utilização

### **Registrar Usuário**
```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{
  "username": "johndoe",
  "password": "securepassword"
}'
```

### **Fazer Login**
```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{
  "username": "johndoe",
  "password": "securepassword"
}'
```

### **Cadastrar Destino**
```bash
curl -X POST http://localhost:8080/api/destinations -H "Content-Type: application/json" -H "Authorization: Bearer SEU_TOKEN" -d '{
  "name": "Paris",
  "location": "France",
  "description": "City of Light"
}'
```

### **Listar Destinos**
```bash
curl -X GET http://localhost:8080/api/destinations -H "Authorization: Bearer SEU_TOKEN"
```

### **Pesquisar Destinos**
```bash
curl -X GET "http://localhost:8080/api/destinations/search?query=Paris" -H "Authorization: Bearer SEU_TOKEN"
```

### **Visualizar Destino Específico**
```bash
curl -X GET http://localhost:8080/api/destinations/1 -H "Authorization: Bearer SEU_TOKEN"
```

### **Avaliar Destino**
```bash
curl -X PATCH "http://localhost:8080/api/destinations/1/rate?rating=9" -H "Authorization: Bearer SEU_TOKEN"
```

### **Excluir Destino**
```bash
curl -X DELETE http://localhost:8080/api/destinations/1 -H "Authorization: Bearer SEU_TOKEN"
```

### **Reservar Pacote**
```bash
curl -X POST http://localhost:8080/api/destinations/1/reserve -H "Content-Type: application/json" -H "Authorization: Bearer SEU_TOKEN" -d '{
  "customerName": "John Doe",
  "numberOfPeople": 2
}'
```

---
## Autor
Este projeto foi desenvolvido como um exemplo de API RESTful em Spring Boot.

Para dúvidas ou melhorias, entre em contato! 😄
