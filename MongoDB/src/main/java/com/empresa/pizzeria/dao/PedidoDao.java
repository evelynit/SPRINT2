package com.empresa.pizzeria.dao;


import com.empresa.pizzeria.model.Pedido;
import com.mongodb.client.MongoCollection;
import com.empresa.pizzeria.dao.MongoUtil;
import org.bson.Document;

public class PedidoDao {
    private MongoCollection<Document> pedidos;

    public PedidoDao() {
        pedidos = MongoUtil.getDatabase().getCollection("pedidos");
    }

    public void create(Pedido pedido) {
        Document doc = new Document("id", pedido.getId())
                .append("fechaHora", pedido.getFechaHora())
                .append("modo", pedido.getModo())
                .append("productos", pedido.getProductos())
                .append("precioTotal", pedido.getPrecioTotal())
                .append("clienteId", pedido.getClienteId())
                .append("tiendaId", pedido.getTiendaId())
                .append("empleadoId", pedido.getEmpleadoId())
                .append("horaEntrega", pedido.getHoraEntrega());
        pedidos.insertOne(doc);
    }
}

