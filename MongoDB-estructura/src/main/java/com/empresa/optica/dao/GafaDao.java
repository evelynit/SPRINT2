package com.empresa.optica.dao;

import com.empresa.optica.model.Gafa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class GafaDao {
    private MongoCollection<Document> collection;

    public GafaDao() {
        collection = MongoUtil.getDatabase().getCollection("gafas");
    }

    // Create
    public void insertGafa(Gafa gafa) {
        Document doc = new Document("marca", gafa.getMarca())
            .append("graduacion", gafa.getGraduacion())
            .append("tipoMontura", gafa.getTipoMontura())
            .append("colorMontura", gafa.getColorMontura())
            .append("colorCristal", gafa.getColorCristal())
            .append("precio", gafa.getPrecio());
        collection.insertOne(doc);
    }

    // Read
    public Document getGafa(String marca) {
        return collection.find(Filters.eq("marca", marca)).first();
    }

    // Update
    public void updateGafa(Gafa gafa) {
        Document doc = new Document("marca", gafa.getMarca())
            .append("graduacion", gafa.getGraduacion())
            .append("tipoMontura", gafa.getTipoMontura())
            .append("colorMontura", gafa.getColorMontura())
            .append("colorCristal", gafa.getColorCristal())
            .append("precio", gafa.getPrecio());
        collection.replaceOne(Filters.eq("marca", gafa.getMarca()), doc);
    }

    // Delete
    public void deleteGafa(String marca) {
        collection.deleteOne(Filters.eq("marca", marca));
    }
}