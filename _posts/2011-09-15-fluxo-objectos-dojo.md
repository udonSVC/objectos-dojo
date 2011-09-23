---
layout: post-alpha
title: "Fluxo de trabalho Objectos-dojô"
author: "Hellen Carla Paixão Escarate"
published: false
tags:
- alpha
- wiki
- aprendizes
- fluxo de trabalho
---

# Fluxo de trabalho Objectos Dojô

## Introdução

Aqui será mostrado passo a passo como trabalhar com os artigos que ficarão neste dojô, e como deve ser o
padrão de cada um, com o propósito de manter a qualidade do que é produzido por nós da Objectos.

Passo 1)

O primeiro passo é certificar-se de que o endereço do origin está correto, ou seja, se realmente o endereço se refere 
ao fork do projeto, e não o projeto original. Para confirmar essa informação pode ser usado o comando abaixo:

    $ git remote -v

Então os remotos serão listados:

    objectos        git@github.com:objectos/objectos-dojo.git (fetch)
    objectos        git@github.com:objectos/objectos-dojo.git (push)
    origin  git@github.com:hescarate/objectos-dojo.git (fetch)
    origin  git@github.com:hescarate/objectos-dojo.git (push)

Se os endereços estiverem corretos (no lugar de `hescarate` deve ser o seu usuário) é só seguir para o passo 2, caso
contrário, remova o que estiver errado usando o comando que segue:

    $ git remote rm objectos

    $ git remote rm origin

Depois de removido os endereços errados, adicione agora os endereços corretamente (lembrando novamente que é necessário 
trocar no comando abaixo `hescarate` pelo seu usuário):

    $ git remote add origin git@github.com:hescarate/objectos-dojo.git

    $ git remote add objectos git@github.com:objectos/objectos-dojo.git

E então, depois de confirmado se o origin (apontando para o seu fork) e objectos (apontando para o projeto original)
estão corretos pode ser seguido para o segundo passo. 

Passo 2) 

Ainda na branch master, certifique-se de que não há nenhuma atualização pendente para mandar ao seu fork do projeto.

Em seguida, é necessário trazer o conteúdo da branch gh-pages que está no remoto objectos (projeto original) para o seu
fork do projeto. Para que isso aconteça é necessário executar o comando `fetch` :

    $ git fetch objectos
    remote: Counting objects: 48, done.
    remote: Compressing objects: 100% (25/25), done.
    remote: Total 37 (delta 15), reused 28 (delta 10)
    Unpacking objects: 100% (37/37), done.
    From github.com:objectos/objectos-dojo
    * [new branch]      gh-pages   -> objectos/gh-pages
    * [new branch]      master     -> objectos/master

O comando fetch faz o download das novas branches e dos arquivos existentes no repositório remoto, como pode ser
observado no comando acima.

Agora certifique-se quais são as branches existentes no seu diretório local:

    $ git branch
    * master

Em seguida deve ser executado o mesmo comando, passando o parâmetro `-a`:

    $ git branch -a
    * master
    remotes/objectos/gh-pages
    remotes/objectos/master
    remotes/origin/gh-pages
    remotes/origin/master

Pode ser observado que o parâmetro `-a` lista todas as branches, inclusive as remotas.

E então, mude para a branch gh-pages do remoto objectos, executando o comando abaixo:

    $ git checkout remotes/objectos/gh-pages

E então um erro deve aparecer.

    Note: checking out 'remotes/objectos/gh-pages'.

    You are in 'detached HEAD' state. You can look around, make experimental
    changes and commit them, and you can discard any commits you make in this
    state without impacting any branches by performing another checkout.

    If you want to create a new branch to retain commits you create, you may
    do so (now or later) by using -b with the checkout command again. Example:

    git checkout -b new_branch_name

    HEAD is now at 9f08788... Merge pull request #17 from marcioendo/gh-pages

Mas o que houve de errado? O que isso significa?

Nesse momento, o modo é "detached HEAD", nenhuma branch está habilitada. É necessário então criar uma branch local 
gh-pages para receber as atualizações da branch remota gh-pages, e esse é exatamente o próximo passo. 

Passo 3) 

É necessário então executar o comando abaixo: 

    $ git checkout -b gh-pages
    Switched to a new branch 'gh-pages'

Foi criada então a branch gh-pages local, que recebe as atualizações da branch gh-pages remota, e em seguida a nova 
branch foi habilitada. 

Agora é necessário enviar as atualizações (que foram trazidas da branch remota (do projeto original) para o fork do 
projeto (remoto):

Passo 4)

    $ git push origin gh-pages
    Total 0 (delta 0), reused 0 (delta 0)
    To git@github.com:hescarate/objectos-dojo.git
    * [new branch]      gh-pages -> gh-pages

Dessa forma as atualizações da branch local gh-pages foram enviadas para a branch remota gh-pages (do fork do projeto). 

Feito esses procedimentos, é necessário acessar o servidor, onde estão as páginas dos artigos / tutoriais:

    $ jekyll --server
    Configuration from /home/hescarate/kdo/projetos/objectos-dojo/_config.yml
    Auto-regenerating enabled: . -> ./_site
    [2011-09-12 16:31:35] regeneration: 35 files changed
    [2011-09-12 16:31:35] INFO  WEBrick 1.3.1
    [2011-09-12 16:31:35] INFO  ruby 1.8.7 (2011-02-18) [x86_64-linux]
    [2011-09-12 16:31:35] INFO  WEBrick::HTTPServer#start: pid=4461 port=4000

Agora no navegador aponte para o endereço:

    http://localhost:4000/

E então o Objectos Dojô estará disponível para ser acessado internamente.

## Padrão

Todas as páginas / tutoriais devem ter:

- Introdução

- Conclusão

- Referências: de onde foram consultadas informações, exemplos (de livros, ou sites (devem constar data e hs do
  acesso)), e ainda nas referências deve constar quem escreveu o artigo.

- Cabeçalho, conforme o modelo abaixo:

    ---
    layout: post
    title: "Git :: Trabalhando em equipe"
    published: true
    tags:
    - git
    - aprendizes
    ---

Depois de concluir a nova página / artigo é necessário que isso seja revisado antes de ir oficialmente para o "ar",
portanto, é preciso fazer um `Pull Request` (em caso de dúvidas consulte o tutorial sobre Pull Request).

## Referências

_Artigo escrito por Hellen Escarate_















































