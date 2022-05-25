# BDD com Selenium e Java

### O que é BDD?
Behavior Driven Development (BDD) é um framework de desenvolvimento ágil que auxilia a comunicação entre as áreas que engloba o desenvolvimento de software, incluindo pessoas não-técnicas, como, por exemplo, cliente e time de negócios, desta forma a verificação e validação ficam mais assertivas.

### Porque BDD existe?
O BDD foi criado para mitigar as falhas de comunicação dentro de uma equipe, para que os contextos dos requisitos não sejam perdidos, ou alterados, pelo que chamamos  "telefone sem fio", onde um requisito chega para equipe e acaba sendo desenvolvido de forma diferente ao planejado, causando perda de tempo, e consequentemente dinheiro, além, de frustração no cliente e todo o time de negócios que agora tera que renegociar com o cliente. 

### Processos do BDD

#### Reunião
Nós vemos diariamente uma comunicação onde uma feature chega na equipe atrás do product ower que repassa isso ao analista de negócio que separa as user stories que será desenvolvida e testada, porem, como já dito anteriormente, existe o "telefone sem fio", então, um dos processos de BDD é uma reunião de abertura com todos os envolvidos no processo, haverá a apresentação dos requisitos, onde, todos podem fazer perguntas para sanar as dúvidas 

#### Formalização
O resultado da reunião é um documento onde são descritos os critérios de aceitação para os cenários possíveis, o Given-When-Then (Dado-Quando-Então), onde é dado ações e resultados esperados, serão posteriormente repassados para código-fonte, esses cenários iram ajudar os desenvolvedores na criação da feature e testados, criando validações mais precisas através da automação dos testes dos cenários.

#### Automação
Então é realizado a automação dos possíveis cenários relatados na reunião e formalizados, usando Cucumber, Gherkin e TDD.

#### Validação
Após feature implementada e validade pelo time de testes, corre a validação por quem propôs a feature, no caso, o product owner ou analista de negócios, onde irão verificar a feature implementada e sugerir possíveis ajustes.

<p align="center">
  <img height="150px" src="https://github.com/raulpacheco2k/BDD-Java/blob/main/docs/Diagrama%20de%20fluxo%20BDD.svg?raw=true" />
</p>
