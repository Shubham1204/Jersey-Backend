package com.kraftwork.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/product")
public class ProductResource {

	 @GET 
	    @Produces("text/plain")
	    public String getIt() {
	        return "Hi Product!";
	    }
}
