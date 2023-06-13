
package com.empresa.pizzeria.dao;

import com.empresa.pizzeria.model.Provincia;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProvinciaDao {
    private MongoCollection<Document> provincias;

    public ProvinciaDao() {
        provincias = MongoUtil.getDatabase().getCollection("provincias");
    }

    public void create(Provincia provincia) {
        Document doc = new Document("id", provincia.getId())
                .append("nombre", provincia.getNombre());
        provincias.insertOne(doc);
    }
}
