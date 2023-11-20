# Documentarr Api
Projeto simples para estudo de spring boot e jpa.

### Rodando o projeto
* Crie um arquivo `application.properties` ou `application.yml` em `src/main/resources`;
* Adicione suas configurações de datasource. Ex.:
    * `spring.datasource.url=jdbc:postgresql://localhost:5432/seu-banco`
    * `spring.datasource.username=usuario-do-banco`
    * `spring.datasource.password=senha-do-banco`
    * `spring.datasource.driver-class-name=org.postgresql.Driver`

No exemplo acima estamos configurando um banco de dados _postgres_ e como as entidades desse projeto não estão com schema
mapeado, por padrão o projeto irá vinculá-las ao schema public. Você pode mapear um schema específico usando a propriedade
`spring.datasource.hikari.schema=nome-do-schema`.

Caso deseja que o JPA cire as tabelas, utilize a propriedade `spring.jpa.hibernate.ddl-auto` com valor `create-drop` ou
`update`. Lembre-se que `create-drop` significa que toda vez que a aplicação for encerrada, as tabelas serão dropadas e,
consequentemente, seus dados removidos.