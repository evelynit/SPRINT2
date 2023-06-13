package com.empresa.optica.dao;

import com.empresa.optica.model.Proveedor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class ProveedorDao {
    private MongoCollection<Document> collection;

    public ProveedorDao() {
        collection = MongoUtil.getDatabase().getCollection("proveedores");
    }

    // Create
    public void insertProveedor(Proveedor proveedor) {
        Document doc = new Document("nombre", proveedor.getNombre())
            .append("direccion", proveedor.getDireccion())
            .append("telefono", proveedor.getTelefono())
            .append("fax", proveedor.getFax())
            .append("nif", proveedor.getNif());
        collection.insertOne(doc);
    }

    // Read
    public Document getProveedor(String nombre) {
        return collection.find(Filters.eq("nombre", nombre)).first();
    }

    // Update
    public void updateProveedor(Proveedor proveedor) {
        Document doc = new Document("nombre", proveedor.getNombre())
            .append("direccion", proveedor.getDireccion())
            .append("telefono", proveedor.getTelefono())
            .append("fax", proveedor.getFax())
            .append("nif", proveedor.getNif());
        collection.replaceOne(Filters.eq("nombre", proveedor.getNombre()), doc);
    }

    // Delete
    public void deleteProveedor(String nombre) {
        collection.deleteOne(Filters.eq("nombre", nombre));
    }

}

