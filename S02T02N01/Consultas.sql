/*CONSULTAS A DATABASE TIENDA*/
USE tienda;

/*Consulta 1: Lista el nombre de todos los productos que hay en la mesa producto.*/
SELECT nombre FROM producto;
/*Consulta 2: Lista los nombres y los precios de todos los productos de la mesa producto.*/
SELECT nombre, precio FROM producto;
/*Consulta 3: Lista todas las columnas de la tabla producto.*/
SELECT * FROM producto;
/*Consulta 4: Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). Suponiendo que 1 Euro es igual a 1.12 USD.*/
SELECT nombre, precio, precio*1.12 AS precio_USD FROM producto;
/*Consulta 5: Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). Utiliza los siguientes sobrenombre para las columnas: nombre de producto, euros, dólares.*/
SELECT nombre AS 'Nombre de producto', precio AS euros, precio*1.12 AS dolares FROM producto;
/*Consulta 6: Lista los nombres y los precios de todos los productos de la mesa producto, convirtiendo los nombres a mayúscula.*/
SELECT UPPER(nombre), precio FROM producto;
/*Consulta 7: Lista los nombres y los precios de todos los productos de la mesa producto, convirtiendo los nombres a minúscula.*/
SELECT LOWER(nombre), precio FROM producto;
/*Consulta 8: Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres del nombre del fabricante.*/
SELECT nombre, UPPER(LEFT(nombre,2)) AS primeros_2_caracteres FROM fabricante;
/*Consulta 9: Lista los nombres y los precios de todos los productos de la mesa producto, redondeando el valor del precio.*/
SELECT nombre, ROUND(precio) AS precio_redondeo FROM producto;
/*Consulta 10: Lista los nombres y precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna cifra decimal.*/
SELECT nombre, TRUNCATE(precio,0) AS precio_truncado FROM producto;
 /*Consulta 11: Lista el código de los fabricantes que tienen productos en la mesa producto.*/
 SELECT codigo_fabricante FROM producto;
/*Consulta 12: Lista el código de los fabricantes que tienen productos en la mesa producto, eliminando los códigos que aparecen repetidos.*/
SELECT DISTINCT codigo_fabricante FROM producto;
/*Consulta 13: Lista los nombres de los fabricantes ordenados de forma ascendente.*/
SELECT nombre FROM fabricante ORDER BY nombre ASC;
/*Consulta 14: Lista los nombres de los fabricantes ordenados de forma descendente.*/
SELECT nombre FROM fabricante ORDER BY nombre DESC;
/*Consulta 15: Lista los nombres de los productos ordenados, en primer lugar, por el nombre de forma ascendente y, en segundo lugar, por el precio de forma descendente.*/
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;
/*Consulta 16: Devuelve una lista con las 5 primeras filas de la mesa fabricante.*/
SELECT * FROM fabricante LIMIT 5;
/*Consulta 17: Devuelve una lista con 2 filas a partir de la cuarta fila de la mesa fabricante. La cuarta fila también debe incluirse en la respuesta.*/
SELECT * FROM fabricante LIMIT 3,2;
/*Consulta 18: Lista el nombre y precio del producto más barato. (Utiliza solo las cláusulas ORDER BY y LIMIT). NOTA: Aquí no podría usar MIN(precio), necesitaría GROUP BY.*/
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;
/*Consulta 19: Lista el nombre y precio del producto más caro. (Utiliza solo las cláusulas ORDER BY y LIMIT). NOTA: Aquí no podría usar MAX(precio), necesitaría GROUP BY.*/
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;
/*Consulta 20: Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.*/
SELECT producto.nombre FROM producto WHERE producto.codigo_fabricante = 2;
/*Consulta 21: Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.*/
SELECT producto.nombre AS nombre_producto, producto.precio, fabricante.nombre AS nombre_fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;
/*Consulta 22: Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordena el resultado por el nombre del fabricante, por orden alfabético.*/
SELECT producto.nombre AS nombre_producto, producto.precio, fabricante.nombre AS nombre_fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY fabricante.nombre;  

/*CONSULTAS A DATABASE UNIVERSIDAD*/
USE universidad;

