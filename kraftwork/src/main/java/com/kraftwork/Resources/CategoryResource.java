package com.kraftwork.Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kraftwork.Service.CategoryService;


@Path("/category")
public class CategoryResource {
	
	CategoryService service;
	String s;
	
	public CategoryResource() throws ClassNotFoundException {
		service = new CategoryService();
	}
	
	 @GET 
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/getAll")
	 public Response getAll() throws ClassNotFoundException{		
		  s = service.getCategoryJson();
		return Response.ok().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(s)
			      .build();
	 }
	 
	 @GET 
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/getById")
	 public Response getById(@QueryParam("categoryId") int c1) throws ClassNotFoundException{	
		  s = service.getByIdCategoryJson(c1);
		return Response.ok().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(s)
			      .build();
	 }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addCategory")
	public Response addCategory(String c) throws ClassNotFoundException {
		s = service.addCategoryJson(c.toString());
		return Response.status(Response.Status.CREATED).header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Content-Type",MediaType.APPLICATION_JSON ).header("Accept",MediaType.APPLICATION_JSON)
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(s)
			      .build();
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateCategory")
	public Response updateCategory(String c,@QueryParam("categoryId") int s1 ) throws ClassNotFoundException {
		s = service.updateCategoryJson(c.toString(),s1);
		return Response.ok().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Content-Type",MediaType.APPLICATION_JSON ).header("Accept",MediaType.APPLICATION_JSON)
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(s)
			      .build();
		
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteCategory")
	public Response deleteCategory(@QueryParam("categoryId") int s1 ) throws ClassNotFoundException {
		s = service.deleteCategoryJson(s1);
		return Response.ok().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Content-Type",MediaType.APPLICATION_JSON ).header("Accept",MediaType.APPLICATION_JSON)
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(s)
			      .build();
		
	}
}
