import com.mongodb.client.*;
import com.mongodb.client.model.Projections;

import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

	public static void main(String[] args) {
        
		// Establecemos conexión con el servidor MongoDB
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("restaurantes");
        
		// Obtenemos la colección "ejemplo"
		MongoCollection<Document> collection = database.getCollection("ejemplo");
	
		//Queries
		/*1 Escribe una consulta para mostrar todos los documentos en la colección Restaurantes.*/
		FindIterable<Document> documento1 = collection.find();
		
		/*2 Escribe una consulta para mostrar restaurante_id, name, borough y cuisine para todos los documentos en la colección Restaurantes.*/
		FindIterable<Document> documento2 = collection.find().projection(new Document("restaurant_id", 1).append("name", 1).append("borough", 1).append("cuisine", 1));
		
		/*3 Escribe una consulta para mostrar restaurante_id, name, borough y cuisine, pero excluye el campo _id para todos los documentos en la colección Restaurantes.*/
        FindIterable<Document> documento3 = collection.find().projection(new Document("_id", 0).append("restaurant_id", 1).append("name", 1).append("borough", 1).append("cuisine", 1));

        /*4 Escribe una consulta para mostrar restaurant_id, name, borough y zip code, pero excluye el campo _id para todos los documentos en la colección Restaurantes.*/
        FindIterable<Document> documento4 = collection.find().projection(new Document("_id", 0).append("restaurant_id", 1).append("name", 1).append("borough", 1).append("address.zipcode", 1));

        /*5 Escribe una consulta para mostrar todos los restaurantes que están en el Bronx.*/
        FindIterable<Document> documento5 = collection.find(new Document("borough", "Bronx"));

        /*6 Escribe una consulta para mostrar los primeros 5 restaurantes que están en el Bronx.*/
        FindIterable<Document> documento6 = collection.find(new Document("borough", "Bronx")).limit(5);

        /*7 Escribe una consulta para mostrar el próximo 5 restaurantes después de saltar los primeros 5 del Bronx.*/
        FindIterable<Document> documento7 = collection.find(new Document("borough", "Bronx")).skip(5).limit(5);

        /*8 Escribe una consulta para encontrar los restaurantes que tienen un resultado además de 90.*/
        FindIterable<Document> documento8 = collection.find(new Document("score", new Document("$gt", 90)));

        /*9 Escribe una consulta para encontrar los restaurantes que tienen un resultado además de 80 pero menos que 100.*/
        FindIterable<Document> documento9 = collection.find(new Document("score", new Document("$gt", 80).append("$lt", 100)));

        /*10 Escribe una consulta para encontrar a los restaurantes que se localizan en valor de latitud menos de -95.754168.*/
        FindIterable<Document> documento10 = collection.find(new Document("address.coord.0", new Document("$lt", -95.754168)));

        /*11 Escribe una consulta de MongoDB para encontrar los restaurantes que no preparan ninguna cuisine de 'American' y su calificación es superior a 70 y latitud inferior a -65.754168.*/
        FindIterable<Document> documento11 = collection.find(new Document("cuisine", new Document("$ne", "American")).append("grades.score", new Document("$gt", 70)).append("address.coord.0", new Document("$lt", -65.754168)));

        /*12 Escribe una consulta para encontrar a los restaurantes que no preparan ninguna cuisine de 'American' y consiguieron un marcador más de 70 y localizado en la longitud menos que -65.754168. Nota: Realiza esta consulta sin utilizar $and operador.*/
        FindIterable<Document> documento12 = collection.find(new Document("cuisine", new Document("$ne", "American")).append("grades.score", new Document("$gt", 70)).append("address.coord.0", new Document("$lt", -65.754168)));

        /*13 Escribe una consulta para encontrar a los restaurantes que no preparan ninguna cuisine de 'American' y obtuvieron un punto de grado 'A' no pertenece a Brooklyn. Se debe mostrar el documento según la cuisine en orden descendente.*/
        FindIterable<Document> documento13 = collection.find(new Document("cuisine", new Document("$ne", "American")).append("grades.grade", "A").append("borough", new Document("$ne", "Brooklyn"))).sort(new Document("cuisine", -1));

        /*14 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que contienen 'Wil' como las tres primeras letras en su nombre.*/
        FindIterable<Document> documento14 = collection.find(new Document("name", new Document("$regex", "^Wil"))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*15 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que contienen 'ces' como las últimas tres letras en su nombre.*/
        FindIterable<Document> documento15 = collection.find(new Document("name", new Document("$regex", "ces$"))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*16 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que contienen 'Reg' como tres letras en algún sitio en su nombre.*/
        FindIterable<Document> documento16 = collection.find(new Document("name", new Document("$regex", ".*Reg.*"))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*17 Escribe una consulta para encontrar los restaurantes que pertenecen al Bronx y prepararon cualquier plato americano o chino.*/
        FindIterable<Document> documento17 = collection.find(new Document("borough", "Bronx").append("cuisine", new Document("$in", Arrays.asList("American", "Chinese"))));

        /*18 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que pertenecen a Staten Island o Queens o Bronx o Brooklyn.*/
        FindIterable<Document> documento18 = collection.find(new Document("borough", new Document("$in", Arrays.asList("Staten Island", "Queens", "Bronx", "Brooklyn")))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*19 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que no pertenecen a Staten Island o Queens o Bronx o Brooklyn.*/
        FindIterable<Document> documento19 = collection.find(new Document("borough", new Document("$nin", Arrays.asList("Staten Island", "Queens", "Bronx", "Brooklyn")))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*20 Escribe una consulta para encontrar restaurante_id, name, borough y cuisine para aquellos restaurantes que consigan un marcador que no es más de 10.*/
        FindIterable<Document> documento20 = collection.find(new Document("grades.score", new Document("$not", new Document("$gt", 10)))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*21 Escribe una consulta para encontrar el restaurante_id, name, borough y cuisine para aquellos restaurantes que preparan pescado excepto 'American' y 'Chinees' o el name del restaurante comienza con letras 'Wil'.*/
        FindIterable<Document> documento21 = collection.find(new Document("$or", Arrays.asList(new Document("cuisine", "Fish").append("name", new Document("$regex", "^Wil")), new Document("cuisine", new Document("$nin", Arrays.asList("American", "Chinese")))))).projection(Projections.include("restaurant_id", "name", "borough", "cuisine"));

        /*22 Escribe una consulta para encontrar el restaurant_id, name, y gradas para aquellos restaurantes que consigan un grado "A" y un score 11 en datos de estudio ISODate "2014-08-11T00:00:00Z".*/
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = formatter.parse("2014-08-11T00:00:00Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FindIterable<Document> documento22 = collection.find(new Document("grades", new Document("$elemMatch", new Document("grade", "A").append("score", 11).append("date", date)))).projection(Projections.include("restaurant_id", "name", "grades"));

        
        /*23 Escribe una consulta para encontrar el restaurante_id, name y gradas para aquellos restaurantes donde el 2º elemento de variedad de grados contiene un grado de "A" y marcador 9 sobre un ISODate "2014-08-11T00:00:00Z".*/
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date1 = null;
		try {
			date = formatter1.parse("2014-08-11T00:00:00Z");
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        FindIterable<Document> documento23 = collection.find(new Document("grades.1.grade", "A").append("grades.1.score", 9).append("grades.1.date", date1)).projection(Projections.fields(Projections.include("restaurant_id", "name", "grades"), Projections.excludeId()));


        /*24 Escribe una consulta para encontrar el restaurante_id, name, dirección y ubicación geográfica para aquellos restaurantes en los que el segundo elemento del array coord contiene un valor que es más de 42 y hasta 52.*/
        FindIterable<Document> documento24 = collection.find(new Document("coord.1", new Document("$gt", 42).append("$lte", 52))).projection(Projections.include("restaurant_id", "name", "address", "coord"));

        /*25 Escribe una consulta para organizar el nombre de los restaurantes en orden ascendente junto a todas las columnas.*/
        FindIterable<Document> documento25 = collection.find().sort(new Document("name", 1));

        /*26 Escribe una consulta para organizar el nombre de los restaurantes en orden descendente junto a todas las columnas.*/
        FindIterable<Document> documento26 = collection.find().sort(new Document("name", -1));

        /*27 Escribe una consulta para organizar el nombre de la cuisine en orden ascendente y por el mismo barrio de cuisine. Orden descendente.*/
        FindIterable<Document> documento27 = collection.find().sort(new Document("cuisine", 1).append("borough", -1));

        /*28 Escribe una consulta para saber tanto si todas las direcciones contienen la calle o no.*/
        FindIterable<Document> documento28 = collection.find(new Document("address", new Document("$regex", ".*street.*").append("$options", "i")));

        /*29 Escribe una consulta que seleccionará todos los documentos en la colección de restaurantes cuyo valor del campo coord es Double.*/
        FindIterable<Document> documento29 = collection.find(new Document("coord", new Document("$type", "double")));

        /*30 Escribe una consulta que seleccionará el restaurante_id, name y grade para aquellos restaurantes que devuelvan 0 como resto después de dividir el marcador por 7.*/
        FindIterable<Document> documento30 = collection.find(new Document("$expr", new Document("$eq", Arrays.asList("$mod", Arrays.asList("$score", 7), 0)))).projection(Projections.include("restaurant_id", "name", "grade"));

        /*31 Escribe una consulta para encontrar el name de restaurante, borough, longitud y altitud y cuisine para aquellos restaurantes que contienen 'mon' como tres letras en algún sitio de su nombre.*/
        FindIterable<Document> documento31 = collection.find(new Document("name", new Document("$regex", ".*mon.*").append("$options", "i"))).projection(Projections.include("name", "borough", "coord.longitude", "coord.latitude", "cuisine"));

        /*32 Escribe una consulta para encontrar el name de restaurante, borough, longitud y latitud y cuisine para aquellos restaurantes que contienen 'Mad' como primeras tres letras de su nombre.*/
        FindIterable<Document> documento32 = collection.find( new Document("name", new Document("$regex", "^Mad").append("$options", "i"))).projection(Projections.include("name", "borough", "coord.longitude", "coord.latitude", "cuisine"));

        // Imprime cada documento
        FindIterable<Document> documents = documento6;

        for (Document document : documents) {
            System.out.println(document.toJson());
        }
		
        // Finalizamos la conexión con MongoDB
        mongoClient.close();
	}

}
