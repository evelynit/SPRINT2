package com.empresa.pizzeria.dao;

import com.empresa.pizzeria.model.Cliente;
import com.empresa.pizzeria.util.MongoUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class ClienteDao {
    private MongoCollection<Document> collection;

    public ClienteDao() {
        collection = MongoUtil.getDatabase().getCollection("clientes");
    }

    public void create(Cliente cliente) {
        Document document = new Document()
                .append("_id", cliente.getId())
                .append("nombre", cliente.getNombre())
                .append("apellidos", cliente.getApellidos())
                .append("direccion", cliente.getDireccion())
                .append("codigoPostal", cliente.getCodigoPostal())
                .append("localidad", cliente.getLocalidad())
                .append("provincia", cliente.getProvincia())
                .append("telefono", cliente.getNumeroTelefono());
        
        collection.insertOne(document);
    }
}
