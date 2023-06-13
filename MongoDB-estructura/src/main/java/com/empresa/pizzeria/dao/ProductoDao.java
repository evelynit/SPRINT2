package com.empresa.pizzeria.dao;

import com.empresa.pizzeria.model.Producto;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProductoDao {
    private MongoCollection<Document> productos;

    public ProductoDao() {
        productos = MongoUtil.getDatabase().getCollection("productos");
    }

    public void create(Producto producto) {
        Document doc = new Document("id", producto.getId())
                .append("nombre", producto.getNombre())
                .append("descripcion", producto.getDescripcion())
                .append("imagen", producto.getImagen())
                .append("precio", producto.getPrecio());
        productos.insertOne(doc);
    }
}
