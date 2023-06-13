package com.empresa.pizzeria;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.empresa.pizzeria.dao.PedidoDao;
import com.empresa.pizzeria.dao.ProductoDao;
import com.empresa.pizzeria.dao.ProvinciaDao;
import com.empresa.pizzeria.dao.TiendaDao;
import com.empresa.pizzeria.model.Pedido;
import com.empresa.pizzeria.model.Producto;
import com.empresa.pizzeria.model.Provincia;
import com.empresa.pizzeria.model.Tienda;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de las clases DAO
        PedidoDao pedidoDao = new PedidoDao();
        ProductoDao productoDao = new ProductoDao();
        ProvinciaDao provinciaDao = new ProvinciaDao();
        TiendaDao tiendaDao = new TiendaDao();

        // Objetos de ejemplo
        Producto producto1 = new Producto("1", "Pizza Margarita", "Deliciosa pizza con tomate y queso", "imagen1.jpg", 8.99);
        Producto producto2 = new Producto("2", "Hamburguesa Clásica", "Sabrosa hamburguesa con carne y queso", "imagen2.jpg", 5.99);
        Provincia provincia1 = new Provincia("1", "Barcelona");
        Tienda tienda1 = new Tienda("1", "Calle Principal 123", "08001", "Barcelona", "1");

        // Los objetos en la base de datos
        productoDao.create(producto1);
        productoDao.create(producto2);
        provinciaDao.create(provincia1);
        tiendaDao.create(tienda1);


        // Crear un mapa de productos para el pedido
        Map<String, Integer> productos = new HashMap<String, Integer>();
        productos.put("1", 2); // Producto con ID "1" y cantidad 2
        productos.put("2", 1); // Producto con ID "2" y cantidad 1

        // Crear una instancia de Pedido utilizando el constructor
        Pedido pedido1 = new Pedido("1", new Date(1/1/1), "domicilio", productos, 25.99, "1", "1", "1", new Date(2/2/2));

        // Persistir el pedido en la base de datos
        pedidoDao.create(pedido1);
        
    }
}