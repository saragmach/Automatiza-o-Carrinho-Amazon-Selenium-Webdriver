# language: pt

Funcionalidade: Pesquisar por um item no Amazon
  Eu enquanto usuário da Amazon
  Quero pesquisar por um item
  Para o adicionar no carrinho e o comprar

  @pesquisa_sucesso
  Cenário: adicionar um item ao carrinho com sucesso
    Dado que estou na tela inicial do site
    Quando eu digito a palavra de busca
    E clico em pesquisar
    E clico no item
    E adiciono ao carrinho
    Então vejo os resultados da pesquisa
