/**
* Baseado no modelo do SDK da Wirecard, abaixo está em código Java de um dos cenários que foi escrito em BDD "Boleto é pago duas vezes no mesmo dia".
 */

 public class BoletoPagoDuasVezes{

Map<String, Object> instructionLines = payloadFactory(
    value("first", "Primeira linha de instrução!"),
    value("second", "Segunda linha de instrução!"),
    value("third", "Terceira linha de instrução!")
)

Map<String, Object> boleto = payloadFactory(
    value("expirationDate", "2020-03-21"),
    value("instructionLines", instructionLines),
    value("logoUri", "https://www.laseve.com.br/")
);

Map<String, Object> fundingInstrument = payloadFactory(
    value("method", "BOLETO");
    value("boleto", boleto);
);

Map<String, Object> payment = payloadFactory(
    value("installmentCount", 1),
    value("statementDescriptor", "laseve.com"),
    value("fundingInstrument", fundingInstrument)
);

Map<String, Object> newPay = Moip.API.payments().pay(payment, "order_id", setup);

Map<String, Object> payment = payloadFactory(
    value("installmentCount", 1),
    value("statementDescriptor", "laseve.com"),
    value("fundingInstrument", fundingInstrument)
);

Map<String, Object> newPay = Moip.API.payments().pay(payment, "order_id", setup);
}
