Este sistema é um fork neste projeto firewave.

Front end
Frameowek js - Angular JS 1.5 + Google's Material Design 

Back end
Spring MVC 4 + Hibernate 

Recomendações:

-Para subir a aplicação é recomendado executar os seguintes passos :
	botão direito no projeto pai: firewave-test > Run as > Maven Build... > digitar comando clean install
	
	botão direito no projeto  firewave-test-web > Run as > Maven Build... > digitar comando clean install jetty:run	

	Obs: O jetty subirá a aplicação utilizando o contexto "/" (ROOT)

-O angular está requisitando o serviço com a seguinte url: http://localhost:8080, caso seja necessário configurar a url do serviço ajustar no arquivo:

	/fiveware-test-web/src/main/webapp/WEB-INF/static/app/core/constants.js

-É recomendado utilizar o navegador Chrome/Firefox ou IE + 10

Informações:

	O sistema possui duas telas: Cadastro de usuário e listagem dos usuários cadastrados.
	Ao cadastrar um usuário, o sistema redirecionará para a listagem de usuários.

	O formulário de cadastro possui todos os campos solicitados (text, checkbox, radio, combobox).
	Os campos checkbox são exibidos ao selecionar um item do campo "Área de atuação".

Autor:
Felipe Cavalcante Miranda
felip.3@hotmail.com