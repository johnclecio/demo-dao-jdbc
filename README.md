📘 JDBC DAO Project – Department & Seller Management

Este projeto implementa um sistema simples de acesso a dados (DAO) utilizando JDBC puro em Java para manipular duas entidades principais: Department e Seller.
O objetivo é demonstrar a arquitetura DAO, uso de conexões JDBC, tratamento de exceções e boas práticas de separação entre camada de acesso a dados e lógica de negócio.

🚀 Tecnologias Utilizadas

Java 17+ (ou sua versão instalada)

JDBC

MySQL (banco usado no curso do Nelio Alves)

MySQL Connector/J

Padrão DAO (Data Access Object)

📂 Estrutura do Projeto

      src/
       ├── application/
       │     └── Program.java        # Classe principal para testes
       │
       ├── db/
       │     ├── DB.java             # Gerencia conexão com o banco
       │     ├── DbException.java    # Exceção personalizada
       │     └── DbIntegrityException.java
       │
       ├── model/
       │     ├── dao/
       │     │     ├── DepartmentDao.java
       │     │     ├── SellerDao.java
       │     │     └── DaoFactory.java
       │     │
       │     ├── dao/impl/
       │     │     ├── DepartmentDaoJDBC.java
       │     │     └── SellerDaoJDBC.java
       │     │
       │     └── entities/
       │           ├── Department.java
       │           └── Seller.java
       │
       └── resources/
       └── db.properties       # Configurações da conexão JDBC

🗄️ Configuração do Banco de Dados

Crie a base conforme o modelo abaixo:

    CREATE TABLE department (
        Id INT NOT NULL AUTO_INCREMENT,
        Name VARCHAR(60) NOT NULL,
        PRIMARY KEY (Id)
    );
    
    CREATE TABLE seller (
        Id INT NOT NULL AUTO_INCREMENT,
        Name VARCHAR(60) NOT NULL,
        Email VARCHAR(100) NOT NULL,
        BirthDate DATE NOT NULL,
        BaseSalary DOUBLE NOT NULL,
        DepartmentId INT NOT NULL,
        PRIMARY KEY (Id),
        FOREIGN KEY (DepartmentId) REFERENCES department(Id)
    );

⚙️ Arquivo db.properties

Exemplo:

    user=root
    password=admin123
    dburl=jdbc:mysql://localhost:3306/coursejdbc
    useSSL=false

🔧 Funcionalidades Implementadas
✔ Department (DAO)

Inserir departamento

Atualizar departamento

Deletar por ID

Buscar por ID

Buscar todos (ordem alfabética)

✔ Seller (DAO)

Inserir vendedor

Atualizar vendedor

Deletar por ID

Buscar por ID

Buscar por Department

Buscar todos

▶️ Como executar

Configure o MySQL e o arquivo db.properties

Certifique-se de que o mysql-connector-j.jar está no classpath

Execute o Program.java

Exemplo de teste:

    SellerDao sellerDao = DaoFactory.createSellerDao();
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);

🧱 Padrão DAO

O projeto utiliza o padrão DAO para:

Isolar lógica de persistência

Facilitar testes

Permitir troca de tecnologia sem afetar o restante do sistema

Deixar o código mais limpo e organizado

🛠 Exceções Personalizadas

DbException – problemas gerais de JDBC

DbIntegrityException – erro ao deletar registros relacionados

🤝 Contribuição

Sinta-se à vontade para abrir issues e pull requests com melhorias, correções ou sugestões.

📜 Licença

Este projeto é de uso livre para fins educacionais.
