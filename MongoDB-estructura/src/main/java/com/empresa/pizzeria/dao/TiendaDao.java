package com.empresa.pizzeria.dao;

import com.empresa.pizzeria.model.Tienda;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class TiendaDao {
    private MongoCollection<Document> tiendas;

    public TiendaDao() {
        tiendas = MongoUtil.getDatabase().getCollection("tiendas");
    }

    public void create(Tienda tienda) {
        Document doc = new Document("id", tienda.getId())
                .append("direccion", tienda.getDireccion())
                .append("codigoPostal", tienda.getCodigoPostal())
                .append("localidad", tienda.getLocalidad())
                .append("provincia", tienda.getProvincia());
        tiendas.insertOne(doc);
    }
}