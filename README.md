# Cloud Bank API

Bem-vindo à **Cloud Bank API**, um projeto desenvolvido para iniciar rapidamente uma API robusta e escalável, voltada para o gerenciamento de contas bancárias, usuários, cartões e outras funcionalidades financeiras. Este repositório fornece uma base sólida para a criação de APIs RESTful, incluindo configuração inicial, autenticação, endpoints básicos e tratamento global de exceções.

---

## 🚀 **Descrição do Projeto**
A **Cloud Bank API** serve como um ponto de partida para criar APIs financeiras robustas e escaláveis. Ela inclui configurações padrão para segurança, banco de dados, organização do código e gerenciamento de erros, facilitando o desenvolvimento de novos projetos.

A API atualmente implementa:
- Gerenciamento de **Usuários**, com suporte para criação, busca por ID e associações a outros recursos.
- Gerenciamento de **Contas Bancárias**, com armazenamento de saldo, limite e informações bancárias.
- Gerenciamento de **Cartões**, incluindo número único e limite disponível.
- Gerenciamento de **Funcionalidades** (Features), reutilizando a estrutura da classe base.
- Gerenciamento de **Notícias** (News), reutilizando a estrutura da classe base.
- **Repositório de Usuários** para operações com dados persistentes.
- **Serviço de Usuários** para encapsular regras de negócio.
- Implementação do **Serviço de Usuários** para validações e operações lógicas.
- **Swagger OpenAPI** para documentação interativa da API.
- Configuração para **PostgreSQL na nuvem** como banco de dados padrão para produção.
- Implantação em nuvem utilizando **Railway**.
- Uma classe base abstrata (`BaseItem`) para reutilização de atributos comuns entre entidades.
- Tratamento global de exceções para respostas consistentes.

---

## 📦 **Tecnologias Utilizadas**
- **Linguagem:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** PostgreSQL (hospedado na nuvem)
- **Documentação:** Swagger OpenAPI (configurado com `@OpenAPIDefinition`)
- **Implantação:** Railway
- **Ferramentas adicionais:** Maven, SLF4J (para logs), Jakarta Persistence API (JPA)

---

## 🛠️ **Como Configurar e Rodar o Projeto**

### **1. Clone o Repositório**
```bash
git clone git@github.com:rodrigobarr0s/cloud-bank-api.git
cd cloud-bank-api
```

### **2. Configuração do Banco de Dados**
O projeto utiliza PostgreSQL como banco de dados padrão, configurado na nuvem via Railway. Os detalhes de conexão são gerenciados por variáveis de ambiente.

**Configuração Padrão no `application.yml`:**
```yaml
spring:
  datasource:
    url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
    username: ${PGUSER}
    password: ${PGPASSWORD}
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: validate
```

**Variáveis de Ambiente Necessárias:**
- `PGHOST`: Endereço do servidor PostgreSQL (fornecido pelo Railway).
- `PGPORT`: Porta do servidor PostgreSQL (geralmente `5432`).
- `PGDATABASE`: Nome do banco de dados.
- `PGUSER`: Nome do usuário do banco de dados.
- `PGPASSWORD`: Senha do usuário do banco de dados.

### **3. Instale as Dependências**
```bash
./mvnw install
```

### **4. Rode a Aplicação**
```bash
java -jar build/libs/cloud-bank-api-0.0.1-SNAPSHOT.jar
```

---

## 🌐 **Implantação em Produção**
A aplicação está implantada em produção utilizando o Railway. Você pode acessar a API e sua documentação interativa no Swagger a partir do seguinte link:

- **Documentação Swagger:** [https://cloud-bank-api-production.up.railway.app/swagger-ui/index.html](https://cloud-bank-api-production.up.railway.app/swagger-ui/index.html)

---

## 📖 **Banco de Dados PostgreSQL**
O PostgreSQL é configurado como o banco de dados padrão para produção, hospedado na nuvem pelo Railway. A configuração utiliza variáveis de ambiente para garantir a segurança das credenciais.

### **Características Principais:**
- **Hospedado na Nuvem:** Banco de dados gerenciado pelo Railway.
- **Variáveis de Ambiente:** Permitem configurar o banco de dados de forma segura e flexível.
- **Hibernate DDL Auto - Validate:** Garante que o esquema do banco de dados é validado contra as entidades JPA sem realizar alterações automáticas.

---

## 📖 **Estrutura do Projeto**

O projeto segue uma estrutura organizada e modularizada para facilitar a manutenção e o desenvolvimento. Abaixo está uma visão geral da estrutura dos diretórios e pacotes:

```plaintext
cloud-bank-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cloud_bank_api/
│   │   │           ├── Application.java          # Classe principal para iniciar o Spring Boot
│   │   │           ├── domain/
│   │   │           │   ├── model/
│   │   │           │   │   ├── BaseItem.java      # Classe abstrata base para entidades
│   │   │           │   │   ├── User.java          # Modelo de usuário
│   │   │           │   │   └── (outros modelos)   # Outros modelos do domínio
│   │   │           │   └── repository/
│   │   │           │       ├── UserRepository.java # Interface para operações de persistência de usuários
│   │   │           │       └── (outros repositórios)
│   │   │           ├── service/
│   │   │           │   ├── UserService.java        # Interface para serviços relacionados a usuários
│   │   │           │   └── impl/
│   │   │           │       └── UserServiceImpl.java # Implementação de UserService
│   │   │           └── (outros pacotes e classes)
│   │   └── resources/
│   │       ├── application.yml                   # Configurações da aplicação (Banco de Dados, etc.)
│   │       └── (outros arquivos de configuração)
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── cloud_bank_api/
│       │           └── (testes unitários e de integração)
│       └── (outros diretórios de teste)
├── build/                                       # Diretório de build gerado pelo Gradle/Maven
├── build.gradle / pom.xml                      # Gerenciador de dependências e build (Gradle/Maven)
└── README.md                                   # Documentação do projeto
```

---

## 📖 **Documentação dos Endpoints**

### **Gerenciamento de Usuários**
#### **1. Buscar Usuário por ID**
- **GET** `/users/{id}`: Retorna os detalhes de um usuário pelo ID.
  - **Resposta de Exemplo:**
    ```json
    {
      "id": 1,
      "name": "João Silva",
      "account": {
        "id": 101,
        "number": "123456",
        "agency": "001",
        "balance": 1000.50,
        "limit": 500.00
      }
    }
    ```

---

## ⚠️ **Tratamento de Erros**

A API utiliza um manipulador global de exceções para lidar com erros de maneira padronizada.

---

## ✅ **Testes**
Execute os testes utilizando:
```bash
./mvnw test
```

---

## 🧐 **Contribuindo**
Contribuições são bem-vindas! Para contribuir:
1. Faça um fork do projeto.
2. Crie uma nova branch: `git checkout -b feature/sua-feature`.
3. Envie suas alterações: `git push origin feature/sua-feature`.
4. Abra um Pull Request.

---

## 📝 **Licença**
Este projeto está licenciado sob a [MIT License](https://github.com/rodrigobarr0s/cloud-api-starter?tab=MIT-1-ov-file).

---

## 📬 **Contato**
- **Autor:** Rodrigo Barros
- **GitHub:** [rodrigobarr0s](https://github.com/rodrigobarr0s)
- **API em Produção:** [https://cloud-bank-api-production.up.railway.app](https://cloud-bank-api-production.up.railway.app)
