#language:pt
# Cenários para validar o pagamento, escrito em BDD

Funcionalidade: Validação de Pagamento
Cenario:  Criar Pagamento sem informar a forma de pagamento
Dado que possuo um Pedido criado
Quando solicitar o Pagamento sem informar a forma de pagamento
Então pagamento não é criado

Cenario: Pagamento com cartão de crédito inválido
Dado que possuo um Pedido criado
Quando solicitar o pagamento informando os dados do cartão de Crédito inválido
Então pagamento não é criado
E exibe mensagem de erro

Cenario: Pagamento via Débito On-line com código do banco incorreto
Dado que possuo um Pedido criado
Quando solicitar o pagamento via Débito On-line
E infomar o código do banco incorreto
Então pagamento não é criado
E exibe mensagem de erro

Cenario: Cliente paga Boleto após data de vencimento
Dado que possuo um pagamento via boleto
Quando o pagamento é efetuado após a data de vencimento
Então exibe mensagem de erro

Cenario: Boleto é pago duas vezes no mesmo dia
Dado que possuo um pagamento via boleto
Quando realizo pagamento do mesmo boleto duas vezes na mesma data
Então exibe mensagem de erro

Cenario: Boleto é pago duas vezes em dias diferentes
Dado que possuo um pagamento via boleto
Quando realizo pagamento do mesmo boleto duas vezes em datas diferentes
Então exibe mensagem de erro
