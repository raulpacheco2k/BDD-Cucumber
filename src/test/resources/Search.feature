Feature: Search

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
