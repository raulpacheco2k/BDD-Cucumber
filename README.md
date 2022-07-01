# BDD com Cucumber, Selenium e JUnit

### O que é BDD?

Behavior Driven Development (BDD) é um framework de desenvolvimento ágil que auxilia a comunicação entre as áreas que
engloba o desenvolvimento de software, incluindo pessoas não-técnicas, como, por exemplo, cliente e time de negócios,
desta forma a verificação e validação ficam mais assertivas.

BDD auxilia na comunicação provendo:

1. Colaboração entre as aáreas para construir um entendimento comum do problema a ser resolvido.
2. Introduzindo iterações rápidas e pequenas para aumentar o fluxo de feedback, por isso está bem integrado ao
   desenvolvimento ágil.

### Porque BDD existe?

O BDD foi criado para mitigar as falhas de comunicação dentro de uma equipe, para que os contextos dos requisitos não
sejam perdidos, ou alterados, pelo que chamamos  "telefone sem fio", onde um requisito chega para equipe e acaba sendo
desenvolvido de forma diferente ao planejado, causando perda de tempo, e consequentemente dinheiro, além, de frustração
no cliente e todo o time de negócios que agora tera que renegociar com o cliente.

### Processos do BDD

O BDD é uma prática dividida em pequenas cerimônias, semelhantes ao desenvolvimento ágil, vale salientar que o BDD é um
incremento ao desenvolvimento ágil e não um substituto, então, para utilizar o BDD presumimos já há algum processo de
metodologia ágil (Scrum, XP...) implantada e o que time está familiarizado com as suas cerimônias, como, por exemplo,
planejamento de trabalhos em pequenos incrementos, as conhecidas user stories.

#### Reunião

Diariamente vemos uma comunicação vertical, onde o product ower repassa uma demanda (users stories) ao analista de
negócio, e este separa as users stories que será desenvolvida e testada e em seguida essa demanda chega até a equipe de
desenvolvimento, porem, como já dito anteriormente, existe o "telefone sem fio".

O primeiro processos do BDD é uma reunião de abertura de história com todos os envolvidos no processo para revelar
lacunas na compreensão do sistema, onde deverá haver a apresentação dos requisitos da nova funcionalidade, todos os
envolvidos podem fazer perguntas para sanar as dúvidas, a reunião deve finalizar quando o time chegar ao concesso do que
será desenvolvido.

É aconselhável que seja um time pequeno entre 3 e 6 pessoas, para manter o fluxo ágil. Deve ter pelo menos o product
owner, o tester e o desenvolvedor, além disso a reunião deve ocorrer em media em 30 minutos, se passar muito disso é um
alerta que a funcionalidade a ser implementada é algo complexo e que precisa ser dividade em pequenos passos (tarefas).

#### Formalização

O resultado da reunião é um documento, onde são descritos as regras de negócio e os possíveis cenários de maneira que
possa ser automatizado e compreendido por humanos e computadores através da sintaxe do Gherkin (Given-When-Then), onde é
descrito os pré-requisitos (Given), ações (When) e resultados esperados (Then) para essas ações.

Após ter passado as regras de negócios e os possíveis cenários para a sintaxe do Gherkin, então, serão posteriormente
repassados para código-fonte, esses cenários iram ajudar os desenvolvedores na criação da feature e os testadores,
criando validações mais precisas através da automação dos testes dos cenários.

```gherkin
Scenario Outline: Search for a celebrity
Given That I'm on the Google homepage
When type <celebrity> in the search field
And click search
Then a <description> about the celebrity is displayed

Examples:
| celebrity           | description                                                                                                                                                                                                                                                                                                       |
| "Bill Gates"        | "William Henry Gates III, mais conhecido como Bill Gates, é um magnata, empresário, diretor executivo, investidor, filantropo e autor americano, que ficou conhecido por fundar, junto com Paul Allen a Microsoft, a maior e mais conhecida empresa de software do mundo em termos de valor de mercado."          |
| "Barack Obama"      | "Barack Hussein Obama II é um advogado e político norte-americano que serviu como o 44.º presidente dos Estados Unidos de 2009 a 2017, sendo o primeiro afro-americano a ocupar o cargo."                                                                                                                         |
| "Steve Jobs"        | "Steven Paul Jobs foi um inventor, empresário e magnata americano no setor da informática. Notabilizou-se como co-fundador, presidente e diretor executivo da Apple Inc. e por revolucionar seis indústrias: computadores pessoais, filmes de animação, música, telefones, tablets e publicações digitais."       |
| "Mark Zuckerberg"   | "Mark Elliot Zuckerberg é um programador e empresário norte-americano, que ficou conhecido internacionalmente por ser um dos fundadores do Facebook, a rede social mais acessada do mundo."                                                                                                                       |
| "George W. Bush"    | "George Walker Bush, /ˈdʒɔrdʒ ˈwɔːkər ˈbʊʃ/; é um político estadunidense que serviu como o 43.º Presidente dos Estados Unidos, de 2001 a 2009, e como o 46.º Governador do Texas, entre 1995 a 2000. Bush faz parte de uma proeminente família política dos Estados Unidos. É o filho mais velho de George H. W." |
| "George H. W. Bush" | "George Herbert Walker Bush foi um político, diplomata e empresário americano que serviu como presidente dos Estados Unidos de 1989 a 1993."                                                                                                                                                                      |
```

Desta forma, temos especificações executáveis escrita em uma tecnologia que é compreensível tanto pelos técnicos quanto
pelos não técnicos, desta forma, ropemos barreiras entre a comunicação entre essas duas partes, assim, podemos utilizar
uma terminologia que seja mais apropriada para o domínio do problema e não em suas implementações.

#### Automação

Então é realizado a automação dos cenários escritos com a sintaxe do Gherkin, utilizando Cucumber. Nesta etapa também é
válido o uso de TDD, desta forma, todo o código criado será desenvolvimento com base nas automações de testes criada,
assim, o desenvolvimento será um reflexo dos testes e, por sua vez, os testes são reflexo do comportamento esperado.

```java
@Given("That I'm on the Google homepage")
public void thatIMOnTheGoogleHomepage(){
        this.googlePage.goTo("https://www.google.com");
        }

@When("type {string} in the search field")
public void iTypeGeorgeWBush(String string){
        this.googlePage.fillSearchInput(string);
        }

@And("click search")
public void iClickSearch(){
        this.googleSearchPage=this.googlePage.search();
        }

@Then("a {string} about the celebrity is displayed")
public void aSummaryAboutThCelebrityIsDisplayed(String description){
        Assertions.assertEquals(
        description,
        this.googleSearchPage.getPageDescription()
        );
        }
```

Ao decorrer do tempo, as automações criadas tornam-se um ativo que permite que sua equipe continue a fazer alterações
no sistema com confiança e velocidade.

#### Validação

Após feature implementada e validade pelo time de testes, ocorre a validação por quem propôs a feature, no caso, o
product owner ou analista de negócios, onde irão verificar a feature implementada e sugerir possíveis ajustes.

<p align="center">
  <img height="150px" src="./docs/Diagrama%20de%20fluxo%20BDD.svg?raw=true" />
</p>