/*Consulta 1*/
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1, apellido2, nombre; 
/*Consulta 2*/
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo = 'alumno' AND telefono IS NULL;
/*Consulta 3*/
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
/*Consulta 4*/
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo = 'profesor' AND nif LIKE '%K' AND persona.telefono IS NULL;
/*Consulta 5*/
SELECT nombre FROM asignatura WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;
/*Consulta 6*/
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS departamento FROM persona p JOIN profesor pr ON p.id = pr.id_profesor JOIN departamento d ON pr.id_departamento = d.id ORDER BY p.apellido1, p.apellido2, p.nombre;
/*Consulta 7*/
SELECT a.nombre, c.anyo_inicio, c.anyo_fin FROM persona p JOIN alumno_se_matricula_asignatura asm ON p.id = asm.id_alumno JOIN asignatura a ON asm.id_asignatura = a.id JOIN curso_escolar c ON asm.id_curso_escolar = c.id WHERE p.nif = '26902806M';
/*Consulta 8: DISTINCT elimina duplicados, si un d estuviera asociado con + de un pr, el nombre d se repetiria */
SELECT DISTINCT d.nombre FROM departamento d JOIN profesor pr ON d.id = pr.id_profesor JOIN asignatura a ON pr.id_profesor = a.id_profesor JOIN grado g ON a.id_grado = g.id WHERE g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';  
/*Consulta 9*/
SELECT DISTINCT p.nombre, p.apellido1, p.apellido2 FROM persona p JOIN alumno_se_matricula_asignatura asm ON p.id = asm.id_alumno JOIN curso_escolar c ON asm.id_curso_escolar = c.id WHERE c.anyo_inicio = 2018;

/*Resuelve las 6 siguientes consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.*/
/*Consulta 1*/
SELECT d.nombre AS departamento, p.apellido1, p.apellido2, p.nombre FROM profesor pr JOIN persona p ON p.id = pr.id_profesor LEFT JOIN departamento d ON pr.id_departamento = d.id WHERE p.tipo = 'profesor' ORDER BY d.nombre, p.apellido1, p.apellido2, p.nombre;
/*Consulta 2*/
SELECT p.nombre, p.apellido1, p.apellido2 FROM persona p JOIN profesor pr ON p.id = pr.id_profesor WHERE pr.id_departamento IS NULL AND p.tipo = 'profesor';
/*Consulta 3*/
SELECT d.nombre FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento WHERE pr.id_profesor IS NULL;
/*Consulta 4*/
SELECT p.nombre, p.apellido1, p.apellido2 FROM persona p JOIN profesor pr ON p.id = pr.id_profesor LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor WHERE a.id_profesor IS NULL AND p.tipo = 'profesor';
/*Consulta 5*/
SELECT a.nombre FROM asignatura a LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor WHERE pr.id_profesor IS NULL;
/*Consulta 6 no funciona*/
SELECT d.nombre FROM departamento d LEFT JOIN asignatura a ON d.id = a.id LEFT JOIN curso_escolar c ON a.id = c.id WHERE a.curso IS NULL;/*Consultas Resumen*/

/*Consulta 1*/
SELECT COUNT(*) AS 'Total Alumnos' FROM persona WHERE tipo = 'alumno';
/*Consulta 2*/
SELECT COUNT(*) AS 'Nº de alumnos nacidos en 1999' FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
/*Consulta 3: GROUP BY (agrupa los resultados por el d.nombre Para cada d.nombre unico, se hace una cuenta de nº de profesores COUNT(*) que esta al inicio). Se suele usar con SUM, AVG, MIN, MAX, COUNT*/
SELECT d.nombre AS 'Departamento', COUNT(pr.id_profesor) AS 'Nº de profesores' FROM departamento d JOIN profesor pr ON d.id = pr.id_departamento GROUP BY d.nombre ORDER BY COUNT(*) DESC; 
/*Consulta 4*/
SELECT d.nombre AS 'Departamento', COUNT(pr.id_profesor) AS 'Nº de profesores' FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento GROUP BY d.nombre ORDER BY COUNT(*) DESC; 
/*Consulta 5*/
SELECT g.nombre AS 'Grado', COUNT(a.id) AS 'Nº de asignaturas' FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre ORDER BY COUNT(a.id) DESC; /*si COUNT(a.id) AS num, then, ORDER BY num DESC*/
/*Consulta 6*/
SELECT g.nombre AS 'Grado', COUNT(a.id) AS 'Nº de asignaturas' FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre HAVING COUNT(a.id) > 40;
