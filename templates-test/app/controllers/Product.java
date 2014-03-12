package controllers;

import java.util.Arrays;
import java.util.List;

import play.*;
import play.mvc.*;
import views.html.*;

public class Product extends Controller {
	public static Result listAllProducts(){
		List<models.Product> products = askDatabaseForAllProducts();
		
		return ok(listallproducts.render(products));
	}
	
	public static Result showOneProduct(int id){
		models.Product product = askDatabaseForOneProduct(id);
		
		if(product == null){
			return notFound("Product not found");
		}
		
		return ok(showoneproduct.render(product));
	}
	
	private static List<models.Product> askDatabaseForAllProducts(){
		return Arrays.asList(new models.Product[]{
			new models.Product(1, "Hitchhikers' Guide", 200.50),
			new models.Product(2, "Bamse i Trollskogen", 180.50)
		});
	}
	
	private static models.Product askDatabaseForOneProduct(int id) {
		if(id == 1){
			return new models.Product(1, "Hitchhikers' Guide", 200.50);
		}
		if(id == 2){
			return new models.Product(2, "Bamse i Trollskogen", 180.50);
		}
		
		return null;
	}
}
