package com.empresa.pizzeria.dao;


import com.mongodb.client.MongoCollection;
import com.empresa.pizzeria.model.Empleado;
import com.empresa.pizzeria.dao.MongoUtil;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class EmpleadoDao {
    private MongoCollection<Document> collection;

    public EmpleadoDao() {
        collection = MongoUtil.getDatabase().getCollection("empleados");
    }

    public void create(Empleado empleado) {
        Document document = new Document()
                .append("_id", empleado.getId())
                .append("nombre", empleado.getNombre())
                .append("apellidos", empleado.getApellidos())
                .append("nif", empleado.getNif())
                .append("telefono", empleado.getTelefono())
                .append("cargo", empleado.getCargo());

        collection.insertOne(document);
    }

}
