/**
* Baseado no modelo do SDK da Wirecard, abaixo está em código Java de um dos cenários que foi escrito em BDD 
"Criar Pedido sem informar dados do cliente".
 */
 
public class ValidarPedidoNaoCriado {

Map<String, Object> subtotals = payloadFactory(
    value("shipping", 18000)
);

Map<String, Object> amount = payloadFactory(
    value("currency", "BRL"),
    value("subtotals", subtotals)
);

Map<String, Object> produto1 = payloadFactory(
    value("product", "Vestido Longo"),
    value("category", "CLOTHING"),
    value("quantity", 1),
    value("detail", "La sève"),
    value("price", 18000)
);


List items = new ArrayList();
items.add(produto1);

Map<String, Object> taxDocument = payloadFactory(
    value("type", ""),
    value("number", "")
);

Map<String, Object> phone = payloadFactory(
    value("countryCode", ""),
    value("areaCode", ""),
    value("number", "")
);

Map<String, Object> shippingAddress = payloadFactory(
    value("city", ""),
    value("district", ""),
    value("street", ""),
    value("streetNumber", ""),
    value("state", ""),
    value("country", ""),
    value("zipCode", "")
);

Map<String, Object> customer = payloadFactory(
    value("ownId", ""),
    value("fullname", ""),
    value("email", ""),
    value("birthDate", ""),
    value("taxDocument", taxDocument),
    value("phone", phone),
    value("shippingAddress", shippingAddress)
);

Map<String, Object> order = payloadFactory(
    value("ownId", "order_own_id"),
    value("amount", amount),
    value("items", items),
    value("customer", customer)
);

Map<String, Object> responseCreation = Moip.API.orders().create(order, setup);
}
