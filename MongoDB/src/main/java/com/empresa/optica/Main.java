package com.empresa.optica;

import com.empresa.optica.model.Cliente;
import com.empresa.optica.model.Empleado;
import com.empresa.optica.model.Gafa;
import com.empresa.optica.model.Proveedor;
import com.empresa.optica.dao.ClienteDao;
import com.empresa.optica.dao.GafaDao;
import com.empresa.optica.dao.ProveedorDao;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear objetos para probar
        Proveedor proveedor = new Proveedor(1, "Proveedor 1", "Calle 1, No. 1, Piso 1, Puerta 1, Ciudad 1, 11111, Pais 1", 
                                            "123456789", "987654321", "NIF123456789");
        Gafa gafa = new Gafa("Marca 1", 1.00, "Tipo Montura 1", "Color Montura 1", "Color Cristal 1", 100.0);
        Cliente cliente = new Cliente(1,"Cliente 1", "Direccion 1", "123456789", "cliente1@email.com", new Date(),null, new Empleado(1, "Juan"));

        // Crear DAOs
        ProveedorDao proveedorDao = new ProveedorDao();
        GafaDao gafaDao = new GafaDao();
        ClienteDao clienteDao = new ClienteDao();

        // Probar inserción
        proveedorDao.insertProveedor(proveedor);
        gafaDao.insertGafa(gafa);
        clienteDao.insertCliente(cliente);

        // Probar lectura
        System.out.println("Proveedor: " + proveedorDao.getProveedor(proveedor.getNombre()));
        System.out.println("Gafa: " + gafaDao.getGafa(gafa.getMarca()));
        System.out.println("Cliente: " + clienteDao.getCliente(cliente.getNombre()));

        // Probar actualización
        proveedor.setDireccion("Nueva direccion");
        gafa.setPrecio(120.0);
        cliente.setTelefono("987654321");
        proveedorDao.updateProveedor(proveedor);
        gafaDao.updateGafa(gafa);
        clienteDao.updateCliente(cliente);

        // Probar lectura después de la actualización
        System.out.println("Proveedor: " + proveedorDao.getProveedor(proveedor.getNombre()));
        System.out.println("Gafa: " + gafaDao.getGafa(gafa.getMarca()));
        System.out.println("Cliente: " + clienteDao.getCliente(cliente.getNombre()));

        // Probar borrado
        proveedorDao.deleteProveedor(proveedor.getNombre());
        gafaDao.deleteGafa(gafa.getMarca());
        clienteDao.deleteCliente(cliente.getNombre());

        // Probar lectura después del borrado (debería dar null)
        System.out.println("Proveedor: " + proveedorDao.getProveedor(proveedor.getNombre()));
        System.out.println("Gafa: " + gafaDao.getGafa(gafa.getMarca()));
        System.out.println("Cliente: " + clienteDao.getCliente(cliente.getNombre()));
    }
}
