package com.empresa.optica.dao;

import com.empresa.optica.model.Cliente;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class ClienteDao {
    private MongoCollection<Document> collection;

    public ClienteDao() {
        collection = MongoUtil.getDatabase().getCollection("clientes");
    }

    // Create
    public void insertCliente(Cliente cliente) {
        Document doc = new Document("nombre", cliente.getNombre())
            .append("direccion", cliente.getDireccionPostal())
            .append("telefono", cliente.getTelefono())
            .append("correoElectronico", cliente.getCorreoElectronico())
            .append("fechaRegistro", cliente.getFechaRegistro())
            .append("recomendadoPor", cliente.getClienteRecomendador());
        collection.insertOne(doc);
    }

    // Read
    public Document getCliente(String nombre) {
        return collection.find(Filters.eq("nombre", nombre)).first();
    }

    // Update
    public void updateCliente(Cliente cliente) {
        Document doc = new Document("nombre", cliente.getNombre())
            .append("direccion", cliente.getDireccionPostal())
            .append("telefono", cliente.getTelefono())
            .append("correoElectronico", cliente.getCorreoElectronico())
            .append("fechaRegistro", cliente.getFechaRegistro())
            .append("recomendadoPor", cliente.getClienteRecomendador());
        collection.replaceOne(Filters.eq("nombre", cliente.getNombre()), doc);
    }
    
    // Delete
    public void deleteCliente(String nombre) {
        collection.deleteOne(Filters.eq("nombre", nombre));
    }

}
