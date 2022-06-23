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

```gherkin
Scenario Outline: : Search for a celebrity
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

#### Automação
Então é realizado a automação dos possíveis cenários relatados e formalizados durante reunião, usando Cucumber e Gherkin em uma linguagem de programação.

```java
@io.cucumber.java.en.Given("That I'm on the Google homepage")
public void thatIMOnTheGoogleHomepage() {
}

@When("type {string} in the search field")
public void iTypeGeorgeWBush(String string) {
    this.googlePage.fillSearchInput(string);
}

@And("click search")
public void iClickSearch() {
    this.googleSearchPage = this.googlePage.search();
}

@Then("a {string} about the celebrity is displayed")
public void aSummaryAboutThCelebrityIsDisplayed(String description) {
    Assert.assertEquals(
            description,
            this.googleSearchPage.getPageDescription()
    );
}
```

#### Validação
Após feature implementada e validade pelo time de testes, ocorre a validação por quem propôs a feature, no caso, o product owner ou analista de negócios, onde irão verificar a feature implementada e sugerir possíveis ajustes.

<p align="center">
  <img height="150px" src="./docs/Diagrama%20de%20fluxo%20BDD.svg?raw=true" />
</p>
