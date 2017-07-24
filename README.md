# desafio-api

Esse projeto foi desenvolvido exclusivamente para atender aos requisitos do desafio.

Consiste em uma api rest desenvolvida e testada usando a linguagem **Java**.

A api foi publicada no Heroku e disponível através da URL: **https://desafio-muxi-api.herokuapp.com/**

### Forma de uso

#### 1 - Salvando um Titulo:

  + Realizar um requisição post para seguinte URL: **https://desafio-muxi-api.herokuapp.com/titulo/[stringTitulo]**.
  
  + Ex.: https://desafio-muxi-api.herokuapp.com/titulo/11132211;258;PWWIN;1;F04A2E4088B;4;8.00b3;0;16777336;PWWIN
  
  + A única **MediaType** aceita na requisição POST é **text/plain**.
  
  + Deve retornar o status 200 - OK e o Titulo no formato Json.
  
  
  #### 2 - Editando um Titulo:

  + Realizar um requisição put para seguinte URL: **https://desafio-muxi-api.herokuapp.com/titulo/[logic]**.
  
  + Ex.: https://desafio-muxi-api.herokuapp.com/titulo/11132211
  
  + O Titulo a ser editado deve ser enviado no formato Json no corpo da rquisição. A única **MediaType** aceita na requisição PUT é **application/json**.
  
  + Deve retornar o status 200 - OK e o Titulo no formato Json.
  
   
  #### 3 - Listando todos os Titulos:

  + Realizar um requisição get para seguinte URL: **https://desafio-muxi-api.herokuapp.com/titulo**.
  
  + Ex.: https://desafio-muxi-api.herokuapp.com/titulo
  
  + Deve retornar o status 200 - OK e o um array com todos os Titulos cadastrados, no formato Json.
  
  
    #### 4 - Buscando um Titulo:

  + Realizar um requisição get para seguinte URL: **https://desafio-muxi-api.herokuapp.com/titulo/[logic]**.
  
  + Ex.: https://desafio-muxi-api.herokuapp.com/titulo/11132211
  
  + Deve retornar o status 200 - OK e o Titulo consultado no formato Json, caso o Titulo não seja localizado, retorna um objeto json vazio.

   
