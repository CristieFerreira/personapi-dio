# Digital Innovation: Expert class - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot

Foi desenvolvido um pequeno sistema para o gerenciamento de pessoas de uma empresa através de uma API REST, criada com o Spring Boot.


Foram desenvolvidos os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema)
* Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto
* Desenvolvimento de testes unitários para validação das funcionalidades
* Implantação do sistema na nuvem através do Heroku


Para executar o projeto no terminal, digite o seguinte comando: 

```
mvn spring-boot:run
```


Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto: 

```
http://localhost:8080/api/v1/people
```



O código foi baseado nesta aplicação: https://github.com/rpeleias-v1/personapi_digital_innovation_one
