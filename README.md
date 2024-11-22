# Global-Solution-Segundo-Semestre-2024

## Membros do Projeto
- Matheus Gusmão - 550826
- Matheus Motta - 550352 
- Guilherme Morais - 551981

## Descrição do Projeto
O Global Solution - Gerenciamento de Infraestrutura é uma aplicação Spring Boot desenvolvida como parte do projeto acadêmico para o segundo semestre de 2024. O objetivo é fornecer uma solução para gerenciamento eficiente de infraestrutura elétrica, permitindo o controle de clientes, contratos, instalações, registros de consumo e produção.

## Estrutura do Projeto
A estrutura do projeto segue o padrão recomendado pelo Spring Boot:

```plain
GLOBAL-SOLUTION-SEGUNDO-SEMESTRE-2024/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.fiap.globalsolution.GerenciamentoDeInfraestrutura/
│   │   │       ├── controller/             # Controladores REST
│   │   │       ├── dto/                   # Classes para transferência de dados
│   │   │       ├── entity/                # Entidades JPA
│   │   │       ├── exception/             # Tratamento de exceções
│   │   │       ├── repository/            # Repositórios JPA
│   │   │       ├── service/               # Serviços de lógica de negócio
│   │   │       └── GerenciamentoDeInfraestruturaApplication.java # Classe principal
│   │   └── resources/
│   │       ├── static/               # Arquivos estáticos (CSS, JS, imagens)
│   │       ├── templates/            # Templates HTML (se aplicável)
│   │       └── application.properties # Configurações do aplicativo
│   ├── test/                         # Testes unitários e de integração
├── pom.xml                           # Arquivo Maven para dependências
└── README.md                         # Documentação do projeto
```

## Configuração do Ambiente
### Pré-requisitos
- Java 21
- Maven 3.8+
- Oracle SQL Developer
### Configurações de Banco de Dados
Edite o arquivo application.properties com suas credenciais de banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/infra_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Como Rodar o Projeto
Clone o repositório:

```bash
git clone https://github.com/MathASMotta/Global-Solution-Segundo-Semestre-2024.git
cd Global-Solution-Segundo-Semestre-2024
```
Compile o projeto:

```bash
mvn clean install
```
Inicie a aplicação:

```bash
mvn spring-boot:run
```
Acesse a API:
Base URL: http://localhost:8080

## Endpoints Disponíveis

### Clientes
- POST /api/clientes: Cria um novo cliente.
```plain
EXEMPLO: INPUT

{
    "nome": "joão da silva",
    "endereco": "Rua das Flores, 41",
    "documento": "966.351.800-60",
    "tipo": "PF",
    "cep": "055345-120"
}
```

- GET /api/clientes/lista: Retorna uma lista com todos os clientes.

- GET /api/clientes/{uuid}: Retorna os detalhes de um cliente.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/clientes/{uuid}
```

- DELETE /api/clientes/{uuid}: Deleta um cliente.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/clientes/{uuid}
```

### Contratos
- POST /api/contratos: Cria um novo contrato.
```plain
EXEMPLO: INPUT

{
    "clienteUuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
    "instalacaoUuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
    "timeframe": 180
}
```

- GET /api/contratos/{uuid}: Retorna os detalhes de um contrato.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/contratos/{uuid}
```

- DELETE /api/contratos/{uuid}: Deleta um contrato.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/contratos/{uuid}
```

### Instalações
- POST /api/instalacoes/: Cria uma nova instalação.
```plain
EXEMPLO: INPUT

{
    "endereco": "Rua das Flores, 41",
    "cep": "055345-120"
}
```

- GET /api/instalacoes/lista: Retorna uma lista com todas as instalações.

- GET /api/instalacoes/{uuid}: Retorna os detalhes de uma instalação.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/instalacoes/{uuid}
```

- DELETE /api/instalacoes/{uuid}: Deleta uma instalação.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/instalacoes/{uuid}
```

### Registros de Consumo
- POST /api/consumo: Cria um novo registro de consumo.
```plain
EXEMPLO: INPUT

{
    "instalacaoUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
    "consumoKWH": 410.90,
    "medicaoTimestamp": "2024-09-04T15:30:00"
}
```

- GET /api/consumo/{uuid}: Retorna os detalhes de um registro de consumo.
```plain
EXEMPLO: INPUT

http://localhost:8080/api/consumo/{uuid}
```

### Registros de Produção
- POST /api/producao: Cria um novo registro de produção.
```plain
EXEMPLO: INPUT

{
    "instalacaoUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
    "producaoKWH": 10.47,
    "medicaoTimestamp": "2024-09-04T15:30:00" 
}
```

## Testes
### Executando Testes
Para rodar os testes unitários e de integração, use o comando:

```bash
mvn test
```

### Cobertura de Testes
Os testes cobrem:

- Controladores REST
- Lógica de negócios nos serviços
- Interações com repositórios JPA

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Oracle SQL Developer
- Maven
- Hibernate
- Postman
