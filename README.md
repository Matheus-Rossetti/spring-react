Auth Service

Microsserviço de autenticação desenvolvido com Spring Boot, Spring Security, JWT e PostgreSQL.


Endpoints Principais

1. Registrar Técnico

Método: POST

Rota: /register

Payload:

{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "senha123"
}


Resposta (200 OK):

{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "id": 1,
  "name": "João Silva"
}


2. Autenticação (Login)

Método: POST

Rota: /login

Payload:

{
  "email": "joao@email.com",
  "password": "senha123"
}


Resposta (200 OK):

{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "id": 1,
  "name": "João Silva"
}




Pode subir a aplicação com 'docker compose up -d' no root dir.
