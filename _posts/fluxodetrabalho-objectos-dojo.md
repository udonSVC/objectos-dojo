---
layout: post
title: "Fluxo de trabalho Objectos-dojô"
published: false
tags:
- wiki
- aprendizes
- fluxo de trabalho
---


## Fluxo de trabalho Objectos Dojô


## Introdução

Aqui será mostrado passo a passo como trabalhar com os artigos que ficarão no Blog Objectos Dojô, e como deve ser o
padrão de cada um, com o propósito de manter a qualidade do que é produzido por nós da Objectos.

O primeiro passo é certificar-se de que o endereço do origin está correto, ou seja, se realmente o endereço traz o fork
do projeto e não o projeto original, pra isso pode ser usado o comando abaixo:

```
$ git remote -v
```

E então os remotos serão listados:

```
objectos        git@github.com:objectos/objectos-dojo.git (fetch)
objectos        git@github.com:objectos/objectos-dojo.git (push)
origin  git@github.com:hescarate/objectos-dojo.git (fetch)
origin  git@github.com:hescarate/objectos-dojo.git (push)
```

Caso os endereços estejam incorretos, remova usando o comando que segue:

```
$ git remote rm objectos
```

```
$ git remote rm origin
```

E então adicione o corretamente os endereços (é necessário trocar no comando abaixo "hescarate" pelo usuário atual):

```
$ git remote add origin git@github.com:hescarate/objectos-dojo.git
```

```
$ git remote add objectos git@github.com:objectos/objectos-dojo.git
```

Depois de confimado se o origin (apontando para o seu fork) e objectos (apontando para o projeto original) estão
corretos, volte para a branch master

```
$ git checkout master
```

E então é necessário executar o **pull** :


```
From github.com:hescarate/objectos-dojo
 * [new branch]      gh-pages   -> origin/gh-pages
  * [new branch]      master     -> origin/master
  You asked me to pull without telling me which branch you
  want to merge with, and 'branch.master.merge' in
  your configuration file does not tell me, either. Please
  specify which branch you want to use on the command line and
  try again (e.g. 'git pull <repository> <refspec>').
  See git-pull(1) for details.

If you often merge with the same branch, you may want to
use something like the following in your configuration file:

    [branch "master"]
    remote = <nickname>
    merge = <remote-ref>

    [remote "<nickname>"]
    url = <url>
    fetch = <refspec>

See git-config(1) for details.
```

O próximo comando a ser executado será o **fetch** :

```
$ git fetch objectos
From github.com:objectos/objectos-dojo
 * [new branch]      gh-pages   -> objectos/gh-pages
 * [new branch]      master     -> objectos/master
```

O comando fetch faz o download das novas branches e dos arquivos existentes no repositório remoto, como pode ser
observado no comando acima.

Agora certifique-se quais são as branches existentes nesse diretório:

```
$ git branch
  gh-pages
* master
```


Em seguida deve ser executado o mesmo comando, passando o parâmetro "-a":

```
$ git branch -a
  gh-pages
* master
  remotes/objectos/gh-pages
  remotes/objectos/master
  remotes/origin/gh-pages
  remotes/origin/master
```


Então pode ser observado que o parâmetro "-a" trás todas as branches, inclusive as remotas.

_Obs: Caso esse procedimento esteja sendo feito pela primeira vez, nas branches locais não vai existir a branch
**gh-pages** que será excluída no próximo passo._

```
$ git branch -d gh-pages
error: The branch 'gh-pages' is not fully merged.
If you are sure you want to delete it, run 'git branch -D gh-pages'
```

Provavelmente usando o comando **-d**, não foi possível excluir a branch. Pode ser usado então **-D** .


```
$ git branch -D gh-pages
Deleted branch gh-pages (was 479cc5b).
```

Depois da branch local excluída (**gh-pages**), execute o comando abaixo:

```
$ git checkout remotes/objectos/gh-pages
```

E então um erro deve aparecer.


```
Note: checking out 'remotes/objectos/gh-pages'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by performing another checkout.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -b with the checkout command again. Example:

git checkout -b new_branch_name

HEAD is now at 9f08788... Merge pull request #17 from marcioendo/gh-pages
```


Mas o que houve de errado?

O que isso significa?

Nesse momento, o modo é "detached HEAD", nenhuma branch está habilitada, por isso não é possível fazer nenhuma
modificação sem antes criar uma branch, e então, esse será o próximo passo:


```
$ git checkout -b gh-pages
Switched to a new branch 'gh-pages'
```

Então, depois de criada a nova branch, é necessário excluir a branch remota gh-pages:


```
$ git checkout -b gh-pages
Switched to a new branch 'gh-pages'
```

Então, depois de criada a nova branch, é necessário excluir a branch remota gh-pages:


```
$ git push origin :gh-pages
To git@github.com:hescarate/objectos-dojo.git
- [deleted]         gh-pages
```

Depois de excluída a branch remota (do fork do projeto), o próximo passo é enviar as atualizações (que foram trazidas
da branch remota (do projeto original) para a branch local):


```
$ git push origin gh-pages
Total 0 (delta 0), reused 0 (delta 0)
To git@github.com:hescarate/objectos-dojo.git
 * [new branch]      gh-pages -> gh-pages
```


Feito esses procedimentos, é necessário acessar o servidor, onde estão as páginas dos artigos / tutoriais:


```
$ jekyll --server
Configuration from /home/hescarate/kdo/projetos/objectos-dojo/_config.yml
Auto-regenerating enabled: . -> ./_site
[2011-09-12 16:31:35] regeneration: 35 files changed
[2011-09-12 16:31:35] INFO  WEBrick 1.3.1
[2011-09-12 16:31:35] INFO  ruby 1.8.7 (2011-02-18) [x86_64-linux]
[2011-09-12 16:31:35] INFO  WEBrick::HTTPServer#start: pid=4461 port=4000
```


Agora no navegador aponte para o endereço:

```
http://localhost:4000/
```

E então o blog Objectos Dojô estará disponível para ser acessado internamente.


## Padrão

Todas as páginas / tutoriais devem ter:

- Introdução

- Conclusão

- Referências: de onde foram consultadas informações, exemplos (de livros, ou sites (devem constar data e hs do
  acesso)), e ainda nas referências deve constar quem escreveu o artigo.

- Cabeçalho, conforme o modelo abaixo:


```
---
layout: post
title: "Git :: Trabalhando em equipe"
published: true
tags:
- git
- aprendizes
---
```

Depois de concluir a nova página / artigo é necessário que isso seja revisado antes de ir oficialmente para o "ar",
portanto, é preciso fazer um **Pull Request** (em caso de dúvidas consulte o tutorial sobre Pull Request).


## Referências

_Artigo escrito por Hellen Escarate_















































