---
layout: post-alpha
title: "maven :: Importando projetos"
author: "Marcos Piazzolla"
published: true
tags:
- alpha
- maven
- mvn
- aprendizes
---

# Compilando projeto maven pela linha de comando

Passos:

1. Primeiramente devemos criar um fork do projeto pelo github;
1. Em seguida criamos uma cópia do mesmo em nosso repositório local;
1. Acessamos o diretório via linha de comando e compilamos o projeto com: mvn clean install;
1. Se tudo der certo o projeto será compilado sem nenhum problema;
1. Caso contrário será exibido na tela uma mensagem de erro junto de todas as 
dependências que faltaram para a conclusão do processo de compilação, 
ler com atenção as dependências que faltam;
1. Verificar se as dependências realmente existem no repositório, 
especificado no arquivo de configurações (settings.xml) do maven, 
caso sim basta utilizar o comando: mvn –U clean install para compilar e forçar a atualização das dependências do projeto no maven;
1. Caso contrário verificar a disponibilidade das novas versões das dependências;
1. Uma boa sugestão para saber se o seu projeto irá compilar com sucesso 
seria olhar em qual commit o seu projeto esta, para isso basta digitar: 
git log -5 que vai nos indicar os cinco últimos commits efetuados, com isso é só procurar no jenkins uma build estável do projeto e comparar em qual commit ocorreu esta build onde a compilação foi bem sucedida, após encontrar este commit e o mesmo pertencer a uma build mais atual no jenkins, quer dizer que devemos atualizar nosso projeto pelo repositório original, no caso “objectos/nomeProjeto”, isso claro, deve ser feito através de um: git pull origin nomeDaBranch, assim nosso projeto será atualizado para um commit onde a compilação é estável e logo poderemos  realizar a compilação utilizando o maven;
1. Estando em uma versão mais atual e em um commit estável de acordo com 
o jenkins, basta compilar o projeto pela linha de comando com: 
mvn -U clean install, devemos utilizar o parâmetro –U para forçar 
a atualização das dependências do projeto, caso o projeto seja compilado 
sem esta opção uma mensagem de erro será lançada dizendo que não foi possível 
encontrar as dependências do projeto, é por isso que é necessário utilizar 
a opção mvn -U clean install.