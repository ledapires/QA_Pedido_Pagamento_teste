#language:pt
# Cenários de Pedido escritos em BDD
Funcionalidade: Validar a não criação de um pedido

Cenario: Criar Pedido sem informar dados do cliente
Dado inicia pedido informando o produto e preço
Quando solicita a criação do Pedido
Então exibe mensagem de erro

Cenario: Criar Pedido com o campo Moeda com mais de 3 caracteres
Dado que possuo um Pedido criado
Quando informo uma moeda com mais de 3 caracteres
Então exibe mensagem de erro

Cenario: Criar Pedido com 2 ou mais produtos, informando as categorias incorretas deles
Dado que estou realizando um  Pedido
Quando incluir 2 ou mais produtos na lista
E informar as categorias incorretas dos produtos
Então Pedido não deve ser criado
