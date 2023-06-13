package com.empresa.pizzeria.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.empresa.pizzeria.model.Categoria;
import com.empresa.pizzeria.dao.MongoUtil;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class CategoriaDao {
    private MongoCollection<Document> collection;

    public CategoriaDao() {
        collection = MongoUtil.getDatabase().getCollection("categorias");
    }

    public void create(Categoria categoria) {
        Document document = new Document()
                .append("_id", categoria.getId())
                .append("nombre", categoria.getNombre());

        collection.insertOne(document);
    }

}
