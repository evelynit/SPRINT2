package com.empresa.pizzeria.dao;

import com.mongodb.client.MongoCollection;
import com.empresa.pizzeria.model.Localidad;
import com.empresa.pizzeria.MongoUtil;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class LocalidadDao {
    private MongoCollection<Document> collection;

    public LocalidadDao() {
        collection = MongoUtil.getDatabase().getCollection("localidades");
    }

    public void create(Localidad localidad) {
        Document document = new Document()
                .append("_id", localidad.getId())
                .append("nombre", localidad.getNombre())
                .append("provincia", localidad.getProvincia());

        collection.insertOne(document);
    }

}
