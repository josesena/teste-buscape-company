# Teste Buscape-Comapany - Viagem ao fundo do mar - José Renato


## Como configurar

1. Baixe o projeto fazendo download do ZIP ou utilizando git clone:

        $ git clone https://github.com/josesena/teste-buscape-company.git
        
2. Na pasta do projeto execute:
		 
		$ mvn clean install
		
3. Em seguida: 

		java -jar target/viagemfundomar-0.0.1-SNAPSHOT.jar


## Como utilizar
	Utilizando um aplicativo cliente com chamada Rest do navegador, entrar com os paths disponíveis.
	
	Método: 		POST
	Path: 			http://localhost:8080/avaliacaoTeste/LMRDDMMUU
	Content-Type: application/json
	Body:
			{
				"direcao": "NORTE",
				"ponto": {
					"eixoX": -1,
					"eixoY": 2,
					"eixoZ": 0
				},
				"mensagem": "Superfície do oceano"
			}
	
	Método: 		POST
	Path: 			http://localhost:8080/avaliacaoTeste/RMMLMMMDDLL
	Content-Type: application/json
	Body:
			{
				"direcao": "SUL",
				"ponto": {
					"eixoX": 2,
					"eixoY": 3,
					"eixoZ": -2
				}
			}
	
Considerações: 
Escolhi utilizar o Spring boot pela facilidade na configuração inicial do projeto com o http://start.spring.io.
Resolvi implementar o teste utilizando Web Service Rest que utiliza muito o protocolo HTTP para realizar 
integração entre aplicações, dessa forma eu apresento a saida no formato Json além de ser um formato mais leve para 
troca de dados é também muito simples de ler. Apliquei no desenvolvimento o Pattern Strategy que permite trocar 
dinamicamente a logica da aplicação no tempo de execução e também o Pattern Factory que permite criar objetos 
sem necessariamente conhecer ou cuidar do tipo de objetos que estamos criando.
