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
Given That I'm on the Google homepage
When type George W. Bush
  And click search
Then a summary about the president is displayed
```

#### Automação
Então é realizado a automação dos possíveis cenários relatados e formalizados durante reunião, usando Cucumber e Gherkin em uma linguagem de programação.

```java
@io.cucumber.java.en.Given("That I'm on the Google homepage")
public void thatIMOnTheGoogleHomepage() {
    this.googlePage = new GooglePage();
    this.googlePage.beforeEach();
}

@When("type {string}")
public void iTypeGeorgeWBush(String text) {
    this.googlePage.fillSearchInput(text);
}

@And("click search")
public void iClickSearch() {
    this.googleSearchPage = this.googlePage.search();
}

@Then("a summary about the president is displayed")
public void aSummaryAboutTheTermIsDisplayed() {
    Assert.assertEquals(
            "George Walker Bush, /ˈdʒɔrdʒ ˈwɔːkər ˈbʊʃ/; é um político estadunidense que serviu como o " +
            "43.º Presidente dos Estados Unidos, de 2001 a 2009, e como o 46.º Governador do Texas, " +
            "entre 1995 a 2000. Bush faz parte de uma proeminente família política dos Estados Unidos. " +
            "É o filho mais velho de George H. W.",
            this.googleSearchPage.getPageDescription()
    );
    this.googleSearchPage.afterEach();
}
```

#### Validação
Após feature implementada e validade pelo time de testes, ocorre a validação por quem propôs a feature, no caso, o product owner ou analista de negócios, onde irão verificar a feature implementada e sugerir possíveis ajustes.

<p align="center">
  <img height="150px" src="./docs/Diagrama%20de%20fluxo%20BDD.svg?raw=true" />
</p>
