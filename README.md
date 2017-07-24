# desafio-api

Esse projeto foi desenvolvido exclusivamente para atender aos requisitos do desafio.

Consiste em uma api rest desenvolvida e testada usando a linguagem **Java**.

### Forma de uso

#### 1 - Salvando um Titulo:

  + Realizar um requisição post para seguinte URL: **[servidor]/titulo/[stringTitulo]**.
  
  + Ex.: localhost:8080/titulo/11132211;258;PWWIN;1;F04A2E4088B;4;8.00b3;0;16777336;PWWIN
  
  + A única **MediaType** aceita na requisição POST é **text/plain**.
  
  + Deve retornar o status 200 - OK e o Titulo no formato Json.
  
  
  #### 2 - Editando um Titulo:

  + Realizar um requisição put para seguinte URL: **[servidor]/titulo/[logic]**.
  
  + Ex.: localhost:8080/titulo/11132211
  
  + O Titulo a ser editado deve ser enviado no formato Json no corpo da rquisição. A única **MediaType** aceita na requisição PUT é **application/json**.
  
  + Deve retornar o status 200 - OK e o Titulo no formato Json.
  
   
  #### 3 - Listando todos os Titulos:

  + Realizar um requisição get para seguinte URL: **[servidor]/titulo**.
  
  + Ex.: localhost:8080/titulo
  
  + Deve retornar o status 200 - OK e o um array com todos os Titulos cadastrados, no formato Json.
  
  
    #### 4 - Buscando um Titulo:

  + Realizar um requisição get para seguinte URL: **[servidor]/titulo/[logic]**.
  
  + Ex.: localhost:8080/titulo/11132211
  
  + Deve retornar o status 200 - OK e o Titulo consultado no formato Json, caso o Titulo não seja localizado, retorna um objeto json vazio.
  
  
  ### Armazenamento
  
  Foi utilizado o banco de dados em memória H2.
  
  Para acessar o banco, entrar no endereço: **[servidor]/h2-console**
  
  + URL do banco: jdbc:h2:mem:muxi
  
  + username: sa
  
  + password: 
  
   
